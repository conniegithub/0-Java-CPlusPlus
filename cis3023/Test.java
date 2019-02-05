class Test{
	public static void main(String args[]){
	
		queen test = new queen();
		
		//case 1: smallest board with a solution
		test.game(10);
		//case 2: smaller board sizes
		test.game(9);
		//case 3: negative board size
		test.game(-1);
		//case 4: no board size
		test.game(0);
		//case 5: decimal size
		test.game(1.0);
		//case 6: large sizes
		test.game(200);
		//case 7: medium size
		test.game(14);
		//case 8:  odd size
		test.game(11);
		//case 9: even size
		test.game(12);
		//test 10: smallest positive size
		test.game(1);
	}
}