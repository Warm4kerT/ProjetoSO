package app;

import java.util.*;

public class Log {
    public List<PCB> finnished;
    public List<PCB> waiting;
    public List<PCB> ready;
    public PCB running;

    public Log(){
        this.finnished=new ArrayList<PCB>();
        this.waiting=new ArrayList<PCB>();
        this.ready=new ArrayList<PCB>();
        this.running=new PCB();
    }

   
    @Override
    public String toString(){
        String print=":: Current Time: "+ Algoritm.time+"\n";
        
        print=print+":: Running Process:\n"+this.running.toString()+"\n\n:: Waiting Processes:\n\n";
            for(PCB aux:this.waiting){
                print=print+aux.toString()+"\n";
        }            
        print=print+":: Ready to Execute Processes:\n\n";
            
        for(PCB aux:this.ready){
                print=print+aux.toString()+"\n";
        }

        print=print+":: Ready to Finished Processes:\n\n";
        for(PCB aux:this.finnished){
            print=print+aux.toString()+"\n";
        }

        return print;
    }

    public List<PCB> getFinnished() {
        return finnished;
    }

    public void setFinnished(List<PCB> finnished) {
        this.finnished = finnished;
    }

    public List<PCB> getWaiting() {
        return waiting;
    }

    public void setWaiting(List<PCB> waiting) {
        this.waiting = waiting;
    }

    public List<PCB> getReady() {
        return ready;
    }

    public void setReady(List<PCB> ready) {
        this.ready = ready;
    }

    public PCB getRunning() {
        return running;
    }

    public void setRunning(PCB running) {
        this.running = running;
    }
}