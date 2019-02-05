class queen{

    private int moves = 0, size;
	private int xStar[][], yStar[][], numMoves[], xQ[], yQ[], noPos[][]; 
	
	//constructor
	public queen(){
		size = 0;
	}
	public queen(int size){
		this.size = size;
	}
	
	//get set methods
	public int getSize(){
		return size;
	}
	public void setSize(int size){
		this.size = size;
	}
	
	
	//method game
	public void game(int size){
		//initialize arrays needed to track changes on the board
        xStar = new int[size][size*size];
        yStar = new int[size][size*size];
        
        numMoves = new int[size];
        xQ = new int[size];
        yQ = new int[size];
		//convert size to the corresponding size of the entire board including borders
		size = size*2+1;
		//initialize the board
		char board[][] = new char[size][size];
        noPos = new int[size][size] ;
		setBoard(board, 0, 0, size);	
		searchBoard(board, 1, size);
     
		System.out.println("\nSuperQueen:");
		remove(board, 0, 0, size);
		board[0][0] = '+';
		printBoard(board, size, 0);	
	}
	
	//set up the board
	private void setBoard(char[][] board, int row, int col, int size){
		if(row<size){
			if(row%2==0){
				setOddRow(board, row, 0, size);
			}
			else if(row%2!=0){
				setEvenRow(board, row, 0, size);
			}
			setBoard(board, row + 1, col, size);
		}
	}
	//set up the odd rows in the board
	private void setOddRow(char[][] board, int row, int col, int size){
		if(col<size){
			if(col%2==0){
				board[row][col] = '+';
			}
			else if(col%2!=0){
				board[row][col] = '-';
			}
			setOddRow(board, row, col + 1, size);
		}
	}
	//set up the even rows in the board
	private void setEvenRow(char[][] board, int row, int col, int size){
		if(col<size){
			if(col%2==0){
				board[row][col] = '|';
			}
			else if(col%2!=0){
				board[row][col] = ' ';
                noPos[row][col] = 0;
			}
			setEvenRow(board, row, col + 1, size);
		}
	}
	
	//print board
	private void printBoard(char[][] board, int size, int row){
		if(row<size){
			printRow(row, 0, size, board);
			System.out.println();
			printBoard(board, size, row + 1);
		}
    }
	//print rows
	private void printRow(int row, int col, int size, char[][] board){
		if(col<size){
			System.out.print(board[row][col]);
		printRow(row, col + 1, size, board);
		}
	}
	
	//search board
	private void searchBoard(char[][] board, int row, int size){
		if(row<size){
			if(searchRow(board, row, 1, size, 0)==0){
				BackTrack(board, 0,0,size);
                row = yQ[moves];//move back to last position
                removeFlag(row);
                searchBoard(board, row, size);
			}
			else{
                searchBoard(board, row+2, size);
            }
		}
	}
	//search rows for empty position and fill it with Queen
	private int searchRow(char[][] board, int row, int col, int size, int count){
		if(col<size){
			if((board[row][col]==' ') && (noPos[row][col] != 1)){
				board[row][col] = 'Q';
                xQ[moves] = col;//keep track of current position where Q is placed
                yQ[moves] = row;
				count = 1;
				killerMoves(board, row, col, size);
                moves++;// keep track of how many moves have occurred
			}
			else{
				count += searchRow(board, row, col + 2, size, count);
			}
		}
		return count;
	}
	
	//queen's killer positions: fill them with *
	private void killerMoves(char[][] board, int row, int col, int size){
        numMoves[moves]  = 0;
		Horizontal(board, row, 0, size);
		Vertical(board, 0, col, size);
		
		DiagonalLeftUp(board, row, col, size);
		DiagonalRightUp(board, row, col, size);
		DiagonalLeftDown(board, row, col, size);
		DiagonalRightDown(board, row, col, size);
		
		Knight(board, row-4, col-4, size, 0);
	}
	//fill horizontal rows
	private void Horizontal(char[][] board, int row, int col, int size){
		if(col<size){
			if(board[row][col] == ' '){
				board[row][col] = '*';
					yStar[moves][numMoves[moves]] = row; //keep track all moves of placing a * along  a row or col
					xStar[moves][numMoves[moves]] = col; 
					numMoves[moves]++;
			}
		Horizontal(board, row, col + 1, size);
		}
	}
	//fill vertical columns
	private void Vertical(char[][] board, int row, int col, int size){
		if(row<size){
			if(board[row][col] == ' '){
				board[row][col] = '*';
					yStar[moves][numMoves[moves]] = row; 
					xStar[moves][numMoves[moves]] = col; 
					numMoves[moves]++;
			}
		Vertical(board, row + 1, col, size);
		}
	}
	//fill diagonals
	private void DiagonalLeftUp(char[][] board, int row, int col, int size){
		if(row>0 && col>0){
			if(board[row][col] == ' '){
				board[row][col] = '*';
					yStar[moves][numMoves[moves]] = row; 
					xStar[moves][numMoves[moves]] = col; 
					numMoves[moves]++;
			}
		DiagonalLeftUp(board, row - 2, col - 2, size);
		}
	}
	private void DiagonalLeftDown(char[][] board, int row, int col, int size){
		if(row<size && col>0){
			if(board[row][col] == ' '){
				board[row][col] = '*';
					yStar[moves][numMoves[moves]] = row; 
					xStar[moves][numMoves[moves]] = col; 
					numMoves[moves]++;
			}
		DiagonalLeftDown(board, row + 2, col - 2, size);
		}
	}
	private void DiagonalRightUp(char[][] board, int row, int col, int size){
		if(row>0 && col<size){
			if(board[row][col] == ' '){
				board[row][col] = '*';
					yStar[moves][numMoves[moves]] = row; 
					xStar[moves][numMoves[moves]] = col; 
					numMoves[moves]++;
			}
		DiagonalRightUp(board, row - 2, col + 2, size);
		}
	}
	private void DiagonalRightDown(char[][] board, int row, int col, int size){
		if(row<size && col<size){
			if(board[row][col] == ' '){
				board[row][col] = '*';
					yStar[moves][numMoves[moves]] = row; 
					xStar[moves][numMoves[moves]] = col; 
					numMoves[moves]++;
			}
		DiagonalRightDown(board, row + 2, col + 2, size);
		}
	}
	//fill Knight positions
	private void KnightRow(char[][] board, int row, int col, int size, int count){
		if(col<size){
			if(count < 5){
				if((row)>0 && (col)>0 && board[row][col] == ' '){
					board[row][col] = '*';
						yStar[moves][numMoves[moves]] = row; 
						xStar[moves][numMoves[moves]] = col; 
						numMoves[moves]++;
				}
			KnightRow(board, row, col + 2, size, count + 1);
			}
		}
	}
	private void Knight(char[][] board, int row, int col, int size, int count){
		if(row<size){
			if(count < 5){
				KnightRow(board, row, col, size, 0);
				Knight(board, row + 2, col, size, count + 1);
			}
		}
	}
	
	//backtracking
    private void BackTrack(char[][] board, int row, int col, int size){
        if((moves <= (size-1)/2) && moves > 0){
            moves--;
            removeChar(board, yQ[moves], xQ[moves], 'Q');
            noPos[yQ[moves]][xQ[moves]] = 1;  //set to 1 to indicate that this position is no good
            removeChar(board, yStar[moves][numMoves[moves]],xStar[moves][numMoves[moves]],'*');
            
			if(searchRow(board, yQ[moves],1,size,0) == 0){
                BackTrack(board, 0,0,size);  
			}
        } 
    }
    //clear all noPos flags
    private void removeFlag(int row){
		if(row<noPos.length){
            removeFlagRow(row,0);
            removeFlag(row+1);
		}
	}
	private void removeFlagRow(int row, int col){
		if(col<noPos[row].length){
            noPos[row][col] = 0;
			removeFlagRow(row, col + 1);
		}
	}
	//remove character at the postion
	private void removeChar(char[][] board, int row, int col, char type){
        board[row][col] = ' ';
        if(type == '*'){
			if(numMoves[moves]-- > 0){
				removeChar(board, yStar[moves][numMoves[moves]], xStar[moves][numMoves[moves]], '*');
			}        
        }
	}
	//remove all * from board
	private void remove(char[][] board, int row, int col, int size){
		if(row<size){
			removeRow(row, 0, size, board);
			remove(board, row + 1, col, size);
		}
	}
	private void removeRow(int row, int col, int size, char[][] board){
		if(col<size){
			if(board[row][col] == '*'){
				board[row][col] = ' ';
			}
		removeRow(row, col + 1, size, board);
		}
	}
}