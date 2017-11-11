package com.agrawal93.tree;

import com.agrawal93.tree.node.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

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

    public final Node<T> remove(T value) {
        AtomicReference<Node<T>> removedNode = new AtomicReference<>();
        removeRecursively(root, value, removedNode);
        return removedNode.get();
    }

    public final Node<T> search(T value) {
        return searchRecursively(root, value);
    }

    protected abstract Node<T> insertRecursively(Node<T> root, T value);

    protected abstract Node<T> removeRecursively(Node<T> root, T value, AtomicReference<Node<T>> removedNode);

    protected abstract Node<T> searchRecursively(Node<T> root, T value);

    @Override
    public boolean equals(Object that) {
        if (that == null || !(that instanceof BinaryTree)) {
            return false;
        }
        return this.root.equals(((BinaryTree) that).root);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.root);
        return hash;
    }

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

    public List<T> levelorderTraversal() {
        List<T> result = new ArrayList<>();
        levelorderTraversalByLines().stream().forEach(list -> list.stream().forEach(result::add));
        return result;
    }

    public List<List<T>> levelorderTraversalByLines() {
        List<List<T>> result = new ArrayList<>();

        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            List<T> levelList = new ArrayList<>(levelCount);
            while (levelCount-- > 0) {
                Node<T> current = queue.poll();
                levelList.add(current.value);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(levelList);
        }

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

    protected static <K extends Comparable> Node<K> createTreeUsingPreOrder(List<K> preOrderTraversal, AtomicInteger index, K lowerBound, K upperBound) {
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

        root.left = createTreeUsingPreOrder(preOrderTraversal, index, lowerBound, value);
        root.right = createTreeUsingPreOrder(preOrderTraversal, index, value, upperBound);

        return root;
    }

    protected static <K extends Comparable> Node<K> createTreeUsingPostOrder(List<K> postOrderTraversal, AtomicInteger index, K lowerBound, K upperBound) {
        if (index.get() < 0) {
            return null;
        }

        K value = postOrderTraversal.get(index.get());

        Node root = null;
        if ((lowerBound != null && value.compareTo(lowerBound) < 0) || (upperBound != null && value.compareTo(upperBound) >= 0)) {
            return root;
        }

        root = new Node<>(value);
        index.decrementAndGet();

        if (index.get() < 0) {
            return root;
        }

        root.right = createTreeUsingPostOrder(postOrderTraversal, index, value, upperBound);
        root.left = createTreeUsingPostOrder(postOrderTraversal, index, lowerBound, value);

        return root;
    }

}
