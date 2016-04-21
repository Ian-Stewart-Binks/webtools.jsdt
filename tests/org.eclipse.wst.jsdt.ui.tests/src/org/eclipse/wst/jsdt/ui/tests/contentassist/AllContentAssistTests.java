/*******************************************************************************
 * Copyright (c) 2011, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.jsdt.ui.tests.contentassist;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.TestSuite;

/**
 * <p>
 * Test suite containing all JSDT content assist tests.
 * </p>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	GlobalFunctionTests.class
})
public class AllContentAssistTests extends TestSuite {

	/**
	 * <p>
	 * Constructor that takes a test name.
	 * </p>
	 * <p>
	 * Use {@link #suite()}
	 * </p>
	 *
	 * @param name
	 *            The name this test run should have.
	 *
	 * @see #suite()
	 */
	public AllContentAssistTests(String name) {
		super(name);
	}

}