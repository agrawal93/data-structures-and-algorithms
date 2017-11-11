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
                Assert.assertNotEquals(node, null);
                Assert.assertEquals(node.value, number);
                count.incrementAndGet();
            } else {
                Assert.assertEquals(node, null);
            }
        });
        Assert.assertEquals(count.get(), VALUES.size());
    }

    @Test
    public void inOrderTraversal() {
        System.out.println("[TEST] InOrder Traversal of Binary Search Tree");
        Assert.assertEquals(TREE.inorderTraversal(), Arrays.asList(1, 5, 7, 10, 40, 50));
    }

    @Test
    public void preOrderTraversal() {
        System.out.println("[TEST] PreOrder Traversal of Binary Search Tree");
        Assert.assertEquals(TREE.preorderTraversal(), VALUES);
    }

    @Test
    public void postOrderTraversal() {
        System.out.println("[TEST] PostOrder Traversal of Binary Search Tree");
        Assert.assertEquals(TREE.postorderTraversal(), Arrays.asList(1, 7, 5, 50, 40, 10));
    }

    @Test
    public void levelOrderTraversal() {
        System.out.println("[TEST] LevelOrder Traversal of Binary Search Tree");
        Assert.assertEquals(TREE.levelorderTraversal(), Arrays.asList(10, 5, 40, 1, 7, 50));
    }

    @Test
    public void levelOrderByLinesTraversal() {
        System.out.println("[TEST] LevelOrder LineByLine Traversal of Binary Search Tree");
        Assert.assertEquals(TREE.levelorderTraversalByLines(), Arrays.asList(Arrays.asList(10), Arrays.asList(5, 40), Arrays.asList(1, 7, 50)));
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
                        Assert.assertNotEquals(node, null);
                        Assert.assertEquals(node.value, number);
                    } else {
                        Assert.assertEquals(node, null);
                    }
                });
    }

}
