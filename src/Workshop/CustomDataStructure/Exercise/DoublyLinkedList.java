package Workshop.CustomDataStructure.Exercise;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {

    class Node {
        int element;
        Node next;
        Node prev;

        public Node(int element) {
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    //•	void addFirst(int element) – adds an element at the beginning of the collection
    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    //•	void addLast(int element) – adds an element at the end of the collection

    public void addLast(int element) {
        Node newNode = new Node(element);

        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    //•	int get(int index) - Returns the element at the specified position in this list

    public int get(int index) {
        validateIndex(index);
        Node current;
        if (index <= this.size / 2) {
            current = this.head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = this.tail;
            for (int i = this.size - 1; i >= index; i--) {
                current = current.prev;
            }
        }

//        Node currentNode = this.head;
//        for (int i = 0; i < index; i++) {
//            currentNode = currentNode.next;
//        }
        return current.element;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException (
                    String.format("Index %d is out of bounds for size %d", index, this.size)
            );
        }
    }

    // int removeFirst() – removes the element at the beginning of the collection

    public int removeFirst() {
        checkEmpty();
        int element = this.head.element;
        this.head = this.head.next;
        // single element
        if (this.head == null) {
            this.tail = null;
        } else {
            // multiple elements
            this.head.prev = null;
        }

        this.size--;
        return element;
    }

    private void checkEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException("List is empty");
        }
    }

    //•	int removeLast() – removes the element at the end of the collection
    public int removeLast() {
        checkEmpty();
        int element = this.tail.element;
        this.tail = this.tail.prev;
        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }
        return element;
    }

    // •	void forEach() – goes through the collection and executes a given action

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    // •	int[] toArray() – returns the collection as an array

    public int[] toArray() {
        int[] array = new int[this.size];
        Node currentNode = this.head;
        for (int i = 0; i < this.size; i++) {
            array[i] = currentNode.element;
            currentNode = currentNode.next;
        }
        return array;
    }
}

