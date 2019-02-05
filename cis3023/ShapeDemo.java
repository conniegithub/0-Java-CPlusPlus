class ShapeDemo{
	public static void main(String args[]){
		//create Island
		Island yong = new Island(1220,620);
		//create instance of fractal
		fractal frac1 = new fractal();
		
		//set new values
		frac1.putStr(frac1.calcStr("S", 0));
		frac1.putLength(frac1.calcLength(0));
		//put the turtle at the center than move it to the corner
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(0,300);
		//draw the fractal and then print out the string representation
		frac1.drawFractal();
		System.out.println("\nS, 0:  " + frac1.calcStr("S", 0));
		
		//set new values
		frac1.putStr(frac1.calcStr("S-S+S+S-S", 1));
		frac1.putLength(frac1.calcLength(1));
		//put the turtle at the center than move it to the corner
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(610,300);
		//draw the fractal and then print out the string representation
		frac1.drawFractal();
		System.out.println("\nS-S+S+S-S, 1:  " + frac1.calcStr("S-S+S+S-S", 1));
		
		//set new values
		frac1.putStr(frac1.calcStr("S-S+S+S-S", 2));
		frac1.putLength(frac1.calcLength(2));
		//put the turtle at the center than move it to the corner again
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(0,600);
		//draw the fractal and then print out the string representation
		frac1.drawFractal();
		System.out.println("\nS-S+S+S-S, 2:  " + frac1.calcStr("S-S+S+S-S", 2));
  		
		//set new values
		frac1.putStr(frac1.calcStr("S-S+S+S-S", 3));
		frac1.putLength(frac1.calcLength(3));
		//put the turtle at the center than move it to the corner again
		yong.putTurtleAtCenter(frac1);
		frac1.moveTo(610,600);
		//draw the fractal and then print out the string representation
		frac1.drawFractal();
		System.out.println("\nS-S+S+S-S, 3:  " + frac1.calcStr("S-S+S+S-S", 3));
              
	}


}