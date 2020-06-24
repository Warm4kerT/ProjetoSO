package app;
import java.util.*;

public class App {
    public int tempo=0;
    public int PC=0;

    public static void main(String[] args){
        System.out.println(": : : Simulador de Gestão de Processos, Escalonamento e Gestão de Memória : : :");
        
        String plan="input/plan.txt";
        System.out.println("\nReading from: "+plan+"\n");
        
        int input=0;
        while(input!=10){
            System.out.println(":: Menu ::");
            System.out.println("1- FCFS\n2- Priority\n\n10-Exit");
            input=read.aInt();
            switch(input){
                case 1:
                    System.out.println(":: FCFS ::");
                    Algoritm.FCFS(fileRW.readPCB(plan));
                    System.out.println(":: End ::\n");
                break;
                case 2:
                    System.out.println(":: Priority ::");
                    Algoritm.Priority(fileRW.readPCB(plan));
                    System.out.println(":: End ::\n");
                break;
            }
        
        }
    }
}