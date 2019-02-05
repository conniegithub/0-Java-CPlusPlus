import java.io.*;

class UserInput{

    UserInput(){
    }

    public static int readInt(){
        String s = new String();
        try{
            s = commandLine.readLine();
        }
        catch(IOException ioexception) { }
        return Integer.parseInt(s);
    }

    public static BufferedReader commandLine;

    static {
        commandLine = new BufferedReader(new InputStreamReader(System.in));
    }
}