package estruturas;

import cadastro.Cliente;




public class Lista{
    public static class No{
        Cliente item;
        No prox;
    }
    
    private No primeiro;
    private No ultimo;
    private int tamanho;
    
    public Lista(){
        primeiro = new No();
        primeiro.prox = null;
        ultimo = primeiro;
        tamanho = 0;
    }
    public void inserirUltimo(Cliente cliente){
        ultimo.prox = new No();
        ultimo = this.ultimo.prox;
        ultimo.item = cliente;
        ultimo.prox = null;
        tamanho++;
    }
    public void inserirPrimeiro(Cliente cliente){
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
    public Cliente remover(long cpf){
        No aux = primeiro;
        int pos = 0;
        while(aux.prox != null && aux.prox.item.getCpf() != cpf){
                 pos++;
                 aux = aux.prox;
        }
         if(pos == 0){
                No dado = primeiro.prox;
                aux = primeiro.prox;
                primeiro.prox = primeiro.prox.prox;
                aux.prox = null;
                 tamanho--;
            
                return dado.item;   
                }
                else if(aux.prox == null){
                Cliente dado = ultimo.item;
                ultimo = aux;
                aux.prox = null;
                ultimo.prox = null;
                tamanho--;
                return dado;
                }
                else{
                No aux2 = aux.prox;
                aux.prox = aux.prox.prox;
                Cliente dado = aux2.item;
                aux2.prox = null;
                tamanho--;
                return dado;
                }
       
    }
    public void imprime(){
        No aux = primeiro.prox;
        while(aux != null){
            System.out.println(aux.item.getNome());
            aux = aux.prox;
        }
    }
    public int getTamanho(){
        return tamanho;
    }
}
