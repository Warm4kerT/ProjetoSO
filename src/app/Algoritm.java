package app;

import java.util.ArrayList;
import java.util.Arrays;

public class Algoritm {
    public static int time;

    public static PCB[] convertP(ArrayList<PCB> array){
        PCB[] output=new PCB[array.size()];
        int i=0;
        for(PCB aux:array){
            output[i]=aux;
            i++;
        }

        return output;
    }

    public static Memory[] convertM(ArrayList<Memory> array){
        Memory[] output=new Memory[array.size()];
        int i=0;
        for(Memory aux:array){
            output[i]=aux;
            i++;
        }
        
        return output;
    }

    public static void FCFS(PCB[] p){
        int tam=p.length;
        time=0;
        int j=0;

        Arrays.sort(p, new Sortbyarrival());
        
        while(j<tam){
            if(p[j].getArrivalTime()<=time){
                ArrayList<Memory> prgmem=fileRW.readMem("input/"+p[j].getNome());
                p[j].setWaitingTime(time-p[j].getArrivalTime());

                for(Memory memTemp:prgmem){
                    Comp.compute(memTemp);
                    //System.out.println(Comp.var);
                    time++;
                    System.out.println(time);
                }

                System.out.println(p[j].getNome()+" Arrival: "+p[j].getArrivalTime()+" Waiting: "+p[j].getWaitingTime());
                j++;
            }else{
                time++;
                System.out.println(time);
            }
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
        int j=0;
        Arrays.sort(p, new Sortbyburst());
        PCB running=new PCB();
        
        while(j<tam){
            if(p[j].getArrivalTime()<=time){
                running=p[j];
                ArrayList<Memory> prgmem=fileRW.readMem("input/"+running.getNome());
                running.setWaitingTime(time-running.getArrivalTime());

                for(Memory memTemp:prgmem){
                    Comp.compute(memTemp);
                    //System.out.println(Comp.var);
                    time++;
                    System.out.println(time);
                }

                System.out.println(running.getNome()+" Arrival: "+running.getArrivalTime()+" Waiting: "+running.getWaitingTime());
                j++;
            }else{
                time++;
                System.out.println(time);
            }
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

    public static int shortBurst(PCB[] list, int current, int reBurst){
        for(int i=current; i<list.length; i++){
            if(list[i].getBurstTime()<reBurst){
                return i;
            }
        }

        return 0;
    }
    
    public static void SRT(PCB[] p){
        time=0;
        int tam=p.length;
        int j=0, h=0;
        Arrays.sort(p, new Sortbyarrival());
        PCB[] waiting=new PCB[tam];
        
        while(j<tam){
            if(p[j].getArrivalTime()<=time){
                Memory[] prgmen=convertM(fileRW.readMem("input/"+p[j].getNome()));
                int i=p[j].getState();
                for(i=0;i<prgmen.length;i++){
                    Comp.compute(prgmen[i]);
                    if(j!=tam-1){
                        if(shortBurst(p, j, p[j].getBurstTime()-i)!=0 && time>=p[shortBurst(p, j, p[j].getBurstTime()-i)].getArrivalTime()){
                            p[j].setState(i);
                            p[j].setBurstTime(p[j].getBurstTime()-i);
                            waiting[j]=p[j];
                            j=h;
                        }
                    }
                    System.out.println(time);
                    System.out.println(p[j].getNome());
                    time++;
                    j++;
                }
            }else{
                time++;
            }
        }
    }

    public static void Priority(PCB[] p){
        int tam=p.length;
        int j=0;
        Arrays.sort(p, new Sortbypriority());
        
        while(j<tam){
            if(p[j].getArrivalTime()<=time){
                ArrayList<Memory> prgmem=fileRW.readMem("input/"+p[j].getNome());
                p[j].setWaitingTime(time-p[j].getArrivalTime());

                for(Memory memTemp:prgmem){
                    Comp.compute(memTemp);
                    //System.out.println(Comp.var);
                    time++;
                    System.out.println(time);
                }

                System.out.println(p[j].getNome()+" Arrival: "+p[j].getArrivalTime()+" Waiting: "+p[j].getWaitingTime());
                j++;
            }else{
                time++;
                System.out.println(time);
            }
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