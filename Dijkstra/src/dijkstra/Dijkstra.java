package dijkstra;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Dijkstra {
  public static <V> HashMap<V, Double> dijkstraShortestPath(Graph<V> graph,V source) {
  HashMap<V, Double> distances = new HashMap<V, Double>();
  ArrayList<V> queue = new ArrayList<V>();
  ArrayList<V> visited = new ArrayList<V>();
  queue.add(0, source);
  distances.put(source, 0.0);
  
	
  while (!queue.isEmpty()) {
    V currentVertex = queue.remove(queue.size() - 1);
     
    if (distances.get(currentVertex) == null) {
      distances.put(currentVertex, Double.POSITIVE_INFINITY);
    }
                    
    for (V adjacentVertex : graph.getAdjacentVertices(currentVertex)) {
      if (distances.get(adjacentVertex) == null) {
        distances.put(adjacentVertex, Double.POSITIVE_INFINITY);
      }

      if (true) {
        if (distances.get(adjacentVertex) > graph.getDistanceBetween(currentVertex, adjacentVertex)+ distances.get(currentVertex)) {
          distances.put(adjacentVertex,graph.getDistanceBetween(currentVertex,adjacentVertex)+ distances.get(currentVertex));
        }
      }

      if (!visited.contains(adjacentVertex)&& !queue.contains(adjacentVertex)) {
        queue.add(0, adjacentVertex);
      }
    }
    visited.add(currentVertex);
	}
    for (V v : graph.getVertexList()) {
      if (!distances.containsKey(v)) {
        distances.put(v, Double.POSITIVE_INFINITY);
      }
    }
    return distances;
  }

  public static void main(String[] args) {
    Graph<String> graph = new Graph<String>(true);
    ArrayList<Edge<String>> connected = new ArrayList<Edge<String>>();
    connected.add(new Edge<String>("B", 4));
    connected.add(new Edge<String>("F", 2));
    graph.add("A", connected);
    graph.addArc("B", "C", 3);
    graph.addArc("B", "E", 7);
    graph.addArc("B", "G", 5);
    graph.addArc("C", "D", 8);
    graph.addArc("C", "E", 4);
    graph.addArc("D", "E", 7);
    graph.addArc("D", "H", 5);
    graph.addArc("E", "G", 2);
    graph.addArc("E", "H", 3);
    graph.addArc("F", "G", 3);
    graph.addArc("G", "H", 5);
    System.out.println(graph.toString());
    System.out.println(Dijkstra.dijkstraShortestPath(graph, "A"));
  }  
}