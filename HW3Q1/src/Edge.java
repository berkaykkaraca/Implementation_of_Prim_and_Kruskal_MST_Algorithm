import java.util.Iterator;

public class Edge implements Comparable<Edge> {
	// -----------------------------------------------------
	// Title: Main Class
	// Author: Berkay Kaan Karaca
	// Section: 1
	// Assignment: 3
	// Description: This class is for create edge objects.
	// -----------------------------------------------------
	int source;
	int destination;
	double weight;

	public Edge(int source, int destination, double weight) {
		// --------------------------------------------------------
		// Summary: Constructor sets all the variables.
		// --------------------------------------------------------
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public int either()
//--------------------------------------------------------
// Summary: returns the source vertex on the edge
//--------------------------------------------------------
	{
		return source;
	}

	public int other(int vertex)
//--------------------------------------------------------
// Summary: returns the other vertex on the edge with given vertex
//--------------------------------------------------------
	{
		if (vertex == source)
			return destination;
		else
			return source;
	}

	@Override
	public int compareTo(Edge other) {
		return Double.compare(this.weight, other.weight);
	}
}
