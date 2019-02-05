class DrawCastle{
	public static void main(String [ ] args){
	// initialization
	Island yong = new Island(600,600);
	GeoTurtle tim = new GeoTurtle();
	//turtle is placed at the center of the island
	yong.putTurtleAtCenter(tim);
	
	//draw a tower
	tim.rectangle(30.0, 100.0);
	
	//move to top of the tower
	tim.turnLeft(90.0);
	tim.move(100.0);
	tim.turnLeft(270.0);
	tim.move(15.0);
	//draw triangle
	tim.triangle(40.0);
	
	//move to about the center of the tower
	tim.turnLeft(270.0);
	tim.move(55.0);
	tim.turnLeft(270.0);
	tim.move(5.0);
	tim.turnLeft(180.0);
	//draw square
	tim.square(10.0);
	//move up
	tim.turnLeft(90.0);
	tim.move(30.0);
	tim.turnLeft(270.0);
	tim.move(1.0);
	//draw pentagon
	tim.pentagon(8.0);
	
	//put tim back to starting point
	yong.putTurtleAtCenter(tim);
	//move to the other end of the base of the tower
	tim.move(30.0);
	//draw the body of castle
	tim.rectangle(160.0, 70.0);
	
	tim.move(60.0);
	//draw the door
	tim.rectangle(40.0, 35.0);
	
	//move to the other end of the base of the body
	tim.move(100.0);
	//draw second tower
	tim.rectangle(30.0, 100.0);
	
	//go to the top of the body
	tim.turnLeft(90.0);
	tim.move(70.0);
	tim.turnLeft(90.0);
	tim.move(150.0);
	tim.turnLeft(180.0);
	//draw blocks
	tim.rectangle(20.0, 10.0);
	tim.move(30.0);
	tim.rectangle(20.0, 10.0);
	tim.move(30.0);
	tim.rectangle(20.0, 10.0);
	tim.move(30.0);
	tim.rectangle(20.0, 10.0);
	tim.move(30.0);
	tim.rectangle(20.0, 10.0);
	tim.move(30.0);
	
	//move turtle to the top of the tower
	tim.turnLeft(90.0);
	tim.move(30.0);
	tim.turnLeft(270.0);
	tim.move(15.0);
	//draw triangle
	tim.triangle(40.0);

	//move to about the center of the tower
	tim.turnLeft(270.0);
	tim.move(55.0);
	tim.turnLeft(270.0);
	tim.move(5.0);
	tim.turnLeft(180.0);
	//draw square
	tim.square(10.0);
	//move up
	tim.turnLeft(90.0);
	tim.move(30.0);
	tim.turnLeft(270.0);
	tim.move(1.0);
	//draw pentagon
	tim.pentagon(8.0);

	} // end main()
} // end class Castle