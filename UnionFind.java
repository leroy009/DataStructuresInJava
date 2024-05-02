public class UnionFind {
    private int[] root;
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; // Initially, all elements are their own parent, and the rank is 1.
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]); // Path compression
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1; // Increase the rank if both have the same rank.
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        // connect some elements
        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(4, 3);
        uf.union(5, 6);

        // Check if elements are connected
        System.out.println("1 and 4 are connected: " + uf.connected(1, 4));
        System.out.println("5 and 6 are connected: " + uf.connected(5, 6));
        System.out.println("5 and 1 are connected: " + uf.connected(5, 1));
    }
}
