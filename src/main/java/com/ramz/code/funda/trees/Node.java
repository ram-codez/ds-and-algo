package com.ramz.code.funda.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node<T> {

    private T value;
    private List<Node<T>> children;

    private Node(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public List<Node<T>> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public static <T> Node<T> of(T value) {
        return new Node<>(value);
    }

    public Node<T> addChild(T value) {
        Node<T> newChild = new Node<>(value);
        children.add(newChild);
        return newChild;
    }

}