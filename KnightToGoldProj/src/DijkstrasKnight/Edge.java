package DijkstrasKnight;

public class Edge {



	private int fromNodeIndex;
	private int toNodeIndex;
	private int length;
	
	
	
	public Edge(int fromNodeIndex, int toNodeIndex, int length) {
		super();
		this.fromNodeIndex = fromNodeIndex;
		this.toNodeIndex = toNodeIndex;
		this.length = length;
	}
	
	  // determines the neighboring node of a supplied node, based on the two nodes connected by this edge
	  public int getNeighbourIndex(int nodeIndex) {
	    if (this.fromNodeIndex == nodeIndex) {
	      return this.toNodeIndex;
	    } else {
	      return this.fromNodeIndex;
	   }
	  }
	  
	
	// getters and setters
	public int getFromNodeIndex() {
		return fromNodeIndex;
	}



	public void setFromNodeIndex(int fromNodeIndex) {
		this.fromNodeIndex = fromNodeIndex;
	}



	public int getToNodeIndex() {
		return toNodeIndex;
	}



	public void setToNodeIndex(int toNodeIndex) {
		this.toNodeIndex = toNodeIndex;
	}



	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}


	

}
