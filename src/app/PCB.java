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
        return "Name: " + this.nome + " ID: " + this.pid + " State: " + this.state + "\n";
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

    @Override
    public PCB clone(){
        PCB clone=new PCB();
        clone.setArrivalTime(this.getArrivalTime());
        clone.setBurstTime(this.getBurstTime());
        clone.setWaitingTime(this.getWaitingTime());
        clone.setNome(this.getNome());
        clone.setPC(this.getPC());
        clone.setPid(this.getPid());
        clone.setPpid(this.getPpid());
        clone.setPriority(this.getPriority());
        clone.setState(this.getState());

        return clone;
    }
}

class arrivalTimeSorter implements Comparator<PCB> {
    @Override
    public int compare(PCB o1, PCB o2) {
        return o1.getArrivalTime() - o2.getArrivalTime();
    }   
}

class prioritySorter implements Comparator<PCB> {
    @Override
    public int compare(PCB o1, PCB o2) {
        return o1.getPriority() - o2.getPriority();
    }   
}

