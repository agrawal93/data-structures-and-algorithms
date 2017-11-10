package com.agrawal93.tree.node;

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

}
