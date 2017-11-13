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
public class PostOrderTraversalTest {

    private static final BinarySearchTree TREE = new BinarySearchTree();
    private static final List<Integer> VALUES = Arrays.asList(10, 5, 1, 7, 40, 50);
    private static final List<Integer> RESULT = Arrays.asList(1, 7, 5, 50, 40, 10);

    @BeforeClass
    public static void init() {
        VALUES.forEach(TREE::insert);
    }

    @AfterClass
    public static void removeNodes() {
        VALUES.forEach(TREE::remove);
    }

    @Test
    public void postOrderRecursive() {
        Assert.assertEquals(RESULT, PostOrderTraversal.traverse(TREE, PostOrderTraversal.TraversalMethod.RECURSIVE));
    }

    @Test
    public void postOrderIterativeOneStack() {
        Assert.assertEquals(RESULT, PostOrderTraversal.traverse(TREE, PostOrderTraversal.TraversalMethod.ITERATIVE_ONE_STACK));
    }

    @Test
    public void postOrderIterativeTwoStack() {
        Assert.assertEquals(RESULT, PostOrderTraversal.traverse(TREE, PostOrderTraversal.TraversalMethod.ITERATIVE_TWO_STACK));
    }
    
}
