package estruturas;

import cadastro.Carro;



public class Filas{
	public static class No{
        PilhaCarro item;
        No prox;
    }
	private No primeiro;
    private No ultimo;
    private int tamanho;
    private String letra;
    private String alfabeto;
    
    public Filas(){
        primeiro = new No();
        primeiro.prox = null;
        ultimo = primeiro;
        tamanho = 0;
        alfabeto = "@";
    }
    /*public void inserirUltimo(PilhaCarro carros){

        ultimo.prox = new No();
        ultimo = this.ultimo.prox;
        ultimo.item = carros;
        ultimo.prox = null;
        tamanho++;
    }*/
    /**
     * metodo insere pilhas de carro em uma fila indentificando a posicao da fila com uma letra de "A" a "Z"
     * @param carros - pilha com varios carros
     */
    public void inserir(PilhaCarro carros){
        if(tamanho == 0){
             No novo = new No();
            novo.item = carros;
            primeiro.prox = novo;
            ultimo = novo;
            ultimo.prox = null;
            letra = alfabeto+1;
            tamanho++;
        }
        else{
            No novo = new No();
            novo.item = carros;
            novo.prox = primeiro.prox;
            primeiro.prox = novo;
            letra = alfabeto+1;
            tamanho++;
        }
    }
    /**
     * @throws se a pilha estiver vazia para desempilhar gera excecao
     * @return int - tamanho da fila
     */
    public int getTamanho(){
        return tamanho;
    }
    public String getLetraFila() {
		return letra;
	}
	/**
     * 
     * @param nome - procura pelo nome
     * @return String - com os dados do cliente 
     * @throws Exception - pilha vazia
     */
    public String consultarNome(String nome) throws Exception{
    	No aux = primeiro.prox;
    	while(aux != null){
    	Carro car =aux.prox.item.desempilha();
    	if(car.getCliente().getNome().equalsIgnoreCase(nome)){
   String consulta = "-------------------------------------------------------"+"\n"
                    + "NOME: "+car.getCliente().getNome()+"\n"
                    + "CPF: "+car.getCliente().getCpf()+"\n"
                    + "MODELO CARRO: "+car.getModelo()+"\n"
                    + "ANO CARRO: "+ car.getAno()+"\n"
                    + "PLACA DO CARRO: "+car.getPlaca()+"\n"
                    + "HORARIO DE ENTRADA: "+ car.gethoraEntrada()+"\n"
                    + "----------------------------------------------------------"+"\n";
   
   			return consulta;
    		}
    	}
    	return "Nome não encontrado";
    }
    /**
     * 
     @param placa - procura pela placa
     * @return String - com os dados do cliente 
     * @throws Exception - pilha vazia
     */
    public String consultarPlaca(String placa) throws Exception{
    	No aux = primeiro.prox;
    	while(aux != null){
    	Carro car = aux.prox.item.desempilha();
    	if(car.getPlaca().equalsIgnoreCase(placa)){
   String consulta = "-------------------------------------------------------"+"\n"
                    + "NOME: "+car.getCliente().getNome()+"\n"
                    + "CPF: "+car.getCliente().getCpf()+"\n"
                    + "MODELO CARRO: "+car.getModelo()+"\n"
                    + "ANO CARRO: "+ car.getAno()+"\n"
                    + "PLACA DO CARRO: "+car.getPlaca()+"\n"
                    + "HORARIO DE ENTRADA: "+ car.gethoraEntrada()+"\n"
                    + "----------------------------------------------------------"+"\n";
   
   			return consulta;
    		}
    	}
    	return "Placa não encontrada";
    }
}

