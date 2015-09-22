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
    private int pos;	
    
    public PilhaCarro(){
        topo = null;
        tamanho = 0;
    }
    /**
     * 
     * @return int - indicando a posicao que foi inserido na pilha
     */
    public int gerPos(){
    	return pos;
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
        pos = tamanho;
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
    /*public void imprime(){
        No aux = topo.prox;
        while(aux != null){
           DateTimeFormatter formatador = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("pt", "br"));
            System.out.println("-------------------------------------------------------"+"\n"
                             + "NOME: "+aux.item.getNome()+"\n"
                             + "CPF: "+aux.item.ggetCpf()+"\n"
                             + "MODELO CARRO: "+aux.item.getModelo()+"\n"
                             + "ANO CARRO: "+ aux.item.getAno()+"\n"
                             + "PLACA DO CARRO: "+aux.item.getPlaca()+"\n"
                             + "HORARIO DE ENTRADA: "+ aux.item.getData().format(formatador)+"\n"
                             + "----------------------------------------------------------"+"\n");
            aux = aux.prox;
        }*/
    
   
}
