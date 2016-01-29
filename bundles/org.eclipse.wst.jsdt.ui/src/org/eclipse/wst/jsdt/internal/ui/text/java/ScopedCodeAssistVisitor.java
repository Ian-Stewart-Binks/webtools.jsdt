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

import org.eclipse.wst.jsdt.core.CompletionProposal;
import org.eclipse.wst.jsdt.core.dom.ASTNode;
import org.eclipse.wst.jsdt.core.dom.Block;
import org.eclipse.wst.jsdt.core.dom.CatchClause;
import org.eclipse.wst.jsdt.core.dom.ForInStatement;
import org.eclipse.wst.jsdt.core.dom.ForStatement;
import org.eclipse.wst.jsdt.core.dom.FunctionDeclaration;
import org.eclipse.wst.jsdt.core.dom.IBinding;
import org.eclipse.wst.jsdt.core.dom.Initializer;
import org.eclipse.wst.jsdt.core.dom.JavaScriptUnit;
import org.eclipse.wst.jsdt.core.dom.SingleVariableDeclaration;
import org.eclipse.wst.jsdt.core.dom.Statement;
import org.eclipse.wst.jsdt.core.dom.TypeDeclarationStatement;
import org.eclipse.wst.jsdt.core.dom.VariableDeclaration;
import org.eclipse.wst.jsdt.core.dom.VariableDeclarationExpression;
import org.eclipse.wst.jsdt.core.dom.VariableDeclarationStatement;
import org.eclipse.wst.jsdt.internal.codeassist.HierarchicalASTVisitor;

/**
 * Visit the AST following the scope for the position. 
 * Marks all the variables, functions etc on the way for code completion.
 */
public class ScopedCodeAssistVisitor extends HierarchicalASTVisitor {
	
	private class Scope {
		ArrayList<CompletionProposal> proposals = new ArrayList<CompletionProposal>(); 
	}

	private int filePosition;
	private Stack<Scope> scopes = new Stack<Scope>();
	
	public ScopedCodeAssistVisitor(int position) {
		filePosition = position;
	}
	
	/**
	 * Determines whether the file position is inside the given ASTNode.
	 */
	private boolean isInside(ASTNode node) {
		int start = node.getStartPosition();
		int end = start + node.getLength();
		return start <= filePosition && filePosition < end;
	}
	
	public boolean visit(JavaScriptUnit node) {
		// Push the global scope.
		scopes.push(new Scope());
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.wst.jsdt.internal.codeassist.HierarchicalASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.JavaScriptUnit)
	 */
	public void endVisit(JavaScriptUnit node) {
		//Send all the proposals from all scopes
		for (Scope scope : scopes) {
			for (CompletionProposal proposal : scope.proposals) {
				requestor.accept(proposal);
			}
		}
		super.endVisit(node);
	}
	
	public boolean visit(FunctionDeclaration node) {
		if (node.getStartPosition() < filePosition && node.getName() != null) {
			final String nodeName = node.getName().toString();
			CompletionProposal proposal = createProposal(CompletionProposal.METHOD_REF, nodeName, nodeName + "()");
			List parameters = node.parameters();
			if (parameters != null ) {
				char[][] parameterNames = new char[parameters.size()][];
				for (int i = 0; i< parameters.size(); i++) {
					SingleVariableDeclaration decl = (SingleVariableDeclaration) parameters.get(i);
					parameterNames[i] = decl.getName().toString().toCharArray(); 
				}
				proposal.setParameterNames(parameterNames);
			}
			scopes.peek().proposals.add(proposal);
		}
		if (isInside(node)) {
			Block body = node.getBody();
			if (body != null) {
				// New function scope
				scopes.push(new Scope());
				body.accept(this);
			}
			visitBackwards(node.parameters());
		}
		return false;
	}
	
	public boolean visit(Initializer node) {
		return isInside(node);
	}		
	
	public boolean visit(Statement node) {
		
		return isInside(node);
	}
	
	public boolean visit(Block node) {
		return false;
	}
			
	public boolean visit(VariableDeclaration node) {
		if (node.getStartPosition() < filePosition) {
			if (node.getName() != null) {
				System.out.println("Variable Declaration >> " + node);
				final String nodeName = node.getName().toString();
				CompletionProposal proposal = createProposal(CompletionProposal.LOCAL_VARIABLE_REF, nodeName, nodeName);
				Scope currentScope = scopes.peek();
				currentScope.proposals.add(proposal);
			}
		}
		return true;
	}
	
	public boolean visit(VariableDeclarationStatement node) {
		visitBackwards(node.fragments());
		return false;
	}		
	
	public boolean visit(VariableDeclarationExpression node) {
		visitBackwards(node.fragments());
		return false;
	}

	public boolean visit(CatchClause node) {
		if (isInside(node)) {
			node.getBody().accept(this);
			node.getException().accept(this);
		}
		return false;			
	}
	
	public boolean visit(ForStatement node) {
		if (isInside(node)) {
			node.getBody().accept(this);
			visitBackwards(node.initializers());
		}
		return false;
	}	

	public boolean visit(ForInStatement node) {
		if (isInside(node)) {
			node.getBody().accept(this);
			node.getIterationVariable().accept(this);
		}
		return false;
	}	

	public boolean visit(TypeDeclarationStatement node) {
		if (node.getStartPosition() + node.getLength() < filePosition) {
			IBinding binding = node.getDeclaration().getName().resolveBinding();
			if (binding != null) {
				CompletionProposal proposal = CompletionProposal.create(CompletionProposal.LOCAL_VARIABLE_REF, filePosition);
				proposal.setCompletion(binding.getName().toCharArray());
				requestor.accept(proposal);
			}
			return false;
		}
		return isInside(node);
	}
	
	private void visitBackwards(List<ASTNode> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			ASTNode curr = list.get(i);
			if (curr.getStartPosition() <  filePosition) {
				curr.accept(this);
			}
		}			
	}

}