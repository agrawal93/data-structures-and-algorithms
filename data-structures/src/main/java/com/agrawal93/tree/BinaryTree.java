package com.agrawal93.tree;

import com.agrawal93.tree.node.Node;
import com.agrawal93.tree.problems.InOrderTraversal;
import com.agrawal93.tree.problems.LevelOrderTraversal;
import com.agrawal93.tree.problems.PostOrderTraversal;
import com.agrawal93.tree.problems.PreOrderTraversal;
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

    public Node<T> root() {
        return root;
    }
    
    public long leafCount() {
        return leafCountRecursively(root);
    }
    
    private long leafCountRecursively(Node<T> root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        long count = root.left == null ? 0 : leafCountRecursively(root.left);
        count += root.right == null ? 0 : leafCountRecursively(root.right);
        return count;
    }
    
    public long size() {
        return countRecursively(root);
    }
    
    private long countRecursively(Node<T> root) {
        if(root == null) return 0;
        
        long count = 1;
        count += root.left == null ? 0 : countRecursively(root.left);
        count += root.right == null ? 0 : countRecursively(root.right);
        return count;
    }
    
    public long height() {
        return heightRecursively(root);
    }

    private long heightRecursively(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightRecursively(root.left), heightRecursively(root.right));
    }

    public List<T> inorderTraversal() {
        return InOrderTraversal.traverse(this, InOrderTraversal.TraversalMethod.RECURSIVE);
    }

    public List<T> preorderTraversal() {
        return PreOrderTraversal.traverse(this, PreOrderTraversal.TraversalMethod.RECURSIVE);
    }

    public List<T> postorderTraversal() {
        return PostOrderTraversal.traverse(this, PostOrderTraversal.TraversalMethod.RECURSIVE);
    }

    public List<T> levelorderTraversal() {
        return LevelOrderTraversal.traverse(this, LevelOrderTraversal.TraversalMethod.ITERATIVE);
    }

    public List<List<T>> levelorderTraversalByLines() {
        return LevelOrderTraversal.traverse_LineByLine(root);
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
