package com.agrawal93.tree.node;

import java.util.Objects;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 * @param <T>
 */
public class Node<T extends Comparable> {

    public T value;
    public Node<T> left;
    public Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Node)) {
            return false;
        }

        Node<T> that = (Node<T>) o;
        if (this.value.compareTo(that.value) != 0) {
            return false;
        }
        if (this.left != null && !this.left.equals(that.left)) {
            return false;
        }
        return this.right == null ? true : this.right.equals(that.right);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.value);
        hash = 47 * hash + Objects.hashCode(this.left);
        hash = 47 * hash + Objects.hashCode(this.right);
        return hash;
    }

}
