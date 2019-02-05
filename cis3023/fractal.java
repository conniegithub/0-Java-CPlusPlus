class fractal extends Turtle{
	//theString variable
	private String str;
	//strLength variable
	private double len;
	//constructor
	public fractal(){
		str = "S";
		len = 600;
	}
	public fractal(String str, double len){
		this.str = str;
		this.len = len;
	}
	//get set methods
	public String getStr(){
		return str;
	}
	public void putStr(String str){
		this.str = str;
	}
	public double getLength(){
		return len;
	}
	public void putLength(double len){
		this.len = len;
	}

	//calcStr method
    public String calcStr(String rep, int times){
	    return calcStr(rep, rep, times);
	}
	//helper method
    private String calcStr(String oldStr, String newStr, int times){
	    if(times > 1){
            newStr = newStr.concat("-" + oldStr + "+" + oldStr + "+" + oldStr + "-" + oldStr);
			newStr = calcStr(newStr, newStr, times-1);
		}

        return newStr;
	}

	//math function is used to facilitate calculation of the length
	public double calcLength(int times){
		this.len = (600/(Math.pow(3,times)));
		return len;
	}
	
	//drawFractal method
	public void drawFractal(){
		drawFractal(0);
	}
	//helper method
	private void drawFractal(int count){//the count keeps track of how many times recursion will occur
	    if(count < str.length()){
		    this.tailDown();
		    if(str.charAt(count) == 'S')
			   this.move(len);
			else if(str.charAt(count) == '-')
			   this.turnLeft(90.0);
			else if(str.charAt(count) == '+')
			   this.turnRight(90.0);
			this.tailUp();
		    drawFractal(count+1);
		}
	 }
}