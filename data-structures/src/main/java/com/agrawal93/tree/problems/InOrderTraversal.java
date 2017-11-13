package com.agrawal93.tree.problems;

import com.agrawal93.tree.BinaryTree;
import com.agrawal93.tree.node.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class InOrderTraversal {
    
    public static enum TraversalMethod {
        RECURSIVE,
        ITERATIVE
    }
    
    public static <T extends Comparable> List<T> traverse(BinaryTree<T> tree, TraversalMethod method) {
        List<T> result = new ArrayList<>();
        switch(method) {
            case RECURSIVE:
                traverse_Recursive(tree.root(), result);
                break;
            case ITERATIVE:
                traverse_Iterative(tree.root(), result);
                break;
            default:
                throw new IllegalArgumentException("Invalid Traversal Method specified.");
        }
        return result;
    }
    
    private static <T extends Comparable> void traverse_Recursive(Node<T> root, List<T> result) {
        if (root == null) {
            return;
        }

        traverse_Recursive(root.left, result);
        result.add(root.value);
        traverse_Recursive(root.right, result);
    }
    
    private static <T extends Comparable> void traverse_Iterative(Node<T> root, List<T> result) {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> current = root;
        while(current != null) {
            stack.push(current);
            current = current.left;
        }
        
        while(!stack.isEmpty()) {
            current = stack.pop();
            result.add(current.value);
            current = current.right;
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
        }
    }
    
}
