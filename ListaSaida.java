package estruturas;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locapackage estruturas;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import cadastro.Carro;
import estruturas.Filas.No;

public class ListaSaida {
	public static class No{
		public Carro item;
		public No prox;
		// quando for criado o No da Lista de saida sera inserido a Data e hora que foi criado
		public LocalDateTime horaSaida; 
		// quando for criado o No da Lista de saida o No receberá o valor a que o cliente pagou para retirar o carro
		public double valorPago;
		// quando for criado o No da Lista de saida mostrara onde foi inserido
		public String posicao;
		// criara um novo no da fila 
		public Filas.No fila;
		// mostra os passo feitos para remover
		public String passos;
	}
	private No primeiro;
	private No ultimo;
	
	public ListaSaida(){
		 primeiro = new No();
	     primeiro.prox = null;
	     ultimo = primeiro;
	}
	/**
	 * metodo insere os carros em uma lista de saida
	 * @param carro - carros que sairam
	 * @param valorpago valor que pagaram
	 */
	public void inserir(Carro carro, double valorpago){
        LocalDateTime hora = LocalDateTime.now(ZoneId.of("Brazil/East"));
		ultimo.prox = new No();
        ultimo = this.ultimo.prox;
        ultimo.item = carro;
        ultimo.horaSaida = hora;
        ultimo.valorPago = valorpago;
        ultimo.prox = null;
    }
}
le;

import cadastro.Carro;
import estruturas.Filas.No;

public class ListaSaida {
	public static class No{
		Carro item;
		No prox;
		LocalDateTime horaSaida;
		double valorPago;
	}
	private No primeiro;
	private No ultimo;
	
	public ListaSaida(){
		 primeiro = new No();
	     primeiro.prox = null;
	     ultimo = primeiro;
	}
	/**
	 * metodo insere os carros em uma lista de saida
	 * @param carro - carros que sairam
	 * @param valorpago valor que pagaram
	 */
	public void inserir(Carro carro, double valorpago){
        LocalDateTime hora = LocalDateTime.now(ZoneId.of("Brazil/East"));
		ultimo.prox = new No();
        ultimo = this.ultimo.prox;
        ultimo.item = carro;
        ultimo.horaSaida = hora;
        ultimo.valorPago = valorpago;
        ultimo.prox = null;
    }
}
