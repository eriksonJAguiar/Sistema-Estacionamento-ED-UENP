package estruturas;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import cadastro.Carro;
import estruturas.ListaCliente.No;


public class PilhaCarro{
    public static class No{
        Carro item;
        No prox;
    }
    
    private No topo;
    private int tamanho;
    
    public PilhaCarro(){
        topo = null;
        tamanho = 0;
    }
    
    public int getTamanho(){
        return tamanho;
    }
    /**
     * 
     * @param carro - carro que sera empilhado
     */
    public void empilhar(Carro carro){
        No aux = new No();
        aux.item = carro;
        aux.prox = topo;
        topo = aux;
        tamanho++;
        
    }
    /**
     * 
     * @return Carro - desempilhado
     * @throws Exception - se não tiver nenhum carro no estacionamento gera exceção
     */
    public Carro desempilha()throws Exception{
        if(topo == null) 
          throw new Exception("Nenhum Carro foi inserido");
        No aux = topo;
        topo = topo.prox;
        tamanho--;
        return (Carro) aux.item;
    }
    
   
}
