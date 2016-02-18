/*******************************************************************************
 * Licensed Materials - Property of IBM
 * © Copyright IBM Corporation 2016. All Rights Reserved.
 * U.S. Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp. 
 *******************************************************************************/

package org.eclipse.wst.jsdt.internal.ui.text.java;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
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
import org.eclipse.wst.jsdt.core.CompletionProposal;
import org.eclipse.wst.jsdt.core.IJavaScriptProject;
import org.eclipse.wst.jsdt.core.dom.JSdoc;
import org.eclipse.wst.jsdt.ui.text.java.IJavaCompletionProposal;

public class FunctionDeclarationIdentifierProposal implements IJavaCompletionProposal, ICompletionProposalExtension2, ICompletionProposalExtension3, ICompletionProposalExtension4 {
	
	private String displayString;
	private IRegion fRegion;
	private Region fSelectedRegion;
	private List<String> parameters;
	private JSdoc JSDoc;
	private ProposalInfo fProposalInfo;
	private IJavaScriptProject jsProject;
	private CompletionProposal completionProposal;
	
	public FunctionDeclarationIdentifierProposal(String displayString, List<String> parameters, JSdoc jsDoc) {
		this.displayString = displayString;
		this.parameters = parameters;
		this.JSDoc = jsDoc;
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
		int y;
		
		// Get location of the end of the first parameter, if it exists.
		if (this.parameters.isEmpty()) {
			y = 0;
		} else {
			y = this.parameters.get(0).length();
		}
		
		return new Point(fRegion.getOffset() + this.displayString.length() + 1, y);
	}
	
	
    /**
     * Sets the proposal info.
     *
     * @param proposalInfo The additional information associated with this proposal or
     *        <code>null</code>
     */
    public void setProposalInfo(ProposalInfo proposalInfo) {
            fProposalInfo = proposalInfo;
    }

	
    /**
     * Returns the additional proposal info, or <code>null</code> if none exists.
     *
     * @return the additional proposal info, or <code>null</code> if none exists
     */
    protected ProposalInfo getProposalInfo() {
        return fProposalInfo;
    }
    
    public void setProject(IJavaScriptProject project) {
    	this.jsProject = project;
    }


    /*
     * @see ICompletionProposal#getAdditionalProposalInfo()
     */
    @Override
    public String getAdditionalProposalInfo() {
		CompletionProposal completionProposal = CompletionProposal.create(CompletionProposal.METHOD_REF, fRegion.getOffset());
		setProposalInfo(new MethodProposalInfo(jsProject, completionProposal));
        Object info = getAdditionalProposalInfo2(new NullProgressMonitor());
        return info == null ? null : info.toString();
    }

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getAdditionalProposalInfo()
	 */
	private String getAdditionalProposalInfo2(IProgressMonitor monitor) {
//		System.out.println(this.JSDoc.replace("\n", ));
//		
//        if (getProposalInfo() != null) {
//            String info = getProposalInfo().getInfo(monitor);
//            if (info != null && info.length() > 0) {
//                    StringBuffer buffer = new StringBuffer();
//                    HTMLPrinter.insertPageProlog(buffer, 0, getCSSStyles());
//
//                    buffer.append(info);
//
//                    IJavaScriptElement element = null;
//                    try {
//                            element= getProposalInfo().getJavaElement();
////                            if (element instanceof IMember) {
////                                    String base= JSdocContentAccess2.extractBaseURL(info);
////                                    if (base == null) {
////                                            base= JavaDocLocations.getBaseURL(element, ((IMember) element).isBinary());
////                                    }
////                                    if (base != null) {
////                                            int endHeadIdx= buffer.indexOf("</head>"); //$NON-NLS-1$
////                                            buffer.insert(endHeadIdx, "\n<base href='" + base + "'>\n"); //$NON-NLS-1$ //$NON-NLS-2$
////                                    }
////                            }
//                    } catch (JavaScriptModelException e) {
//                            JavaScriptPlugin.log(e);
//                    }
//
//                    HTMLPrinter.addPageEpilog(buffer);
//                    info = buffer.toString();
//
//                    return info; //new JSdocBrowserInformationControlInput(null, element, info, 0);
//            }
//    }
    return null;
	}

	public String getDisplayString() {
		return displayString;
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
			document.replace(fRegion.getOffset(), offset - fRegion.getOffset(), this.displayString + "(" + getParameterString() + ")");
		}
		catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		this.fSelectedRegion = new Region(fRegion.getOffset() + this.displayString.length(), this.displayString.length());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#selected(org.eclipse.jface.text.ITextViewer, boolean)
	 */
	public void selected(ITextViewer viewer, boolean smartToggle) {
		// TODO Auto-generated method stub
		
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
	
	private String getParameterString() {
		StringBuilder str = new StringBuilder();
		for (String param : parameters) {
			str.append(param + ", "); //$NON-NLS-1$
		}
		return str.substring(0, str.length() - 2);
	}
//	
//	/**
//     * The CSS used to format javadoc information.
//     * @since 3.3
//     */
//    private static String fgCSSStyles;

	
	
	
//	/**
//     * Returns the style information for displaying HTML (Javadoc) content.
//    *
//    * @return the CSS styles
//    * @since 3.3
//    */
//   protected String getCSSStyles() {
//           if (fgCSSStyles == null) {
//                   Bundle bundle = Platform.getBundle(JavaScriptPlugin.getPluginId());
//                   URL url = bundle.getEntry("/JavadocHoverStyleSheet.css"); //$NON-NLS-1$
//                   if (url != null) {
//                           BufferedReader reader = null;
//                           try {
//                                   url= FileLocator.toFileURL(url);
//                                   reader = new BufferedReader(new InputStreamReader(url.openStream()));
//                                   StringBuffer buffer = new StringBuffer(200);
//                                   String line = reader.readLine();
//                                   while (line != null) {
//                                           buffer.append(line);
//                                           buffer.append('\n');
//                                           line = reader.readLine();
//                                   }
//                                   fgCSSStyles= buffer.toString();
//                           } catch (IOException ex) {
//                        	   	JavaScriptPlugin.log(ex);
//                           } finally {
//                                   try {
//                                           if (reader != null)
//                                                   reader.close();
//                                   } catch (IOException e) {
//                                   }
//                           }
//
//                   }
//           }
//           String css = fgCSSStyles;
//           if (css != null) {
//                   FontData fontData= JFaceResources.getFontRegistry().getFontData(PreferenceConstants.APPEARANCE_JAVADOC_FONT)[0];
//                   css= HTMLPrinter.convertTopLevelFont(css, fontData);
//           }
//           return css;
//   }

	
	

}
