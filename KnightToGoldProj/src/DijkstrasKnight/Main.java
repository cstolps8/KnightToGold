package DijkstrasKnight;

import java.io.FileFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Main {

	public static void  main(String[] args) {
		
		
				Edge[] edges = {
			      new Edge(0, 2, 1), new Edge(0, 3, 4), new Edge(0, 4, 2),
			      new Edge(0, 1, 3), new Edge(1, 3, 2), new Edge(1, 4, 3),
			      new Edge(1, 5, 1), new Edge(2, 4, 1), new Edge(3, 5, 4),
			      new Edge(4, 5, 2), new Edge(4, 6, 7), new Edge(4, 7, 2),
			      new Edge(5, 6, 4), new Edge(6, 7, 5)
			      //, new Edge(fromNodeIndex, toNodeIndex, length)
			    };
		
		Dijkstra g = new Dijkstra(edges);
		
	//	g.calculateShortestDistances();
		
	//	g.printResult();

		//*************************************************************************************************************
		

		Game gameObj = new Game();
		
		Queue<Node> queue = new LinkedList<>();
		int gkx = gameObj.knightObj.x; // knight x position
		int gky = gameObj.knightObj.y; // knight y position
		

		//*** prints the index and its neighbors
		for (int i = 0; i < gameObj.N.length; i++) {
			for (int j = 0; j < gameObj.N.length; j++) {
				// gameObj.N[i][j].printXY();
				// System.out.println(" Index :" +gameObj.N[i][j].index+" has neighbors");
				int tmp = gameObj.N[gkx][gky].getNeihbors().size();
				for (int n = 0; n < tmp  ; n++) {
					
	
				//	gameObj.N[gkx][gky].neihbors.get(n).printXY();
				//	System.out.println(" Index "+gameObj.N[gkx][gky].neihbors.get(n).index);
					
					

				}
				//  System.out.println();
				
			}
		}
		


		
		
		
		// get the neighbors ( moves the knight from the initial cell)  from the knights position
		// get the knight and gold location index
		int knightIndex = gameObj.N[gkx][gky].index;
		int goldIndex = gameObj.N[gameObj.knightObj.goldX][gameObj.knightObj.goldY].index;
		
		System.out.println("Knights position: ("+gkx+", "+gky+") Index: "+knightIndex);

		
		
		int numOfKnightNeighbors = gameObj.N[gkx][gky].neihbors.size(); // the number of neighbors the knight has
		for (int i = 0; i < numOfKnightNeighbors  ; i++) {

			gameObj.N[gkx][gky].neihbors.get(i).printXY(); // prints the neighbors of the knight position 
			System.out.println(" Index :" +gameObj.N[gkx][gky].neihbors.get(i).index);

			// if the gold was not found check the neighbors from the passed in cell

		}
		
		
		System.out.println("Gold position: ("+gameObj.knightObj.goldX+", "+gameObj.knightObj.goldY+") Index: "+ goldIndex);
		System.out.println();
		
		//*************************************************************************************************************
		
		
		// Initialize the knight's distance to 0 and visited to true 
		gameObj.N[gkx][gky].distance = 0 ;
		
		//gameObj.N[gkx][gky].visited = true;
		
		
		// get the distance from the first level of neighbors
		for (int i = 0; i < numOfKnightNeighbors; i++) {
			gameObj.N[gkx][gky].neihbors.get(i).distance = 1;
			
			gameObj.N[gkx][gky].neihbors.get(i).previous  = gameObj.N[gkx][gky];
		}	
		
		for (int i = 0; i < numOfKnightNeighbors; i++) {
			gameObj.N[gkx][gky].neihbors.get(i).printXY();
			System.out.println(" Distance from Knight " +gameObj.N[gkx][gky].neihbors.get(i).distance);
			System.out.println("Previous node: "+	gameObj.N[gkx][gky].neihbors.get(i).previous.index);
			
		}
		
		System.out.println();
		
		// get the second level of nodes from the first node of the knight
		for (int i = 0; i < gameObj.N[gkx][gky].neihbors.size(); i++) {

			int nx = gameObj.N[gkx][gky].neihbors.get(i).x;
			int ny = gameObj.N[gkx][gky].neihbors.get(i).y;

			//System.out.println("(" + nx + ", " + ny + ") "); // pass in the first neighbor of the knight
			rundijstras(gameObj, nx,ny);

			
		}

		
			
			
		for (int i = 0; i < numOfKnightNeighbors; i++) {

			
		//	int nx = gameObj.N[gkx][gky].neihbors.get(0).x;
		//	int ny = gameObj.N[gkx][gky].neihbors.get(0).y;
			
			//System.out.println("("+nx+", "+ny+") ");
			
			//System.out.println(gameObj.N[nx][ny].neihbors.get(i).index);
		}
		
		
		
		ArrayList vertex = new ArrayList<>();
		for (int i = 0; i < numOfKnightNeighbors  ; i++) {

			vertex.add(gameObj.N[1][1].index);
			
			//gameObj.N[gkx][gky].neihbors.get(i).index;

			// if the gold was not found check the neighbors from the passed in cell

		}
		
		ArrayList<Node> shortestDistFromStart = new ArrayList<>();
		ArrayList<Node> previous = new ArrayList<>();
		
		

		
		
	

	}
	
	public static Game rundijstras(Game gameObj, int nx, int ny ) {
		
		System.out.println("Neighbors of "+gameObj.N[nx][ny].index);
		
		for (int j = 0; j < gameObj.N[nx][ny].neihbors.size(); j++) {
			
		System.out.println();
		printCoords(gameObj, nx, ny, j);
		System.out.println("   " +gameObj.N[nx][ny].neihbors.get(j).index);
		
		}


		
		
		
	
		



		return gameObj;
	}
	
	static void printCoords(Game game, int nx, int ny, int n) {
		int pcx = game.N[nx][ny].neihbors.get(n).x;
		int pcy = game.N[nx][ny].neihbors.get(n).y;
		System.out.println("("+pcx+", "+pcy+") ");
	}
	
	public static void  goldFound(Game gameObj, int x, int y) {
		
		if (gameObj.N[x][y].neihbors.get(0).x == gameObj.knightObj.goldX && gameObj.N[x][y].neihbors.get(0).y == gameObj.knightObj.goldY ) {
			System.out.println(gameObj.N[x][y].neihbors.get(0).index);
		
			
			System.out.println( gameObj.knightObj.path);
		}
		
	}

}
