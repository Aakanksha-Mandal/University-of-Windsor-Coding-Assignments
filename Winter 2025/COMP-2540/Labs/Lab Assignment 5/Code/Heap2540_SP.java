public class Heap2540_SP {
    int[] heap;
    int[] index;
    Double[] distances;
    int n = 0; // actual heap size
    int CAPACITY = 1000001; // array size

    public Heap2540_SP() {
        heap = new int[CAPACITY];
        index = new int[CAPACITY];
        distances = new Double[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            index[i] = -1; // Initialize index array to -1
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int removeMin() {
        int min = heap[1];
        swap(1, n);
        n--;
        sink(1);
        index[min] = -1;
        distances[min] = null;
        return min;
    }

    public void insert(Integer node, Double dist) {
        n++;
        heap[n] = node;
        index[node] = n;
        distances[node] = dist;
        swim(n);
    }

    public void put(int node, double dist) {
        if (index[node] != -1) {
            distances[node] = dist;
            swim(index[node]);
        } else {
            insert(node, dist);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
        // Update the index array to reflect the swap
        index[heap[i]] = i;
        index[heap[j]] = j;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1))
                j++;
            if (!greater(k, j))
                break;
            swap(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private boolean greater(int i, int j) {
        return distances[heap[i]] > distances[heap[j]];
    }
}