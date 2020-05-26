package app;
import java.util.*;

public class App {
    public int tempo=0;
    public int PC=0;

    public static void main(String[] args){ 
        ArrayList<PCB> PcbTabela=new ArrayList<>();
        PcbTabela=fileRW.readPCB("input/plan.txt"); 
        
        for(PCB aux:PcbTabela){
            System.out.println(aux.toString());
            
            Comp memory=new Comp(fileRW.readMem("input/"+aux.getNome()));
            memory.compute();
            System.out.println("\n");
        }
       
    }
}