package cadastro;

import java.time.LocalDateTime;

import estruturas.Filas;
import estruturas.ListaCliente;
import estruturas.PilhaCarro;



public class Estacionamento {
	private int numeroFilas;
	private int numeroCarrosPorFila;
	private double taxaPorHora;
	private Filas filas;
	private ListaCliente listaClientes;
	private PilhaCarro pilhaCarros;
	
	public Estacionamento(int numeroFilas,int numeroCarrosPorFila, double taxaPorHora){
		this.numeroFilas = numeroFilas;
		this.numeroCarrosPorFila = numeroCarrosPorFila;
		this.taxaPorHora = taxaPorHora;
		pilhaCarros = new PilhaCarro();
		filas = new Filas();
	}
	
	/**
	 * 
	 * @return int - O maximo de carros que podem ser inseridos no estacionamento
	 */
	public int lotacaoMaxima(){
		return (((numeroFilas - 1) *numeroCarrosPorFila)+1);
	}
	/**	
	 * 
	 * @return boolean - se tem vagas livres no estacionamento
	 */
	public boolean temVaga(){
		int vagasOcupadas = pilhaCarros.getTamanho() * filas.getTamanho();
		if(vagasOcupadas < lotacaoMaxima()){
			return true;
		}
			return false;
	}
	/**
	 * @param Carro - o carro retirado sera passado por parametro para 
	 * @return double- valor a ser cobrado por hora no estacionamento
	 */
	public double valorCobrado(LocalDateTime horaEntrada){
		// ainda não foi feito pois  variavel de data e hora tem que ser alterada seu tipo
		return 0;
	}
	/**
	 *@return String - indicando a posicao do estacionamento que foi inserida
	 * @param carro - o objeto carro que sera inserido no estacionamento
	 */
	public String inserir(Carro carro){
		if(pilhaCarros.getTamanho() < numeroCarrosPorFila){
			pilhaCarros.empilhar(carro);
		}
		else{
			filas.inserir(pilhaCarros);
			pilhaCarros = new PilhaCarro();
		}
		return verificaMelhorPosicao();
	}
	/**
	 * 
	 * @param carro -  objeto carro que sera removido do estacionamento
	 * @return String - movimentações que o manobrista deve fazer para retirar o carro
	 */
	public String remover(Carro carro){
		return null;
	}
	/**
	 * troca a taxa por hora inserida inicialmente por uma nova
	 * @param novaTaxa - nova taxa cobrada por hora
	 */
	public void alterarTaxa(double novaTaxa){
		taxaPorHora = novaTaxa;
	}
	/**
	 * metodo verifica qual a melhor posicao para inserir o carro
	 * @return String - com melhor posicao
	 */
	public String verificaMelhorPosicao(){
		return ((pilhaCarros.gerPos()+1) + (filas.getLetraFila()+1));
	}
	/**
	 * metodo grava o os clientes em um arquivo
	 */
	public void gerarRelatorioCliente(){
		
	}
	/**
	 * metodo grava os carros que sairam em um arquivo
	 */
	public void gerarRelatorioCarros(){
		
	}
	/**
	 * grava os lucros do dia em um arquivo
	 *
	 */
	public void gerarRelatorioLucros(){
		
	}
	
}
