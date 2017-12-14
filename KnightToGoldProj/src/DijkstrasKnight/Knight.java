package DijkstrasKnight;

import java.util.ArrayList;
import java.util.Random;

public class Knight {

	String path, currentMove;
	String[][] gameBoard;
	int x, y, boardRows, boardCols, goldX, goldY;
	boolean goldFound;
	

	public Knight() {
		this.path = "";
		this.x = 0; // x coordinate of knight
		this.y = 0; // y coordinate of knight
		this.goldX = 0; // x coordinate for gold
		this.goldY = 0; // y coordinate for gold
		this.goldFound = false;
	}

	public String getPath() {
		return this.path;
	}

	public void moveKnight() {

		// this.pickMove();

		// this.findMove();

		/*
		 * System.out.println("Knight coordinates: ("+this.x+", "+this.y+") " +
		 * "\n  Row move: "+randomMove[0]+ "\n  Column move: "+randomMove[1]); Debugging
		 * code
		 */

		if (this.x == this.goldX && this.y == this.goldY) {
			System.out.println("The gold has been found!\nPath: " + this.path);
			this.goldFound = true;
		}

		else {
			// System.out.println("** First two loops negated");
			this.printBoardObj();
			System.out.println();
			// this.findMove();
			// this.moveKnight();
		}
	}

	public ArrayList findMove(int x, int y) {

		// stores the legal moves that can be made from that cell
		ArrayList legal = new ArrayList<>();

		// display the legal moves for the current knight location
		//System.out.println("Knight at:(" + x + ", " + y + ") can make the moves:");

		//boardRows = 5;
	//	boardCols = 5;

		int[][] possiblemoves = {

				{ 2, -1 }, { 2, 1 }, { -2, -1 }, { -2, 1 }, { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 }

		};
		
		
		// check if the move will go outside of the board
		for (int i = 0; i < possiblemoves.length; i++) {
			ArrayList newlegal = new ArrayList<>(); // holds all the legal moves from the current cell

			// System.out.println("Try the move ("+possiblemoves[i][0]+",
			// "+possiblemoves[i][1]+")");

			if ((x + possiblemoves[i][0] >= 0) && (y + possiblemoves[i][1] >= 0)) { // make sure move doesn't go negative (lower bound) can = 0

				if (x + possiblemoves[i][0] < boardRows && y + possiblemoves[i][1] < boardCols) { // keeps knight from going outside the board (upper\ bound) has to be 1- board size

					

					// tmpx and tmpy finds the coordinates of the cells that are the possible moves for the cell being searched
					int tmpx = (x + possiblemoves[i][0]);
					int tmpy = (y + possiblemoves[i][1]);
					
				//	System.out.println(tmpx + "   "+ tmpy);

					// System.out.println(" to positions (" + tmpx + ", "+tmpy+")");

					// check if the gold has been found
					if (tmpx == this.goldX && tmpy == this.goldY) {
						System.out.println(" gold has been found ");
						System.out.println(" gold is at: (" + this.goldX + ", " + this.goldY + ")");
						System.out.println("with move: (" + possiblemoves[i][0] + ", " + possiblemoves[i][1] + ")");
						// this.printBoardObj();
						System.out.println();
						this.goldFound = true;
						// break;

					}
					// add arraylist newLegal to arraylist legal,
					// which only has 2 values (r,c) to legal moves
				//	newlegal.add(possiblemoves[i][0]); // add x of legal move
					newlegal.add(tmpx); 
				//	newlegal.add(possiblemoves[i][1]); // add y of legal move
					newlegal.add(tmpy); 
					legal.add(newlegal); // add the legal moves to the array of the current location of the knight


				}

			}

		}

		// }// end of while loop

		return legal;

	}

	public Knight pickMove() {

		// knightMoves contains the possible moves of the knight
		// with the 2-space move first and the 1-space move second
		String[] knightMoves = { "UL", "UR", "DL", "DR", "RU", "RD", "LU", "LD" };

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

		int postMoveRow = this.x + moves[0];
		int postMoveCol = this.y + moves[1];

		while (postMoveCol > this.gameBoard[0].length || postMoveRow > this.gameBoard.length || postMoveCol < 0
				|| postMoveRow < 0) {
			this.pickMove();
			System.out.println("** Row or columns was out of bounds");
		}

		this.gameBoard[this.x][this.y] = ".";
		this.x = postMoveRow;
		this.y = postMoveCol;
		this.path += "(" + this.x + ", " + this.y + ") => ";
		this.gameBoard[this.x][this.y] = "K";
		this.printBoardObj();

		return this;
	}

	/*
	 * Prints the knight object's gameBoard
	 */
	public void printBoardObj() {

		for (int i = 0; i < this.gameBoard[0].length; i++) {
			if (i == 0)
				System.out.print("  " + i + "\t");
			else
				System.out.print(i + "\t");
		}
		System.out.println();
		for (int i = 0; i < this.gameBoard.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < this.gameBoard[i].length; j++) {
				System.out.print(this.gameBoard[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
