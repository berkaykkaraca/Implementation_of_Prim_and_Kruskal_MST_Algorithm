
import java.util.PriorityQueue;

public class Graph {
	//-----------------------------------------------------
		// Title: Graph class
		// Author: Berkay Kaan Karaca
		// Section: 1
		// Assignment: 3
		// Description: This class creates a graph and includes graph methods
		//-----------------------------------------------------

	private Bag<Edge>[] adjacencylist;
	private boolean[][] adjMatrix;
	private City[] cities;
	public int size;
	private final int maxSize = 26;

	Graph() {
		size = 0;
		adjacencylist = new Bag[maxSize];
		adjMatrix = new boolean[maxSize][maxSize];
		cities = new City[maxSize];

		// initialize adjacency lists for all the vertices
		for (int i = 0; i < maxSize; i++) {
			adjacencylist[i] = new Bag<>();
		}
	}

	public void addEgde(Edge e) {
		//--------------------------------------------------------
		 // Summary: This method adds edge between 2 verteces
		 //--------------------------------------------------------
		int v = e.either(), w = e.other(v);
		 adjacencylist[v].add(e);
		 adjacencylist[w].add(e); 
		 adjMatrix[v][w]=true;
		 adjMatrix[w][v]=true;
	}

	 public City getOrCreateCity(String cityName) {
			//--------------------------------------------------------
		 // Summary: This method search all the cities to check there is a city such given name
		 // if there is returns it, if not creates a new city object.
		 //--------------------------------------------------------
	        for (int i = 0; i < size; i++) {
	            if (cities[i].getName().equals(cityName)) {
	                return cities[i];
	            }
	        }
	        City city = new City(cityName,size);
	        cities[size] = city;
	        size++;
	        return city;
	    }

	 public void printGraph() {
			//--------------------------------------------------------
		 // Summary: This method prints all the graph to see more clearly
		 //--------------------------------------------------------
	        for (int i = 0; i < size; i++) {
	            System.out.print(cities[i].getName() + " -> ");
	            for (int j = 0; j < size; j++) {
	                if (adjMatrix[i][j]) {
	                    System.out.print(cities[j].getName() + " ");
	                }
	            }
	            System.out.println();
	        }
	        
	        }

	
	

	public Iterable<Edge> adj(int v) {
		return adjacencylist[v];
	}



	public City getCity(int index) {
		return cities[index];
	}

	public City getCityByName(String name) {
		//--------------------------------------------------------
		 // Summary: This method returns the city by its name.
		 //--------------------------------------------------------
		for (int i = 0; i < size; i++) {
			if (cities[i] != null && cities[i].getName().equals(name)) {
				return cities[i];
			}
		}
		return null;
	}
	

}

class City {
	String name;
	int  index;

	public City(String name,int index) {
		this.name = name;
		
		
		this.index=index;
	}

	public String getName() {
		return name;
	}

	public int getIndex() {
		return index;
	}
}
