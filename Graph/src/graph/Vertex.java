package graph;
import java.util.ArrayList;

public class Vertex {
    private ArrayList<Edge> neighborhood;
    private String kota;
    
    public Vertex(String label){
        this.kota = label;
        this.neighborhood = new ArrayList<Edge>();
    }
    
    public void addNeighbor(Edge edge){
        if(this.neighborhood.contains(edge)){
            return;
        }
        
        this.neighborhood.add(edge);
    }
    
    public boolean containsNeighbor(Edge other){
        return this.neighborhood.contains(other);
    }
    
    public Edge getNeighbor(int index){
        return this.neighborhood.get(index);
    }
    
    public Edge removeNeighbor(int index){
        return this.neighborhood.remove(index);
    }
    
    public void removeNeighbor(Edge e){
        this.neighborhood.remove(e);
    }
    
    
    public int getNeighborCount(){
        return this.neighborhood.size();
    }
    
    public void setLabel(String label) {
        this.kota = label;
    }
    
    
    public String getLabel(){
        return this.kota;
    }
    
    public String toString(){
        return "Vertex " + kota;
    }
    
    public int hashCode(){
        return this.kota.hashCode();
    }
    
    public boolean equals(Object other){
        if(!(other instanceof Vertex)){
            return false;
        }
        Vertex v = (Vertex)other;
        return this.kota.equals(v.kota);
    }
    
    public ArrayList<Edge> getNeighbors(){
        return new ArrayList<Edge>(this.neighborhood);
    }
}