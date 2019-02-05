/*
Name: Connie

 Main Method and GameBoard class are the same from Project 5.

*/

class P6{
        public static void main(String args[]){
	
        char board[][];
        int row, column, piece = (int) (Math.random() * 5);	//randomly generates a piece
        char pieces[] = new char[] {'A', 'B', 'C', 'D', 'E'};
		String name;
		
        System.out.print("Name: Connie");

        GameBoard gameBoard = new GameBoard(5);	//create an instance

        System.out.print("\n\nWelcome to Tetris!");
		System.out.println("\nYour name is?  ");
		name = new String(UserInput.readString());	//initializing name
		
		Player player = new Player(name);	//create an instance of player
        
		gameBoard.printBoard();		//prints the board
        System.out.print("\nWhere would you like to place the piece:  " + pieces[piece]);
		System.out.print("\n\nChoose the row (0 - 4)  ");
        row = UserInput.readInt();
        System.out.print("\nChoose the column (0 - 4)  ");
        column = UserInput.readInt();
        System.out.println();

    while(!gameBoard.endOfGame(pieces[piece])){
      if(gameBoard.validMove(pieces[piece], row, column) == true){	//checks for valid moves
          gameBoard.makeMove(pieces[piece], row, column);
		  player.addToScore(gameBoard.calculateScore());	//get score
          gameBoard.printBoard();		//prints new board
      }
      else if(gameBoard.validMove(pieces[piece], row, column) == false){
          System.out.print("  Invalid move!");	//deals with invalid moves
          gameBoard.printBoard();		//prints new board
      }
			System.out.println("\nYour current score is " + player.getScore());
	        piece = (int) (Math.random() * 5);	//select new pieces
            System.out.print("\nWhere would you like to place the piece:  " + pieces[piece]);
			System.out.print("\n\nChoose the row (0 - 4)  ");
	        row = UserInput.readInt();
	        System.out.print("\nChoose the column (0 - 4)  ");
	        column = UserInput.readInt();
	        System.out.println();
    }
      System.out.println();
	  System.out.println(player.getName() + "'s total score is " + player.getScore());
      System.out.print("\n  No more moves available!" + "\n\n  Thanks for playing Tetris!");
   }
}

class GameBoard{
	public char board[][];
	
	public GameBoard(){
		board = new char[5][5];
		for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = ' ';
            }
        }

	}
	public GameBoard(int size){
		board = new char[size][size];
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
	}

	public boolean endOfGame(char piece){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(validMove(piece, i, j) == true)
                return false;
			}
        }
        return true;
    }

	public void printBoard(){

            // draw the board
            System.out.println();
			System.out.print("  ");
			printDashesRecursive();		// print the top line of all dashes
			for(int i = 0; i < 5; i++){
				System.out.println();
				printRowRecursive(i, 0);	// for each row, print the contents and a line of all dashes
				System.out.println();
				System.out.print("  ");
				printDashesRecursive();
			}
			System.out.println();
			System.out.print("   ");
			for(int i = 0; i < 5; i++){
			System.out.print(i + " ");
			}
    }
	
	public void makeMove(char piece, int moveRow, int moveColumn){
		if(piece == 'A'){
			board[moveRow][moveColumn - 1] = 'A';
			board[moveRow][moveColumn] = 'A';
			board[moveRow][moveColumn  + 1] = 'A';
		}
		else if(piece == 'B'){
			board[moveRow - 1][moveColumn] = 'B';
			board[moveRow][moveColumn] = 'B';
			board[moveRow + 1][moveColumn] = 'B';
		}
		else if(piece == 'C'){
			board[moveRow + 1][moveColumn] = 'C';
			board[moveRow][moveColumn] = 'C';
			board[moveRow][moveColumn - 1] = 'C';
		}
		else if(piece == 'D'){
			board[moveRow - 1][moveColumn] = 'D';
			board[moveRow][moveColumn + 1] = 'D';
			board[moveRow][moveColumn - 1] = 'D';
			board[moveRow][moveColumn] = 'D';
		}
		else if(piece == 'E'){
			board[moveRow][moveColumn + 1] = 'E';
			board[moveRow][moveColumn - 1] = 'E';
			board[moveRow + 1][moveColumn] = 'E';
			board[moveRow][moveColumn] = 'E';
		}
	}

	public boolean validMove(char piece, int moveRow, int moveColumn){
        boolean result = false;
        if(moveRow < 0 || moveRow >= board.length || moveColumn < 0 || moveColumn >= board.length){
				System.out.println("\n  Moves must be between 0 & 4.");
        }
        else if(piece == 'A' && moveColumn > 0 && moveColumn < board.length - 1){
            if(board[moveRow][moveColumn - 1] == ' ' && board[moveRow][moveColumn] == ' ' && board[moveRow][moveColumn + 1] == ' ')
                result = true;
        }
        else if(piece == 'B' && moveRow > 0 && moveRow < board.length - 1){
            if(board[moveRow - 1][moveColumn] == ' ' && board[moveRow][moveColumn] == ' ' && board[moveRow + 1][moveColumn] == ' ')
                result = true;
        }
        else if(piece == 'C' && moveRow < board.length - 1 && moveColumn > 0){
            if(board[moveRow][moveColumn - 1] == ' ' && board[moveRow][moveColumn] == ' ' && board[moveRow + 1][moveColumn] == ' ')
                result = true;
        }
        else if(piece == 'D' && moveRow > 0 && moveColumn > 0 && moveColumn < board.length - 1){
            if(board[moveRow - 1][moveColumn] == ' ' && board[moveRow][moveColumn - 1] == ' ' && board[moveRow][moveColumn] == ' ' && board[moveRow][moveColumn + 1] == ' ')
                result = true;
        }
        else if(piece == 'E' && moveRow < board.length - 1 && moveColumn > 0 && moveColumn < board.length - 1){
            if(board[moveRow + 1][moveColumn] == ' ' && board[moveRow][moveColumn - 1] == ' ' && board[moveRow][moveColumn] == ' ' && board[moveRow][moveColumn + 1] == ' ')
                result = true;
        }
        else{
                result = false;
        }
        return result;
    }

	public void printDashesRecursive(){
		printDashesRecursive(11);
	}
	public int printDashesRecursive(int column){
		if(column > 0){
		System.out.print("-");
		return printDashesRecursive(column-1);
		}
	return column;
	}

	public  int printRowRecursive(int moveRow, int moveColumn){
		if(moveColumn == 0){
		System.out.print(moveRow + " |" + board[moveRow][moveColumn]);
		return printRowRecursive(moveRow, moveColumn+1);
		}
		else if(moveColumn < 5 && moveColumn !=0){
		System.out.print("|" + board[moveRow][moveColumn]);
		return printRowRecursive(moveRow, moveColumn+1);
		}
		System.out.print("|");
		return moveColumn;
	}

	public boolean searchFullRowRecursive(int row){		//search rows and columns for empty spaces
		return searchFullRowRecursive(row, 0);
	}
	public boolean searchFullRowRecursive(int row, int column){
		if(column < 5){
			if(board[row][column] == ' '){
				return false;
			}
			else if(board[row][column] != ' '){
				return searchFullRowRecursive(row, column+1);
			}	
		}
		return true;
 	}   
	
	public boolean searchFullColumnRecursive(int column){
		return searchFullColumnRecursive(0, column);
	}
	public boolean searchFullColumnRecursive(int row, int column){
		if(row < 5){
				if(board[row][column] == ' '){
				return false;
			}
			else if(board[row][column] != ' '){
				return searchFullColumnRecursive(row+1, column);
			}	
		}
		return true;
	}
	
	public void resetRow(int row){		//fill full rows and columns with empty spaces
		for(int i = 0; i < 5; i++){
			board[row][i] = ' ';
		}
	}
	
	public void resetColumn(int column){
		for(int i = 0; i < 5; i++){
			board[i][column] = ' ';
		}
	}
	
	public int calculateScore(){		//if a row or column is full, player gets score of 10
		int score = 0;
		
		for(int i = 0; i < 5; i++){
			if(searchFullRowRecursive(i)){
			score += 10;
			resetRow(i);
			}

			if(searchFullColumnRecursive(i)){
			score += 10;
			resetColumn(i);
			}
		}
		return score;
	}
}

class Player{
	private String name;
	private int score;
	
	public Player(){		//default constructor
		name = new String();
		score = 0;
	}
	public Player(String name){		//initializing
		this.name = new String(name);
		score = 0;
	}
	public String getName(){		//get set methods
		return name;
	}
	public int getScore(){
		return score;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setScore(int score){
		this.score = score;
	}
	public String toString(){
		return name + "'s score is  " + score + "\n";
	}
	public void addToScore(int currentScore){
		score += currentScore;
	}
}
