package app;
import java.io.*;
import java.util.*;

public class fileRW {
    public static ArrayList<Process> readF(String path){
        try{
            ObjectInputStream input=new ObjectInputStream(new FileInputStream(path));
            return (ArrayList<Process>) input.readObject();   
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            return new ArrayList<Process>();
        }
    }

    public static void writeF(String path, ArrayList<Process> lista){
        try{
            ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(path));
            output.writeObject(lista);
            output.flush();
            output.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }
}