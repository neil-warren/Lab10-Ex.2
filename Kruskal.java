import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Kruskal
{
    public static ArrayList<Edge> kruskal (List<Edge> edges, int numVertices)
    {
        DisjSet ds = new DisjSet(numVertices);
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);
        ArrayList<Edge> mst = new ArrayList<>();
        
        while(mst.size() != numVertices - 1)
        {
            Edge e = pq.remove();
            int uset = ds.find(e.getU());
            int vset = ds.find(e.getV());
            
            if(uset != vset)
            {
                mst.add(e);
                ds.union(uset, vset);
            }
        }
        
        return mst;
    }
    
    public static void main(String[] args)
    {
        List<Edge> e = new ArrayList<>();
        e.add(new Edge(0, 1, 3));
        e.add(new Edge(0, 3, 4));
        e.add(new Edge(0, 4, 4));
        e.add(new Edge(1, 2, 10));
        e.add(new Edge(1, 4, 2));
        e.add(new Edge(1, 5, 3));
        e.add(new Edge(2, 5, 6));
        e.add(new Edge(2, 6, 1));
        e.add(new Edge(3, 4, 5));
        e.add(new Edge(3, 7, 6));
        e.add(new Edge(4, 5, 11));
        e.add(new Edge(4, 7, 2));
        e.add(new Edge(4, 8, 1));
        e.add(new Edge(5, 6, 2));
        e.add(new Edge(5, 8, 3));
        e.add(new Edge(5, 9, 11));
        e.add(new Edge(6, 9, 8));
        e.add(new Edge(7, 8, 4));
        e.add(new Edge(8, 9, 7));
        
        //ArrayList<Edge> k = kruskal(e, 10);
       ArrayList<Edge> mst = kruskal(e, 10);
       int total = 0;
       for (Edge edge : mst)
       {
           total += edge.weight();
           System.out.println(edge);
       }
       System.out.println("Total weight of MST: " + total);
    }
}
