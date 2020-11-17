import java.util.*;

public class Graph {
        
    //create adjacency list of nodes
    List<List<Node>> adj_list = new ArrayList<>();
    
    //static subclass to represent nodes
    static class Node{
        int value, weight;
        Node(int value, int weight) {
            this.value = value;
            this.weight = weight;

        }   
    }

    //constructor
    public Graph(List<Edge> edges)
        { 
            //allocate memory for adjacency list
            for(int i = 0; i < edges.size(); i++)
                {
                adj_list.add(i, new ArrayList<>());
                }
            //add edges to graph
            for(Edge e : edges)
                {
                adj_list.get(e.src).add(new Node(e.dest, e.weight));
                }
        }
    
    //print out the contents of graph
    public static void printGraph(Graph graph){
        int src_vertex = 0;
        int list_size = graph.adj_list.size();

        System.out.println("Contents of the graph:");
        while (src_vertex < list_size) {
            //traverse through list, printing edges
            for(Node node: graph.adj_list.get(src_vertex)) {
                System.out.print("Vertex:" + src_vertex + "==>" + node.value + "(" + node.weight + ")\t");
                
            }
            System.out.println();
            src_vertex++;       
    }

}
}
