import java.io.*;
public class A4 {
	static BufferedReader br_;
	static BufferedWriter bw_;
	static double $tmp_real;
	public static void main(String[] args) throws Exception{
		int A;
 		A=F1(3);
 		double B;
 		B=F2(A, 4.5);
 $tmp_real = Double.valueOf(B); bw_ = new BufferedWriter(new FileWriter("XKOUTPUT")); bw_.write("" + $tmp_real); bw_.close(); 
	} 
	public static int F1(int A1) throws Exception{
		return A1+5;
 	}
 
	public static double F2(int A1, double A2) throws Exception{
		double br;
 		br=A1+A2;
 		return br;
 	}

}