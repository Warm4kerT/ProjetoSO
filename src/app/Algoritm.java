package app;

import java.util.*;

public class Algoritm {
    public static int time;

    public static List<Memory> convertM(ArrayList<Memory> array){
        List<Memory> output=new ArrayList<Memory>();
        for(Memory aux:array){
            output.add(aux);
        }
        
        return output;
    }

    public static boolean exist(List<PCB> list, PCB p){
        for(PCB aux:list){
            if(aux.equals(p)){
            return true;
            }
        }

        return false;
    }

    public static void FCFS(ArrayList<PCB> p){
        Collections.sort(p, new arrivalTimeSorter());
        int tam=p.size();
        time=0;
        int h=0,pid=0;
        Log log=new Log();
        log.setRunning(p.get(0).clone());

        while(log.finnished.size()!=tam){
            if(p.get(0).getArrivalTime()<=time && !exist(log.getReady(), p.get(0))){
                p.get(0).setPid(pid);
                log.ready.add(p.get(0));
                p.remove(0);
                pid++;
            }

            if(log.running.getArrivalTime()<=time){
                List<Memory> prgmem=convertM(fileRW.readMem("input/"+log.running.getNome()));
                log.running.setWaitingTime(time-log.running.getArrivalTime());
                h=0;
                for(Memory aux:prgmem){
                    Comp.compute(aux);
                    time++;
                    h++;
                    log.running.setState(h);
                }
                time++;
                log.finnished.add(log.running);
                log.setRunning(log.ready.get(0).clone());
                log.ready.remove(0);
                System.out.println(log.toString());
            }else{
                time++;
                System.out.println(log.toString());
            }
        }

        int[] waitingTime=new int[tam]; waitingTime[0]=0;
        int[] turnAround=new int[tam]; turnAround[0]=log.finnished.get(0).getBurstTime();

        for (int i=1; i<tam; i++){
            waitingTime[i] = log.finnished.get(i-1).getBurstTime() + waitingTime[i-1] - log.finnished.get(i).getArrivalTime();
            turnAround[i] = waitingTime[i] + log.finnished.get(i).getBurstTime();
        }

        int totalW = 0, totalT = 0;
        for (int i=0; i<tam; i++){
            totalW += waitingTime[i];
            totalT += turnAround[i];
        }

        System.out.print("Average waiting time is " + totalW/tam + "\n" + "Average turn around time is " + totalT/tam + "\n");
    }

    public static void Priority(ArrayList<PCB> p){
        Collections.sort(p, new prioritySorter());
        int tam=p.size();
        time=0;
        int h=0,pid=0;
        Log log=new Log();
        log.setRunning(p.get(0).clone());
    
        while(log.finnished.size()!=tam){
            if(p.get(0).getArrivalTime()<=time && !exist(log.getReady(), p.get(0))){
                p.get(0).setPid(pid);
                log.ready.add(p.get(0));
                p.remove(0);
                pid++;
            }

            if(log.running.getArrivalTime()<=time){
                List<Memory> prgmem=convertM(fileRW.readMem("input/"+log.running.getNome()));
                log.running.setWaitingTime(time-log.running.getArrivalTime());
                h=0;
                for(Memory aux:prgmem){
                    Comp.compute(aux);
                    time++;
                    h++;
                    log.running.setState(h);
                }
                time++;
                log.finnished.add(log.running);
                log.running=log.ready.get(0).clone();
                log.ready.remove(0);
                System.out.println(log.toString());
            }else{
                time++;
                System.out.println(log.toString());
            }
        }

        int[] waitingTime=new int[tam]; waitingTime[0]=0;
        int[] turnAround=new int[tam]; turnAround[0]=log.finnished.get(0).getBurstTime();

        for (int i=1; i<tam; i++){
            waitingTime[i] = log.finnished.get(i-1).getBurstTime() + waitingTime[i-1] - log.finnished.get(i).getArrivalTime();
            turnAround[i] = waitingTime[i] + log.finnished.get(i).getBurstTime();
        }

        int totalW = 0, totalT = 0;
        for (int i=0; i<tam; i++){
            totalW += waitingTime[i];
            totalT += turnAround[i];
        }

        System.out.print("Average waiting time is " + totalW/tam + "\n" + "Average turn around time is " + totalT/tam + "\n");
    }
}