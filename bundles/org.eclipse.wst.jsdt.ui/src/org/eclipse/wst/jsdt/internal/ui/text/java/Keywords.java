/*******************************************************************************
 * Licensed Materials - Property of IBM
 * © Copyright IBM Corporation 2016. All Rights Reserved.
 * U.S. Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp. 
 *******************************************************************************/

package org.eclipse.wst.jsdt.internal.ui.text.java;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Keywords {
	
	private static Keywords instance;
	private final Set<String> keywords;
	
	private Keywords() {
		keywords = new HashSet<String>(27);
		keywords.add("break");      //$NON-NLS-1$
		keywords.add("case");       //$NON-NLS-1$
		keywords.add("catch");      //$NON-NLS-1$
		keywords.add("continue");   //$NON-NLS-1$
		keywords.add("default");    //$NON-NLS-1$
		keywords.add("delete");     //$NON-NLS-1$
		keywords.add("do");         //$NON-NLS-1$
		keywords.add("else");       //$NON-NLS-1$
		keywords.add("elseif");     //$NON-NLS-1$
		keywords.add("finally");    //$NON-NLS-1$
		keywords.add("for");        //$NON-NLS-1$
		keywords.add("function");   //$NON-NLS-1$
		keywords.add("if");         //$NON-NLS-1$
		keywords.add("in");         //$NON-NLS-1$
		keywords.add("instanceof"); //$NON-NLS-1$
		keywords.add("new");        //$NON-NLS-1$
		keywords.add("return");     //$NON-NLS-1$
		keywords.add("switch");     //$NON-NLS-1$
		keywords.add("this");       //$NON-NLS-1$
		keywords.add("throw");      //$NON-NLS-1$
		keywords.add("try");        //$NON-NLS-1$
		keywords.add("typeof");     //$NON-NLS-1$
		keywords.add("var");        //$NON-NLS-1$
		keywords.add("void");       //$NON-NLS-1$
		keywords.add("while");      //$NON-NLS-1$
		keywords.add("with");       //$NON-NLS-1$
	}
	
	public static Keywords getInstance() {
		if (instance == null) {
			instance = new Keywords();
		}
		return instance;
	}
	
	public boolean isKeyword(String string) {
		return keywords.contains(string);
	}
	
	public List<String> getMatchingKeywords(String string) {
		return keywords.stream().filter(k -> k.startsWith(string)).collect(Collectors.toList());
	}
	
}
