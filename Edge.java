
public class Edge implements Comparable<Edge>
{
    private final int u;
    private final int v;
    private final int weight;
    
    public Edge(int u, int v, int weight)
    {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
    
    public int weight()
    {
        return weight;
    }
    
    public int getU()
    {
        return u;
    }
    
    public int getV()
    {
        return v;
    }
    
    public int other(int vertex)
    {
        if (vertex == u)
            return v;
        else
            return u;   
    }
    
    public int compareTo(Edge e)
    {
        if(this.weight() < e.weight())
            return -1;
        else if (this.weight() > e.weight())
            return 1;
        else
            return 0;
    }
    
    public String toString()
    {
        return String.format("Edge: %d-%d    Weight: %d", u, v, weight);
    }
}
