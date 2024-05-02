public class Edge implements Comparable<Edge> {
	//-----------------------------------------------------
			// Title: Edge class
			// Author: Berkay Kaan Karaca
			// Section: 1
			// Assignment: 3
			// Description: This class creates an Edge object. 
			//-----------------------------------------------------
	int source;
	int destination;
	double weight;

	public Edge(int source, int destination, double weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public int either() {
		return source;
	}

	public int other(int vertex) {
		if (vertex == source)
			return destination;
		else
			return source;
	}

	@Override
	public int compareTo(Edge that) {
		if (this.weight < that.weight)
			return -1;
		else if (this.weight > that.weight)
			return +1;
		else
			return 0;
	}
}
