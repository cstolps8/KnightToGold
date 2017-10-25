package DijkstrasKnight;

import java.util.Random;

public class Knight {
	
	String path, currentMove;
	int x, y, boardRows, boardCols;
	boolean goldFound;
	
	public Knight() {
		this.path = "";
		this.boardRows = 0; // stores number of board rows for later functions
		this.boardCols = 0; // stores number of board columns for later functions
		this.x = 0; // x coordinate of knight
		this.y = 0; // y coordinate of knight
		this.goldFound = false;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public void moveKnight() {
		
		Integer[] randomMove = pickMove();
		int rowMove = randomMove[0];
		int colMove = randomMove[1];
		
		System.out.println("Knight coordinates: ("+this.x+", "+this.y+")" +
				"\n  Row move: "+randomMove[0]+
				"\n  Column move: "+randomMove[1]+
				"\n  Board Rows from Knight: "+this.boardRows+
				"\n  Board Columns from Knight: "+this.boardCols);
	}
	
	public Integer[] pickMove() {
		// knightMoves contains the possible moves of the knight
		//   with the 2-space move first and the 1-space move second
		String[] knightMoves = {"UL", "UR", "DL", "DR", "RU", "RD", "LU", "LD"};
				
		// Generates a random number to randomly pick the knights move
		Random randNumber = new Random();
		int randMovePicker = randNumber.nextInt(knightMoves.length);
			
		String randomMove = knightMoves[randMovePicker];
		
		Integer[] moves = new Integer[2];
		switch (randomMove) {
		
		case "UL":
			moves[0] = 2;
			moves[1] = -1;
			break;
		
		case "UR":
			moves[0] = 2;
			moves[1] = 1;
			break;
			
		case "DL":
			moves[0] = -2;
			moves[1] = -1;
			break;
			
		case "DR":
			moves[0] = -2;
			moves[1] = 1;
			break;
			
		case "RU":
			moves[0] = 1;
			moves[1] = 2;
			break;
			
		case "RD":
			moves[0] = -1;
			moves[1] = 2;
			break;
			
		case "LU":
			moves[0] = 1;
			moves[1] = -2;
			break;
			
		case "LD":
			moves[0] = -1;
			moves[1] = -2;
			break;
			
		default:
			System.out.println("** No moves have been made **");
			break;
			
		}
		
		
		
		return moves;
	}

}