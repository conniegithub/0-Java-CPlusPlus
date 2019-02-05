/*
    Name: Connie Yong
    Section: 6925
    Group: 1
    Partner: Oscar Alvarado

First I declared the class name and main method.  Then I declared my variables. Then my program welcomes the player with a welcome print statement.  Then I start my while loop, which will display the board over and over again.  After displaying the board, the program asks the player to place the randomly selected piece.  The program then receives the user inputs (row and column number) and the program determines what to do next with the if statements.  If user inputs are within the range of values of rows and columns, then the piece would be placed in the corresponding spots on the board.  If the user enters numbers outside the range for either row or column number, then the program will display an invalid move message and then continue with the game.  When all the possible moves are out, then a goodbye message will be displayed.
*/

class P4{
        public static void main(String args[]){
	
        char board[][];
        int row, column, piece = (int) (Math.random() * 4);	//randomly generates a piece
        char pieces[] = new char[] {'A', 'B', 'C', 'D', 'E'};

        System.out.print("Name: Connie Yong" + "\nSection: 6925" + "\nGroup: 1" + "\nPartner: Oscar Alvarado");

        GameBoard.init(5);		//this initializes the board
        System.out.print("\n\nWelcome to Tetris!");
        GameBoard.printBoard();		//prints the board
        System.out.print("\nWhere would you like to place the piece:  " + pieces[piece]);


    while(!GameBoard.endOfGame(pieces[piece])){

        System.out.print("\n\nChoose the row (0 - 4)  ");
        row = UserInput.readInt();
        System.out.print("\nChoose the column (0 - 4)  ");
        column = UserInput.readInt();
        System.out.println();
    
      if(GameBoard.validMove(pieces[piece], row, column)){	//checks for valid moves
          GameBoard.makeMove(pieces[piece], row, column);
          GameBoard.printBoard();		//prints new board
          piece = (int) (Math.random() * 4);	//select new pieces
          System.out.print("\nWhere would you like to place the piece:  " + pieces[piece]);

      }
      else{
          System.out.print("  Invalid move!");	//deals with invalid moves
          GameBoard.printBoard();		//prints new board
      }
    }
      System.out.println();
      System.out.print("\n  No more moves available!" + "\n\n  Thanks for playing Tetris!");
   }
}


/*
public static boolean validMove(char piece, int moveRow, int moveColumn){
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

*/