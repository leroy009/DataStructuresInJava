class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


class LinkedList {
    Node head; // head of list

    // Method to insert a new node at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    // Method to search for an element in the linked list
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}


public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert elements
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(9);  // Inserting 9 as an example

        // Print the linked list
        System.out.println("Linked List:");
        list.printList();

        // Search for an element
        boolean found = list.search(9);
        if (found) {
            System.out.println("Element 9 is found in the list.");
        } else {
            System.out.println("Element 9 is not found in the list.");
        }
    }
}
