package DijkstrasKnight;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

	Knight knightObj;
	String[][] gameBoard;

	int rows;
	int cols;
	public Node[][] N;
	Node n = new Node();
	public ArrayList<Node>[][] board;

	/*
	 * Game constructor
	 * 
	 * Creates a scanner and calls the functions to generate the board and run the
	 * algorithm on the gameboard The board is stored in the object itself, so all
	 * functions can be run on the object without input
	 */
	public Game() {

		Scanner scannerObj = new Scanner(System.in);
		System.out.println("Please enter the number of rows for the board:");
		rows = scannerObj.nextInt();
		System.out.println("Please enter the number of columns for the board:");
		cols = scannerObj.nextInt();

		// validate the size of the board
		while (rows < 3 || cols < 3) {
			System.out.println("Number of rows and columns must be greater than 2. Please enter new values.");
			System.out.print("Rows: ");
			this.rows = scannerObj.nextInt();
			System.out.print("\nCols: ");
			this.cols = scannerObj.nextInt();
			System.out.println();
		}

		this.knightObj = new Knight();

		this.knightObj = generateCompleteBoard(this.knightObj, rows, cols);
		NodeBoard();
	}

	// create a board of nodes made of arraylists and set the coordinates of the
	// board piece
	// side note: should create this as a class so that other classes can get the
	// board but this might work
	public void NodeBoard() {
		N = new Node[rows][cols];
		// get the possible moves in Knight object
		board = new ArrayList[rows][cols];
		Knight k = new Knight();

		k.boardRows = rows;
		k.boardCols = cols;


		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {

				// create a node that stores the neighbors
				// k.findMove(i,j) is passed row and col and returns the moves that can be made from the (i,j) cell
				// passed in ( row, col, array of the legal moves of that cell(row,col), is visited, distance
				
				N[i][j] = new Node(i, j, k.findMove(i, j), false, 1);
				//System.out.println(N[i][j].x);
				//System.out.println("Cell: ("+i+", "+j+") has moves: "+N[i][j].neihbors);	// this works yay5
				//System.out.println("*************************************");
				//System.out.println();

			}
		}

	}// end of NodeBoard

	public void simulateGame() {
		
		// 

		
		

		//while (this.knightObj.goldFound != true) {
		//	this.knightObj.moveKnight();
		//	this.knightObj.printBoardObj();
		//}
	}

	// Generates a blank board
	public String[][] generateBoard(int rows, int cols) {

		String[][] blankBoard = new String[rows][cols];
		for (int i = 0; i < blankBoard.length; i++) {
			for (int j = 0; j < blankBoard[i].length; j++) {
				blankBoard[i][j] = ".";
			}
		}
		return blankBoard;
	}

	// Generates a board and randomly places the Knight and Gold pieces
	public Knight generateCompleteBoard(Knight knightObj, int rows, int cols) {
		// Creates the knight object
		knightObj.boardRows = rows;
		knightObj.boardCols = cols;
		/*
		 * Randomly generates the coordinates of the gold and knight
		 */
		Random coordinateGenerator = new Random();
		int knightX = coordinateGenerator.nextInt(rows);
		int knightY = coordinateGenerator.nextInt(cols);
		int goldX = coordinateGenerator.nextInt(rows);
		int goldY = coordinateGenerator.nextInt(cols);

		String[][] completeBoard = new String[rows][cols];

		/*
		 * fills the blank "board" with . so that the board can be visualized in the
		 * console
		 */
		for (int i = 0; i < completeBoard.length; i++) {
			for (int j = 0; j < completeBoard[i].length; j++) {
				completeBoard[i][j] = ".";
			}
		}

		/*
		 * while loop that continues until the knight and gold coordinates are not the
		 * same
		 */
		while (knightX == goldX && knightY == goldY) {

			knightX = coordinateGenerator.nextInt(rows);
			knightY = coordinateGenerator.nextInt(cols);
			goldX = coordinateGenerator.nextInt(rows);
			goldY = coordinateGenerator.nextInt(cols);

		}
		// Sets the knightObj x and y coordinates and the gold coordinates for use in
		// algorithms
		knightObj.x = knightX;
		knightObj.y = knightY;
		knightObj.path += "(" + knightObj.x + ", " + knightObj.y + ") ";
		knightObj.goldX = goldX;
		knightObj.goldY = goldY;

		// designates the knight (K) and gold (G) coordinates and changes to those
		// characters on the board
		completeBoard[knightX][knightY] = "K";
		completeBoard[goldX][goldY] = "G";

		knightObj.gameBoard = completeBoard;
		return knightObj;
	}

	/*
	 * printBoard: parameter String[][] boardIn boardIn is the array that the game
	 * will run on prints the board with the proper row and column indices
	 */
	public void printBoard(String[][] boardIn) {
		for (int i = 0; i < boardIn[0].length; i++) {
			if (i == 0)
				System.out.print("  " + i + "\t");
			else
				System.out.print(i + "\t");
		}
		System.out.println();
		for (int i = 0; i < boardIn.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < boardIn[i].length; j++) {
				System.out.print(boardIn[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/*
	 * Prints the game object's gameBoard
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

	// getters and setters
	public ArrayList<Node>[][] getBoard() {
		return board;
	}

	public void setBoard(ArrayList<Node>[][] board) {
		this.board = board;
	}

	// public Void setBoardNeighbors(Arraylist neigh) {

	// }
}
