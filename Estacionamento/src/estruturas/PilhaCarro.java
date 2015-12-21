package estruturas;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import cadastro.Carro;
import estruturas.ListaCliente.No;


public class PilhaCarro{
    public static class No{
       public Carro item;
       public No prox;
       public int pos; //posicao da pilha que o no representa
        
    }
    
    private No topo;
    private int tamanho;
    	
    
    public PilhaCarro(){
        topo = null;
        tamanho = 0;
    }
    /**
     * @return int - indicando a posicao que foi inserido na pilha
     */
    public int getTamanho(){
        return tamanho;
    }
    /** 
     * @return No - que e relacionado ao Topo
     */
    public No getTopo()
    {
    	return topo;
    }
    /**
     * @param carro - carro que sera empilhado
     */
    public void empilhar(Carro carro){
        No aux = new No();
        aux.item = carro;
        aux.prox = topo;
        aux.pos = ++tamanho;
        topo = aux;
    }
    /**
     * @return Carro - desempilhado
     */
    public Carro desempilha(){
        if(topo == null) 
          return null;
        
        No aux = topo;
        if(topo.prox != null)
        	topo = topo.prox;
        else
        	topo = null;
        tamanho--;
        return aux.item;
    }
    /**
     * busca o placa e retorna um no da pilha
     * @param placa
     * @return No da ListaSaida
     */
   
    public estruturas.ListaSaida.No buscarPlaca(String placa){
        No aux = topo;
        while(aux != null)
        {
            if(aux.item.getPlaca().equalsIgnoreCase(placa))
            {
            	estruturas.ListaSaida.No no = new estruturas.ListaSaida.No();
            	no.item = aux.item;
            	no.posicao = String.valueOf(aux.pos);
            	no.horaSaida = LocalDateTime.now(ZoneId.of("Brazil/East"));
            	return no;
            }
        	aux = aux.prox;
        }
        return null;
    }
    /**
     * busca o placa e retorna um no da pilha
     * @param nome
     * @return No da ListaSaida
     */
    public estruturas.ListaSaida.No buscarNome(String nome){
        No aux = topo;
        while(aux != null)
        {
            if(aux.item.getCliente().getNome().equalsIgnoreCase(nome))
            {
            	estruturas.ListaSaida.No no = new estruturas.ListaSaida.No();
            	no.item = aux.item;
            	no.posicao = String.valueOf(aux.pos);
            	no.horaSaida = LocalDateTime.now(ZoneId.of("Brazil/East"));
            	return no;
            }
        	aux = aux.prox;
        }
        return null;
    }
    
   
}
