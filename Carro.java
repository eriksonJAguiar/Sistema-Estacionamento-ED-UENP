package cadastro;


public class Carro {
    private String modelo;
    private String placa;
    private int ano;

    public Carro() {
        this.modelo = "";
        this.placa = "";
        ano = 0;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }   
    
}
