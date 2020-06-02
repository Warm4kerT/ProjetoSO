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

        int[] waitingTime=new int[tam]; waitingTime[0]=0;
        int[] turnAround=new int[tam]; turnAround[0]=p[0].getBurstTime();

        for (int i=1; i<tam; i++){
            waitingTime[i] = p[i-1].getBurstTime() + waitingTime[i-1] - p[i].getArrivalTime();
            turnAround[i] = waitingTime[i] + p[i].getBurstTime();
        }

        int totalW = 0, totalT = 0;
        for (int i=0; i<tam; i++){
            totalW += waitingTime[i];
            totalT += turnAround[i];
        }

        System.out.print("Average waiting time is " + totalW/tam + "\n" + "Average turn around time is " + totalT/tam + "\n");
    }

    public static void SJF(PCB[] p){

    }
    
    public static void SRT(PCB[] p){
        
    }
}