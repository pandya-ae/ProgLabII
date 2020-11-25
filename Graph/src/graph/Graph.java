package graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
    private HashMap<String, Vertex> vertices;
    private HashMap<Integer, Edge> edges;
    
    public Graph(){
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
    }
    
    public Graph(ArrayList<Vertex> vertices){
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
        
        for(Vertex v: vertices){
            this.vertices.put(v.getLabel(), v);
        }
    }
    
    public boolean addVertex(Vertex vertex, boolean overwriteExisting){
        Vertex current = this.vertices.get(vertex.getLabel());
        if(current != null){
            if(!overwriteExisting){
                return false;
            }
            while(current.getNeighborCount() > 0){
                this.removeEdge(current.getNeighbor(0));
            }
        }
        vertices.put(vertex.getLabel(), vertex);
        return true;
    }
    
    public Vertex removeVertex(String label){
        return vertices.remove(label);
    }
    
    public Set<String> vertexKeys(){
        return this.vertices.keySet();
    }
    
    public List<Vertex> getVertex(){
        List<Vertex> vertex = new ArrayList<Vertex>();
        for(Map.Entry entry:this.vertices.entrySet()){
            vertex.add((Vertex)entry.getValue());
    	}
         return vertex;
    }
    
    public boolean containsVertex(Vertex vertex){
        return this.vertices.get(vertex.getLabel()) != null;
    }
    
    public Vertex getVertex(String label){
        return vertices.get(label);
    }
      
    public boolean addEdge(Vertex start, Vertex end){
        if(start.equals(end)){
            return false;   
        }
        Edge e = new Edge(start, end, 1);
        if(edges.containsKey(e.hashCode())){
            return false;
        }
        else if(start.containsNeighbor(e) || end.containsNeighbor(e)){
            return false;
        }
        edges.put(e.hashCode(), e);
        start.addNeighbor(e);
        end.addNeighbor(e);
        return true;
    }
    
    public boolean containsEdge(Edge e){
        if(e.getOne() == null || e.getTwo() == null){
            return false;
        }
        return this.edges.containsKey(e.hashCode());
    }
    
    public Edge removeEdge(Edge e){
       e.getOne().removeNeighbor(e);
       e.getTwo().removeNeighbor(e);
       return this.edges.remove(e.hashCode());
    }
          
    public Set<Edge> getEdges(){
        return new HashSet<Edge>(this.edges.values());
    }  
}