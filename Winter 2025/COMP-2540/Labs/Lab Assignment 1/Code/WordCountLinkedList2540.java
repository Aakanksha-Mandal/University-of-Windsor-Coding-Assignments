import java.io.File;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class WordCountLinkedList2540 {
    // count_ARRAY_BAD
	public static Entry<String, Integer> count_ARRAY(String[] tokens) {
		int CAPACITY = 10000;
		String[] words = new String[CAPACITY];
		int[] counts = new int[CAPACITY];
		for (int j = 0; j < tokens.length; j++) {
			String token = tokens[j];
			for (int i = 0; i < CAPACITY; i++) {
				if (words[i] == null) {
					words[i] = token;
					counts[i] = 1;
					break;
				} else if (words[i].equals(token))
					counts[i] = counts[i] + 1;
			}
		}

		int maxCount = 0;
		String maxWord = "";
		for (int i = 0; i < CAPACITY && words[i] != null; i++) {
			if (counts[i] > maxCount) {
				maxWord = words[i];
				maxCount = counts[i];
			}
		}
		return new AbstractMap.SimpleEntry<String, Integer>(maxWord, maxCount);
	}

    // count_LINKED_LIST_BAD
	public static Entry<String, Integer> count_LINKED_LIST(String[] tokens) {
		LinkedList<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>();
		for (int j = 0; j < tokens.length; j++) {
			String word = tokens[j];
			boolean found = false;
			for (int i = 0; i < list.size(); i++) {
				Entry<String, Integer> e = list.get(i);

				if (word.equals(e.getKey())) {
					e.setValue(e.getValue() + 1);
					list.set(i, e);
					found = true;
					break;
				}
			}
			if (!found)
				list.add(new AbstractMap.SimpleEntry<String, Integer>(word, 1));
		}

		int maxCount = 0;
		String maxWord = "";
		for (int i = 0; i < list.size(); i++) {
			int count = list.get(i).getValue();
			if (count > maxCount) {
				maxWord = list.get(i).getKey();
				maxCount = count;
			}
		}
		return new AbstractMap.SimpleEntry<String, Integer>(maxWord, maxCount);
	}

    // count_LINKED_LIST_GOOD
    public static Entry<String, Integer> count_LINKED_LIST_GOOD(String[] tokens) {
		/*LinkedList<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>();
		for (String word : tokens) {
            boolean found = false;
            ListIterator<Entry<String, Integer>> iterator = list.listIterator();
            while (iterator.hasNext()) {
                Entry<String, Integer> e = iterator.next();
                if (word.equals(e.getKey())) {
                    e.setValue(e.getValue() + 1);
                    found = true;
                    break;
                }
            }
			if (!found) list.add(new AbstractMap.SimpleEntry<String, Integer>(word, 1));
		}
		int maxCount = 0;
		String maxWord = "";
		for (int i = 0; i < list.size(); i++) {
			int count = list.get(i).getValue();
			if (count > maxCount) {
				maxWord = list.get(i).getKey();
				maxCount = count;
			}
		}
		return new AbstractMap.SimpleEntry<String, Integer>(maxWord, maxCount);*/
		// Create a linked list to store word-frequency pairs
		LinkedList<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>();

		// Iterate through each word in the input tokens array
		for (String word : tokens) {
			boolean found = false; // Flag to check if the word is already in the list

			// Use a ListIterator to iterate through the linked list
			ListIterator<Entry<String, Integer>> iterator = list.listIterator();
			while (iterator.hasNext()) {
				Entry<String, Integer> e = iterator.next(); // Get the next word-frequency pair
				if (word.equals(e.getKey())) { // Check if the current word matches the key
					e.setValue(e.getValue() + 1); // Increment the word's frequency
					found = true; // Mark as found
					break; // Exit the loop since the word is found
				}
			}

			// If the word is not found, add it to the list with an initial frequency of 1
			if (!found) 
				list.add(new AbstractMap.SimpleEntry<String, Integer>(word, 1));
		}

		// Initialize variables to track the word with the highest frequency
		int maxCount = 0;
		String maxWord = "";

		// Iterate through the linked list to find the word with the maximum frequency
		for (int i = 0; i < list.size(); i++) {
			int count = list.get(i).getValue(); // Get the frequency of the current word
			if (count > maxCount) { // Update maxWord and maxCount if a higher frequency is found
				maxWord = list.get(i).getKey();
				maxCount = count;
			}
		}

		// Return the word with the highest frequency and its count as a key-value pair
		return new AbstractMap.SimpleEntry<String, Integer>(maxWord, maxCount);
	}

    // countFAST
	public static Entry<String, Integer> countFAST(String[] tokens) {
		/*HashMap<String, Integer> wordCounts = new HashMap<>();
    	for (String token : tokens) {
			if (wordCounts.containsKey(token)) {
				int currentCount = wordCounts.get(token);
				wordCounts.put(token, currentCount + 1);
			} else {
				wordCounts.put(token, 1);
			}
    	}
		int maxCount = 0;
		String maxWord = "";
		for (HashMap.Entry<String, Integer> entry : wordCounts.entrySet()) {
        	String word = entry.getKey();
        	int count = entry.getValue();
			if (count > maxCount) {
				maxWord = word;
				maxCount = count;
        	}
    	}
	    return new AbstractMap.SimpleEntry<>(maxWord, maxCount);*/

		HashMap<String, Integer> wordCounts = new HashMap<>();
		// Loop through each token
    	for (String token : tokens) {
			// Check if token is already in map
			if (wordCounts.containsKey(token)) {
				// Update currentCount to the current token's count
				int currentCount = wordCounts.get(token);
				// Increment the current count and update the map
				wordCounts.put(token, currentCount + 1);
			} else {
				// If the word is not in the map, add it with a count of 1
				wordCounts.put(token, 1);
			}
    	}
		int maxCount = 0;
		String maxWord = "";
		for (HashMap.Entry<String, Integer> entry : wordCounts.entrySet()) {
        	String word = entry.getKey();
        	int count = entry.getValue();
			// If this word has a higher count than the current max, update maxWord and maxCount
			if (count > maxCount) {
				maxWord = word;
				maxCount = count;
        	}
    	}
	    return new AbstractMap.SimpleEntry<>(maxWord, maxCount);
	}
	
	// public static Entry<String, Integer> countFASTOLD(String[] tokens) {
    //     Arrays.sort(tokens);
    //     String currentWord = tokens[0];
    //     int currentCount = 0;
    //     String maxWord = "";
    //     int maxCount = 0;

    //     for (String token : tokens) {
    //         if (token.equals(currentWord)) {
    //             currentCount++;
    //         } else {
    //             if (currentCount > maxCount) {
    //                 maxCount = currentCount;
    //                 maxWord = currentWord;
    //             }
    //             currentWord = token;
    //             currentCount = 1;
    //         }
    //     }
    //     if (currentCount > maxCount) {
    //         maxCount = currentCount;
    //         maxWord = currentWord;
    //     }
    //     return new AbstractMap.SimpleEntry<String, Integer>(maxWord, maxCount);
    // }

	static String[] readText(String PATH) throws Exception {
		Scanner doc = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
		int length = 0;
		while (doc.hasNext()) {
			doc.next();
			length++;
		}

		String[] tokens = new String[length];
		Scanner s = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
		length = 0;
		while (s.hasNext()) {
			tokens[length] = s.next().toLowerCase();
			length++;
		}
		doc.close();

		return tokens;
	}

	public static void main(String[] args) throws Exception {

		String PATH = "Test Data Files/dblp1m.txt";
		String[] tokens = readText(PATH);
		long startTime = System.currentTimeMillis();
		Entry<String, Integer> entry = count_LINKED_LIST_GOOD(tokens);
		long endTime = System.currentTimeMillis();
		String time = String.format("%12d", endTime - startTime);
		System.out.println("count_LINKED_LIST_GOOD time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());

        tokens = readText(PATH);
		startTime = System.currentTimeMillis();
		entry = count_LINKED_LIST(tokens);
		endTime = System.currentTimeMillis();
		time = String.format("%12d", endTime - startTime);
		System.out.println("count_LINKED_LIST_BAD time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());

        tokens = readText(PATH);
		startTime = System.currentTimeMillis();
		entry = countFAST(tokens);
		endTime = System.currentTimeMillis();
		time = String.format("%12d", endTime - startTime);
		System.out.println("countFAST time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());

		tokens = readText(PATH);
		startTime = System.currentTimeMillis();
		entry = count_ARRAY(tokens);
		endTime = System.currentTimeMillis();
		time = String.format("%12d", endTime - startTime);
		System.out.println("count_ARRAY_BAD time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());
		
	}

}