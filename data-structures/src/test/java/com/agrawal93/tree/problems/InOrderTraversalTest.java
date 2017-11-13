package com.agrawal93.tree.problems;

import com.agrawal93.tree.BinarySearchTree;
import java.util.Arrays;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class InOrderTraversalTest {

    private static final BinarySearchTree TREE = new BinarySearchTree();
    private static final List<Integer> VALUES = Arrays.asList(10, 5, 1, 7, 40, 50);
    private static final List<Integer> RESULT = Arrays.asList(1, 5, 7, 10, 40, 50);

    @BeforeClass
    public static void init() {
        VALUES.forEach(TREE::insert);
    }

    @AfterClass
    public static void removeNodes() {
        VALUES.forEach(TREE::remove);
    }

    @Test
    public void inOrderRecursive() {
        Assert.assertEquals(RESULT, InOrderTraversal.traverse(TREE, InOrderTraversal.TraversalMethod.RECURSIVE));
    }

    @Test
    public void inOrderIterative() {
        Assert.assertEquals(RESULT, InOrderTraversal.traverse(TREE, InOrderTraversal.TraversalMethod.ITERATIVE));
    }

}
