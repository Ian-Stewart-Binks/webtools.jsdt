/*******************************************************************************
 * Licensed Materials - Property of IBM
 * � Copyright IBM Corporation 2016. All Rights Reserved.
 * U.S. Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *******************************************************************************/

package org.eclipse.wst.jsdt.internal.ui.text.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import org.eclipse.wst.jsdt.core.CompletionProposal;
import org.eclipse.wst.jsdt.core.dom.ASTNode;
import org.eclipse.wst.jsdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.wst.jsdt.core.dom.ArrayAccess;
import org.eclipse.wst.jsdt.core.dom.ArrayCreation;
import org.eclipse.wst.jsdt.core.dom.ArrayInitializer;
import org.eclipse.wst.jsdt.core.dom.ArrayType;
import org.eclipse.wst.jsdt.core.dom.Assignment;
import org.eclipse.wst.jsdt.core.dom.Block;
import org.eclipse.wst.jsdt.core.dom.BlockComment;
import org.eclipse.wst.jsdt.core.dom.BooleanLiteral;
import org.eclipse.wst.jsdt.core.dom.BreakStatement;
import org.eclipse.wst.jsdt.core.dom.CatchClause;
import org.eclipse.wst.jsdt.core.dom.CharacterLiteral;
import org.eclipse.wst.jsdt.core.dom.ClassInstanceCreation;
import org.eclipse.wst.jsdt.core.dom.ConditionalExpression;
import org.eclipse.wst.jsdt.core.dom.ConstructorInvocation;
import org.eclipse.wst.jsdt.core.dom.ContinueStatement;
import org.eclipse.wst.jsdt.core.dom.DoStatement;
import org.eclipse.wst.jsdt.core.dom.EmptyStatement;
import org.eclipse.wst.jsdt.core.dom.EnhancedForStatement;
import org.eclipse.wst.jsdt.core.dom.Expression;
import org.eclipse.wst.jsdt.core.dom.ExpressionStatement;
import org.eclipse.wst.jsdt.core.dom.FieldAccess;
import org.eclipse.wst.jsdt.core.dom.FieldDeclaration;
import org.eclipse.wst.jsdt.core.dom.ForInStatement;
import org.eclipse.wst.jsdt.core.dom.ForStatement;
import org.eclipse.wst.jsdt.core.dom.FunctionDeclaration;
import org.eclipse.wst.jsdt.core.dom.FunctionExpression;
import org.eclipse.wst.jsdt.core.dom.FunctionInvocation;
import org.eclipse.wst.jsdt.core.dom.FunctionRef;
import org.eclipse.wst.jsdt.core.dom.FunctionRefParameter;
import org.eclipse.wst.jsdt.core.dom.IBinding;
import org.eclipse.wst.jsdt.core.dom.IfStatement;
import org.eclipse.wst.jsdt.core.dom.ImportDeclaration;
import org.eclipse.wst.jsdt.core.dom.InferredType;
import org.eclipse.wst.jsdt.core.dom.InfixExpression;
import org.eclipse.wst.jsdt.core.dom.Initializer;
import org.eclipse.wst.jsdt.core.dom.InstanceofExpression;
import org.eclipse.wst.jsdt.core.dom.JavaScriptUnit;
import org.eclipse.wst.jsdt.core.dom.LabeledStatement;
import org.eclipse.wst.jsdt.core.dom.LineComment;
import org.eclipse.wst.jsdt.core.dom.ListExpression;
import org.eclipse.wst.jsdt.core.dom.MemberRef;
import org.eclipse.wst.jsdt.core.dom.Modifier;
import org.eclipse.wst.jsdt.core.dom.NullLiteral;
import org.eclipse.wst.jsdt.core.dom.NumberLiteral;
import org.eclipse.wst.jsdt.core.dom.ObjectLiteral;
import org.eclipse.wst.jsdt.core.dom.ObjectLiteralField;
import org.eclipse.wst.jsdt.core.dom.PackageDeclaration;
import org.eclipse.wst.jsdt.core.dom.ParenthesizedExpression;
import org.eclipse.wst.jsdt.core.dom.PostfixExpression;
import org.eclipse.wst.jsdt.core.dom.PrefixExpression;
import org.eclipse.wst.jsdt.core.dom.PrimitiveType;
import org.eclipse.wst.jsdt.core.dom.QualifiedName;
import org.eclipse.wst.jsdt.core.dom.QualifiedType;
import org.eclipse.wst.jsdt.core.dom.RegularExpressionLiteral;
import org.eclipse.wst.jsdt.core.dom.ReturnStatement;
import org.eclipse.wst.jsdt.core.dom.SimpleName;
import org.eclipse.wst.jsdt.core.dom.SimpleType;
import org.eclipse.wst.jsdt.core.dom.SingleVariableDeclaration;
import org.eclipse.wst.jsdt.core.dom.Statement;
import org.eclipse.wst.jsdt.core.dom.StringLiteral;
import org.eclipse.wst.jsdt.core.dom.SuperConstructorInvocation;
import org.eclipse.wst.jsdt.core.dom.SuperFieldAccess;
import org.eclipse.wst.jsdt.core.dom.SuperMethodInvocation;
import org.eclipse.wst.jsdt.core.dom.SwitchCase;
import org.eclipse.wst.jsdt.core.dom.SwitchStatement;
import org.eclipse.wst.jsdt.core.dom.TagElement;
import org.eclipse.wst.jsdt.core.dom.TextElement;
import org.eclipse.wst.jsdt.core.dom.ThisExpression;
import org.eclipse.wst.jsdt.core.dom.ThrowStatement;
import org.eclipse.wst.jsdt.core.dom.TryStatement;
import org.eclipse.wst.jsdt.core.dom.TypeDeclaration;
import org.eclipse.wst.jsdt.core.dom.TypeDeclarationStatement;
import org.eclipse.wst.jsdt.core.dom.TypeLiteral;
import org.eclipse.wst.jsdt.core.dom.UndefinedLiteral;
import org.eclipse.wst.jsdt.core.dom.VariableDeclaration;
import org.eclipse.wst.jsdt.core.dom.VariableDeclarationExpression;
import org.eclipse.wst.jsdt.core.dom.VariableDeclarationFragment;
import org.eclipse.wst.jsdt.core.dom.VariableDeclarationStatement;
import org.eclipse.wst.jsdt.core.dom.WhileStatement;
import org.eclipse.wst.jsdt.core.dom.WithStatement;
import org.eclipse.wst.jsdt.internal.codeassist.HierarchicalASTVisitor;

/**
 * Visit the AST following the scope for the position.
 * Marks all the variables, functions etc on the way for code completion.
 */
public class ScopedCodeAssistVisitor extends HierarchicalASTVisitor {

	// TODO: For recently used methods, create new visitor that extends ASTVisitor. Makes sense to cache that.

	private ArrayList<IdentifierProposal> identifiers = new ArrayList<IdentifierProposal>();
	private String mostRecentSimpleName;
	private Stack<String> fieldNameStack = new Stack<String>();
	private boolean inFieldAccess;
	IdentifierProposal currentIdentifier;

	int filePosition;
	boolean global;
	public Stack<Scope> scopes = new Stack<Scope>();

	public class Scope {
		ArrayList<CompletionProposal> proposals = new ArrayList<CompletionProposal>();
	}

	public List<IdentifierProposal> getIdentifiers() {
		return identifiers;
	}

	public List<IdentifierProposal> getIdentifiers(String key) {
		printIdentifierTree();
		return getIdentifiers(key, identifiers);
	}

	private List<IdentifierProposal> getIdentifiers(String key, List<IdentifierProposal> proposals) {
		System.out.println("Looking for... " + key);
		if (key.contains(".")) {
			String[] splitString = key.split("\\.", 2);
			String firstIdentifier = splitString[0];
			String rest = splitString[1];
			System.out.println("first is:" + firstIdentifier);
			System.out.println("rest is:" + rest);
			for (IdentifierProposal identifier : proposals) {
				System.out.println("Checking : " + identifier.getName());
				if (identifier.getName().equals(firstIdentifier)) {
					return getIdentifiers(rest, identifier.getFields());
				}
			}
			return Collections.emptyList();
		} else {
			return proposals.stream().filter(k -> k.getName().startsWith(key)).collect(Collectors.toList());
		}

	}

	public void clearIdentifierProposals() {
		this.identifiers.clear();
	}

	public ScopedCodeAssistVisitor(int position) {
		filePosition = position;
	}

	/**
	 * Determines whether the file position is inside the given ASTNode.
	 */
	private boolean isInside(ASTNode node) {
		int start = node.getStartPosition();
		int end = start + node.getLength();

		return (start <= filePosition) && (filePosition < end);
	}

	public boolean visit(JavaScriptUnit node) {
		System.out.println("JavaScriptUnit >>");
		// Push the global scope.
		scopes.push(new Scope());
		System.out.println(scopes.size());
		return true;
	}

	public boolean visit(AnonymousClassDeclaration node) {
		System.out.println("AnonymousClassDeclaration >>");
		return true;
	}

	public boolean visit(ArrayAccess node) {
		System.out.println("ArrayAccess >>");
		return true;
	}

	public boolean visit(ArrayCreation node) {
		System.out.println("ArrayCreation >>");
		return true;
	}

	public boolean visit(ArrayInitializer node) {
		System.out.println("ArrayInitializer >>");
		return true;
	}

	public boolean visit(ArrayType node) {
		System.out.println("ArrayType >>");
		return true;
	}

	public boolean visit(Assignment node) {
		System.out.println("Assignment >> " + node.toString());
		String name;
		if (node.toString().contains(".")) {
			name = node.toString().split("\\.")[0];
		} else {
			name = node.toString().split("=")[0];
		}

		if (!identifierExists(name, identifiers)) {
			IdentifierProposal proposal = new IdentifierProposal(name);
			proposal.setIsGlobal(scopes.size() == 1);
			identifiers.add(proposal);
			currentIdentifier = proposal;
			System.out.println("Adding identifier: " + proposal.getName());
		}
		return true;
	}

	public void endVisit(Assignment node) {
		System.out.println("Assignment <<");
		currentIdentifier = null;
	}

	public boolean visit(BlockComment node) {
		System.out.println("BlockComment >>");
		return true;
	}

	public boolean visit(BooleanLiteral node) {
		System.out.println("BooleanLiteral >>");
		return true;
	}

	public boolean visit(BreakStatement node) {
		System.out.println("BreakStatement >>");
		return true;
	}

	public boolean visit(CharacterLiteral node) {
		System.out.println("CharacterLiteral >>");
		return true;
	}

	public boolean visit(RegularExpressionLiteral node) {
		System.out.println("RegularExpressionLiteral >>");
		return true;
	}

	public boolean visit(ClassInstanceCreation node) {
		System.out.println("ClassInstanceCreation >>");
		return true;
	}

	public boolean visit(ConditionalExpression node) {
		System.out.println("ConditionalExpression >>");
		return true;
	}

	public boolean visit(ConstructorInvocation node) {
		System.out.println("ConstructorInvocation >>");
		return true;
	}

	public boolean visit(ContinueStatement node) {
		System.out.println("ContinueStatement >>");
		return true;
	}

	public boolean visit(DoStatement node) {
		System.out.println("DoStatement >>");
		return true;
	}

	public boolean visit(EmptyStatement node) {
		System.out.println("EmptyStatement >>");
		return true;
	}

	public boolean visit(EnhancedForStatement node) {
		System.out.println("EnhancedForStatement >>");
		return true;
	}

	public boolean visit(ExpressionStatement node) {
		System.out.println("ExpressionStatement >>" + node);
		return true;
	}

	private IdentifierProposal getFieldAccessParent(String fieldName, Expression fieldExpression) {
		System.out.println("Searching for ... " + fieldName + " ... in ... " + fieldExpression.toString());
		String rootId, parentId;
		if (fieldExpression.toString().contains(".")) {
			String[] splitExpression = fieldExpression.toString().split("\\.");
			rootId = splitExpression[0];
			parentId = splitExpression[splitExpression.length - 1];
		} else {
			return getIdentifier(fieldExpression.toString());
		}

		IdentifierProposal root = getIdentifier(rootId);
		if (root == null) {
			return null;
		}
		return findField(parentId, root);
	}

	private IdentifierProposal findField(String fieldName, IdentifierProposal root) {
		if (root.getName().equals(fieldName)) {
			return root;
		}
		for (IdentifierProposal fieldProposal : root.getFields()) {
			IdentifierProposal found = findField(fieldName, fieldProposal);
			if (found != null) {
				return found;
			}
		}
		return null;
	}

	private IdentifierProposal getIdentifier(String string) {
		System.out.println("Getting " + string);
		List<IdentifierProposal> matchingIdentifiers = identifiers.stream().filter(k -> k.getName().equals(string)).collect(Collectors.toList());
		if (matchingIdentifiers.isEmpty()) {
			return null;
		}
		return matchingIdentifiers.get(0);
	}

	public boolean visit(FieldAccess node) {
		System.out.println("FieldAccess >> " + node.getName() + " Expression: " + node.getExpression());

		return true;
	}

	public void endVisit(FieldAccess node) {
		System.out.println("FieldAccess <<");
		IdentifierProposal field = new IdentifierProposal(node.getName().toString());
		IdentifierProposal parent = getFieldAccessParent(node.getName().toString(), node.getExpression());
		System.out.println("\t Parent is: "+ parent);
		if ((parent != null) && !identifierExists(field.getName(), parent.getFields())) {
			parent.addField(field);
			currentIdentifier = field;
		}
	}

	public boolean visit(FieldDeclaration node) {
		System.out.println("FieldDeclaration >>");
		return true;
	}

	public boolean visit(IfStatement node) {
		System.out.println("IfStatement >>");
		return true;
	}

	public boolean visit(ImportDeclaration node) {
		System.out.println("ImportDeclaration >>");
		return true;
	}

	public boolean visit(InferredType node) {
		System.out.println("InferredType >>");
		return true;
	}

	public boolean visit(InfixExpression node) {
		System.out.println("InfixExpression >>");
		return true;
	}

	public boolean visit(InstanceofExpression node) {
		System.out.println("InstanceofExpression >>");
		return true;
	}

	public boolean visit(LabeledStatement node) {
		System.out.println("LabeledStatement >>");
		return true;
	}

	public boolean visit(LineComment node) {
		System.out.println("LineComment >>");
		return true;
	}

	public boolean visit(ListExpression node) {
		System.out.println("ListExpression >>");
		return true;
	}

	public boolean visit(MemberRef node) {
		System.out.println("MemberRef >>");
		return true;
	}

	public boolean visit(FunctionRef node) {
		System.out.println("FunctionRef >>");
		return true;
	}

	public boolean visit(FunctionRefParameter node) {
		System.out.println("FunctionRefParameter >>");
		return true;
	}

	public boolean visit(FunctionInvocation node) {
		System.out.println("FunctionInvocation >>");
		return true;
	}

	public boolean visit(Modifier node) {
		System.out.println("Modifier >>");
		return true;
	}

	public boolean visit(NullLiteral node) {
		System.out.println("NullLiteral >>");
		return true;
	}

	public boolean visit(UndefinedLiteral node) {
		System.out.println("UndefinedLiteral >>");
		return true;
	}

	public boolean visit(NumberLiteral node) {
		System.out.println("NumberLiteral >>");
		return true;
	}

	public boolean visit(PackageDeclaration node) {
		System.out.println("PackageDeclaration >>");
		return true;
	}

	public boolean visit(ParenthesizedExpression node) {
		System.out.println("ParenthesizedExpression >>");
		return true;
	}

	public boolean visit(PostfixExpression node) {
		System.out.println("PostfixExpression >>");
		return true;
	}

	public boolean visit(PrefixExpression node) {
		System.out.println("PrefixExpression >>");
		return true;
	}

	public boolean visit(PrimitiveType node) {
		System.out.println("PrimitiveType >>");
		return true;
	}

	public boolean visit(QualifiedName node) {
		System.out.println("QualifiedName >>");
		return true;
	}

	public boolean visit(QualifiedType node) {
		System.out.println("QualifiedType >>");
		return true;
	}

	public boolean visit(ReturnStatement node) {
		System.out.println("ReturnStatement >>");
		return true;
	}

	public boolean visit(SimpleName node) {
		System.out.println("SimpleName >>");
		mostRecentSimpleName = node.getIdentifier().toString();
		System.out.println(mostRecentSimpleName);
		return true;
	}

	public void endVisit(SimpleName node) {
		System.out.println("SimpleName <<");
		if (inFieldAccess) {
		}
	}

	public boolean visit(SimpleType node) {
		System.out.println("SimpleType >>");
		return true;
	}

	public boolean visit(SingleVariableDeclaration node) {
		System.out.println("SingleVariableDeclaration >>");
		IdentifierProposal proposal = new IdentifierProposal(mostRecentSimpleName);
		proposal.setIsGlobal(scopes.size() == 1);
		System.out.println("Adding identifier: " + proposal.getName());
		identifiers.add(proposal);
		return true;
	}

	public void endVisit(SingleVariableDeclaration node) {
		System.out.println("SingleVariableDeclaration >>");
	}

	public boolean visit(StringLiteral node) {
		System.out.println("StringLiteral >>");
		return true;
	}

	public boolean visit(SuperConstructorInvocation node) {
		System.out.println("SuperConstructorInvocation >>");
		return true;
	}

	public boolean visit(SuperFieldAccess node) {
		System.out.println("SuperFieldAccess >>");
		return true;
	}

	public boolean visit(SuperMethodInvocation node) {
		System.out.println("SuperMethodInvocation >>");
		return true;
	}

	public boolean visit(SwitchCase node) {
		System.out.println("SwitchCase >>");
		return true;
	}

	public boolean visit(SwitchStatement node) {
		System.out.println("SwitchStatement >>");
		return true;
	}

	public boolean visit(TagElement node) {
		System.out.println("TagElement >>");
		return true;
	}


	public boolean visit(TextElement node) {
		System.out.println("TextElement >>");
		return true;
	}

	public boolean visit(ThisExpression node) {
		System.out.println("ThisExpression >>");
		return true;
	}

	public boolean visit(ThrowStatement node) {
		System.out.println("ThrowStatement >>");
		return true;
	}

	public boolean visit(TryStatement node) {
		System.out.println("TryStatement >>");
		return true;
	}

	public boolean visit(TypeDeclaration node) {
		System.out.println("TypeDeclaration >>");
		return true;
	}

	public boolean visit(TypeLiteral node) {
		System.out.println("TypeLiteral >>");
		return true;
	}

	public boolean visit(VariableDeclarationFragment node) {
		System.out.println("VariableDeclarationFragment >>");
		IdentifierProposal identifierProposal = new IdentifierProposal(node.getName().getIdentifier());
		identifierProposal.setIsGlobal(scopes.size() == 1);
		System.out.println("Adding identifier: " + node.getName().getIdentifier());
		identifiers.add(identifierProposal);
		currentIdentifier = identifierProposal;
		return true;
	}

	public void endVisit(VariableDeclarationFragment node) {
		currentIdentifier = null;
		System.out.println("VariableDeclarationFragment <<");
	}

	public boolean visit(WhileStatement node) {
		System.out.println("WhileStatement >>");
		return true;
	}

	public boolean visit(WithStatement node) {
		System.out.println("WithStatement >>");
		return true;
	}

	public boolean visit(FunctionExpression node) {
		System.out.println("FunctionExpression >>");
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.wst.jsdt.internal.codeassist.HierarchicalASTVisitor#endVisit(org.eclipse.wst.jsdt.core.dom.JavaScriptUnit)
	 */
	public void endVisit(JavaScriptUnit node) {
		System.out.println("JavaScriptUnit >>");
//		//Send all the proposals from all scopes
//		for (Scope scope : scopes) {
//			for (CompletionProposal proposal : scope.proposals) {
//			}
//		}
		super.endVisit(node);
	}

	public boolean visit(FunctionDeclaration node) {
		System.out.println("FunctionDeclaration >>" + node);
		IdentifierProposal proposal;
		if (currentIdentifier == null) {
			String name;
			Expression methodName = node.getMethodName();
			name = methodName.toString();
			proposal = new IdentifierProposal(name);
			System.out.println("Adding identifier: " + proposal.getName());
			identifiers.add(proposal);
			proposal.setIsGlobal(scopes.size() == 1);
		} else {
			proposal = currentIdentifier;
		}

		proposal.setType(IdentifierType.FUNCTION);
		List<String> parameterNames = (List<String>) node.parameters().stream().map(k -> ((SingleVariableDeclaration) k).getName().toString()).collect(Collectors.toList());
		proposal.setParameters(parameterNames);
		proposal.setJSdoc(node.getJavadoc());

		if (node.getName() == null) {
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

		if (isInside(node)) {
			Block body = node.getBody();
			if (body != null) {
				// New function scope
				scopes.push(new Scope());
				body.accept(this);
			}
			visitBackwards(node.parameters());
		}

		// Doesn't recognize anything inside function body.
		return false;
	}

	public void endVisit(FunctionDeclaration node) {
		System.out.println("FunctionDeclaration <<");
	}

	public boolean visit(Initializer node) {
		System.out.println("Initializer >>");
		return isInside(node);
	}

	public boolean visit(Statement node) {
		System.out.println("Statement >>" + node.toString());

		return true;
	}

	public boolean visit(Block node) {
		System.out.println("block >>");

		return true;
	}

	public boolean visit(VariableDeclaration node) {
		System.out.println("VariableDeclaration >> " + node);

		// TODO: object literal fields and methods
//		visit(node.getBodyChild());
//		if (node.getStartPosition() < filePosition) {
//			if (node.getName() != null) {
//				System.out.println("Variable Declaration >> " + node);
//				final String nodeName = node.getName().toString();
//				CompletionProposal proposal = createProposal(CompletionProposal.LOCAL_VARIABLE_REF, nodeName, nodeName);
//				Scope currentScope = scopes.peek();
//				currentScope.proposals.add(proposal);
//			}
//		}
		return true;
	}

	public boolean visit(VariableDeclarationStatement node) {
		System.out.println("VariableDeclarationStatement >> " + node.fragments());
		visitBackwards(node.fragments());
		return false;
	}

	public boolean visit(VariableDeclarationExpression node) {
		System.out.println("VariableDeclarationExpression >> " + node.fragments());
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
		System.out.println("ForStatement >>");
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

	public boolean visit(ObjectLiteral node) {
		System.out.println("ObjectLiteral >> " + node);
		return true;
	}

	public boolean visit(ObjectLiteralField node) {
		System.out.println("ObjectLiteralField >> " + node.getFieldName());
//		variableStack.peek().addField(node.getFieldName().toString());
		return true;
	}

	public boolean visit(TypeDeclarationStatement node) {
		System.out.println("TypeDeclarationStatement >>");
		if ((node.getStartPosition() + node.getLength()) < filePosition) {
			IBinding binding = node.getDeclaration().getName().resolveBinding();
			if (binding != null) {
				CompletionProposal proposal = CompletionProposal.create(CompletionProposal.LOCAL_VARIABLE_REF, filePosition);
				proposal.setCompletion(binding.getName().toCharArray());
//				requestor.accept(proposal);
			}
			return false;
		}
		return isInside(node);
	}

	private void visitBackwards(List<ASTNode> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			ASTNode curr = list.get(i);
			curr.accept(this);
		}
	}

	private boolean identifierExists(String identifierName, List<IdentifierProposal> proposals) {
		return proposals.stream().filter(k -> k.getName() == identifierName).collect(Collectors.toList()).size() > 0;
	}

	private void printIdentifierTree() {
		for (IdentifierProposal identifier : identifiers) {
			System.out.println("> " + identifier.getName());
			printIdentifierTree(1, identifier.getFields());
		}
	}

	private void printIdentifierTree(int indent, List<IdentifierProposal> proposals) {
		for (IdentifierProposal identifier : proposals) {
			System.out.println("> " + new String(new char[indent]).replace("\0", "    ") + identifier.getName());
			printIdentifierTree(indent + 1, identifier.getFields());
		}

	}



}