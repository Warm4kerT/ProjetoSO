package app;
import java.io.*;
import java.util.*;

public class fileRW {
    public static ArrayList<PCB> readF(String path){
        try{
            ObjectInputStream input=new ObjectInputStream(new FileInputStream(path));
            ArrayList<PCB> retorna=(ArrayList<PCB>) input.readObject();
            input.close();
            return retorna;      
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            return new ArrayList<PCB>();
        }
    }

    public static void writeF(String path, ArrayList<PCB> lista){
        try{
            ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(path));
            output.writeObject(lista);
            output.flush();
            output.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }

    public static void printList(ArrayList<PCB> list){
        for(PCB aux:list){
            System.out.println(aux.toString());
        }
    }
}