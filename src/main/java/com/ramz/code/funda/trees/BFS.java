package com.ramz.code.funda.trees;

import java.util.*;

public class BFS {

    public static <T> Optional<Node<T>> search(T value, Node<T> root) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(root);

        Node<T> currentNode;


        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.println("Visited node with value:" + currentNode.getValue());

            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                queue.addAll(currentNode.getChildren());
            }
        }

        System.out.println("No value found");
        return Optional.empty();
    }




    public static Node<Integer> searchV2(Integer value, Node<Integer> root) {

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            Node<Integer> readNode = queue.remove();

            System.out.println("Visited node with value:" + readNode.getValue());

            if(value.equals(readNode.getValue())) {
                return readNode;
            } else {
                queue.addAll(readNode.getChildren());
            }
        }

        System.out.println("No value found");
        return null;
    }



























}
