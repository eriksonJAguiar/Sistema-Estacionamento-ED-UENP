package estruturas;

import cadastro.Cliente;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;




public class ListaCliente{
    public static class No{
        Cliente item;
        No prox;
    }
    
    private No primeiro;
    private No ultimo;
    private int tamanho;
    
    public  ListaCliente(){
        primeiro = new No();
        primeiro.prox = null;
        ultimo = primeiro;
        tamanho = 0;
    }
    /**
     * metodo auxilia o inserirOrdenado
     * @param cliente - cliente Inserido
     */
    private void inserirUltimo(Cliente cliente){
        ultimo.prox = new No();
        ultimo = this.ultimo.prox;
        ultimo.item = cliente;
        ultimo.prox = null;
        tamanho++;
    }
    /**
     * metodo auxilia o inserirOrdenado
     * @param cliente - cliente Inserido
     */
    private void inserirPrimeiro(Cliente cliente){
        if(tamanho == 0){
             No novo = new No();
            novo.item = cliente;
            primeiro.prox = novo;
            ultimo = novo;
            ultimo.prox = null;
            tamanho++;
        }
        else{
            No novo = new No();
            novo.item = cliente;
            novo.prox = primeiro.prox;
            primeiro.prox = novo;
            tamanho++;
        }
       
        
    }
    /**
     * metodo cadastra o cliente em uma lista de forma ordenada por nome
     * @param cliente - cliente que sera cadastrado
     */
    public void inserirOrdenado(Cliente cliente){
        if(primeiro == ultimo){
            inserirPrimeiro(cliente);
            return;
        }
        else{
            No aux = primeiro;
            No aux2 = primeiro;
            int val = 0;
            while(aux.prox != null && val <= 0){
                
               val = aux.prox.item.getNome().compareToIgnoreCase(cliente.getNome());
               aux2 = aux;
               aux  = aux.prox;
                
            }
             if(val > 0){
               No novo = new No();
               novo.item = cliente;
               novo.prox = aux;
               aux2.prox = novo;
               tamanho++;
             }
             else{
                 inserirUltimo(cliente);
             }
        }
        
    }
    /**
     * metodo prucura um cliente pelo cpf 
     * @param cpf - cpf procurado
     * @return achou 
     */
    public boolean possuiCliente(long cpf){
    	No aux = primeiro;
        boolean achou = false;
    	while(aux.prox != null){
            if(aux.prox.item.getCpf() == cpf){
            	achou = true;
            	return achou;
            }
            aux = aux.prox;
    	}
    	return achou;
    }
    public void imprime(){
        No aux = primeiro.prox;
        while(aux != null){
            System.out.println("-------------------------------------------------------"+"\n"
                             + "NOME: "+aux.item.getNome()+"\n"
                             + "CPF: "+aux.item.getCpf()+"\n"
                             + "----------------------------------------------------------"+"\n");
            aux = aux.prox;
        }
    }
}
