package app;

import java.util.ArrayList;

public class Algoritm {

    public static PCB[] convert(ArrayList<PCB> array){
        PCB[] output=new PCB[array.size()];
        int i=0;
        for(PCB aux:array){
            output[i]=aux;
            i++;
        }
        return output;
    }

    public static void FCFS(PCB[] p){
        PCB temp=new PCB();
        int tam=p.length;

        for(int i=0;i<tam;i++){
            for(int j=i;j<tam-2;j++){
                if(p[j].getArrivalTime() > p[j+1].getArrivalTime()){
                    temp=p[j+1];
                    p[j+1]=p[j];
                    p[j]=temp;
                }
            }
        }
        for(PCB aux:p){
            Comp.compute(fileRW.readMem("input/"+aux.getNome()));
        }
    }

    public static void SJF(PCB[] p){

    }
    
    public static void SRT(PCB[] p){
        
    }
}