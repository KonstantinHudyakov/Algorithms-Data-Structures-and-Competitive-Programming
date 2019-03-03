package graphs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    private static class Edge {
        int from;
        int to;
        int weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static int kruskals(int gNodes, List<Edge> edges) {
        int resWeight = 0;
        edges.sort((edge1, edge2) -> edge1.weight - edge2.weight);
        int[] trees = new int[gNodes + 1];
        for(int i = 1; i < trees.length; i++)
            trees[i] = i;

        for(Edge edge : edges) {
            if(trees[edge.from] != trees[edge.to]) {
                resWeight += edge.weight;
                int oldTree = trees[edge.to];
                int newTree = trees[edge.from];
                for(int i = 1; i < trees.length; i++) {
                    if(trees[i] == oldTree)
                        trees[i] = newTree;
                }
            }
        }
        return resWeight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] gNodesEdges = bufferedReader.readLine().split(" ");
        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < gEdges; i++) {
            String[] edgeLine = bufferedReader.readLine().split(" ");
            edges.add(new Edge(Integer.parseInt(edgeLine[0]), Integer.parseInt(edgeLine[1]), Integer.parseInt(edgeLine[2])));
        }
        bufferedReader.close();

        int res = kruskals(gNodes, edges);
        System.out.println(res);
    }
}
