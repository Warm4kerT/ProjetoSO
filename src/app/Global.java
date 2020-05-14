package app;

public class Global {
    public int var;

    public Global(int n){
        this.var=n;
    }

    public Global(){
        this.var=0;
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }

    public void intrucao(Memory ins){
        switch(ins.getIns()){
            case "M" :
                this.var=ins.getN();
            break;

            case "A" :
                this.var+=ins.getN();
            break;

            case "S" :
                this.var-=ins.getN();
            break;

            case "L" :
            break;

            case "C" :
            break;
            
        }
    }


}