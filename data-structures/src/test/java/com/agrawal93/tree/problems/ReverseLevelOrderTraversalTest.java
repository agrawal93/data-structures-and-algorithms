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
public class ReverseLevelOrderTraversalTest {

    private static final BinarySearchTree TREE = new BinarySearchTree();
    private static final List<Integer> VALUES = Arrays.asList(10, 5, 1, 7, 40, 50);
    private static final List<Integer> RESULT = Arrays.asList(1, 7, 50, 5, 40, 10);

    @BeforeClass
    public static void init() {
        VALUES.forEach(TREE::insert);
    }

    @AfterClass
    public static void removeNodes() {
        VALUES.forEach(TREE::remove);
    }

    @Test
    public void reverseLevelOrderRecursive() {
        Assert.assertEquals(RESULT, ReverseLevelOrderTraversal.traverse(TREE, ReverseLevelOrderTraversal.TraversalMethod.RECURSIVE));
    }

    @Test
    public void reverseLevelOrderIterative() {
        Assert.assertEquals(RESULT, ReverseLevelOrderTraversal.traverse(TREE, ReverseLevelOrderTraversal.TraversalMethod.ITERATIVE));
    }

    @Test
    public void reverseLevelOrderLineByLine() {
        Assert.assertEquals(Arrays.asList(Arrays.asList(1, 7, 50), Arrays.asList(5, 40), Arrays.asList(10)), ReverseLevelOrderTraversal.traverse_LineByLine(TREE.root()));
    }

}
