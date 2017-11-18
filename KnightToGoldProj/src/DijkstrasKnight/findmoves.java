package DijkstrasKnight;

import java.util.ArrayList;

public class findmoves {
	
	// current position of the knight
	int knightx;
	int knighty;
	
	int x;
	int y;
	
	// board rows and columns
	int rows;
	int cols;
	
	int newlegalx;
	int newlegaly;
	
	int[][] possiblemoves = {
			
			{ 2, -1 }, 
			{ 2, 1 },
			{ -2, -1 },
			{ -2, 1 }, 
			{ 1, 2 },
			{ -1, 2 }, 
			{ 1, -2 }, 
			{ -1, -2 }

	};
			
	String[][] legalmoves;
	
	
	ArrayList legal = new ArrayList<>();
	


	
	//find all moves that the knight can maker from its current position
	public void findlegal() {
		
		

		//System.out.println("Knights initial position: ("+knightx+", "+knighty+")");
		// check if the move will go outside of the board
		for (int i = 0; i < possiblemoves.length; i++) {
			ArrayList newlegal = new ArrayList<>(); // holds all the legal moves from the current knight location
	
							
			//System.out.println("Try the move ("+possiblemoves[i][0]+", "+possiblemoves[i][1]+")");

			
			if ((knightx + possiblemoves[i][0] >= 0 ) && (knighty + possiblemoves[i][1] >= 0)) { // make sure move doesn't go negative (lower bound)
				
				if (knightx + possiblemoves[i][0] <= rows &&  knighty + possiblemoves[i][1] <= cols  ){ // keeps knight from going outside the board (upper bound) 
					
			
			/*// debugging purposes
				System.out.println("knight in position: ("+knightx+", "+knighty+")  can make the move: ("+possiblemoves[i][0]+", "+possiblemoves[i][1]+")" );
				
					int tmpx = (knightx + possiblemoves[i][0]);
					int tmpy = (knighty + possiblemoves[i][1]);
				
					System.out.println(" to positions (" + tmpx  + ", "+tmpy+")");
			 */			

				newlegal.add(possiblemoves[i][0]); // add x of legal move 
				newlegal.add(possiblemoves[i][1]); // add y of legal move
				
				
				
					legal.add(newlegal); // add the legal moves to the array of the current location of the knight 
				}
					
			}
			
		
			
		}
		
		
		
		
		
		
	} // end of findmoves
	
	// getters and setters
	public ArrayList getLegal() {
		return legal;
	}

	public void setLegal(ArrayList legal) {
		this.legal = legal;
	}

	
	
}
