package estruturas;

import java.util.ArrayList;


public class Lista<T extends NomeLista> {
    public static class No<T extends NomeLista>{
        T item;
        No prox;
    }
    
    private No primeiro;
    private No ultimo;
    
    public Lista(){
        primeiro = new No();
        primeiro.prox = null;
        ultimo = primeiro;
    }
    public void inserir(T t){
        ultimo.prox = new No();
        ultimo = this.ultimo.prox;
        ultimo.item = t;
        ultimo.prox = null;
    }
    
    public void inserirOrdenado(T t){
        if(primeiro == ultimo){
            inserir(t);
            return;
        }
        else{
            No aux = primeiro;
            
             int val = 0;
            while(aux.prox != null && val <= 0 ){
                
               val = aux.prox.item.getNome().compareToIgnoreCase(t.getNome());
                
                aux  = aux.prox;
                
            }
            if(val > 0){ /* falta arrumar essa parte */
               No novo = new No();
               aux.prox = novo;
               novo.item = t;
               novo = aux.prox;
               
            }
            else{
                inserir(t);
            }
           
        }
        
    }
    public void imprime(){
        No aux = primeiro.prox;
        while(aux != null){
            T t =  (T) aux.item;
            System.out.println(t.getNome());
            aux = aux.prox;
        }
    }
}
