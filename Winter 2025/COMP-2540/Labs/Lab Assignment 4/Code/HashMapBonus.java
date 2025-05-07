import java.util.LinkedList;
import java.util.AbstractMap;

public class HashMap2540<Key, Value> {
    private static final int INIT_CAPACITY = 16;
    private int n; // number of elements
    private int m; // hash table size
    private LinkedListForHash2540<Key, Value>[] st; // array of linked-lists.
    
    public HashMap2540() {
        this(INIT_CAPACITY);
    }

    // Used in resize.
    public HashMap2540(int m) {
        this.m = m;
        st = (LinkedListForHash2540<Key, Value>[]) new LinkedListForHash2540[m];
        for (int i = 0; i < m; i++) {
            st[i] = new LinkedListForHash2540<Key, Value>();
        }
    }

    // Resize the hash table to have the given number of chains, rehashing all of the keys.
    private void resize(int newSize) {
        HashMap2540<Key, Value> temp = new HashMap2540<>(newSize);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m = temp.m;
        this.n = temp.n;
        this.st = temp.st;
    }

    // Improved hash function to reduce collisions using a prime multiplier and modulo
    private int myhash(Key key) {
        String k = (String) key; // Assuming keys are strings.
        int hash = 0;
        int prime = 31;  // A prime number used to spread out the keys better.
        int salt = 12345; // A salt value to reduce hash collisions

        // Use an effective hash function similar to Java's String hashCode method
        for (int i = 0; i < k.length(); i++) {
            hash = prime * hash + (k.charAt(i) + salt);  // Adding salt for better distribution
        }
        
        // Ensure the hash value is non-negative and within the table size.
        return Math.abs(hash) % m;
    }

    // Get the value associated with the key.
    public Value get(Key key) {
        int i = myhash(key);
        return st[i].get(key);
    }

    // Put the key-value pair into the hash table.
    public void put(Key key, Value val) {
        // Double table size if average linked list size exceeds 3
        if (n / m >= 3) resize(2 * m);
        
        // Get the hash value of the key
        int i = myhash(key);
        
        // If the key is not present, increase the number of elements.
        if (st[i].get(key) == null) n++;
        
        // Put the key-value pair in the corresponding linked list.
        st[i].put(key, val);
    }

    // Delete the key-value pair from the hash table.
    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("Argument to delete() is null");
        int i = myhash(key);
        if (st[i].get(key) != null)
            n--;
        st[i].delete(key);

        // Halve the table size if average length of list <= 2.
        if (m > INIT_CAPACITY && n <= 2 * m)
            resize(m / 2);
    }

    // Get all the keys in the hash table.
    public LinkedList<Key> keys() {
        LinkedList<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.add(key);
        }
        return queue;
    }
}