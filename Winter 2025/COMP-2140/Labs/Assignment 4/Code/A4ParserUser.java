import java.io.*;
class A4ParserUser {
    public static void main(String[] args){
        try {
            File inputFile = new File ("A4.tiny");
            A4Parser parser= new A4Parser(new A4Scanner(new FileInputStream(inputFile)));
            Integer result= (Integer)parser.debug_parse().value;
            //System.out.println("result is "+ result);
            FileWriter fw = new FileWriter(new File( "A4.output"));
            fw.write("Number of methods: " + result.intValue()) ;
            fw.close() ;
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
    
}
