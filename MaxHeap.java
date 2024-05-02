public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    // Constructor to initialize the heap
    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE; // sentinel value at the root
    }

    // Function to return the position of the parent for the node currently at pos
    private int parent(int pos) {
        return pos / 2;
    }

    // Function to return the position of the left child for the node currently at pos
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // Function to return the position of the right child for the node currently at pos
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Function that returns true if the passed node is a leaf node
    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    // Function to swap two nodes of the heap
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Function to heapify the node at pos
    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    // Function to insert a node into the heap
    public void insert(int element) {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;

        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Function to print the contents of the heap
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " +
                             Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    // Function to remove and return the maximum element from the heap
    public int extractMax() {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }
}



public class Main {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The max value is " + maxHeap.extractMax());
    }
}
