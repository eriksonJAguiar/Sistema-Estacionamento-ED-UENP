package cadastro;

import estruturas.Filas;
import estruturas.ListaCliente;



public class Estacionamento {
	private int numeroFilas;
	private int numeroCarrosPorFila;
	private double taxaPorHora;
	private Filas filas;
	private ListaCliente listaClientes;
	
	public Estacionamento(int numeroFilas,int numeroCarrosPorFila, double taxaPorHora){
		this.numeroFilas = numeroFilas;
		this.numeroCarrosPorFila = numeroCarrosPorFila;
		this.taxaPorHora = taxaPorHora;
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
		return false;
	}
	/**
	 * 
	 * @return double- valor a ser cobrado por hora no estacionamento
	 */
	public double valorCobrado(){
		return 0;
	}
	/**
	 *
	 * @param carro - o objeto carro que sera inserido no estacionamento
	 */
	public void inserir(Carro carro){
		
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
		return null;
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
