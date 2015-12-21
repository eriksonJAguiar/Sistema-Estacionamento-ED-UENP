package cadastro;




public class Cliente{
    
    private String nome;
    private long cpf;
   
    public Cliente(){
    	this.nome = "";
    	this.cpf = 0;
    }
    
    public Cliente(String nome, long cpf){
        this.nome = nome;
        this.cpf = cpf;
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
     * @param nome - insere nome cliente
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
