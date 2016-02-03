/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.jsdt.internal.core;

import java.util.HashMap;

import org.eclipse.wst.jsdt.core.dom.JavaScriptUnit;

public class ASTHolderCUInfo extends CompilationUnitElementInfo {
	int astLevel;
	boolean resolveBindings;
	int reconcileFlags;
	HashMap problems = null;
	JavaScriptUnit ast;
	
	/**
	 * @return the astLevel
	 */
	public int getAstLevel() {
		return astLevel;
	}
	/**
	 * @param astLevel the astLevel to set
	 */
	public void setAstLevel(int astLevel) {
		this.astLevel = astLevel;
	}
	/**
	 * @return the resolveBindings
	 */
	public boolean isResolveBindings() {
		return resolveBindings;
	}
	/**
	 * @param resolveBindings the resolveBindings to set
	 */
	public void setResolveBindings(boolean resolveBindings) {
		this.resolveBindings = resolveBindings;
	}
	/**
	 * @return the reconcileFlags
	 */
	public int getReconcileFlags() {
		return reconcileFlags;
	}
	/**
	 * @param reconcileFlags the reconcileFlags to set
	 */
	public void setReconcileFlags(int reconcileFlags) {
		this.reconcileFlags = reconcileFlags;
	}
	/**
	 * @return the problems
	 */
	public HashMap getProblems() {
		return problems;
	}
	/**
	 * @param problems the problems to set
	 */
	public void setProblems(HashMap problems) {
		this.problems = problems;
	}
	/**
	 * @return the ast
	 */
	public JavaScriptUnit getAst() {
		return ast;
	}
	/**
	 * @param ast the ast to set
	 */
	public void setAst(JavaScriptUnit ast) {
		this.ast = ast;
	}
}
