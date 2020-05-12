package app;
import java.io.*;
import java.util.*;

public class fileRW {

    public static ArrayList<?> readF(String path){
        ArrayList<Memory> mList=new ArrayList<>();

        try{
            BufferedReader buff= new BufferedReader(new FileReader(path));
            String line;
            while((line=buff.readLine())!=null){
                if(!line.equals("\n") && !line.equals("") && !line.equals(" ")){
                    if(line.contains(" ")){
                        String[] parts=line.split(" ");
                        Memory aux=new Memory(parts[0], new Integer(parts[1]), parts[2]);
                        mList.add(aux);
                    }
                }
            }
            return mList;
        }catch(IOException e){
            System.out.println(e.getMessage());

            return null;
        }
    }

    public static void writeF(String path, ArrayList<?> lista){
        File fl=new File("output/"+path+".txt");
        BufferedWriter writer;
        try{
            if((fl.exists())==false){
                fl.createNewFile();
            }

            for(Object aux:lista){
                writer=new BufferedWriter(new FileWriter("output/"+path+".txt"));
                writer.append(aux.toString()+"\r\n");
                writer.flush();
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }

    public static void printList(ArrayList<?> list){
        for(Object aux:list){
            System.out.println(aux.toString());
        }
    }
}