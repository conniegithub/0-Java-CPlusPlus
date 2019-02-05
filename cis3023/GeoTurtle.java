class GeoTurtle extends Turtle{

	public void drawSide(double length, double angle){
		//first put the tail down
		this.tailDown();
		//draw a side
		this.move(length);
		//turn to direction
		this.turnLeft(angle);
		//face in starting direction and pickup tail
		this.tailUp();
	}

	public void triangle(double length){
		//draw triangle
		drawSide(length/2, 120.0);
		drawSide(length, 120.0);
		drawSide(length, 120.0);
		drawSide(length/2, 0);
	}
	public void rectangle(double width, double height){
		//draw rectangle
		drawSide(width, 90.0);
		drawSide(height, 90.0);
		drawSide(width, 90.0);
		drawSide(height, 90.0);
	} //end rectangle
	public void pentagon(double length){
		//draw pentagon
		drawSide(length, 72.0);
		drawSide(length, 72.0);
		drawSide(length, 72.0);
		drawSide(length, 72.0);
		drawSide(length, 72.0);
	} //end pentagon
	public void hexagon(double length){
		//draw hexagon
		drawSide(length, 60.0);
		drawSide(length, 60.0);
		drawSide(length, 60.0);
		drawSide(length, 60.0);
		drawSide(length, 60.0);
		drawSide(length, 60.0);
	}// end hexagon
	public void octagon(double length){
		//draw octagon
		drawSide(length, 45.0);
		drawSide(length, 45.0);
		drawSide(length, 45.0);
		drawSide(length, 45.0);
		drawSide(length, 45.0);
		drawSide(length, 45.0);
		drawSide(length, 45.0);
		drawSide(length, 45.0);
	} //end octagon
	public void square(double length){
		// draw square
		drawSide(length, 90.0);
		drawSide(length, 90.0);
		drawSide(length, 90.0);
		drawSide(length, 90.0);
	} // end square
} // end class GeoTurtle