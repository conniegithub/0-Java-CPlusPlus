class Draw{
	//this is the test class
	public static void main(String [ ] args){
	// Initialization
	Island yong = new Island(600,600);
	GeoTurtle tim = new GeoTurtle();
	yong.putTurtleAtCenter(tim);

	//choose a random method and test zero length value
	tim.triangle(0);
	//choose another method to test extremely large values
	tim.square(600);
	//test negative values for rectangle with comparison to positive
	tim.rectangle(10, 20);
	tim.rectangle(-10, 20);//width negative
	tim.rectangle(10, -20);//height negative
	tim.rectangle(-10, -20);//both negative
	//test negative values for pentagon with comparison to positive
	tim.pentagon(30);
	tim.pentagon(-30);
	//test negative values for hexagon with comparison to positive
	tim.hexagon(40);
	tim.hexagon(-40);
	//test negative values for octagon with comparison to positive
	tim.octagon(50);
	tim.octagon(-50);
	//test negative values for square with comparison to positive
	tim.square(60);
	tim.square(-60);
	//test negative values for triangle with comparison to positive
	tim.triangle(70);
	tim.triangle(-70);
	
	}
}//end of test class