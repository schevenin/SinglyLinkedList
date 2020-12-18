package LinkedLists;

public class SinglyLinkedList<E extends Comparable<E>> implements List<E> {
    // NODE CLASS
    public static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }
        public void setElement(E value) {
            element = value;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    // INSTANCE VARIABLES
    private Node<E> head;
    private Node<E> tail;
    private int size;

    // CONSTRUCTORS
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    public SinglyLinkedList(List<E> copy) {
        clear();

        // Add datum from copy
        for (int i = 0; i < copy.size(); i++) {
            add(copy.get(i));
        }
    }

    // ACCESS METHODS
    public int count(E target) {
        int count = 0;
        Node<E> temp = this.head;

        // Find target node and increment count
        for (int i = 0; temp != null && i < size() - 1; i++) {
            temp = temp.getNext();
            if (temp.getElement().compareTo(target) == 0) {
                count++;
            }
        }

        return count;
    }
    public E get(int index) {
        // If list is empty
        if (isEmpty()) {
            System.out.println("SinglyLinkedList is empty!");
            return null;
        }

        // Store head node
        Node<E> temp = this.head;

        // If returning head
        if (index == 0) {
            return temp.getElement();
        }

        // If index is within bounds of list
        if ((index >= size()*-1) && (index < size())) {

            // Change negative index to their respective positive index
            if (index < 0) {
                index += size();
            }

            // Find node with the value to be returned
            for (int i = 0; temp != null && i < index; i++) {
                temp = temp.getNext();
            }

            // If node is null
            if (temp != null) {
                return temp.getElement();
            } else {
                return null;
            }
        } else {
            System.out.println("Index out of bounds for size " + size());
            return null;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    // UPDATE METHODS
    public boolean add(List<E> other) {
        for (int i = 0; i < other.size(); i++) {
            add(other.get(i));
        }
        return true;
    }
    public boolean add(E datum) {
        return addLast(datum);
    }
    public boolean addFirst(E datum) {
        // Make new head point to old head
        head = new Node<>(datum, head);

        // Check contents
        if (isEmpty()) {
            tail = head;
        }

        // Update size
        size++;
        return true;
    }
    public boolean addLast(E datum) {
        // Make new node that points to null
        Node<E> newNode = new Node<>(datum, null);

        // Check contents
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }

        // Update tail & size
        tail = newNode;
        size++;
        return true;
    }
    public E remove(int index) {
        // If list is empty
        if (isEmpty()) {
            System.out.println("SinglyLinkedList is empty!");
            return null;
        }

        // Store head node
        Node<E> temp = this.head;

        // If removing head
        if (index == 0) {
            head = temp.getNext();
            size--;
            return temp.getElement();
        }

        // If index is within bounds of list
        if ((index >= size()*-1) && (index < size())) {

            // Change negative index to their respective positive index
            if (index < 0) {
                index += size();
            }

            // Find node before the node to be removed
            for (int i = 0; temp != null && i < index - 1; i++) {
                temp = temp.getNext();
            }

            // Store node before the node that is to be deleted
            Node<E> before = temp;

            // Store node to be deleted
            Node<E> delete = temp.getNext();

            // Store node after the node that is to be deleted
            Node<E> after = temp.getNext().getNext();

            // Point before->after, effectively deleting desired node
            before.setNext(after);
            size--;

            return delete.getElement();
        } else {
            System.out.println("Index out of bounds for size " + size());
            return null;
        }
    }
    public void clear() {
        head = null;
        size = 0;
    }
    public void reverse() {
        Node<E> pointer = head, previous = null, current;

        if (isEmpty()) {
            System.out.println("The list you're trying to reverse is empty!");
            return;
        }

        this.tail = head;

        // Traverse the list
        while (pointer != null) {
            current = pointer;
            pointer = pointer.getNext();

            // Reverse pointer
            current.next = previous;
            previous = current;
            head = current;
        }
    }
    public E set(int index, E value) {
        Node<E> temp = this.head;

        // Find node to be edited
        for (int i = 0; temp != null && i < index; i++) {
            temp = temp.getNext();
        }

        // Store old value
        E old = null;
        if (temp != null) {
            old = temp.getElement();
        }

        // Replace old value with new value
        if (temp != null) {
            temp.setElement(value);
        }

        return old;
    }
    public void sort() {
        Node<E> temp = this.head;

        // Traverse the list
        while (temp != null) {
            Node<E> min = temp;
            Node<E> k = temp.next;

            // Traverse the unsorted sublist
            while (k != null) {
                if (min.getElement().compareTo(k.getElement()) > 0) {
                    min = k;
                }

                k = k.getNext();
            }

            // Swap Data
            E swap = temp.getElement();
            temp.setElement(min.getElement());
            min.setElement(swap);
            temp = temp.getNext();
        }
    }

    // HELPER METHODS
    public void print() {
        if (isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < size(); i++) {
                if (i == size()-1) {
                    System.out.print(get(i).toString());
                } else {
                    System.out.print(get(i).toString() + ", ");
                }
            }
            System.out.println("]");
        }
    }
}