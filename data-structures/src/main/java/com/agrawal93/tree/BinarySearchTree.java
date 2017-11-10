package com.agrawal93.tree;

import com.agrawal93.tree.node.Node;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable> extends BinaryTree<T> {

    @Override
    protected Node<T> insertRecursively(Node<T> root, T value) {
        if (root == null) {
            return new Node(value);
        }

        if (value.compareTo(root.value) < 0) {
            root.left = insertRecursively(root.left, value);
        } else {
            root.right = insertRecursively(root.right, value);
        }

        return root;
    }

    @Override
    protected Node<T> removeRecursively(Node<T> root, T value) {
        if (root == null) {
            return null;
        }

        int compareValue = value.compareTo(root.value);
        if (compareValue < 0) {
            root.left = removeRecursively(root.left, value);
        } else if (compareValue > 0) {
            root.right = removeRecursively(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.value = nextInorderSuccessor(root.right);
            root.right = removeRecursively(root.right, root.value);
        }

        return root;
    }

    @Override
    protected Node<T> searchRecursively(Node<T> root, T value) {
        if (root == null) {
            return null;
        }

        int compareValue = value.compareTo(root.value);
        if (compareValue == 0) {
            return root;
        }

        return compareValue < 0 ? searchRecursively(root.left, value) : searchRecursively(root.right, value);
    }

    private T nextInorderSuccessor(Node<T> root) {
        T minValue = root.value;
        while (root.left != null) {
            root = root.left;
            minValue = root.value;
        }
        return minValue;
    }

    public static <K extends Comparable> BinarySearchTree treeFromPreOrder(List<K> preOrderTraversal) {
        BinarySearchTree<K> tree = new BinarySearchTree<>();
        tree.root = BinaryTree.createNodeUsingPreOrder(preOrderTraversal, new AtomicInteger(0), null, null);
        return tree;
    }

}
