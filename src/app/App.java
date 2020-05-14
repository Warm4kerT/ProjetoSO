package app;
import java.util.*;

public class App {
    public int tempo=0;
    public int PC=0;

    public static void main(String[] args){ 
        ArrayList<PCB> PcbTabela=new ArrayList<>();
        ArrayList<Memory> memo=new ArrayList<>();
        PcbTabela=fileRW.readPCB("soproject/input/plan.txt"); 
        
        for(PCB aux:PcbTabela){
            System.out.println(aux.toString());
            
            memo=fileRW.readMem("soproject/input/"+aux.getNome());
            for(Memory aux1:memo){
                System.out.println(aux1.toString());
            }
        }
       
    }
}