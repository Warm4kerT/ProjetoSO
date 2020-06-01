package app;

import java.util.ArrayList;

public class Comp{
    public static int var;

    public static void compute(ArrayList <Memory> array){
        ImpleThread thread= new ImpleThread();
        loop: for(int i=0;i<array.size();i++){
            Memory aux=array.get(i);
            
            switch(aux.getIns()){
                case "M":
                    var=aux.getN();
                break;
                case "A":
                    var+=aux.getN();
                break;
                case "S":
                    var-=aux.getN();
                break;
                case "C":
                break;
                case "L":
                    thread.run(fileRW.readMem("input/"+aux.getNome()+".prg"));
                break;
                case "T":
                    thread.stop();
                break loop;

            }
            System.out.println("Iteração: "+i+"\tValor: "+var+"\tIteração: "+aux.getIns()+"\tFile: "+aux.getNome());
        }
    }
}