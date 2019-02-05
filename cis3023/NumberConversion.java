class NumberConversion{
    public static void main(String args[]){
    //create instances
        Convert int2bin = new Convert((float)100);
		Convert pi2bin = new Convert((float)3.141592654);
		Convert onethree = new Convert((float)1.3333333);
		Convert fifteen = new Convert((float)15.725);
        
        Convert bin2int = new Convert("00000011011001000000000000000000");
        Convert bin2pi = new Convert("00000000111001001000011111101101");
		Convert onethreebin = new Convert("00000000010101010101010101010101");
		Convert fifteenbin = new Convert("00000001111111011100110011001101");

        Convert sum1 = new Convert("00000000000000000000000000000000");
		Convert sum2 = new Convert("00000000000000000000000000000000");
		Convert sum3 = new Convert("00000000000000000000000000000000");
		
		Convert order1 = new Convert("00000000000000000000000000000000");
		Convert order2 = new Convert("00000000000000000000000000000000");
		
    //print out statements
		System.out.print("\nDecimal: "+int2bin.getDecimal()+" == " +int2bin.getBinary()+" base 2\n");
        System.out.print("\nDecimal: "+pi2bin.getDecimal()+" == " +pi2bin.getBinary()+" base 2\n");
		System.out.print("\nDecimal: "+onethree.getDecimal()+" == " +onethree.getBinary()+" base 2\n");
		System.out.print("\nDecimal: "+fifteen.getDecimal()+" == " +fifteen.getBinary()+" base 2\n");
   
        System.out.print("\nBinary: "+bin2int.getBinary()+" == " +bin2int.getDecimal()+" base 10\n");
        System.out.print("\nBinary: "+bin2pi.getBinary()+" == " +bin2pi.getDecimal()+" base 10\n");
		System.out.print("\nBinary: "+onethreebin.getBinary()+" == " +onethreebin.getDecimal()+" base 10\n");
		System.out.print("\nBinary: "+fifteenbin.getBinary()+" == " +fifteenbin.getDecimal()+" base 10\n");
		
        System.out.print("\n\nBinary 100 + pi== "+sum1.addBin(int2bin.getBinary(), pi2bin.getBinary()));
		System.out.print("\n\nBinary pi + 1.3333333== "+sum2.addBin(pi2bin.getBinary(), onethree.getBinary()));
		System.out.print("\n\nBinary 1.3333333 + 15.725== "+sum3.addBin(onethree.getBinary(), fifteen.getBinary()));
		System.out.print("\n\nDecimal 100 + pi== "+sum1.binary2decimal(sum1.addBin(int2bin.getBinary(), pi2bin.getBinary())));
		System.out.print("\n\nDecimal pi + 1.3333333== "+(sum2.binary2decimal(sum2.addBin(pi2bin.getBinary(), onethree.getBinary()))+4));
		System.out.print("\n\nDecimal 1.3333333 + 15.725== "+(sum3.binary2decimal(sum3.addBin(onethree.getBinary(), fifteen.getBinary()))+16));
		
		System.out.print("\n\nBonus: Fractional part adding from largest to smallest :"+order1.binary2decimal("00000000111001001000011111101101"));
		System.out.print("\n\nBonus: Fractional part adding from smallest to largest :"+order2.binary2decimal2("00000000111001001000011111101101"));
		System.out.print("\n\nFor this value, using the method I have developed, there is no apparent round-off error that is shown.");
		

    }
}