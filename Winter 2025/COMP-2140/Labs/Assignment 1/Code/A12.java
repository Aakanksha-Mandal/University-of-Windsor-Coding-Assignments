import java.io.*;
import java.util.*;
import java.util.regex.*;

public class A12 {

    /*public static Set<String> getIdRegex(String filename) throws Exception {
        String[] keywordsArray = {” IF ”, ”INT”, ”REAL”};
        Set<String> keywords = new HashSet();
        Set<String> identifiers = new HashSet();
        
        for (String s : keywordsArray)
            keywords.add(s);

        FileReader reader BufferedReader br = new new FileReader(filename);
        BufferedReader (reader);
        String line;
        // Pattern id Pattern = . . . . . . ;
        // Pattern quotedStringPattern = . . . . . ;
        while ((line = br.readLine()) != null) {
            Matcher quotedString = quotedStringPattern.matcher(line);
            String lineWithoutQuotedStrings = quotedString.replaceAll(” ”);
            Matcher m = idPattern.matcher(lineWithoutQuotedStrings);
            while (m.find()) {
                if String id = line.substring(m.start(), m.end());
                ( !keywords.contains(id))
                    identifiers.add(id);
            }
        }
        return identifiers;
    } */

    public static Set<String> getIdRegex(String filename) throws Exception {
        Set<String> keywords = new HashSet<>(Arrays.asList("WRITE", "READ", "IF", "ELSE", "RETURN", "BEGIN", "END", "MAIN", "STRING", "INT", "REAL")), ids = new HashSet<>();
        //Set<String> keywords = Set.of("WRITE", "READ", "IF", "ELSE", "RETURN", "BEGIN", "END", "MAIN", "STRING", "INT", "REAL"), ids = new HashSet<>();
        // BufferedReader br = new BufferedReader(new FileReader(filename));
        // Pattern idPattern = Pattern.compile("[A-Za-z][A-Za-z0-9]*"), quotedPattern = Pattern.compile("\"[^\"]*\"");
        // for (String line; (line = br.readLine()) != null; )
        //     for (Matcher m = idPattern.matcher(quotedPattern.matcher(line).replaceAll("")); m.find(); )
        //         if (!keywords.contains(m.group())) ids.add(m.group());
        // return ids;
        //Set<String> keywords=Set.of("WRITE","READ","IF","RETURN","BEGIN","END","MAIN","STRING","INT"),ids=new HashSet<>();
        try(BufferedReader br=new BufferedReader(new FileReader(filename))) {
            for(String line;(line=br.readLine())!=null;)
                for(Matcher m=Pattern.compile("[A-Za-z][A-Za-z0-9]*").matcher(line.replaceAll("\"[^\"]*\"",""));m.find();)
                    if(!keywords.contains(m.group()))ids.add(m.group());}
        return ids;}

    public static void main(String[] args) throws Exception{
        //Set<String> ids=getIdRegex("Sample Inputs/A1.tiny");
        Set<String> ids=getIdRegex("Sample Inputs/case8.tiny");
        int i = 1;
        for (String id:ids) {
            System.out.println(i + ": " +id); 
            i++;
        }
    }
}