package com.agrawal93.tree.problems;

import com.agrawal93.tree.BinaryTree;
import com.agrawal93.tree.node.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class LevelOrderTraversal {
    
    public static enum TraversalMethod {
        RECURSIVE,
        ITERATIVE
    }
    
    public static <T extends Comparable> List<T> traverse(BinaryTree<T> tree, TraversalMethod method) {
        List<T> result = new ArrayList<>();
        switch(method) {
            case RECURSIVE:
                long height = tree.height();
                for(long l = 1; l <= height; l++) {
                    traverse_Recursive(tree.root(), result, l);
                }
                break;
            case ITERATIVE:
                traverse_Iterative(tree.root(), result);
                break;
            default:
                throw new IllegalArgumentException("Invalid Traversal Method specified.");
        }
        return result;
    }
    
    private static <T extends Comparable> void traverse_Recursive(Node<T> root, List<T> result, long level) {
        if (root == null) {
            return;
        }

        if(level <= 1) result.add(root.value);
        else {
            traverse_Recursive(root.left, result, level-1);
            traverse_Recursive(root.right, result, level-1);
        }
    }
    
    private static <T extends Comparable> void traverse_Iterative(Node<T> root, List<T> result) {
        traverse_LineByLine(root).stream().forEach(list -> list.stream().forEach(result::add));
    }
    
    public static <T extends Comparable> List<List<T>> traverse_LineByLine(Node<T> root) {
        List<List<T>> result = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            List<T> levelList = new ArrayList<>(levelCount);
            while (levelCount-- > 0) {
                Node<T> current = queue.poll();
                levelList.add(current.value);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }
    
}
