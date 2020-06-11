package app;

import java.util.*;

public class PCB{
    private int pid, ppid, priority, burstTime, arrivalTime, waitingTime, PC, state;
    private String nome;

    public PCB(int a, int b, int c, int d, int e, int f, int g, int h, String n) {
        this.pid = a;
        this.ppid = b;
        this.priority = c;
        this.arrivalTime = d;
        this.burstTime = e;
        this.waitingTime = f;
        this.PC = g;
        this.state = h;
        this.nome = n;
    }

    public PCB() {
        this.pid = 0;
        this.ppid = 0;
        this.priority = 0;
        this.arrivalTime = 0;
        this.burstTime = 0;
        this.waitingTime = 0;
        this.PC = 0;
        this.state = 0;
        this.nome = "";
    }

    // getter's
    public int getPid() {
        return this.pid;
    }

    public int getPpid() {
        return this.ppid;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getPC() {
        return this.PC;
    }

    public int getState() {
        return this.state;
    }

    public String getNome() {
        return this.nome;
    }

    // setter's
    public void setPid(int x) {
        this.pid = x;
    }

    public void setPpid(int x) {
        this.ppid = x;
    }

    public void setPriority(int x) {
        this.priority = x;
    }

    public void setPC(int x) {
        this.PC = x;
    }

    public void setState(int x) {
        this.state = x;
    }

    public void setNome(String x) {
        this.nome = x;
    }

    @Override
    public String toString() {
        return "Process Name: " + this.nome + "\nProcess ID: " + this.pid + "\nParent Process ID: " + this.ppid
                + "\nState: " + this.state + "\n";
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
}

class Sortbyarrival implements Comparator<PCB>{

    public int compare(PCB a, PCB b){ 
        return a.getArrivalTime() - b.getArrivalTime(); 
    } 
}

class Sortbyburst implements Comparator<PCB> { 
    
    public int compare(PCB a, PCB b){ 
        return a.getBurstTime() - b.getBurstTime(); 
    } 
} 

class Sortbypriority implements Comparator<PCB>{ 
    
    public int compare(PCB a, PCB b){ 
        return a.getPriority() - b.getPriority(); 
    } 
} 
