package cadastro;




public class Cliente{
    
    private String nome;
    private long cpf;
   
    
    public Cliente(){
        nome = "";
        cpf = 0;
       
    }
    /**
     * 
     * @return String - nome do cliente
     */
    public String getNome() {
        return nome;
    }
    /**
     * 
     * @param nome - isere nome cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * 
     * @return long - cpf cliente
     */
    public long getCpf() {
        return cpf;
    }
    /**
     * 
     * @param cpf - insere cpf
     */
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
}
