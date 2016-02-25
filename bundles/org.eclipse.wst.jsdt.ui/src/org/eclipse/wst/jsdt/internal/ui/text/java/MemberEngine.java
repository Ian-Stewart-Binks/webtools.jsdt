/*******************************************************************************
 * Licensed Materials - Property of IBM
 * © Copyright IBM Corporation 2016. All Rights Reserved.
 * U.S. Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp. 
 *******************************************************************************/

package org.eclipse.wst.jsdt.internal.ui.text.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wst.jsdt.core.IJavaScriptProject;
import org.eclipse.wst.jsdt.core.IJavaScriptUnit;
import org.eclipse.wst.jsdt.core.dom.JavaScriptUnit;
import org.eclipse.wst.jsdt.internal.corext.template.java.CompilationUnitContextType;
import org.eclipse.wst.jsdt.internal.ui.JavaScriptPlugin;
import org.eclipse.wst.jsdt.internal.ui.javaeditor.ASTProvider;

public class MemberEngine {

	/** The context type. */
	private CompilationUnitContextType fContextType;
	
	/** The result proposals. */
	private ArrayList<ICompletionProposal> fProposals = new ArrayList<ICompletionProposal>();
	private ScopedCodeAssistVisitor visitor;
	
	public MemberEngine(CompilationUnitContextType contextType) {
		Assert.isNotNull(contextType);
		fContextType = contextType;
	}

	public void complete(IJavaScriptProject project, ITextViewer viewer, int completionPosition, IJavaScriptUnit compilationUnit) {
	    IDocument document = viewer.getDocument();
		Point selection = viewer.getSelectedRange();

		if (!isMemberAccess(document, completionPosition)) {
			return;
		}
		
		int start = getPreviousDotPosition(document, completionPosition) + 1;
		int end = completionPosition;
		IRegion region = new Region(start, end - start);
		
		JavaScriptUnit ast = JavaScriptPlugin.getDefault().getASTProvider().getAST(compilationUnit, ASTProvider.WAIT_ACTIVE_ONLY, new NullProgressMonitor());
		
		visitor = new ScopedCodeAssistVisitor(completionPosition);
		ast.accept(visitor);
		List<VariableDeclarationIdentifierProposal> variableDeclarationProposals = this.visitor.getVariableDeclarationIdentifiers();
		
		String previousIdentifierName = getPreviousIdentifierName(document, completionPosition);
		Optional<VariableDeclarationIdentifierProposal> variableDeclarationIdentifier = variableDeclarationProposals.stream().filter(k -> k.getDisplayString().equals(previousIdentifierName)).findFirst();
		List<String> fields = variableDeclarationIdentifier.get().getFields();
		List<FieldProposal> fieldProposals = fields.stream().map(k -> new FieldProposal(k, region)).collect(Collectors.toList());
		
		fProposals.addAll(fieldProposals);
	}

	public void reset() {
		fProposals.clear();
	}

	/**
	 * Returns the array of matching keywords.
	 */
	public ICompletionProposal[] getResults() {
		return fProposals.toArray(new ICompletionProposal[fProposals.size()]);
	}
	
	public List<String> getMatchingIdentifiers(List<String> identifiers, String string) {
		return identifiers.stream().filter(k -> k.startsWith(string)).collect(Collectors.toList());
	}
	
	private boolean isMemberAccess(IDocument document, int completionPosition) {
		char text;
		try {
			text = document.getChar(completionPosition - 1);
			return text == '.';
		}
		catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	private String getPreviousIdentifierName(IDocument document, int completionPosition) {
		StringBuilder string = new StringBuilder();

		try {
			// Subtract two to get character before '.'.
			for (int i = completionPosition - 2; i >= 0; i--) {
				char ch = document.getChar(i);
				if (ch == ' ' || ch == '\n') {
					break;
				}
					string.append(ch);
				}
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Handle case when something like identifier.method().^space
		
		return string.reverse().toString();
	}
	
	private int getPreviousDotPosition(IDocument document, int completionPosition) {

		try {
			for (int i = completionPosition - 1; i > 0; i--) {
				char ch = document.getChar(i);
				if (ch == '.') {
					return i;
				}
			}
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
}
