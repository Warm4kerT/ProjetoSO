package app;
import java.util.*;

public class App {
    public int tempo=0;
    public int PC=0;

    public static void main(String[] args){
        System.out.println(": : : Simulador de Gestão de Processos, Escalonamento e Gestão de Memória : : :");
        ArrayList<PCB> PcbTabela=new ArrayList<>();
        
        String plan="input/plan.txt";
        PcbTabela=fileRW.readPCB(plan);
        System.out.println("\nReading from: "+plan+"\n");
        
        int input=0;
        while(input!=10){
            System.out.println(":: Menu ::");
            System.out.println("1- FCFS\n2- SJF\n3- SRT\n4- Priority\n\n10-Exit");
            input=read.aInt();
            switch(input){
                case 1:
                    System.out.println(":: FCFS ::");
                    Algoritm.FCFS(Algoritm.convertP(PcbTabela));
                    System.out.println(":: End ::\n");
                break;
                case 2:
                    System.out.println(":: SJF ::");
                    Algoritm.SJF(Algoritm.convertP(PcbTabela));
                    System.out.println(":: End ::\n");
                break;
                case 3:
                    System.out.println(":: SRT ::");
                    Algoritm.SRT(Algoritm.convertP(PcbTabela));
                    System.out.println(":: End ::\n");
                break;
                case 4:
                    System.out.println(":: Priority ::");
                    Algoritm.Priority(Algoritm.convertP(PcbTabela));
                    System.out.println(":: End ::\n");
                break;
            }
        
        }
    }
}