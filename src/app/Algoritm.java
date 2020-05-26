package app;

public class Algoritm {
    public void FCFS(PCB[] p){
        PCB temp=new PCB();
        int tam=p.length;

        for(int i=0;i<tam;i++){
            for(int j=i;j<tam-2;j++){
                if(p[j].getArrivalTime() > p[j+1].getArrivalTime()){
                    temp=p[j+1];
                    p[j+1]=p[j];
                    p[j]=temp;
                }
            }
        }
    }
}