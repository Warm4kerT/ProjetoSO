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
        Arrays.sort(p, new Sortbyarrival());
        int j=0, h=0;
        Arrays.sort(p, new Sortbyarrival());
        Log log=new Log(tam);
        
        log.setRunning(p[0]);

        while(log.running!=null){
            if(log.running.getArrivalTime()<=time){
                log.ready[h]=p[h].clone();
                p[h]=null;
            }

            if(log.running.getArrivalTime()<=time){
                Memory[] prgmem=convertM(fileRW.readMem("input/"+log.running.getNome()));
                log.running.setWaitingTime(time-log.running.getArrivalTime());
                
                j=log.running.getState();
                while(j<prgmem.length){
                    Comp.compute(prgmem[j]);
                    time++;
                    j++;
                }
                System.out.println(log.toString());
                time++;
                h++;
            }else{
                time++;
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

    public static int shortBurst(PCB[] list, int reBurst){
        for(int i=0; i<list.length; i++){
            if(list[i].getBurstTime()!=0 && list[i].getBurstTime()<reBurst){
                return i;
            }
        }

        return 0;
    }
    
    public static void SRT(PCB[] p){
        time=0;
        int tam=p.length;
        int j=0, h=0, i=0, w=0;
        Arrays.sort(p, new Sortbyarrival());
        Log log=new Log(tam);
        
        log.setRunning(p[0]);

        while(log.running!=null){
            if(log.running.getArrivalTime()<=time){
                log.ready[h]=p[h];
                p[h]=null;
            }

            if(log.running.getArrivalTime()<=time){
                Memory[] prgmem=convertM(fileRW.readMem("input/"+log.running.getNome()));
                log.running.setWaitingTime(time-log.running.getArrivalTime());
                
                j=log.running.getState();
                while(j<prgmem.length){
                    Comp.compute(prgmem[j]);
                    time++;
                    if((i=shortBurst(log.getReady(),log.running.getBurstTime()-j))!=0){
                        log.running.setState(j+1);
                        log.waiting[w]=log.running;
                        log.running=log.ready[i];
                        w++;
                        break;
                    }
                    j++;
                }
                System.out.println(log.toString());
                time++;
                h++;
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