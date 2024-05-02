
public class Dijkstra {
	//-----------------------------------------------------
	// Title: Dijkstra class
	// Author: Berkay Kaan Karaca
	// Section: 1
	// Assignment: 3
	// Description: This class includes the methods that required for use dijkstra algorithm on the Graph.
	//-----------------------------------------------------
	public Edge[] edgeTo;
	public double[] distTo;
	private IndexMinPQ<Double> pq;
	private int count;
	private Edge[] path;
	private int size;
	private int sum;

	public Dijkstra(Graph G, int s) {
		sum=0;
		count=0;
		size=0;
		path = new Edge[100];
		
		}
	
	private void start(Graph G,int s) {
		//--------------------------------------------------------
		 // Summary: This method starts the dijkstra algorithm on edge with a source vertex. Sets the arrays
		//and pq.
		 //--------------------------------------------------------
		edgeTo = new Edge[G.size];
		distTo = new double[G.size];
		pq = new IndexMinPQ<Double>(G.size);
		for (int v = 0; v < G.size; v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		pq.insert(s, 0.0);
		while (!pq.isEmpty()) {
			int v = pq.delMin();
			
			for (Edge e : G.adj(v)) {
				relax(e);
			
		}
			}
	}

	private void relax(Edge e) {
		//--------------------------------------------------------
		 // Summary: This method is called in start function. Compares distTo values and sets it.
		 //--------------------------------------------------------
		int v = e.either(), w = e.other(v);
		if (distTo[w] > distTo[v] + e.weight) {
			distTo[w] = distTo[v] + e.weight;
			edgeTo[w] = e;
			if (pq.contains(w))
				pq.decreaseKey(w, distTo[w]);
			else
				pq.insert(w, distTo[w]);
		}
	}
	
	
	public void findPath(Graph g,City source,City destination,int num,String[] citiesToVisit) {
		//--------------------------------------------------------
		 // Summary: This method finds the path between 2 verteces. Firstly if there is no city to visit
		// prints the edge between that 2 cities. if there is cities to visit it use Dijkstra algorithm
		// between all of them. This helps to find shortest path between every city.
		 //--------------------------------------------------------
		
		if(num==0) {
			
			for(Edge e:g.adj(source.index)) {
				if(g.getCity(e.destination).index==destination.index) {
					System.out.println("Routes are:");
					System.out.println(source.name+"-"+destination.name);
					System.out.println("Length of route is:"+(int)e.weight);
				}
			}
		}
		else {
			start(g,source.index);
			back(g,source.index,g.getCityByName(citiesToVisit[0]).index);
			for(int i = 1;i<citiesToVisit.length;i++) {
				
			
					start(g,g.getCityByName(citiesToVisit[i-1]).index);
				back(g,g.getCityByName(citiesToVisit[i-1]).index ,g.getCityByName(citiesToVisit[i]).index);
				
				
			}
			start(g,destination.index-1);
			back(g,g.getCityByName(citiesToVisit[num-1]).index,destination.index);
			
		}
		
		
	}
	private void back(Graph g,int source,int dest) {
		//--------------------------------------------------------
		 // Summary: This function is required for findPath method. Every time code use Dijkstra and find
		// shortest path this function start from the end and by going back holds the every edge to the source vertex
		// While doing that adds the weight of that edge to the sum variable. Because of the code starts from the end
		// The path is reversed so in path array holds them in reversed order.
		 //--------------------------------------------------------
		Edge[] temp = new Edge[100];
		int s = 0;
		Edge e = edgeTo[dest];
		while (e!=null) {
			temp[s]=e;
			sum+=(int)e.weight;
			
			s++;
			e=edgeTo[e.source];
			
			count++;
		}
		
		
		for(int i =s-1;i>=0;i--) {
			this.path[size]=temp[i];
			
			this.size++;
		}
	}
	
	public void print(Graph g) {
		System.out.println("Routes are:");
		for(int i = 0;i<size;i++) {
			System.out.print(g.getCity(path[i].source).name+"-");
		}
		System.out.println(g.getCity(path[size-1].destination).name);
		System.out.println("Length of route is:"+sum);
	}
}
