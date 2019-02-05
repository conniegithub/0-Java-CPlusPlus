class Convert{
    private float decimal;
    private String binary;
    //constructor
    public Convert(){
        decimal = 0;
        binary = "0000000000000000000000000000";    
    }
    public Convert(float decimal){
        this.decimal = decimal;
        binary = decimal2binary(decimal);    //access decimal2binary method directly
    }
    public Convert(String binary){
        this.binary = binary;
        decimal = binary2decimal(binary);    //access binary2decimal method directly
    }
    //get and set methods
    public float getDecimal(){
        return decimal;
    }
    public String getBinary(){
        return binary;
    }
    public void setDecimal(){
        this.decimal = decimal;
    }
    public void setBinary(){
        this.binary = binary;
    }
    
    //method of converting binary to decimal representation
    public float binary2decimal(String binary){
        float decimal = 0;
        int exp = 0, integer = 0, bit = 0, counter = 8;
        byte temp[] = new byte[32];
        
        //turn string into an array, which is easier to work with
        temp = binary.getBytes();

        //convert exponent
        exp = bin2exp(counter, temp, bit, exp);
        //convert decimal part in mantissa
        decimal = bin2dec(0, temp, exp);
            //make sure decimal does not have an integer part
            if(decimal >= 1){
                decimal = decimal - (int) decimal;
            }
        //convert integer part in mantissa
        integer = bin2int(exp, integer, 0, temp);
        
        //add decimal and integer
        decimal = decimal + (float) integer;
        //determine the sign
        if(temp[0] == '1'){
            decimal = 0 - decimal;
        }
		
        return decimal;
    }
    private int bin2exp(int counter, byte temp[], int bit, int exp){
        if(counter > 0){
            if(temp[counter] == '1'){
                exp += Math.round(Math.pow(2.0, bit));
            }
            exp = bin2exp(counter - 1, temp, bit + 1, exp);    
        }
        return exp;
    }
    private float bin2dec(int counter, byte temp[], int exp){
		if(exp + counter < 23){
            if(temp[9 + exp + counter] == '1'){
                decimal += Math.pow(0.5, counter);
            }
            decimal = bin2dec(counter + 1, temp, exp);
        }
		return decimal;
    }
    private int bin2int(int exp, int integer, int bit, byte temp[]){
        if(exp >= 0){
            if(temp[9 + exp] == '1'){
                integer += Math.round(Math.pow(2.0, bit));
            }
            integer = bin2int(exp - 1, integer, bit + 1,temp);        
        }
        return integer;
    }
    
    
    //method of converting decimal to binary representation
    private String decimal2binary(float decimal){
        char binary[], exp[], man[];
        int expbit, temp;
        int decPointPos = 0, counter = 0, manbit = 0;
        binary = new char[32];
        exp = new char[8];
        man = new char[23];
        
        //determine sign
        if(decimal < 0){
            binary[0] = '1';
        }
        else{
            binary[0] = '0';
        }
        //get integer part 
        temp = (int) decimal;
        
        //convert integer part to binary and make sure it does not overflow
        counter = int2bin(temp, counter, manbit, man);
        decPointPos = counter;
        //reverse the order to the proper order
        int2binReverse(0, binary, man, counter);
        
        //now work with the decimal part the limit will be reach position 23rd bit of the mantissa
            decimal = decimal - (int) decimal; //get the integer part
        dec2bin(counter, manbit, decimal, binary);
        //convert decPointPos to binary as exp
        decPointPos = decPointPos - 1; // leave one digit to the left
        counter = dec2exp(0, decPointPos, 0, exp);
        //reverse order of exp and store it into binary string start pos 1
        dec2expReverse(binary, exp, counter);

        return new String(binary);
    }
    private int int2bin(int temp, int counter,int manbit, char man[]){
        if((temp / 2 >= 0) && (temp != 0) && (counter <24)){
            manbit = temp % 2;
            man[counter] = (char)(manbit + '0');
            temp = temp / 2;
        counter = int2bin(temp, counter + 1, manbit, man);
        }
        return counter;
    }
	//reverse order
    private void int2binReverse(int temp, char binary[], char man[], int counter){
        if(temp < counter){
            binary[9 + temp] = man[counter - 1 - temp];
            int2binReverse(temp + 1, binary, man, counter);
        }
    }
    private void dec2bin(int counter, int manbit, float decimal, char binary[]){
        if(counter < 23){
            manbit = (int)(decimal * 2);
            binary[9 + counter] = (char)(manbit + '0');
            decimal = decimal * 2 - (int)(decimal * 2);
            dec2bin(counter + 1, manbit, decimal, binary);
        }
    }
    private int dec2exp(int counter, int decPointPos, int expbit, char exp[]){
        if(counter < 8){
            expbit = decPointPos % 2;
            decPointPos = decPointPos / 2;
            exp[counter] = (char)(expbit + '0');
            counter = dec2exp(counter + 1, decPointPos, expbit, exp);
        }
        return counter;
    }
	//reverse order
    private void dec2expReverse(char binary[], char exp[], int counter){
        if(counter > 0){
            binary[counter] = exp[8 - counter];
            dec2expReverse(binary, exp, counter - 1);
        }
    }
    

    public String addBin(String one, String two){
		int exp1, exp2, counter;
		byte temp1[] = new byte[32], temp2[] = new byte[32], temp[] = new byte[32], sum[] = new byte[32];

        //convert the 2 strings to arrays
        temp1 = one.getBytes();
        temp2 = two.getBytes();

        //convert each exponent to decimal exponents
        exp1 = bin2exp(8, temp1, 0, 0);
        exp2 = bin2exp(8, temp2, 0, 0);

		//set new exponent
		//set counter to the difference in the exponent
		if(exp1 > exp2){
			setExp(temp1, temp2, 1);
			counter = exp1 - exp2;
			shift(temp2, counter, 0);
		}
		else{
			setExp(temp2, temp1, 1);
			counter = exp2 - exp1;
			shift(temp1, counter, 0);
		}
		
        //add
        add(temp1, temp2, 31, sum, 0);

        sum[0] = temp1[0];
		setExp(temp1, sum, 1);
		
        return new String(sum);
    }
	//set smaller exponent to larger
	private byte[] setExp(byte[] temp1, byte[] temp2, int index){
		if(index < 9){
			temp2[index] = temp1[index];
			return setExp(temp1, temp2, index + 1);
		}
		return temp2;
	}
	//shift  according to the value of counter
    private void shift(byte[] temp, int counter, int index){
        if((31 - counter - index) > 8){
            temp[31 - index] = temp[31 - counter - index];
            shift(temp, counter, index + 1);
        }
		else if(31 - index > 8){
		    temp[31 - index] = '0';
			shift(temp, counter, index + 1);
		}
    }
    private void add(byte[] temp1, byte[] temp2, int index, byte[] sum, int carry){
	    if(index > 8){
			sum[index] = (byte) ((temp1[index] - '0') + (temp2[index]- '0') + carry) ;
			if(sum[index] > 1 ){
		        if(sum[index] > 2){
				   sum[index] = 1 + '0';
				   carry = 1;
				}
				else{
				   sum[index] = 0 + '0';
				   carry = 1;				
				}                
            }
			else{
				sum[index] = (byte)( sum[index] + '0');
				carry = 0;			
			}
			add(temp1, temp2, index - 1, sum, carry);
        }
    }
	
	
	
	//bonus method that adds from smallest to largest
	public float binary2decimal2(String binary){
        float decimal = 0;
        int exp = 0, integer = 0, bit = 0, counter = 8;
        byte temp[] = new byte[32];
        
        //turn string into an array, which is easier to work with
        temp = binary.getBytes();

        //convert exponent
        exp = bin2exp(counter, temp, bit, exp);
        //convert decimal part in mantissa
        decimal = bin2dec2(0, temp, exp);
            //make sure decimal does not have an integer part
            if(decimal >= 1){
                decimal = decimal - (int) decimal;
            }
        //convert integer part in mantissa
        integer = bin2int(exp, integer, 0, temp);
        
        //add decimal and integer
        decimal = decimal + (float) integer;
        //determine the sign
        if(temp[0] == '1'){
            decimal = 0 - decimal;
        }
		
        return decimal;
    }
	//count backwards (in comparison to bin2dec)
	private float bin2dec2(int counter, byte temp[], int exp){
		if(exp + counter < 23){
            if(temp[31 - counter] == '1'){
                decimal += Math.pow(0.5, 22 - exp - counter);
            }
            decimal = bin2dec2(counter + 1, temp, exp);
        }
        return decimal;
    }
}





