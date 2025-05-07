import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class A11 {
	//check whether the char is a letter
	static boolean isLetter(int character) {
		return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
	}
	
	// check whether the char is a letter or digit
	static boolean isLetterOrDigit(int character) {
		return isLetter(character) || (character >= '0' && character <= '9');
	}

	/*
	public static Set<String> getIdentifiers(String filename) throws Exception{
		String[] keywordsArray = { "IF", "WRITE", "READ", "RETURN", "BEGIN",
				"END", "MAIN", "INT", "REAL" };
		Set<String> keywords = new HashSet();
		Set<String> identifiers = new HashSet();
		for (String s : keywordsArray) {;
			keywords.add(s);
		}
		String state="INIT"; // Initially it is in the INIT state. 
		
		StringBuilder code = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		while ((line = br.readLine()) != null) { 
			code=code.append(line+"\n");
		} // read the text line by line.
		code =code.append('$'); //add a special symbol to indicate the end of file.  

		int len=code.length();
		String token="";
		for (int i=0; i<len; i++) { //look at the characters one by one
			char next_char=code.charAt(i);

			if (state.contentEquals("INIT")){ 
			    if (isLetter(next_char)){	 
			    	state="ID";  // go to the ID state
			    	token=token+next_char;
			    } //ignore everything if it is not a letter
			
			}else if (state.equals("ID")) {
				if (isLetterOrDigit(next_char)) { //take letter or digit if it is in ID state
				  token=token+next_char;
				} else { // end of ID state
					identifiers.add(token);
					token="";
					state="INIT";
				}	
			}
		}
		return identifiers;
  	}  */

	public static Set<String> getIdentifiers(String file) throws Exception {
		//Set<String> keywords = Set.of("WRITE", "READ", "IF", "ELSE", "RETURN", "BEGIN", "END", "MAIN", "STRING", "INT", "REAL"), ids = new HashSet<>();
		// Set<String> keywords = new HashSet<>(Arrays.asList("WRITE", "READ", "IF", "ELSE", "RETURN", "BEGIN", "END", "MAIN", "STRING", "INT", "REAL")), ids = new HashSet<>();
		// StringBuilder code = new StringBuilder(), token = new StringBuilder();
		// try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		// 	for (String line; (line = br.readLine()) != null; ) code.append(line).append("\n");
		// }
		// boolean inQuotes = false, inID = false;
		// for (char c : (code.append('$').toString()).toCharArray()) {
		// 	if (inQuotes = c == '"' ? !inQuotes : inQuotes) continue;
		// 	if (Character.isLetter(c)) { if (!inID) token.setLength(0); inID = true; token.append(c); }
		// 	else if (Character.isLetterOrDigit(c) && inID) token.append(c);
		// 	else if (inID) { if (!keywords.contains(token.toString())) ids.add(token.toString()); inID = false; }
		// }
		// return ids;
		Set<String> keywords=Set.of("WRITE","READ","IF","RETURN","BEGIN","END","MAIN","STRING","INT"),ids=new HashSet<>();
		StringBuilder code = new StringBuilder(), token = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) { 
			for (String line; (line = br.readLine()) != null; ) code.append(line).append("\n");
		}
		boolean inQuotes = false, inID = false;
		for (char c : (code.append('$').toString()).toCharArray()) {
			if (inQuotes = c == '"' ? !inQuotes : inQuotes) continue;
			if (Character.isLetter(c)) { if (!inID) token.setLength(0); inID = true; token.append(c); }
			else if (Character.isLetterOrDigit(c) && inID) token.append(c);
			else if (inID) { if (!keywords.contains(token.toString())) ids.add(token.toString()); inID = false; }
		}
		return ids;
	}
	
	public static void main(String[] args) throws Exception{
		//Set<String> ids=getIdentifiers("Sample Inputs/A1.tiny");
		Set<String> ids=getIdentifiers("Sample Inputs/case1.tiny");
		int i = 1;
		for (String id:ids) {
			System.out.println(i + ": " +id); 
			i++;
		}
	}
}