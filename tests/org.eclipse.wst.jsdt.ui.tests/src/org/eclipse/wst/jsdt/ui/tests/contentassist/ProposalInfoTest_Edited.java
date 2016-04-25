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

import org.eclipse.wst.jsdt.ui.tests.utils.TestProjectSetup;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("nls")
public class ProposalInfoTest_Edited {
	private static TestProjectSetup fTestProjectSetup;

	@Ignore @BeforeClass
	public static void setup() throws Exception {
		fTestProjectSetup = new TestProjectSetup("ContentAssist", "root", false);
		fTestProjectSetup.setUp();
		editFile_TestProposalInfo_0();
	}

	@Ignore @Test
	public void testProposalInfo_OtherFile_AfterEdit_Expression_NotStarted() throws Exception {
		String[][] expectedProposals = new String[][] { { "HelloWorld() - Global", "HelloAmerica(State, City) - Global" } };
		String[][] expectedInfo = new String[][] { { "Hello Earth", "NC" } };
		ContentAssistTestUtilities.runProposalInfoTest(fTestProjectSetup, "TestProposalInfo_1.js", 0, 0, expectedProposals, expectedInfo);
	}

	@Ignore @Test
	public void testProposalInfo_OtherFile_AfterEdit_ExpressionStarted_1() throws Exception {
		String[][] expectedProposals = new String[][] { { "HelloWorld() - Global",
				"HelloAmerica(State, City)  - Global" } };
		String[][] expectedInfo = new String[][] { { "Hello Earth", "Wake" } };
		ContentAssistTestUtilities.runProposalInfoTest(fTestProjectSetup, "TestProposalInfo_1.js", 2, 3, expectedProposals, expectedInfo);
	}

	@Ignore @Test
	public void _testProposalInfo_OtherFile_AfterEdit_ExpressionStarted_2() throws Exception {
		String[][] expectedProposals = new String[][] { { "nodeOne : String - Global" } };
		String[][] expectedInfo = new String[][] { { "nodeOne = Edit" } };
		ContentAssistTestUtilities.runProposalInfoTest(fTestProjectSetup, "TestProposalInfo_1.js", 4, 3, expectedProposals, expectedInfo);
	}

	@Ignore @Test
	public void testProposalInfo_ThisFile_AfterEdit_NotStarted() throws Exception {
		String[][] expectedProposals = new String[][] { { "HelloWorld() - Global", "HelloAmerica(State, City) - Global" } };
		String[][] expectedInfo = new String[][] { { "Hello Earth", "NC" } };
		ContentAssistTestUtilities.runProposalInfoTest(fTestProjectSetup, "TestProposalInfo_0.js", 0, 0, expectedProposals, expectedInfo);
	}

	@Ignore @Test
	public void testProposalInfo_ThisFile_AfterEdit_ExpressionStarted_1() throws Exception {
		String[][] expectedProposals = new String[][] { { "HelloWorld() - Global", "HelloAmerica(State, City) - Global" } };
		String[][] expectedInfo = new String[][] { { "Hello Earth", "NC" } };
		ContentAssistTestUtilities.runProposalInfoTest(fTestProjectSetup, "TestProposalInfo_0.js", 15, 3, expectedProposals, expectedInfo);
	}

	@Ignore @Test
	public void _testProposalInfo_ThisFile_AfterEdit_ExpressionStarted_2() throws Exception {
		String[][] expectedProposals = new String[][] { { "nodeOne : String - Global" } };
		String[][] expectedInfo = new String[][] { { "nodeOne = Edit" } };
		ContentAssistTestUtilities.runProposalInfoTest(fTestProjectSetup, "TestProposalInfo_0.js", 22, 3, expectedProposals, expectedInfo);

	}

	/**
	 * File Edited : TestProposal_0.js
	 * World -> Earth
	 * State -> NC
	 * City -> Wake
	 * nodeOne = test -> nodeOne = Edit
	 *
	 * @throws Exception
	 */
	private static void editFile_TestProposalInfo_0() throws Exception {
		fTestProjectSetup.editFile("TestProposalInfo_0.js", 1, 9, 5, "Earth");
		fTestProjectSetup.editFile("TestProposalInfo_0.js", 8, 10, 5, "NC");
		fTestProjectSetup.editFile("TestProposalInfo_0.js", 18, 13, 4, "Edit");
	}
}