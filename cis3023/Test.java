class Test{
	public static void main(String args[]){
   
	//Data for test 1
	//Test 1:  large values outside of range
		PsarTime psTime0 = new PsarTime(2147483648,0,0,0);
	//Data for test 2
	//Test 2:  decimal values
		EarthTime etTime0 = new EarthTime(12.34,0,0,0);
	//Data for test 3
		PsarTime psTime1 = new PsarTime(2147483647,0,0,0);
		PsarTime psTime2 = new PsarTime(1,0,0,0);
	//Data for test 4
		EarthTime etTime1 = new EarthTime(-10,-10,-10,-10);
		EarthTime etTime2 = new EarthTime(-90,-90,-90,-90);
	//Data for test 5
		EarthTime etTime3 = new EarthTime(59,23,364,0);
		EarthTime etTime4 = new EarthTime(1,1,1,0);
	//Data for test 6
		PsarTime psTime3 = new PsarTime(50,0,0,0);
	//Data for test 7
		EarthTime etTime5 = new EarthTime(10,10,10,10);
		EarthTime etTime6 = new EarthTime(-25,-15,-5,0);
	//Data for test 8
		PsarTime psTime4 = new PsarTime(100,100,100,100);
		EarthTime etTime7 = new EarthTime();
	//Data for test 9
		PsarTime psTime5 = new PsarTime(80,65,292,0);
		EarthTime etTime8 = new EarthTime(210,28,366,0);
	//Data for test 10
		PsarTime psTime6 = new PsarTime(30,30,293,0);
		EarthTime etTime5cor = new EarthTime();
		EarthTime etTime6cor = new EarthTime();
		PsarTime psTime5cor = new PsarTime();
		PsarTime psTime6cor = new PsarTime();

	//Test 3:  adding large values within range
		System.out.println("psTime1: 0A:0C:0c:2147483647S" + "\npsTime2: 0A:0C:0c:1S");
		System.out.println("psTime1 + psTime2 = " + psTime1.addPsarTime(psTime2).toString());
	
	//Test 4:  adding negative values
		System.out.println("\netTime1: -10Y:-10D:-10H:-10M" + "\netTime2: -90Y:-90D:-90H:-90M");
		System.out.println("etTime1 + etTime2 = " + etTime1.addEarthTime(etTime2).toString());
		
	//Test 5:  adding border values
		System.out.println("\netTime3: 0Y:364D:23H:59M" + "\netTime2: 0Y:1D:1H:1M");
		System.out.println("etTime3 + etTime4 = " + etTime3.addEarthTime(etTime4).toString());
		
	//Test 6:  printing border values
		System.out.println("\npsTime3 = " + psTime3);
		
	//Test 7: subtracting a negative value from a positive
		System.out.println("\netTime: 10Y:10D:10H:10M" + "/netTime2: 0Y:-5D:-15H:-25M");
		System.out.println("etTime5 - etTime6 = " + etTime5.subEarthTime(etTime6).toString());
		
	//Test 8: converting values with improper form of inputs
		System.out.println("\npsTime4: 100A:100C:100c:100S");
		etTime7.convert(psTime4);
		System.out.println("psTime4 = " + etTime7);
		
	//Test 9: compare equivalent times in different units with improper form of inputs
		System.out.println("\npsTime5: 0A:292C:65c:80S" + "\netTime8: 0Y:366D:28H:210M");
		System.out.println("psTime5 = etTime8 :" + etTime8.equals(psTime5));
		
	//Test 10: campare equivalent times in the same unit with improper form of inputs
		System.out.println("\npsTime5: 0A:292C:65c:80S" + "\npsTime6: 0A:293C:30c:20S");
		System.out.println("psTime5 = psTime6 :" + psTime5.equals(psTime6));
		//correct implementation of case 10 (campare value in EarthTime or PsarTime)
		System.out.println("\npsTime5: 0A:292C:65c:80S" + "\npsTime6: 0A:293C:30c:20S");
		etTime5cor.convert(psTime5);
		psTime5cor.convert(etTime5cor);
		etTime6cor.convert(psTime6);
		psTime6cor.convert(etTime6cor);
		System.out.println("psTime5 = psTime6 :" + psTime5cor.equals(psTime6cor));
   }
}//end of Testclass

class Test{
	public static void main(String args[]){
		//create Island
		Island yong = new Island(1200,620);
		//create instance of fractal
		fractal frac1 = new fractal();
		
		
		//Test case 1: working values
		//set new values
		frac1.putStr(frac1.calcStr("S-S+S+S-S", 1));
		frac1.putLength(frac1.calcLength(1));
		//put the turtle at the center than move it to the corner
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(0,600);
		//draw the fractal and then print out the string representation
		frac1.drawFractal();
		System.out.println("\nS-S+S+S-S, 1:  " + frac1.calcStr("S-S+S+S-S", 1));

        //Test case 2: small values
		frac1.putStr(frac1.calcStr("S-S+S+S-S", 6));
		frac1.putLength(frac1.calcLength(6));
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(0,600);
		frac1.drawFractal();
		System.out.println("\nS-S+S+S-S, 6:  " + frac1.calcStr("S-S+S+S-S", 6));
		
		//Test case 3: negative values
		frac1.putStr(frac1.calcStr("S-S+S+S-S", -1));
		frac1.putLength(frac1.calcLength(-1));
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(0,600);
		frac1.drawFractal();
		System.out.println("\nS-S+S+S-S, -1:  " + frac1.calcStr("S-S+S+S-S", -1));
		
		//Test case 4: zero value
		frac1.putStr(frac1.calcStr("S-S+S+S-S", 0));
		frac1.putLength(frac1.calcLength(0));
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(0,600);
		frac1.drawFractal();
		System.out.println("\nS-S+S+S-S, 0:  " + frac1.calcStr("S-S+S+S-S", 0));
		
		//Test case 5: large values
		frac1.putStr(frac1.calcStr("S-S+S+S-S", 1000000));
		frac1.putLength(frac1.calcLength(1000000));
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(0,600);
		frac1.drawFractal();
		System.out.println("\nS-S+S+S-S, 1000000:  " + frac1.calcStr("S-S+S+S-S", 1000000));
		
		//Test case 6:  short string
		frac1.putStr(frac1.calcStr("S-S", 1));
		frac1.putLength(frac1.calcLength(1));
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(0,600);
		frac1.drawFractal();
		System.out.println("\nS-S, 1:  " + frac1.calcStr("S-S", 1));
		
		//Test case 7:  long string
		frac1.putStr(frac1.calcStr("S-S+S-S+S-S+S-S+S-S+S-S+S-S+S-S+S-S", 1));
		frac1.putLength(frac1.calcLength(1000000));
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(0,600);
		frac1.drawFractal();
		System.out.println("\nS-S+S-S+S-S+S-S+S-S+S-S+S-S+S-S+S-S, 1:  " + frac1.calcStr("S-S+S-S+S-S+S-S+S-S+S-S+S-S+S-S+S-S", 1));
		
		//Test case 8: empty string
		frac1.putStr(frac1.calcStr(" ", 1));
		frac1.putLength(frac1.calcLength(1));
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(0,600);
		frac1.drawFractal();
		System.out.println("\n , 1:  " + frac1.calcStr(" ", 1));
		
		//Test case 9: out of range values
		frac1.putStr(frac1.calcStr("S-S+S+S-S", 2147483648));
		frac1.putLength(frac1.calcLength(2147483648));
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(0,600);
		frac1.drawFractal();
		System.out.println("\nS-S+S+S-S, 2147483648:  " + frac1.calcStr("S-S+S+S-S", 2147483648));
		
		//Test case 10: decimal values
		frac1.putStr(frac1.calcStr("S-S+S+S-S", 1.1));
		frac1.putLength(frac1.calcLength(1.1));
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(0,600);
		frac1.drawFractal();
		System.out.println("\nS-S+S+S-S, 1.1:  " + frac1.calcStr("S-S+S+S-S", 1.1));
		
		
	}


}

class Test{
	public static void main(String args[]){
	//create instances
		Convert case1 = new Convert((float)1.33);
		Convert case2 = new Convert((float)2.2);
		Convert case3 = new Convert((float) (-1.1));
		Convert case4 = new Convert((float)0.0);
		Convert case5 = new Convert((float)100000000000000000000000.5);

		Convert case6 = new Convert("000000000000000000000000000000011");
		Convert case7 = new Convert("10000000000000000000000000000001");
		Convert case8 = new Convert("00000000000000000000000000000000");
		Convert case9 = new Convert("01111111111111111111111111111111");
		Convert case10 = new Convert(" ");
		
	//print out statements
		System.out.print("\nCase 1: "+case1.getDecimal()+" == " +case1.getBinary()+" base 2\n");
		System.out.print("\nCase 2: "+case2.getDecimal()+" == " +case2.getBinary()+" base 2\n");
		System.out.print("\nCase 3: "+case3.getDecimal()+" == " +case3.getBinary()+" base 2\n");
		System.out.print("\nCase 4: "+case4.getDecimal()+" == " +case4.getBinary()+" base 2\n");
		System.out.print("\nCase 5: "+case5.getDecimal()+" == " +case5.getBinary()+" base 2\n");

		System.out.print("\nCase 6: "+case6.getBinary()+" == " +case6.getDecimal()+" base 10\n");
		System.out.print("\nCase 7: "+case7.getBinary()+" == " +case7.getDecimal()+" base 10\n");
		System.out.print("\nCase 8: "+case8.getBinary()+" == " +case8.getDecimal()+" base 10\n");
		System.out.print("\nCase 9: "+case9.getBinary()+" == " +case9.getDecimal()+" base 10\n");
		System.out.print("\nCase 10: "+case10.getBinary()+" == " +case10.getDecimal()+" base 10\n");
	}
}

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

