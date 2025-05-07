import java.io.*;
import java.util.*;

public class Graph_Client {
    public static void main(String[] args) throws Exception {
        Graph G = new Graph(new Scanner(new File("graph1.txt")));
        int s = 0;

        long startTime = System.currentTimeMillis();
        Graph_SP sp = new Graph_SP(G, s);
        System.out.println(System.currentTimeMillis() - startTime);

        // Print the first few shortest paths
        for (int t = 0; t < 5; t++) {
            if (sp.distTo[t] < Double.POSITIVE_INFINITY) {
                System.out.printf("%d => %d (%.2f) ", s, t, sp.distTo[t]);

                String path = t + " ";
                for (Edge e = sp.edgeTo[t]; e != null; e = sp.edgeTo[e.from()]) {
                    path = e.from() + " ->(" + e.weight() + ") -> " + path;
                }
                System.out.println(path);
            } else {
                System.out.printf("%d to %d no path \n", s, t);
            }
        }
    }
}