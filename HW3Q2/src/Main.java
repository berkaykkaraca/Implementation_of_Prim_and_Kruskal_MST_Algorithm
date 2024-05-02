import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.nextLine();
		
		String sourceCityName = scanner.nextLine();

	
		String destinationCityName = scanner.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				String name = parts[0];
				String name1 = parts[1];
				int weight = Integer.parseInt(parts[2]);
				City city1 = graph.getOrCreateCity(name);
				City city2 = graph.getOrCreateCity(name1);
				Edge e = new Edge(city1.index, city2.index, weight);
				graph.addEgde(e);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int numCitiesToVisit = scanner.nextInt();
		String[] citiesToVisit = new String[numCitiesToVisit];
		if(numCitiesToVisit!=0) {
		
		for (int i = 0; i < numCitiesToVisit; i++) {
			
			citiesToVisit[i] = scanner.next();
		}
		}
		Dijkstra d = new Dijkstra(graph, graph.getCityByName(sourceCityName).index);
		d.findPath(graph, graph.getCityByName(sourceCityName), graph.getCityByName(destinationCityName),
				numCitiesToVisit, citiesToVisit);
		if(numCitiesToVisit!=0) {
		d.print(graph);
	}}

}
