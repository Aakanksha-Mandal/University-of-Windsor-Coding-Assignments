import java.io.*;
import java.util.*;

public class Graph_SP {
    public double[] distTo;
    public Edge[] edgeTo;
    public Map<Integer, Double> distTable = new HashMap<>();

    public Graph_SP(Graph G, int s) {
        distTo = new double[G.V];
        edgeTo = new Edge[G.V];
        
        for (int v = 0; v < G.V; v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        
        distTo[s] = 0.0;
        distTable.put(s, distTo[s]);

        while (!distTable.isEmpty()) {
            int v = removeMin(distTable);
            for (Edge e : G.edgesOf[v])
                relax(e);
        }
    }

    private void relax(Edge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            distTable.put(w, distTo[w]);
        }
    }

    public static int removeMin(Map<Integer, Double> distTable) {
        Iterator<Map.Entry<Integer, Double>> it = distTable.entrySet().iterator();
        double minValue = Double.MAX_VALUE;
        int minKey = -1;

        while (it.hasNext()) {
            Map.Entry<Integer, Double> pair = it.next();
            if (minValue > pair.getValue()) {
                minKey = pair.getKey();
                minValue = pair.getValue();
            }
        }
        distTable.remove(minKey);
        return minKey;
    }
}