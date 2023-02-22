package dijkstra;

import java.util.Collection;

public class UndirectedEdge {
    private final Vortex v1;
    private final Vortex v2;
    private final Integer weight;

    public UndirectedEdge(Vortex v1, Vortex v2, Integer weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public Vortex getV1() {
        return v1;
    }

    public Vortex getV2() {
        return v2;
    }

    public boolean vortexExist(Vortex v){
        return this.v1.equals(v) || this.v2.equals(v);
    }

    public Vortex getOtherVortexInEdge(Vortex v){
        return v1.equals(v) ? v2 : v1;
    }

    public Integer getWeight(){
        return this.weight;
    }

    @Override
    public String toString() {
        return v1.name() + "---("+weight+")--->" + v2.name();
    }

    public boolean onlyOneVortexInCollection(Collection<Vortex> vortexes){
        return (vortexes.contains(v1) && !vortexes.contains(v2)) || (!vortexes.contains(v1) && vortexes.contains(v2));
    }

    public Vortex getExistingVortexInEdge(Collection<UndirectedEdge> vortexes){
        return vortexes.contains(v1)? v1 : v2;
    }
}
