/*******************************************************************************
 * Licensed Materials - Property of IBM
 * � Copyright IBM Corporation 2016. All Rights Reserved.
 * U.S. Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp. 
 *******************************************************************************/

package org.eclipse.wst.jsdt.internal.ui.text.template.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wst.jsdt.core.IJavaScriptUnit;
import org.eclipse.wst.jsdt.internal.corext.template.java.CompilationUnitContext;
import org.eclipse.wst.jsdt.internal.corext.template.java.CompilationUnitContextType;
import org.eclipse.wst.jsdt.internal.ui.text.java.Keywords;

public class IdentifierEngine {

	/** The context type. */
	private CompilationUnitContextType fContextType;
	
	/** The result proposals. */
	private ArrayList<IdentifierProposal> fProposals = new ArrayList<IdentifierProposal>();
	
	public IdentifierEngine(CompilationUnitContextType contextType) {
		Assert.isNotNull(contextType);
		fContextType = contextType;
	}

	public void complete(ITextViewer viewer, int completionPosition, IJavaScriptUnit compilationUnit) {
	    IDocument document = viewer.getDocument();

		Point selection = viewer.getSelectedRange();
		Position position = new Position(completionPosition, selection.y);

		CompilationUnitContext context = fContextType.createContext(document, position, compilationUnit);
		int start = context.getStart();
		int end = context.getEnd();
		IRegion region = new Region(start, end - start);
		
		Keywords keywords = Keywords.getInstance();
		
		List<String> matchingKeywords = keywords.getMatchingKeywords(context.getKey());
		
		for (String keywordName : matchingKeywords) {
			IdentifierProposal keywordProposal = new IdentifierProposal("PLACEHOLDER");
			fProposals.add(keywordProposal);
		}
		
	}

	public void reset() {
		fProposals.clear();
	}

	/**
	 * Returns the array of matching keywords.
	 */
	public IdentifierProposal[] getResults() {
		return fProposals.toArray(new IdentifierProposal[fProposals.size()]);
	}

}
