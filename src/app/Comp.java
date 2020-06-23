package app;

import java.util.*;

public class Comp{
    public static int var;

    public static void compute(Memory instruc){
            switch(instruc.getIns()){
                case "M":
                    var=instruc.getN();
                break;
                case "A":
                    var+=instruc.getN();
                break;
                case "S":
                    var-=instruc.getN();
                break;
                case "C":
                break;
                case "L":
                    cicleComp(instruc.getNome());
                break;
                case "T":
                    System.out.println("Finished prg\n");
                break;

            }
        }

    public static void cicleComp(String path){
        List<Memory> prgmem=Algoritm.convertM(fileRW.readMem("input/"+path+".prg"));
        
        for(Memory aux:prgmem){
            Comp.compute(aux);
            Algoritm.time++;
        }
    }
}