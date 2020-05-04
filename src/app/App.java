package app;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception { 
        ArrayList <PCB> processos=fileRW.readF("./processos.txt");
        System.out.println("insira o processo a ler:\n");
        PCB aux=new PCB(read.aInt(),read.aInt(),read.aInt(),read.aInt(),read.aInt(),read.aInt(),read.aString());
        processos.add(aux);
        fileRW.writeF("./processos.txt", processos);

        ArrayList <PCB> pro=fileRW.readF("./processos.txt");
        fileRW.printList(pro);     
    }
}