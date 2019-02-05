class PsarTime{
    private int Sparens, Cies, Cromas, Asurs;
	//constructor methods
	public PsarTime(){
	   Sparens = Cies = Cromas = Asurs = 0;	
	}
	public PsarTime(int Sparens,int Cies,int Cromas,int Asurs){
	   this.Sparens = Sparens; 
	   this.Cies = Cies;
	   this.Cromas = Cromas;
	   this.Asurs = Asurs;	
	}
	//get methods
    public int getSparens(){
	   return Sparens;
	}
	public int getCies(){
	   return Cies;
	}
	public int getCromas(){
	   return Cromas;
	}
	public int getAsurs(){
	   return Asurs;
	}
	//set methods
	public void setSparens(int Sparens){
	   this.Sparens = Sparens;
	}
	public void setCies(int Cies){
	   this.Cies = Cies;
	}
	public void setCromas(int Cromas){
	   this.Cromas = Cromas;
	}
	public void setAsurs(int Asurs){
	   this.Asurs = Asurs;
	}
	
	
	//convert method converts et to PsarTime; calls the getTime and mktime methods
	public void convert(EarthTime et){
       setSparens(getTime("Sparens", mktime(et)));
	   setCies(getTime("Cies", mktime(et)));
	   setCromas(getTime("Cromas", mktime(et)));
	   setAsurs(getTime("Asurs", mktime(et)));	   
	}
	//addPsarTime method adds the PsarTime object with pt and returns PsarTime object
    public PsarTime addPsarTime(PsarTime pt){
	   int time;
	   
	   time = mktime(pt) + mktime(this);
	   
	   return new PsarTime(getTime("Sparens",time),getTime("Cies",time),getTime("Cromas",time),getTime("Asurs",time));
	}
	//addEarthTime method adds the PsarTime object with et and returns PsarTime object
    public PsarTime addEarthTime(EarthTime et){
	   int time;
	   
	   time = mktime(et) + mktime(this);
	   
	   return new PsarTime(getTime("Sparens",time),getTime("Cies",time),getTime("Cromas",time),getTime("Asurs",time));   
	}
	//subPsarTime method subtracts pt from PsarTime object and returns PsarTime object
    public PsarTime subPsarTime(PsarTime pt){
	   int time;
	   
	   time = mktime(this) - mktime(pt);
	   
	   return new PsarTime(getTime("Sparens",time),getTime("Cies",time),getTime("Cromas",time),getTime("Asurs",time));
	}
	//subEarthTime method subtracts et from PsarTime object and retursn PsarTime object
    public PsarTime subEarthTime(EarthTime et){
	   int time;
	   
	   time = mktime(this) - mktime(et);
	   
	   return new PsarTime(getTime("Sparens",time),getTime("Cies",time),getTime("Cromas",time),getTime("Asurs",time));
	}
	//toString method returns String representation of PsarTime
    public String toString(){
	   return Asurs + "A:" + Cromas + "C:" + Cies + "c:" + Sparens + "S";
	}
	//equals method determines whether PsarTime object equals pt and returns a boolean value
    public boolean equals(PsarTime pt){
	   boolean result;
	   
	   result = pt.toString().equals(this.toString());
	   
	   return result;
	}
	
	
	//this mktime method creates a timestamp for each Earth time
	private int mktime(EarthTime et){
	   int timestamps = 0;
	   
	   timestamps = et.getYears() * (365*24*60) + et.getDays() * (24*60) + et.getHours() * 60 + et.getMins();
	   
	   return timestamps;
	}
	//this mktime method creates a timestamp for each Psar time
	private int mktime(PsarTime pt){
	   int timestamps = 0;
	   
	   timestamps = pt.getAsurs() * (1000*36*50) + pt.getCromas() * (36*50) + pt.getCies() * 50 + pt.getSparens();
	   
	   return timestamps;
	}
	//getTime method converts timestamps to time in different units
	private int getTime(String type, int timestamps){
	   int time = 0;
	   
	   if(type.equals("Years")){
          time = timestamps / (365*24*60);
       }else if(type.equals("Days")){
	      time = (timestamps % (365*24*60)) / (24*60);
	   }else if(type.equals("Hours")){
	      time = (timestamps % (365*24*60) % (24*60)) / 60;
	   }else if(type.equals("Mins")){
    	  time = (timestamps % (365*24*60) % (24*60) % 60);
       }else if(type.equals("Asurs")){
		  time = timestamps / (1000*36*50);
	   }else if(type.equals("Cromas")){
		  time = (timestamps % (1000*36*50)) / (36*50);
	   }else if(type.equals("Cies")){
		  time = (timestamps % (1000*36*50) % (36*50)) / 50;
	   }else if(type.equals("Sparens")){
		  time = (timestamps % (1000*36*50) % (36*50) % 50);
	   }		   
	   return time;
	}
}//end of PsarTime class



class EarthTime{
    private int Mins, Hours, Days, Years;
	//constructors
	public EarthTime(){
	   Mins = Hours = Days = Years = 0;	
	}
	public EarthTime(int Mins,int Hours,int Days,int Years){
	   this.Mins = Mins; 
	   this.Hours = Hours;
	   this.Days = Days;
	   this.Years = Years;	
	}
	//get methods
    public int getMins(){
	   return Mins;
	}
	public int getHours(){
	   return Hours;
	}
	public int getDays(){
	   return Days;
	}
	public int getYears(){
	   return Years;
	}
	//set methods
	public void setMins(int Mins){
	   this.Mins = Mins;
	}
	public void setHours(int Hours){
	   this.Hours = Hours;
	}
	public void setDays(int Days){
	   this.Days = Days;
	}
	public void setYears(int Years){
	   this.Years = Years;
	}
	
	
	//convert method converts pt to EarthTime; calls getTime and mktime methods
    public void convert(PsarTime pt){
	   setMins(getTime("Mins", mktime(pt)));
	   setHours(getTime("Hours", mktime(pt)));
	   setDays(getTime("Days", mktime(pt)));
	   setYears(getTime("Years", mktime(pt)));
	}
	//addPsarTime method adds EarthTime object with pt and returns EarthTime object
    public EarthTime addPsarTime(PsarTime pt){
	   int time;
	   
	   time = mktime(pt) + mktime(this);
	   
	   return new EarthTime(getTime("Mins",time),getTime("Hours",time),getTime("Days",time),getTime("Years",time));
	}
	//addEarthTime method adds EarthTime object with et and returns EarthTime object
    public EarthTime addEarthTime(EarthTime et){
	   int time;
	   
	   time = mktime(et) + mktime(this);
	   
	   return new EarthTime(getTime("Mins",time),getTime("Hours",time),getTime("Days",time),getTime("Years",time));
	}
	//subPsarTime method subtracts pt from EarthTime object and returns EarthTime object
    public EarthTime subPsarTime(PsarTime pt){
	   int time;
	   
	   time = mktime(this) - mktime(pt);
	   
	   return new EarthTime(getTime("Mins",time),getTime("Hours",time),getTime("Days",time),getTime("Years",time));
	}
	//subEarthTime method subtracts et from EarthTime object and returns EarthTime object
    public EarthTime subEarthTime(EarthTime et){
	   int time;
	   
	   time = mktime(this) - mktime(et);
	   
	   return new EarthTime(getTime("Mins",time),getTime("Hours",time),getTime("Days",time),getTime("Years",time));
	}
	//toString method returns String representation of EarthTime
    public String toString(){
	   return Years + "Y:" + Days + "D:" + Hours + "H:" + Mins + "M";
	}
	//equals method determines whether EarthTime object equals et and returns a boolean value
    public boolean equals(EarthTime et){
	   boolean result;
	   
	   result = et.toString().equals(this.toString());
	   
	   return result;
	}
	
	
	//this mktime method creates a timestamp for each Earth time
	private int mktime(EarthTime et){
	   int timestamps = 0;
	   
	   timestamps = et.getYears() * (365*24*60) + et.getDays() * (24*60) + et.getHours() * 60 + et.getMins();
	   
	   return timestamps;
	}
	//this mktime method creates a timestamp for each Psar time
	private int mktime(PsarTime pt){
	   int timestamps = 0;
	   
	   timestamps = pt.getAsurs() * (1000*36*50) + pt.getCromas() * (36*50) + pt.getCies() * 50 + pt.getSparens();
	   
	   return timestamps;
	}
	//getTime method converts timestamps to time in different units
	private int getTime(String type, int timestamps){
	   int time = 0;
	   
	   if(type.equals("Years")){
          time = timestamps / (365*24*60);
       }else if(type.equals("Days")){
	      time = (timestamps % (365*24*60)) / (24*60);
	   }else if(type.equals("Hours")){
	      time = (timestamps % (365*24*60) % (24*60)) / 60;
	   }else if(type.equals("Mins")){
    	  time = (timestamps % (365*24*60) % (24*60) % 60);
       }else if(type.equals("Asurs")){
		  time = timestamps / (1000*36*50);
	   }else if(type.equals("Cromas")){
		  time = (timestamps % (1000*36*50)) / (36*50);
	   }else if(type.equals("Cies")){
		  time = (timestamps % (1000*36*50) % (36*50)) / 50;
	   }else if(type.equals("Sparens")){
		  time = (timestamps % (1000*36*50) % (36*50) % 50);
	   }	
	   
	   
	   return time;
	}
}//end of EarthTime class



class TimeDemo{
   public static void main(String args[]){
   
	//defined values
      EarthTime erTime1 = new EarthTime(21,15,5,2);
	  EarthTime erTime2 = new EarthTime(45,8,2,3);
	  EarthTime erTime3 = new EarthTime();
	  PsarTime  psTime1 = new PsarTime(23,10,150,5);
	  PsarTime  psTime2 = new PsarTime(49,32,19,15);
	//printouts of defined values
	  System.out.println("erTime1 has been defined to be: " + erTime1.toString());
	  System.out.println("erTime2 has been defined to be: " + erTime2.toString());
	  System.out.println("erTime3 has been defined to be: " + erTime3.toString());
	  System.out.println("psTime1 has been defined to be: " + psTime1.toString());
	  System.out.println("psTime2 has been defined to be: " + psTime2.toString());
	//printouts of operations between numbers
	  System.out.println("erTime1 + erTime2 = " + erTime1.addEarthTime(erTime2).toString());
	  System.out.println("erTime2 + erTime3 = " + erTime2.addEarthTime(erTime3).toString());
	  System.out.println("erTime2 - erTime1 = " + erTime2.subEarthTime(erTime1).toString());
	  System.out.println("psTime2 + psTime1 = " + psTime2.addPsarTime(psTime1).toString());
	  System.out.println("psTime1 + psTime2 = " + psTime2.addPsarTime(psTime1).toString());
	  System.out.println("erTime1 + psTime1 = " + erTime1.addPsarTime(psTime1).toString());
	  System.out.println("erTime3 - psTime2 = " + erTime3.subPsarTime(psTime2).toString());
	  System.out.println("psTime2 + erTime1 = " + psTime2.addEarthTime(erTime1).toString());
	  System.out.println("psTime2 - erTime1 = " + psTime2.subEarthTime(erTime1).toString());
   }
}//end of TimeDemo class