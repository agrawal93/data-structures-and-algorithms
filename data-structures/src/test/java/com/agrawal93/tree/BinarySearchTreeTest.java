package com.agrawal93.tree;

import com.agrawal93.tree.node.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class BinarySearchTreeTest {

    private static final BinarySearchTree TREE = new BinarySearchTree();
    private static final List<Integer> VALUES = Arrays.asList(10, 5, 1, 7, 40, 50);
    private static final List<Integer> INTEGERS = new ArrayList<>();

    @BeforeClass
    public static void init() {
        for (int i = 0; i <= 100; i++) {
            INTEGERS.add(i);
        }

        System.out.println("[TEST] Inserting Nodes to Binary Search Tree");
        VALUES.forEach(TREE::insert);
    }

    @AfterClass
    public static void removeNodes() {
        System.out.println("[TEST] Removing Nodes from Binary Search Tree");
        AtomicInteger count = new AtomicInteger();
        INTEGERS.forEach(number -> {
            Node<Integer> node = TREE.remove(number);
            if (VALUES.contains(number)) {
                Assert.assertNotEquals(null, node);
                Assert.assertEquals(number, node.value);
                count.incrementAndGet();
            } else {
                Assert.assertEquals(null, node);
            }
        });
        Assert.assertEquals(VALUES.size(), count.get());
    }

    @Test
    public void leaves() {
        System.out.println("[TEST] Count of Leaf Nodes of Binary Search Tree");
        Assert.assertEquals(3, TREE.leafCount());
    }
    
    @Test
    public void size() {
        System.out.println("[TEST] Size of Binary Search Tree (Total Number of Nodes)");
        Assert.assertEquals(VALUES.size(), TREE.size());
    }
    
    @Test
    public void height() {
        System.out.println("[TEST] Height of Binary Search Tree");
        Assert.assertEquals(3, TREE.height());
    }

    @Test
    public void inOrderTraversal() {
        System.out.println("[TEST] InOrder Traversal of Binary Search Tree");
        Assert.assertEquals(Arrays.asList(1, 5, 7, 10, 40, 50), TREE.inorderTraversal());
    }

    @Test
    public void preOrderTraversal() {
        System.out.println("[TEST] PreOrder Traversal of Binary Search Tree");
        Assert.assertEquals(VALUES, TREE.preorderTraversal());
    }

    @Test
    public void postOrderTraversal() {
        System.out.println("[TEST] PostOrder Traversal of Binary Search Tree");
        Assert.assertEquals(Arrays.asList(1, 7, 5, 50, 40, 10), TREE.postorderTraversal());
    }

    @Test
    public void levelOrderTraversal() {
        System.out.println("[TEST] LevelOrder Traversal of Binary Search Tree");
        Assert.assertEquals(Arrays.asList(10, 5, 40, 1, 7, 50), TREE.levelorderTraversal());
    }

    @Test
    public void levelOrderByLinesTraversal() {
        System.out.println("[TEST] LevelOrder LineByLine Traversal of Binary Search Tree");
        Assert.assertEquals(Arrays.asList(Arrays.asList(10), Arrays.asList(5, 40), Arrays.asList(1, 7, 50)), TREE.levelorderTraversalByLines());
    }

    @Test
    public void createTreeFromPreOrderTest() {
        System.out.println("[TEST] Creating Tree From PreOrder Traversal of Binary Search Tree");
        Assert.assertEquals(TREE, BinarySearchTree.treeFromPreOrder(TREE.preorderTraversal()));
    }

    @Test
    public void createTreeFromPostOrderTest() {
        System.out.println("[TEST] Creating Tree From PostOrder Traversal of Binary Search Tree");
        Assert.assertEquals(TREE, BinarySearchTree.treeFromPostOrder(TREE.postorderTraversal()));
    }

    @Test
    public void searchNodesTest() {
        System.out.println("[TEST] Searching Nodes In Binary Search Tree");
        INTEGERS
                .parallelStream()
                .forEach(number -> {
                    Node<Integer> node = TREE.search(number);
                    if (VALUES.contains(number)) {
                        Assert.assertNotEquals(null, node);
                        Assert.assertEquals(number, node.value);
                    } else {
                        Assert.assertEquals(null, node);
                    }
                });
    }

}
