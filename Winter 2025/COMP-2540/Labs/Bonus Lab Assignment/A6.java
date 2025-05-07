import java.util.*;
import java.io.*;

public class A6 {

	private static final int CHAR_RANGE = 256;

	public static String compress(String s, String[] codeTable) {
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			out.append(codeTable[s.charAt(i)]);
		}
		return new String(out);
	}

	// get the table for the encoding for all characters.
	private static void getTable(String[] code_table, Node node, String s) {
		if (!node.isLeaf()) {
			getTable(code_table, node.left, s + '0');
			getTable(code_table, node.right, s + '1');
		} else {
			code_table[node.ch] = s;
		}
	}

	public static String expand(String code, Node tree) {
		Node x = tree;
		StringBuffer s = new StringBuffer();
		int i=0;
		while (i < code.length()) {
			while (!x.isLeaf()) {			
				if (code.charAt(i) == '0') {
					if (x.left != null)
						x = x.left;
				}
				else {
						if (x.right != null)				
						x = x.right;
					}				
				i++; 
			}
			s.append(x.ch);
			x = tree;
			
		}
		return new String(s);
	}

	private static Node buildTree(String s) {
		StringBuffer out = new StringBuffer();
		int[] freq = new int[CHAR_RANGE];
		for (int i = 0; i < s.length(); i++)
			freq[s.charAt(i)]++;

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for (char c = 0; c < CHAR_RANGE; c++)
			if (freq[c] > 0)
				pq.add(new Node(c, freq[c], null, null));

		while (pq.size() > 1) {
 			// add the missing lines here
			// You should remove two minimum nodes from the priority queue
			// create a parent node for those two nodes
			// add that parent node into the queue
			Node left = pq.remove();
			Node right = pq.remove();
			Node parent = new Node('\0', left.freq + right.freq, left, right);
			pq.add(parent);
		}

		return pq.remove();
	}

	public static void main(String[] args) throws Exception {
		Node tree = buildTree(args[0]); 
		String[] codeTable = new String[255];
		getTable(codeTable, tree, "");

		String code = compress(args[0], codeTable);
		System.out.println(code);

		String decode = expand(code, tree);
		System.out.println(decode);
	}
}
