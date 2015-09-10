package estruturas;

import cadastro.Carro;


public class Pilha<T> {
    public static class No<T>{
        T item;
        No prox;
    }
    
    private No topo;
    private int tamanho;
    
    public Pilha(){
        topo = null;
        tamanho = 0;
    }
    
    public int getTamanho(){
        return tamanho;
    }
    
    public void empilhar(T t){
        No aux = new No();
        aux.item = t;
        aux.prox = topo;
        topo = aux;
        tamanho++;
        
    }
    public T desempilha()throws Exception{
        if(topo == null) 
          throw new Exception("ERRO: a pilha está vazia");
        No aux = topo;
        topo = topo.prox;
        tamanho--;
        return (T) aux.item;
    }
}
