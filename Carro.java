package cadastro;


import java.time.LocalDateTime;
import java.time.ZoneId;




public class Carro {
    private String modelo;
    private String placa;
    private int ano;
    private Cliente cliente;
    private LocalDateTime data;
    
    
    public Carro() {
        this.modelo = "";
        this.placa = "";
        ano = 0;
        cliente = new Cliente();
       data = LocalDateTime.now(ZoneId.of("Brazil/East"));
    }
    /**
     * 
     * @return String - modelo carro
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * 
     * @param modelo - insere modelo carro
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    /**
     * 
     * @return String - placa carro
     */
    public String getPlaca() {
        return placa;
    }
    /**
     * 
     * @param placa - insere placa carro
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    /**
     * 
     * @return int - ano carro
     */
    public int getAno() {
        return ano;
    }
    /**
     * 
     * @param ano -insere ano carro
     */
    public void setAno(int ano) {
        this.ano = ano;
    } 
    /**
     * 
     * @return LocalDateTime - hora e data do sistema
     */
    public LocalDateTime getData(){
        return data;
    }
    
}
