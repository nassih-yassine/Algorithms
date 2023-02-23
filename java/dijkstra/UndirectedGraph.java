package dijkstra;

import java.util.*;


public class UndirectedGraph {
    private final Collection<Vertex> vertices;
    private final Collection<UndirectedEdge> edges;

    public UndirectedGraph(Collection<Vertex> vertices, Collection<UndirectedEdge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void dijkstra(Vertex startingVertex){
        Map<Vertex, Integer> vertexCost = new HashMap<>();
        Map<Vertex, String> vertexPath = new HashMap<>();
        Collection<Vertex> consumedVertices = new ArrayList<>();

        vertices.forEach(vertex -> vertexCost.put(vertex, Integer.MAX_VALUE));
        vertexCost.put(startingVertex, 0);
        vertexPath.put(startingVertex, startingVertex.name());
        consumedVertices.add(startingVertex);

        while (vertices.size() != consumedVertices.size()){
            Collection<UndirectedEdge> connectedEdges = new ArrayList<>();

            for (Vertex v : consumedVertices){
                for (UndirectedEdge ue : edges){
                    if (ue.vertexExist(v)){
                        connectedEdges.add(ue);
                    }
                }
            }
            connectedEdges = connectedEdges
                    .stream()
                    .filter(
                    elem -> !(consumedVertices.contains(elem.getV2()) && consumedVertices.contains(elem.getV1()))
            ).toList();

            Map<Vertex, Integer> connectedEdgesVertexCost = new HashMap<>();

            for (UndirectedEdge ue : connectedEdges){
                Vertex smallVertexValue;
                Vertex bigVertexValue;
                
                if (vertexCost.get(ue.getV1()) > vertexCost.get(ue.getV2())){
                    bigVertexValue = ue.getV1();
                    smallVertexValue = ue.getV2();
                }
                else{
                    bigVertexValue = ue.getV2();
                    smallVertexValue = ue.getV1();
                }

                if (vertexCost.get(smallVertexValue)+ ue.getWeight() > vertexCost.get(bigVertexValue)){
                    connectedEdgesVertexCost.put(bigVertexValue, vertexCost.get(bigVertexValue));
                    continue;
                }

                Collection<Boolean> testingLoop =  edges.stream()
                        .filter(e -> e.vertexExist(bigVertexValue))
                        .map(e -> consumedVertices.contains(e.getOtherVertexInEdge(bigVertexValue)))
                        .toList();

                if (!testingLoop.contains(false) && !consumedVertices.contains(bigVertexValue)){
                    consumedVertices.add(bigVertexValue);
                    continue;
                }

                if(vertexCost.get(smallVertexValue)+ ue.getWeight() < vertexCost.get(bigVertexValue)){
                    vertexCost.put(bigVertexValue, vertexCost.get(smallVertexValue)+ ue.getWeight());
                    connectedEdgesVertexCost.put(bigVertexValue, vertexCost.get(smallVertexValue)+ ue.getWeight());
                    vertexPath.put(bigVertexValue, vertexPath.get(smallVertexValue) + " -> " + bigVertexValue.name());
                }
            }

            Vertex minVertex = null;
            Integer minValue = Integer.MAX_VALUE;
            for (Map.Entry<Vertex, Integer> entry : connectedEdgesVertexCost.entrySet()) {
                if (entry.getValue() < minValue && entry.getKey() != null) {
                    minValue = entry.getValue();
                    minVertex = entry.getKey();
                }
            }
            consumedVertices.add(minVertex);
        }

        for (Vertex v : vertexCost.keySet()){
            System.out.println(v.name() + "\tPath: '"+ vertexPath.get(v) + "'\tCost: " + vertexCost.get(v));
        }
    }
}