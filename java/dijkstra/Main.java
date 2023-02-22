package dijkstra;


import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        // Undirected Algorithm

        //EXAMPLE 1
        //  VORTEXES
        Vortex a = new Vortex("A");
        Vortex b = new Vortex("B");
        Vortex c = new Vortex("C");
        Vortex d = new Vortex("D");
        Vortex e = new Vortex("E");
        Vortex f = new Vortex("F");
        Vortex g = new Vortex("G");
        Vortex h = new Vortex("H");
        Vortex i = new Vortex("I");

        Collection<Vortex> vortexes2 = Arrays.asList(
                a, b, c, d, e, f, g, h, i
        );

        //  EDGES
        UndirectedEdge l21 = new UndirectedEdge(a, b, 4);
        UndirectedEdge l22 = new UndirectedEdge(a, h, 8);
        UndirectedEdge l23 = new UndirectedEdge(h, b, 11);
        UndirectedEdge l24 = new UndirectedEdge(c, b, 8);
        UndirectedEdge l25 = new UndirectedEdge(h, g, 1);
        UndirectedEdge l26 = new UndirectedEdge(h, i, 7);
        UndirectedEdge l27 = new UndirectedEdge(c, i, 2);
        UndirectedEdge l28 = new UndirectedEdge(i, g, 6);
        UndirectedEdge l29 = new UndirectedEdge(g, f, 2);
        UndirectedEdge l210 = new UndirectedEdge(c, f, 4);
        UndirectedEdge l211 = new UndirectedEdge(c, d, 7);
        UndirectedEdge l212 = new UndirectedEdge(d, f, 14);
        UndirectedEdge l213 = new UndirectedEdge(d, e, 9);
        UndirectedEdge l214 = new UndirectedEdge(f, e, 10);

        Collection<UndirectedEdge> edges2 = Arrays.asList(
                l21, l22, l23, l24, l25, l26, l27, l28, l29, l210, l211, l212, l213, l214
        );

        //  Graph
        UndirectedGraph undirectedGraph2 = new UndirectedGraph(
                vortexes2,
                edges2
        );

        //undirectedGraph2.dijkstra(a);

        //EXAMPLE 2
        //  VORTEX
        Vortex A = new Vortex("A");
        Vortex B = new Vortex("B");
        Vortex C = new Vortex("C");
        Vortex P = new Vortex("P");
        Vortex E = new Vortex("E");
        Vortex V = new Vortex("V");
        Vortex L = new Vortex("L");
        Vortex G = new Vortex("G");

        Collection<Vortex> vortexes3 = Arrays.asList(
                A, B, C, P, E, V, L, G
        );

        //  EDGES
        UndirectedEdge AC = new UndirectedEdge(A, C, 160);
        UndirectedEdge AP = new UndirectedEdge(A, P, 180);
        UndirectedEdge CP = new UndirectedEdge(C, P, 130);
        UndirectedEdge CE = new UndirectedEdge(C, E, 140);
        UndirectedEdge CL = new UndirectedEdge(C, L, 180);
        UndirectedEdge PE = new UndirectedEdge(P, E, 80);
        UndirectedEdge PV = new UndirectedEdge(P, V, 100);
        UndirectedEdge EL = new UndirectedEdge(E, L, 70);
        UndirectedEdge EV = new UndirectedEdge(E, V, 100);
        UndirectedEdge LB = new UndirectedEdge(L, B, 80);
        UndirectedEdge LG = new UndirectedEdge(L, G, 110);
        UndirectedEdge LV = new UndirectedEdge(L, V, 100);
        UndirectedEdge VG= new UndirectedEdge(V, G, 90);
        UndirectedEdge BG= new UndirectedEdge(B, G, 180);

        Collection<UndirectedEdge> undirectedEdges3 = Arrays.asList(
                AC, AP, CP, CE, CL, PE, PV, EL, EV, LB, LG, LV, VG, BG
        );

        //  Graph
        UndirectedGraph graph2 = new UndirectedGraph(vortexes3, undirectedEdges3);
        graph2.dijkstra(B);
    }
}
