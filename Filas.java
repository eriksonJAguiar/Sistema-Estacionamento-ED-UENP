package estruturas;



public class Filas{
	public static class No{
        PilhaCarro item;
        No prox;
        String letra;
    }
	private No primeiro;
    private No ultimo;
    private int tamanho;
    private String letraFila;
    
    public Filas(){
        primeiro = new No();
        primeiro.prox = null;
        ultimo = primeiro;
        tamanho = 0;
        letraFila = "@";
    }
    /*public void inserirUltimo(PilhaCarro carros){

        ultimo.prox = new No();
        ultimo = this.ultimo.prox;
        ultimo.item = carros;
        ultimo.prox = null;
        tamanho++;
    }*/
    /**
     * metodo insere pilhas de carro em uma fila indentificando a posição da fila com uma letra de "A" à "Z"
     * @param carros - pilha com varios carros
     */
    public void inserir(PilhaCarro carros){
        if(tamanho == 0){
             No novo = new No();
            novo.item = carros;
            primeiro.prox = novo;
            ultimo = novo;
            ultimo.prox = null;
            novo.letra = letraFila+1;
            tamanho++;
        }
        else{
            No novo = new No();
            novo.item = carros;
            novo.prox = primeiro.prox;
            primeiro.prox = novo;
            novo.letra = letraFila+1;
            tamanho++;
        }
    }
    /**
     * 
     * @return int - tamanho da fila
     */
    public int getTamanho(){
        return tamanho;
    }
   
}
