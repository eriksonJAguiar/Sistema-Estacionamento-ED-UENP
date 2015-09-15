package cadastro;


public class Cliente{
    
    private String nome;
    private long cpf;
    private Carro carro;
    
    public Cliente(){
        nome = "";
        cpf = 0;
        carro = new Carro();
       
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
}
