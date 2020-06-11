package app;
import java.io.*;

public class read {
    public static String aString (){
        String s="";
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader (System.in));
            s=in.readLine();
        }catch(IOException e){
            System.out.println("Error reading the input flux!!!\n");
        }
        System.out.println("\n");
        return s;
    }
    
    public static int aInt(){
        while(true){
            try{
                return Integer.valueOf(aString().trim()).intValue();
            }catch(Exception e){
                System.out.println("Not a valid Integer!!!\n");
            }
        }
    }
    
    public static double aDouble(){
        while(true){
            try{
                return Double.valueOf(aString().trim()).doubleValue();
            }catch(Exception e){
                System.out.println("Not a valid Double!!!\n");
            }
        }
    }
    
    public static boolean aBoolean(){
        while(true){
            try{
                return Boolean.valueOf(aString().trim()).booleanValue();
            }catch(Exception e){
                System.out.println("Not a valid boolean!!!\n");
            }
        }
    }
}