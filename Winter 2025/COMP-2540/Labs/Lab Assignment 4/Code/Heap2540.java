public class Heap2540 {
    private String[] heap;
    private int n=0;
    
    public Heap2540(String[ ] a) {    	
        // define the constructor for a heap from an array
        n = a.length; //length of array
        heap = new String[n+1]; // create a new heap
        // add elements from array to heap
        for (int i = 0; i < n; i++) {
            heap[i+1] = a[i];
        }
        // heapify
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
    }
  
    public Heap2540() {   
    	heap=new String[128];
    }
  
    public String removeMax() {
    	String max=heap[1];
	    swap(1, n);
        n--;
        sink(1);       
	    return max;
    }

    public void insert(String x) {
        // add resize
        if (n + 1 == heap.length) resize(2 * heap.length); // Double capacity 
        n++;
        heap[n] = x;
        swim(n);
    }

    private void resize(int capacity) {
        String[] newHeap = new String[capacity];
        System.arraycopy(heap, 1, newHeap, 1, n);
        heap = newHeap;
    }

    private void swim(int k) {
        // add swim 
        while (k > 1 && less(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }
    
    private void swap(int i, int j) {
        String temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void sink(int k) {
        // add definition here
        while (2 * k <= n) {
            int j = 2 * k; // Left child
            if (j < n && less(j, j + 1)) j++; // Right child is bigger
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }
    
    /*
    //HeapSort
    public static String[] heapSort2540(String[] a) {
		Heap2540 pq = new Heap2540(a);
		int n = a.length;
		String[] result = new String[n];
		for (int i = 0; i < n; i++) {
			result[i] = pq.removeMax();
		}
		return result;
	}
    */				    
}
    
