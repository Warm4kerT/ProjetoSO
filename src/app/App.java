package app;
import java.util.*;

public class App {
    public int tempo=0;
    public int PC=0;

    public static void main(String[] args){ 
        ArrayList<PCB> PcbTabela=new ArrayList<>();
        PcbTabela=(ArrayList<PCB>) fileRW.readF("input/plan.txt");
        ArrayList<Memory> memo=new ArrayList<>();
        for(PCB aux:PcbTabela){
            System.out.println(aux.toString());
            memo=(ArrayList<Memory>) fileRW.readF("input/"+aux.getNome()+".prg");
            for(Memory aux1:memo){
                System.out.println(aux1.toString());
            }
        }
       
    }
}