public class MinHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    // Constructor to initialize the heap
    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE; // Sentinel value at the root
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
        int tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Function to heapify the node at pos
    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
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

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Function to print the contents of the heap
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.println(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
        }
    }

    // Function to remove and return the minimum element from the heap
    public int extractMin() {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        minHeapify(1);
        return popped;
    }
}


public class Main {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.print();
        System.out.println("The minimum value is " + minHeap.extractMin());
    }
}
