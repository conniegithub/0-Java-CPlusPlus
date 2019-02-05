/*
Name: Connie Yong
Section: 6925
Group: 1
Partner: Oscar Alvarado

 Main Method:
	Declare variables (baord, row, column, piece, pieces)
	Create an instance of GameBoard
	Print out welcome message
	Print board method
	Give options to the user and receive user inputs
	
	While loop when it is not end of the game:
		Check valid move using validMove method
		Make move using makeMove method
		Print new board using printBoard method
		Receive new row and column user inputs
		Continue with the loop
	Print goodbye message
GameBoard class:
	Initialize GameBoard
	
	endOfGame method:
		Check valid moves (if valid, then not end of game)
	printBoard method:
		Using printDashesRecursive method to print dashes
		Using printRowRecursive method to print rows and values
	makeMove method:
		For each piece, place it in its corresponding positions
	validMove method:
		User's input has to be between 0-4
		Check the corresponding positions for each piece (if the corresponding positions are not available, then it is not a valid move)
	printDashesRecursive method:
		Using a helper method to set a value for column
		Base case: when column is less than or equal to zero
		Recursive case: when column is greater than zero
		Recursive step: continue to print dashes using the method for the next column
	printRowRecursive method:
		Base case: when moveColumn is greater than or equal to 5
		Recursive case: when moveColumn is less than 5
		Recursive step: continue to print the row values for the next column
searchFullRowRecursive:
	Base case: if the position is not filled, then return false
	Recursive case: if the postione is not filled in the columns 0-4 (one entire row)
	Recursive step: when position is not filled, continue to search until reaching the end of the row

*/

class P5{
        public static void main(String args[]){
	
        char board[][];
        int row, column, piece = (int) (Math.random() * 5);	//randomly generates a piece
        char pieces[] = new char[] {'A', 'B', 'C', 'D', 'E'};

        System.out.print("Name: Connie Yong" + "\nSection: 6925" + "\nGroup: 1" + "\nPartner: Oscar Alvarado");

        GameBoard gameBoard = new GameBoard(5);	//create an instance
        System.out.print("\n\nWelcome to Tetris!");
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
          gameBoard.printBoard();		//prints new board
      }
      else if(gameBoard.validMove(pieces[piece], row, column) == false){
          System.out.print("  Invalid move!");	//deals with invalid moves
          gameBoard.printBoard();		//prints new board
      }
	        piece = (int) (Math.random() * 5);	//select new pieces
            System.out.print("\nWhere would you like to place the piece:  " + pieces[piece]);
			System.out.print("\n\nChoose the row (0 - 4)  ");
	        row = UserInput.readInt();
	        System.out.print("\nChoose the column (0 - 4)  ");
	        column = UserInput.readInt();
	        System.out.println();
    }
      System.out.println();
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

	public void searchFullRowRecursive(int row){
		searchFullRowRecursive(row, 0);
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

}