package app;

import java.util.ArrayList;

public class Comp{
    public ArrayList <Memory> array;
    public int var;
    
    public Comp(ArrayList <Memory> arr){
        this.array=arr;
    }

    public Comp(){
        this.array=new ArrayList<>();
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }

    public void compute(){
        loop: for(int i=0;i<array.size();i++){
            Memory aux=array.get(i);
            switch(aux.getIns()){
                case "M":
                    this.var=aux.getN();
                break;
                case "A":
                    this.var+=aux.getN();
                break;
                case "S":
                    this.var-=aux.getN();
                break;
                case "C":
                    i++;
                break;
                case "L":
                    this.array=fileRW.readMem("input/"+aux.getNome());
                break;
                case "T":
                break loop;

            }
            System.out.println(this.var);
        }
    }
}