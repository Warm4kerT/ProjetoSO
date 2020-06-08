package app;

import java.util.ArrayList;
import java.util.Arrays;

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
        int tam=p.length;

        Arrays.sort(p, new Sortbyarrival());
        
        for(PCB aux:p){
            Comp.compute(fileRW.readMem("input/"+aux.getNome()));
            System.out.println(aux.getNome()+" Arrival: "+aux.getArrivalTime());
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
        int tam=p.length;

        Arrays.sort(p, new Sortbyburst());
        
        for(PCB aux:p){
            Comp.compute(fileRW.readMem("input/"+aux.getNome()));
            System.out.println(aux.getNome()+" Burst: "+aux.getBurstTime());
        }
        
        int[] waitingTime = new int[tam];
        int[] turnAround = new int[tam];
        waitingTime[0] = 0;
        turnAround[0] = p[0].getBurstTime();

        for (int i = 1; i < tam; i++){
            waitingTime[i] = p[i-1].getBurstTime() + waitingTime[i-1];
            turnAround[i] = waitingTime[i] + p[i].getBurstTime();
        }

        int totalW = 0; int totalT = 0;
        
        for (int i = 0; i < tam; i++){
            totalW += waitingTime[i];
            totalT += turnAround[i];
        }
        
        System.out.print("Average waiting time is " + totalW/tam + "\n" + "Average turn around time is " + totalT/tam + "\n");

    }
    
    public static void SRT(PCB[] p){
        
    }

    public static void Priority(PCB[] p){
        int tam=p.length;

        Arrays.sort(p, new Sortbypriority());
        
        for(PCB aux:p){
            Comp.compute(fileRW.readMem("input/"+aux.getNome()));
            System.out.println(aux.getNome()+" Priority: "+aux.getPriority());
        }

        int[] waitingTime=new int[tam]; waitingTime[0]=0;
        int[] turnAround=new int[tam]; turnAround[0]=p[0].getBurstTime();

        for (int i=1; i<tam; i++){
            waitingTime[i] = p[i-1].getBurstTime() + waitingTime[i-1];
            turnAround[i] = waitingTime[i] + p[i].getBurstTime();
        }

        int totalW = 0, totalT = 0;
        for (int i=0; i<tam; i++){
            totalW += waitingTime[i];
            totalT += turnAround[i];
        }

        System.out.print("Average waiting time is " + totalW/tam + "\n" + "Average turn around time is " + totalT/tam + "\n");
    }
}