package DijkstrasKnight;

import java.util.ArrayList;

public class Node {

	public int index;
	private int distanceFromSource = Integer.MAX_VALUE;
	public boolean visited;
	Node previous;



	
	public Node(int x, int y, boolean visited, int distance, int index ) {
		super();
		this.index = index;
		this.x = x;
		this.y = y;
		// this.neihbors = neihbors;
		this.visited = visited;
		this.distance = Integer.MAX_VALUE;
	}

	public Node() {
		super();

	}

	// vertex
	public int x;
	public int y;

	// previous node

	// edges
	public ArrayList<Node> neihbors = new ArrayList<>();

	public int distance;

	// print row and col coordinates
	public void printXY() {
		System.out.print("(" + this.x + ", " + this.y + ")");
	}

	// getters and setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ArrayList<Node> getNeihbors() {
		return neihbors;
	}

	public void setNeihbors(ArrayList<Node> neihbors) {
		this.neihbors = neihbors;
	}

	public boolean isIsvisited() {
		return visited;
	}

	public void setIsvisited(boolean isvisited) {
		this.visited = isvisited;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDistanceFromSource() {
		return distanceFromSource;
	}

	public void setDistanceFromSource(int distanceFromSource) {
		this.distanceFromSource = distanceFromSource;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	private ArrayList<Edge> edges = new ArrayList<Edge>();

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
}
