
/**
 * A2 starter code for 2540, 2020. 
 * Author: Jianguo Lu 
 * The purpose is to understand sorting algorithms and their performances. 
 * It prints out the frequency of the 200-th most frequent word.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCountSort {

	public static void selectionSort(String[] data) {
		int n = data.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (data[minIndex].compareTo(data[j]) < 0) {
					minIndex = j;
				}
			}
			if (i != minIndex)
				swap(data, minIndex, i);

		}
	}

	public static void insertionSort(String[] data) {
		int n = data.length;
		for (int k = 1; k < n; k++) {
			String cur = data[k];
			int j = k;
			while (j > 0 && data[j - 1].compareTo(cur) > 0) {
				data[j] = data[j - 1];
				j--;
			}
			data[j] = cur;
		}
	}

	/** Merge two strings. See the textbook for explanation. **/
	public static void merge(String[] S1, String[] S2, String[] S) {
		int i = 0, j = 0;
		while (i + j < S.length) {
			if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0))
				S[i + j] = S1[i++];
			else
				S[i + j] = S2[j++];
		}
	}

	public static void mergeSort(String[] S) {
		int n = S.length;
		if (n < 2)
			return;
		int mid = n / 2;
		// partition the string into two strings
		String[] S1 = Arrays.copyOfRange(S, 0, mid);
		String[] S2 = Arrays.copyOfRange(S, mid, n);
		mergeSort(S1);
		mergeSort(S2);
		merge(S1, S2, S);
	}

	private static void swap(String[] array, int i, int j) {
		String tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static Integer count_ARRAY_SORT(String[] tokens, String sortMethod) {

		if (sortMethod.equals("SELECT"))
			selectionSort(tokens);
		else if (sortMethod.equals("INSERT"))
			insertionSort(tokens);
		else if (sortMethod.equals("MERGE"))
			mergeSort(tokens);
		else
			System.out.println(sortMethod + " sorting method does not exist.");

		int CAPACITY = 1000000;
		String[] words = new String[CAPACITY];
		int[] counts = new int[CAPACITY];
		int j = 0, k = 0;
		int len = tokens.length;
		while (j < len - 1) {
			int duplicates = 1;
			while (j < len - 2 & tokens[j].equals(tokens[j + 1])) {
				j++;
				duplicates++;
			}

			words[k] = tokens[j];
			counts[k] = duplicates;
			j++;
			k++;
		}

		String[] copyOfWords=new String[k];
		Integer[] copyOfCounts=new Integer[k];
		
		for (int i=0; i<k; i++) {
			copyOfCounts[i]=counts[i];
		}
			
		Arrays.sort(copyOfCounts);
		
		return copyOfCounts[k-200];
	}

	public static Integer countFAST(String fileName) throws Exception {
        // Use TreeMap for sorted frequency calculation on-the-fly
        Map<String, Integer> wordCount = new HashMap<>();
        // Efficient file reading using BufferedReader
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        // Process each line and update word frequencies
        while ((line = br.readLine()) != null) {
            String[] tokens = line.toLowerCase().split("[^a-zA-Z]+");
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    wordCount.merge(token, 1, Integer::sum);
                }
            }
        }
        // Use a min-heap to track the 200 most frequent elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(200);
        for (int freq : wordCount.values()) {
            if (minHeap.size() < 200) {
                minHeap.offer(freq); // Add frequencies until size reaches 200
            } else if (freq > minHeap.peek()) {
                minHeap.poll(); // Remove smallest and insert new frequency
                minHeap.offer(freq);
            }
        }
        // The root of the heap is the 200th largest frequency
        return minHeap.peek();
    }

	static String[] readText(String PATH) throws Exception {
		Scanner doc = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
		// tokenize text. any characters other than English letters(a-z and A-Z) are delimiters.
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

	static String [] readTextBAD(String PATH) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(PATH));
		String text = "";
		String line = "";
		while ((line=br.readLine()) != null)
			text = text+" "+line.trim();
		String tokens[] = text.trim().split("[^a-zA-Z]+");
		return tokens;
	}

	static String[] readTextGOOD(String PATH) throws Exception {
		// Create a BufferedReader to read the file line by line.
		BufferedReader br = new BufferedReader(new FileReader(PATH));
		// Use a StringBuilder to store the entire text from the file.
		StringBuilder text = new StringBuilder();
		String line;
		// Read each line of the file until reaching the end (null).
		while ((line = br.readLine()) != null) {
			// Append the trimmed line to the StringBuilder, with a space for separation.
			text.append(" ").append(line.trim());
		}
		// Close the BufferedReader to release resources.
		br.close();
		// Convert the text into an array of words by splitting on non-alphabetic characters.
		String[] tokens = text.toString().trim().split("[^a-zA-Z]+");
		// Return the array of words.
		return tokens;
	}

	public static void main(String[] args) throws Exception {
		String PATH = "Test Data Files/dblp";
		//String[] METHODS = { "MERGE", "INSERT", "SELECT" };
		String[] METHODS = {"MERGE"};
		String[] DATASETS = { "200", "400","800","1600","3200","6400", "10000","20000","40000", "80000","160000", "320000", "640000", "1280000", "2560000"};//, "10k","100k"}; //, "5k", "10k", "100k", "1m", "" };
		
		String[] tokens;
		
		/*// run the experiments on different data sets
		for (int j = 0; j < 10; j++) {
			// run the experiments using different methods
			System.out.println("Data is " + DATASETS[j]);
			for (int i = 0; i < 3; i++) {
				//tokens = readText(PATH + DATASETS[j] + ".txt");
				tokens = readTextGOOD(PATH + DATASETS[j] + ".txt");
				long startTime = System.currentTimeMillis();
				Integer _200th_freq= count_ARRAY_SORT(tokens, METHODS[i]);
				long endTime = System.currentTimeMillis();
				String time = String.format("%12d", endTime - startTime);
				System.out.println(METHODS[i] + " method\t time=" + time + ".\t 200th freq is " + _200th_freq);
			}
		}*/
		
		String PATH2 = "Test Data Files/dblp640000.txt";
		// Measure runtime for readTextGOOD
		long startGood = System.currentTimeMillis();
		String[] tokensGood = readTextGOOD(PATH2);
		long endGood = System.currentTimeMillis();
		System.out.println("readTextGOOD runtime: " + (endGood - startGood) + " ms");

		// Measure runtime for readTextBAD
		long startBad = System.currentTimeMillis();
		String[] tokensBad = readTextBAD(PATH2);
		long endBad = System.currentTimeMillis();
		System.out.println("readTextBAD runtime: " + (endBad - startBad) + " ms");

		/*// Measure runtime for countFAST
		for (String dataset : DATASETS) {
			String datasetPath = PATH + dataset + ".txt";
			System.out.println("Processing dataset: " + dataset + "k words");
			long startTime = System.currentTimeMillis();
			Integer _200th_freq = countFAST(datasetPath); // Call the optimized method
			long endTime = System.currentTimeMillis();
			System.out.println("200th most frequent word's frequency: " + _200th_freq);
			System.out.println("Runtime: " + (endTime - startTime) + " ms");
			System.out.println("--------------------------------------------");
		}*/
	}
}