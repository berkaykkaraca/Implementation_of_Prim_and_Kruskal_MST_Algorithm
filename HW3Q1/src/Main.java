import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Main {
	//-----------------------------------------------------
	// Title: Main Class
	// Author: Berkay Kaan Karaca
	// Section: 1
	// Assignment: 3
	// Description: This class takes the inputs, creating graph and use prim algorithm by calling the necessary methods. 
	//-----------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		Scanner sc = new Scanner(System.in);
		String filename = sc.next();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                graph.createCity(name, x, y);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
graph.addEgde();
      

LazyPrimMST l = new LazyPrimMST(graph);  
System.out.println("Paths are:");
l.print(graph);

}

}
