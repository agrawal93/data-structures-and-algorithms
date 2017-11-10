package com.agrawal93.tree;

import com.agrawal93.tree.node.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 * @param <T>
 */
public abstract class BinaryTree<T extends Comparable> {

    protected Node<T> root;

    public final void insert(T value) {
        root = insertRecursively(root, value);
    }

    public final void remove(T value) {
        removeRecursively(root, value);
    }

    public final Node<T> search(T value) {
        return searchRecursively(root, value);
    }

    protected abstract Node<T> insertRecursively(Node<T> root, T value);

    protected abstract Node<T> removeRecursively(Node<T> root, T value);

    protected abstract Node<T> searchRecursively(Node<T> root, T value);

    public List<T> inorderTraversal() {
        List<T> result = new ArrayList<>();
        inorderTraversalRecursively(root, result);
        return result;
    }

    public List<T> preorderTraversal() {
        List<T> result = new ArrayList<>();
        preorderTraversalRecursively(root, result);
        return result;
    }

    public List<T> postorderTraversal() {
        List<T> result = new ArrayList<>();
        postorderTraversalRecursively(root, result);
        return result;
    }

    private void inorderTraversalRecursively(Node<T> root, List<T> result) {
        if (root == null) {
            return;
        }

        inorderTraversalRecursively(root.left, result);
        result.add(root.value);
        inorderTraversalRecursively(root.right, result);
    }

    private void preorderTraversalRecursively(Node<T> root, List<T> result) {
        if (root == null) {
            return;
        }

        result.add(root.value);
        preorderTraversalRecursively(root.left, result);
        preorderTraversalRecursively(root.right, result);
    }

    private void postorderTraversalRecursively(Node<T> root, List<T> result) {
        if (root == null) {
            return;
        }

        postorderTraversalRecursively(root.left, result);
        postorderTraversalRecursively(root.right, result);
        result.add(root.value);
    }

    protected static <K extends Comparable> Node<K> createNodeUsingPreOrder(List<K> preOrderTraversal, AtomicInteger index, K lowerBound, K upperBound) {
        if (index.get() >= preOrderTraversal.size()) {
            return null;
        }

        K value = preOrderTraversal.get(index.get());

        Node root = null;
        if ((lowerBound != null && value.compareTo(lowerBound) < 0) || (upperBound != null && value.compareTo(upperBound) >= 0)) {
            return root;
        }

        root = new Node<>(value);
        index.incrementAndGet();

        if (index.get() >= preOrderTraversal.size()) {
            return root;
        }

        root.left = createNodeUsingPreOrder(preOrderTraversal, index, lowerBound, value);
        root.right = createNodeUsingPreOrder(preOrderTraversal, index, value, upperBound);

        return root;
    }

}
