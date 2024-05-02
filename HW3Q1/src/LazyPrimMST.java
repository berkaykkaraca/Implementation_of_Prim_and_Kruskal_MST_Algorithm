import java.text.DecimalFormat;
public class LazyPrimMST {
	//-----------------------------------------------------
	// Title: Prim Class
	// Author: Berkay Kaan Karaca
	// Section: 1
	// Assignment: 3
	// Description: This class is required to use prim algorithm to graph and find the mst. 
	//-----------------------------------------------------
	private boolean[] marked; // MST vertices
	private MinPQ<Edge> mst; // MST edges
	private MinPQ<Edge> pq;
	private int count;//count how many edge exist on mst.
	 private static final DecimalFormat df = new DecimalFormat("0.0");
	public LazyPrimMST(Graph G) {
		//--------------------------------------------------------
		 // Summary:Constructor for set the variables and use prim algorithm on Graph. 
		 //--------------------------------------------------------
		pq = new MinPQ<Edge>();
		mst = new MinPQ<Edge>();
		marked = new boolean[26];
		count=0;
		visit(G, 0);
		

		while (!pq.isEmpty() && mst.size() < G.size -1) {
			Edge e = pq.delMin();
			
			int v = e.either(), w = e.other(v);
			if (marked[v] && marked[w])
				continue;
			
			mst.insert(e);
			count++;
			
			if (!marked[v])
				visit(G, v);
			if (!marked[w])
				visit(G, w);
		}
	}

	private void visit(Graph G, int v) {
		//--------------------------------------------------------
		 // Summary:While using prim this method visits all the adj verteces.
		 //--------------------------------------------------------
		marked[v] = true;
		for (Edge e : G.adj(v))
			if (!marked[e.other(v)]) {
				
				pq.insert(e);
				
			}
	}
	public void print(Graph G) {
		//--------------------------------------------------------
		 // Summary:This method prints the mst path.
		 //--------------------------------------------------------
				
		for (int i = 0;i<count;i++) {
			Edge e = mst.delMin();
			System.out.println(G.getCity(e.source).name+"-"+G.getCity(e.destination).name+": "+df.format(e.weight));
		}
		
	}

	public Iterable<Edge> mst() {
		return (Iterable<Edge>) mst;
	}
	
}