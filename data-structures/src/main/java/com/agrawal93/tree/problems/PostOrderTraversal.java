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
public class PostOrderTraversal {

    public static enum TraversalMethod {
        RECURSIVE,
        ITERATIVE_ONE_STACK,
        ITERATIVE_TWO_STACK
    }

    public static <T extends Comparable> List<T> traverse(BinaryTree<T> tree, TraversalMethod method) {
        List<T> result = new ArrayList<>();
        switch (method) {
            case RECURSIVE:
                traverse_Recursive(tree.root(), result);
                break;
            case ITERATIVE_ONE_STACK:
                traverse_IterativeOneStack(tree.root(), result);
                break;
            case ITERATIVE_TWO_STACK:
                traverse_IterativeTwoStack(tree.root(), result);
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
        traverse_Recursive(root.right, result);
        result.add(root.value);
    }

    private static <T extends Comparable> void traverse_IterativeOneStack(Node<T> root, List<T> result) {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> current = root;
        while (current != null) {
            if (current.right != null) {
                stack.push(current.right);
            }
            stack.push(current);
            current = current.left;
        }

        while (!stack.isEmpty()) {
            current = stack.pop();
            if (!stack.isEmpty() && stack.peek() == current.right) {
                stack.pop();
                stack.push(current);
                current = current.right;
            } else {
                result.add(current.value);
                current = null;
            }

            while (current != null) {
                if (current.right != null) {
                    stack.push(current.right);
                }
                stack.push(current);
                current = current.left;
            }
        }
    }
    
    private static <T extends Comparable> void traverse_IterativeTwoStack(Node<T> root, List<T> result) {
        if(root == null) return;
        
        Stack<Node<T>> stack1 = new Stack<>();
        Stack<Node<T>> stack2 = new Stack<>();
        
        stack1.push(root);
        while(!stack1.isEmpty()) {
            Node<T> current = stack1.pop();
            stack2.push(current);
            if(current.left != null) stack1.push(current.left);
            if(current.right != null) stack1.push(current.right);
        }
        
        while(!stack2.isEmpty()) {
            result.add(stack2.pop().value);
        }
    }

}
