package DijkstrasKnight;

public class Main {

	public static void main(String[] args) {
		Game gameObj = new Game();
		
		
		Knight knight = new Knight();
		knight.x = 2;
		knight.y = 2;
		
		// get the neightbors of the current knight position
		
		//gameObj.n.x = knight.x;
		//gameObj.n.y = knight.y;
		System.out.println();
		System.out.println(gameObj.N[0][0].getNeihbors());
		//System.out.println(gameObj.n.getNeihbors());
		
	//	gameObj.simulateGame();
	}

}
