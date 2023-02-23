package dijkstra;

import java.util.Collection;

public class UndirectedEdge {
    private final Vertex v1;
    private final Vertex v2;
    private final Integer weight;

    public UndirectedEdge(Vertex v1, Vertex v2, Integer weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public boolean vertexExist(Vertex v){
        return this.v1.equals(v) || this.v2.equals(v);
    }

    public Vertex getOtherVertexInEdge(Vertex v){
        return v1.equals(v) ? v2 : v1;
    }

    public Integer getWeight(){
        return this.weight;
    }

    @Override
    public String toString() {
        return v1.name() + "---("+weight+")--->" + v2.name();
    }

    public boolean onlyOneVertexInCollection(Collection<Vertex> vertices){
        return (vertices.contains(v1) && !vertices.contains(v2)) || (!vertices.contains(v1) && vertices.contains(v2));
    }

    public Vertex getExistingVertexInEdge(Collection<UndirectedEdge> vortexes){
        return vortexes.contains(v1)? v1 : v2;
    }
}
