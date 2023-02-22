package dijkstra;

import java.util.*;


public class UndirectedGraph {
    private final Collection<Vortex> vortexes;
    private final Collection<UndirectedEdge> edges;

    public UndirectedGraph(Collection<Vortex> vortexes, Collection<UndirectedEdge> edges) {
        this.vortexes = vortexes;
        this.edges = edges;
    }

    public void dijkstra(Vortex startingVortex){
        Map<Vortex, Integer> vortexCost = new HashMap<>();
        Map<Vortex, String> vortexPath = new HashMap<>();
        Collection<Vortex> consumedVortexes = new ArrayList<>();

        vortexes.forEach(vortex -> vortexCost.put(vortex, Integer.MAX_VALUE));
        vortexCost.put(startingVortex, 0);
        vortexPath.put(startingVortex, startingVortex.name());
        consumedVortexes.add(startingVortex);

        while (vortexes.size() != consumedVortexes.size()){
            Collection<UndirectedEdge> connectedEdges = new ArrayList<>();

            for (Vortex v : consumedVortexes){
                for (UndirectedEdge ue : edges){
                    if (ue.vortexExist(v)){
                        connectedEdges.add(ue);
                    }
                }
            }
            connectedEdges = connectedEdges
                    .stream()
                    .filter(
                    elem -> !(consumedVortexes.contains(elem.getV2()) && consumedVortexes.contains(elem.getV1()))
            ).toList();

            Map<Vortex, Integer> connectedEdgesVortexCost = new HashMap<>();

            for (UndirectedEdge ue : connectedEdges){
                Vortex smallVortexValue;
                Vortex bigVortexValue;

                if (vortexCost.get(ue.getV1()) > vortexCost.get(ue.getV2())){
                    bigVortexValue = ue.getV1();
                    smallVortexValue = ue.getV2();
                }
                else{
                    bigVortexValue = ue.getV2();
                    smallVortexValue = ue.getV1();
                }

                if (vortexCost.get(smallVortexValue)+ ue.getWeight() > vortexCost.get(bigVortexValue)){
                    connectedEdgesVortexCost.put(bigVortexValue, vortexCost.get(bigVortexValue));
                    continue;
                }

                Collection<Boolean> testingLoop =  edges.stream()
                        .filter(e -> e.vortexExist(bigVortexValue))
                        .map(e -> consumedVortexes.contains(e.getOtherVortexInEdge(bigVortexValue)))
                        .toList();

                if (!testingLoop.contains(false) && !consumedVortexes.contains(bigVortexValue)){
                    consumedVortexes.add(bigVortexValue);
                    continue;
                }

                if(vortexCost.get(smallVortexValue)+ ue.getWeight() < vortexCost.get(bigVortexValue)){
                    vortexCost.put(bigVortexValue, vortexCost.get(smallVortexValue)+ ue.getWeight());
                    connectedEdgesVortexCost.put(bigVortexValue, vortexCost.get(smallVortexValue)+ ue.getWeight());
                    vortexPath.put(bigVortexValue, vortexPath.get(smallVortexValue) + " -> " + bigVortexValue.name());
                }
            }

            Vortex minVortex = null;
            Integer minValue = Integer.MAX_VALUE;
            for (Map.Entry<Vortex, Integer> entry : connectedEdgesVortexCost.entrySet()) {
                if (entry.getValue() < minValue && entry.getKey() != null) {
                    minValue = entry.getValue();
                    minVortex = entry.getKey();
                }
            }
            consumedVortexes.add(minVortex);
        }

        for (Vortex v : vortexCost.keySet()){
            System.out.println(v.name() + "\tPath: '"+ vortexPath.get(v) + "'\tCost: " + vortexCost.get(v));
        }
    }
}