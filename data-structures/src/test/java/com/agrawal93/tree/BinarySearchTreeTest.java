package com.agrawal93.tree;

import com.google.common.base.Stopwatch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class BinarySearchTreeTest {

    private final int MAX_SIZE = 1000001;

    @Test
    public void test() {

        final List<Integer> numberList = new ArrayList<>();
        final BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        Random random = new Random();
        for (int i = 0; i < MAX_SIZE; i++) {
            numberList.add(random.nextInt());
        }

        Stopwatch timer = Stopwatch.createStarted();
        numberList.forEach((number) -> {
            binarySearchTree.insert(number);
        });
        System.out.println("[PERF] Inserting One Million Numbers: " + timer.stop());

        timer = Stopwatch.createStarted();
        List<Integer> traversalResult = binarySearchTree.inorderTraversal();
        System.out.println("[PERF] InOrder Traversal Time: " + timer.stop());
        Collections.sort(numberList);
        Assert.assertEquals(numberList, traversalResult);

        timer = Stopwatch.createStarted();
        List<Integer> preOrderTraversal = binarySearchTree.preorderTraversal();
        System.out.println("[PERF] PreOrder Traversal Time: " + timer.stop());

        timer = Stopwatch.createStarted();
        traversalResult = binarySearchTree.postorderTraversal();
        System.out.println("[PERF] PostOrder Traversal Time: " + timer.stop());
        
        timer = Stopwatch.createStarted();
        BinarySearchTree<Integer> treeFromPreOrderTraversal = BinarySearchTree.treeFromPreOrder(preOrderTraversal);
        System.out.println("[PERF] Tree Creation using PreOrder Traversal [ O(N) ]: " + timer.stop());

        Assert.assertEquals(traversalResult, treeFromPreOrderTraversal.postorderTraversal());

        Collections.shuffle(numberList);
        timer = Stopwatch.createStarted();
        numberList.forEach((number) -> {
            binarySearchTree.search(number);
        });
        System.out.println("[PERF] Searching One Million Numbers: " + timer.stop());

        Collections.shuffle(numberList);
        timer = Stopwatch.createStarted();
        numberList.forEach((number) -> {
            binarySearchTree.remove(number);
        });
        System.out.println("[PERF] Removing One Million Numbers: " + timer.stop());
    }

}
