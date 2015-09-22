package cadastro;


import java.time.LocalDateTime;
import java.time.ZoneId;




public class Carro {
    private String modelo;
    private String placa;
    private int ano;
    private Cliente cliente;
    private LocalDateTime horaEntrada;
    private String observacoes;
    
    public Carro() {
        this.modelo = "";
        this.placa = "";
        ano = 0;
        cliente = new Cliente();
        horaEntrada = LocalDateTime.now(ZoneId.of("Brazil/East"));
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
    public LocalDateTime gethoraEntrada(){
        return horaEntrada;
    }
    /**
     * 
     * @return Cliente - que e dono do carro
     */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * 
	 * @param Cliente - cliente que e dono do carro
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * 
	 * @return String - as observacoes do cliente
	 */
	public String getObservacoes() {
		return observacoes;
	}
	/**
	 * 
	 * @param observacoes - cliente escreve suas observacoes
	 */
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
    
}
