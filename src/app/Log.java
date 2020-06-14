package app;

public class Log {
    public PCB[] finnished;
    public PCB[] waiting;
    public PCB[] ready;
    public PCB running;

    public Log(int tam){
        this.finnished=new PCB[tam];
        this.finnished[0]=new PCB();
        this.waiting=new PCB[tam];
        this.waiting[0]=new PCB();
        this.ready=new PCB[tam];
        this.ready[0]=new PCB();
        this.running=new PCB();
    }

    public PCB[] getFinnished() {
        return finnished;
    }

    public void setFinnished(PCB[] finnished) {
        this.finnished = finnished;
    }

    public PCB[] getWaiting() {
        return waiting;
    }

    public void setWaiting(PCB[] waiting) {
        this.waiting = waiting;
    }

    public PCB[] getReady() {
        return ready;
    }

    public void setReady(PCB[] ready) {
        this.ready = ready;
    }

    public PCB getRunning() {
        return running;
    }

    public void setRunning(PCB running) {
        this.running = running;
    }

    @Override
    public String toString(){
        String print="Current Time: "+ Algoritm.time+"\n";
        
        print=print+"Running Process:\n"+this.running.toString()+"\nWaiting Processes:\n";
        if(this.waiting[0]!=new PCB()){
            for(int i=0; i<this.waiting.length;i++){
                print=print+this.waiting[i].toString()+"\n";
            }
        }
        if(this.ready!=null){
            print=print+"Ready to Execute Processes:\n";
            for(int i=0; i<this.ready.length;i++){
                print=print+this.ready[i].toString()+"\n";
            }
        }  
        if(this.finnished!=null){
            print=print+"Ready to Finished Processes:\n";
            for(int i=0; i<this.finnished.length;i++){
                print=print+this.finnished[i].toString()+"\n";
            }
        }

        return print;
    }
}