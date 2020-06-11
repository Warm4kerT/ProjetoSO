package app;

public class Comp{
    public static int var;

    public static void compute(Memory instruc){
            switch(instruc.getIns()){
                case "M":
                    var=instruc.getN();
                break;
                case "A":
                    var+=instruc.getN();
                break;
                case "S":
                    var-=instruc.getN();
                break;
                case "C":
                
                break;
                case "L":
                    
                break;
                case "T":
                    
                break;

            }
        }
}