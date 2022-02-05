package com.ramz.code.funda;

public class DoubleLinkedList {

    DLLNode head;

    /**
     * To add a node at the front
     * @param value
     */
    public void push(String value) {

        //Initialize Node
        DLLNode node = new DLLNode(value);

        //Update prev and next
        node.next = head;
        node.prev = null;

        //Update head info
        if(head != null) {
            head.prev = node;
        }

        head = node;
    }

    public void insertAfter(DLLNode prevNode, String value) {

        if (prevNode == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        //Initialize Node
        DLLNode newNode = new DLLNode(value);
        newNode.next = prevNode.next;

        prevNode.next = newNode;
        newNode.prev = prevNode;

        if(newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    public void insertBefore(DLLNode nextNode, String value) {

        if(nextNode == null)
        {
            System.out.println("The given next node can not be NULL");
            return;
        }

        DLLNode newNode = new DLLNode(value);

        newNode.prev = nextNode.prev;

        nextNode.prev = newNode;
        newNode.next = nextNode;

        if(newNode.prev != null) {
            newNode.prev.next = newNode;
        } else {
            head = newNode;
        }
    }

    public void addAtEnd(String value) {

        DLLNode newNode = new DLLNode(value);

        DLLNode node = head;

        newNode.next = null;
        if(head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }
        //Traverse to the end

        while(node.next != null) {
            node = node.next;
        }

        node.next = newNode;
        newNode.prev = node;
    }


    public void printList(DLLNode node) {

        while(node.next != null) {
            System.out.println(node.value + " ");
            node = node.next;
        }
        System.out.println(node.value);
    }

    public static void main(String[] args) {

        DoubleLinkedList dll = new DoubleLinkedList();

        // Insert 6. So linked list becomes 6->NULL
        dll.addAtEnd("6");
        // Insert 7 at the beginning. So
        // linked list becomes 7->6->NULL
        dll.push("7");

        // Insert 1 at the beginning. So
        // linked list becomes 1->7->6->NULL
        dll.push("1");

        // Insert 4 at the end. So linked
        // list becomes 1->7->6->4->NULL
        dll.addAtEnd("4");

        // Insert 8, after 7. So linked
        // list becomes 1->7->8->6->4->NULL
        dll.insertAfter(dll.head.next, "8");

        // Insert 5, before 8.So linked
        // list becomes 1->7->5->8->6->4
        dll.insertBefore(dll.head.next.next, "5");

        System.out.println("Created DLL is: ");
        dll.printList(dll.head);

    }

}
