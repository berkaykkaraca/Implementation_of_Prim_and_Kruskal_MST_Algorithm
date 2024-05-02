import java.lang.Math;
import java.text.DecimalFormat;
import java.util.PriorityQueue;

public class Graph {
	//-----------------------------------------------------
	// Title: Graph Class
	// Author: Berkay Kaan Karaca
	// Section: 1
	// Assignment: 3
	// Description: This class helps to create a graph, adding the edges and also implements 
	//City class for create city objects.
	//-----------------------------------------------------
	private Bag<Edge>[] adjacencylist;

	private City[] cities;
	public int size;
	private final int maxSize = 26;
	private static final DecimalFormat df = new DecimalFormat("0.0");

	public Graph() {
		//--------------------------------------------------------
		 // Summary: Constructor sets all the variables.
		 //--------------------------------------------------------
		this.size = 0;
		adjacencylist = new Bag[maxSize];

		cities = new City[maxSize];

		// initialize adjacency lists for all the vertices
		for (int i = 0; i < maxSize; i++) {
			adjacencylist[i] = new Bag<>();
		}
	}

	public void addEgde() {
		//--------------------------------------------------------
		 // Summary: Adding the edges between all the verteces except the vertex itself.
		 //--------------------------------------------------------

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i != j) {
					double weight = findWeight(i, j);

					Edge edge1 = new Edge(i, j, weight);

					adjacencylist[i].add(edge1);

				}
			}
		}
	}

	private double findWeight(int i, int j) {
		//--------------------------------------------------------
		 // Summary: Finds the weight according to their position on coordinate system.
		 //--------------------------------------------------------
		int x1 = cities[i].x;
		int x2 = cities[j].x;
		int y1 = cities[i].y;
		int y2 = cities[j].y;
		double weight = Math.sqrt(((x1 - x2) * (x1 - x2)) + (y1 - y2) * (y1 - y2));
		return weight;
	}

	public void printGraph() {
		//--------------------------------------------------------
		 // Summary: This method prints all the graph with their weights to ease the see the actual graph.
		 //--------------------------------------------------------
		for (int i = 0; i < size; i++) {
			System.out.print(cities[i].name + " -> ");
			Bag<Edge> list = adjacencylist[i];
			for (Edge edge : list) {
				City sourceCity = getCity(edge.source);
				City destCity = getCity(edge.destination);
				System.out.print(sourceCity.name + "(" + getCityIndex(sourceCity.getName()) + ")"
						+ df.format(edge.weight) + destCity.name + "(" + getCityIndex(destCity.getName()) + ") ");
			}
			System.out.println();
		}
	}

	public Iterable<Edge> adj(int v) {
		//--------------------------------------------------------
		 // Summary:This method returns adj verteces to given vertex.
		 //--------------------------------------------------------
		return adjacencylist[v];
	}

	public void createCity(String name, int x, int y) {
		//--------------------------------------------------------
		 // Summary:This method creates a new city and holds the number of cities in size variable.
		//also holds the cities in an array.
		 //--------------------------------------------------------
		City city = new City(name, x, y);
		cities[size] = city;
		size++;
	}

	public City getCity(int index) {
		//--------------------------------------------------------
		 // Summary: Returns the city by its index.
		 //--------------------------------------------------------
		return cities[index];
	}

	private int getCityIndex(String name) {
		//--------------------------------------------------------
		 // Summary:This method finds the city in all cities by its String name.
		 //--------------------------------------------------------
		for (int i = 0; i < size; i++) {
			if (cities[i] != null && cities[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

}

class City {
	String name;
	int x, y;

	public City(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;

	}

	public String getName() {
		return name;
	}

}
