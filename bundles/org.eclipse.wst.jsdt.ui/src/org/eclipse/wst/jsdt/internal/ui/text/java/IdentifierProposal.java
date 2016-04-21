/*******************************************************************************
 * Licensed Materials - Property of IBM
 * © Copyright IBM Corporation 2016. All Rights Reserved.
 * U.S. Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *******************************************************************************/

package org.eclipse.wst.jsdt.internal.ui.text.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension2;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension3;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension4;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wst.jsdt.core.dom.JSdoc;
import org.eclipse.wst.jsdt.internal.ui.text.java.ScopedCodeAssistVisitor.Scope;
import org.eclipse.wst.jsdt.ui.text.java.IJavaCompletionProposal;

public class IdentifierProposal implements IJavaCompletionProposal, ICompletionProposalExtension2, ICompletionProposalExtension3, ICompletionProposalExtension4 {

	private IRegion fRegion;
	private Region fSelectedRegion;
	private List<IdentifierProposal> fields = new ArrayList<IdentifierProposal>();
	private IdentifierType type;
	private List<String> parameterNames;
	private String name;
	private boolean isGlobal = false;
	private IdentifierProposal parent;

	public IdentifierProposal(String name) {
		this.name = name;
	}

	public void setRegion(IRegion fRegion) {
		this.fRegion = fRegion;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#apply(org.eclipse.jface.text.IDocument)
	 */
	public void apply(IDocument document) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getSelection(org.eclipse.jface.text.IDocument)
	 */
	public Point getSelection(IDocument document) {
		// TODO Auto-generated method stub
		return new Point(fRegion.getOffset() + this.name.length(), 0);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getAdditionalProposalInfo()
	 */
	public String getAdditionalProposalInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDisplayString() {
		if (this.isGlobal) {
			return getProposalString() + " - Global";
		}
//		else if (this.parent != null) {
//			return getProposalString() + " - " + this.parent.getName();
//		}
		return getProposalString();
	}

	public String getProposalString() {
		if (this.type == IdentifierType.FUNCTION) {
			return this.name + "(" + getParameterString() + ")";
		} else {
			return this.name;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getImage()
	 */
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getContextInformation()
	 */
	public IContextInformation getContextInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension4#isAutoInsertable()
	 */
	public boolean isAutoInsertable() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension3#getInformationControlCreator()
	 */
	public IInformationControlCreator getInformationControlCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension3#getPrefixCompletionText(org.eclipse.jface.text.IDocument, int)
	 */
	public CharSequence getPrefixCompletionText(IDocument document, int completionOffset) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension3#getPrefixCompletionStart(org.eclipse.jface.text.IDocument, int)
	 */
	public int getPrefixCompletionStart(IDocument document, int completionOffset) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#apply(org.eclipse.jface.text.ITextViewer, char, int, int)
	 */
	public void apply(ITextViewer viewer, char trigger, int stateMask, int offset) {
		IDocument document = viewer.getDocument();

		try {
			document.replace(fRegion.getOffset(), offset - fRegion.getOffset(), getProposalString());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}

		this.fSelectedRegion = new Region(fRegion.getOffset() + this.name.length(), 0);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#selected(org.eclipse.jface.text.ITextViewer, boolean)
	 */
	public void selected(ITextViewer viewer, boolean smartToggle) {
		// TODO Auto-generated method stub

	}

	private String getParameterString() {
		if (parameterNames.isEmpty()) {
			return "";
		}
		StringBuilder str = new StringBuilder();
		for (String param : parameterNames) {
			str.append(param + ", "); //$NON-NLS-1$
		}
		return str.substring(0, str.length() - 2);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#unselected(org.eclipse.jface.text.ITextViewer)
	 */
	public void unselected(ITextViewer viewer) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#validate(org.eclipse.jface.text.IDocument, int, org.eclipse.jface.text.DocumentEvent)
	 */
	public boolean validate(IDocument document, int offset, DocumentEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.wst.jsdt.ui.text.java.IJavaCompletionProposal#getRelevance()
	 */
	public int getRelevance() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addField(IdentifierProposal field) {
		this.fields.add(field);
	}

	public String getName() {
		return this.name;
	}

	public List<IdentifierProposal> getFields() {
		return this.fields;
	}

	public void setType(IdentifierType type) {
		this.type = type;
	}

	public void setParameters(List<String> parameterNames) {
		this.parameterNames = parameterNames;
	}

	public void setJSdoc(JSdoc jsdoc) {
	}

	public void updateScope(Stack<Scope> scopes) {
		this.isGlobal = scopes.size() == 1;
	}

	public void addParent(IdentifierProposal parent) {
		this.parent = parent;
	}

	public IdentifierProposal getParent() {
		return parent;
	}

	public void setIsGlobal(boolean b) {
		isGlobal = b;
	}

}