/*******************************************************************************
 * Licensed Materials - Property of IBM
 * � Copyright IBM Corporation 2016. All Rights Reserved.
 * U.S. Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp. 
 *******************************************************************************/

package org.eclipse.wst.jsdt.internal.ui.text.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wst.jsdt.core.IJavaScriptUnit;
import org.eclipse.wst.jsdt.core.dom.JavaScriptUnit;
import org.eclipse.wst.jsdt.internal.corext.template.java.CompilationUnitContext;
import org.eclipse.wst.jsdt.internal.corext.template.java.CompilationUnitContextType;
import org.eclipse.wst.jsdt.internal.ui.JavaScriptPlugin;
import org.eclipse.wst.jsdt.internal.ui.javaeditor.ASTProvider;

public class IdentifierEngine {

	/** The context type. */
	private CompilationUnitContextType fContextType;
	
	/** The result proposals. */
	private ArrayList<ICompletionProposal> fProposals = new ArrayList<ICompletionProposal>();
	private ScopedCodeAssistVisitor visitor;
	
	public IdentifierEngine(CompilationUnitContextType contextType) {
		Assert.isNotNull(contextType);
		fContextType = contextType;
		visitor = new ScopedCodeAssistVisitor(1);
	}

	public void complete(ITextViewer viewer, int completionPosition, IJavaScriptUnit compilationUnit) {
	    IDocument document = viewer.getDocument();
		Point selection = viewer.getSelectedRange();
		Position position = new Position(completionPosition, selection.y);

		CompilationUnitContext context = fContextType.createContext(document, position, compilationUnit);
		int start = context.getStart();
		int end = context.getEnd();
		IRegion region = new Region(start, end - start);
		
		JavaScriptUnit ast = JavaScriptPlugin.getDefault().getASTProvider().getAST(compilationUnit, ASTProvider.WAIT_ACTIVE_ONLY, new NullProgressMonitor());
		
		ast.accept(visitor);
		
		List<VariableDeclarationIdentifierProposal> variableDeclarationIdentifierProposals = visitor.getVariableDeclarationIdentifiers(context.getKey());
		List<FunctionDeclarationIdentifierProposal> functionDeclarationIdentifierProposals = visitor.getFunctionDeclarationIdentifiers(context.getKey());

		for (VariableDeclarationIdentifierProposal vProp : variableDeclarationIdentifierProposals) {
			vProp.setRegion(region);
		}
		
		
		for (FunctionDeclarationIdentifierProposal fProp : functionDeclarationIdentifierProposals) {
			fProp.setRegion(region);
		}

		fProposals.addAll(variableDeclarationIdentifierProposals);
		fProposals.addAll(functionDeclarationIdentifierProposals);
	}

	public void reset() {
		visitor.clearIdentifierProposals();
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
}
