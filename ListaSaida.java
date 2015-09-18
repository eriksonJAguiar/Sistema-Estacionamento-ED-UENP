package estruturas;

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
