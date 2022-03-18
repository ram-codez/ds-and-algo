package com.ramz.code.funda.trees;

public class BFSClient {

    //https://www.baeldung.com/java-breadth-first-search
    //https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/?ref=lbp
    public static void main(String[] args) {

        Node<Integer> root = Node.of(10);
        Node<Integer> rootFirstChild = root.addChild(2);
        Node<Integer> depthMostChild = rootFirstChild.addChild(3);
        Node<Integer> rootSecondChild = root.addChild(4);

        BFS.searchV2(5, root);
    }
}
