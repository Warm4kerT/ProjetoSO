package app;

public class PCB {
    private int pid, ppid, priority, start, PC, state;
    private String nome;

    public PCB(int a, int b, int c, int d, int e, int f, String n){
        this.pid=a;
        this.ppid=b;
        this.priority=c;
        this.start=d;
        this.PC=e;
        this.state=f;
        this.nome=n;
    }

    public PCB(){
        this.pid=0;
        this.ppid=0;
        this.priority=0;
        this.start=0;
        this.PC=0;
        this.state=0;
        this.nome="";
    }

    //getter's
    public int getPid(){
        return this.pid;
    }
    
    public int getPpid(){
        return this.ppid;
    }
    
    public int getPriority(){
        return this.priority;
    }

    public int getStart(){
        return this.start;
    }

    public int getPC(){
        return this.PC;
    }

    public int getState(){
        return this.state;
    }

    public String getNome(){
        return this.nome;
    }

    //setter's
    public void setPid(int x){
        this.pid=x;
    }
    
    public void setPpid(int x){
        this.ppid=x;
    }
    
    public void setPriority(int x){
        this.priority=x;
    }

    public void setStart(int x){
        this.start=x;
    }

    public void setPC(int x){
        this.PC=x;
    }

    public void setState(int x){
        this.state=x;
    }

    public void setNome(String x){
        this.nome=x;
    }

    @Override
    public String toString(){
        return "Process Name: "+this.nome+"\nProcess ID: "+this.pid+"\nParent Process ID: "+this.ppid+"\nState: "+this.state+"\n";
    }
}
