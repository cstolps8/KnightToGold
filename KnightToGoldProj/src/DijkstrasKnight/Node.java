package DijkstrasKnight;

import java.util.ArrayList;

public class Node {
	// vertex
	public int x; 
	public int y;
	

	// edges
	public ArrayList neihbors = new ArrayList<>();
	 
	public boolean isvisited;
	public int distance; 
	
	
	
	
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
	public ArrayList getNeihbors() {
		return neihbors;
	}
	public void setNeihbors(ArrayList neihbors) {
		this.neihbors = neihbors;
	}
	public boolean isIsvisited() {
		return isvisited;
	}
	public void setIsvisited(boolean isvisited) {
		this.isvisited = isvisited;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}

 

}
