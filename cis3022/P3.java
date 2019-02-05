/*
    Name: Connie Yong
    Section: 6925
    Group: 1
    Partner: Oscar Alvarado

In this project, I will create a simple Tetris game using arrays and letters.  There are 5 rows and 5 columns, however, since I regard each number or symbol as a 'space', thus there are more than just 5 rows and columns.  I will use the while loop to display the board over and over again.  For loops are used to display the board.  After the user inputs, if statements are used to differentiate -1 from 0 - 4.
First I declared the class name and main method.  Then I declared my variables, which are board, row, and column.  My name, section, group number, and my partner's name are printed using a print statement.  Then my program welcomes the player with a welcome print statement.  Then I start my while loop, which will display the board over and over again.  The "-", "|", and the numbers are printed in the for loops.  After displaying the board, the program asks the player to place the "AAA" piece.  The program then receives the user inputs (row and column number) and the program determines what to do next with the if statements.  If user inputs are within the range of values of rows and columns, then the piece would be placed in the corresponding spots on the board.  If the user enters -1 for either row or column number, then the program will display a goodbye message and exits.
*/

class P3{
        public static void main(String args[]){
	
        char board[][];
        board = new char[10][10];
	
        int row = 0;
        int column = 0;
	
        System.out.print("Name: Connie Yong" + "\nSection: 6925" + "\nGroup: 1" + "\nPartner: Oscar Alvarado");
        System.out.println("\n\nWelcome to Tetris!");
        System.out.println();

        while(row != -1 && column != -1){
		int i;
		int j;
			
		for(i = 0; i < 5; i++){			//this is for displaying the board
                                                        System.out.print("  ");
			for(j = 0; j < 11; j++){		//displaying each column of '-'
                                                                          System.out.print("-");
                                                        }
                                                        System.out.println();
			System.out.print(i + " ");
			for(j = 0; j < 5; j++){		//displaying each column of '|'
				System.out.print("|"+ board[i][j]);
			}
			System.out.print("|");
			System.out.println();
	                   }
                                                        System.out.print("  ");
                                      for(j = 0; j < 11; j++){		//last row of '-'
                                                        System.out.print("-");
                                      }
                                      System.out.println();
                                      System.out.print("   ");
                                      for(j = 0; j < 5; j++){			//last row of numbers
                                                        System.out.print(j + " ");
                                      }
                    System.out.println();
                    System.out.print("\n Where would you like to place the piece: AAA");
                    System.out.print("\n\n Choose the row (0 - 4): ");
	      row = UserInput.readInt();
                    System.out.print(" Choose the column (0 - 4): ");
	      column = UserInput.readInt();
			
                    if(row != -1 && column != -1){

                         for(int k = 0; k < 3; k++){
	          board[row][column] = 'A';
	          column++;
                         }
                    }
                    else if(row == -1 || column == -1){		//the case of -1 for row or column
                         System.out.println("\n Thanks for playing Tetris!");
                    }
      }
  }
}