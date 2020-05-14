package app;


public class Memory{
    private String ins, nome;
    private int n;

    public Memory(String a, int b, String nome){
        this.ins=a;
        this.n=b;
        this.nome=nome;
    }

    public Memory(String a, int b){
        this.ins=a;
        this.n=b;
        this.nome="";
    }

    public Memory(){
        this.ins="";
        this.n=0;
        this.nome="";
    }

    public String getIns()
    {
		return this.ins;
	}

    public void setIns(String ins)
    {
		this.ins = ins;
	}

    public int getN() {
        return this.n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return ins+" "+n+" "+nome;
    }
}