package cadastro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import estruturas.Filas;
import estruturas.ListaCliente;
import estruturas.PilhaCarro;



public class Estacionamento {
	private int numeroFilas;
	private int numeroCarrosPorFila;
	private double taxaPorHora;
	private Filas filas;
	private ListaCliente listaClientes;
	private double lucro;

	
	public Estacionamento(int numeroFilas,int numeroCarrosPorFila, double taxaPorHora){
		this.numeroFilas = numeroFilas;
		this.numeroCarrosPorFila = numeroCarrosPorFila;
		this.taxaPorHora = taxaPorHora;
		filas = new Filas(numeroFilas);
		listaClientes = new ListaCliente();
		lucro = 0;
	}
																									
	/**
	 * 
	 * @return int - O maximo de carros que podem ser inseridos no estacionamento
	 */
	public int lotacaoMaxima(){
		return (((numeroFilas - 1) *numeroCarrosPorFila)+1);
	}
	/**	
	 * calcula qual o numero de vagas do estacionamento se for menor que a lotacao maxima tem vaga
	 * @return boolean - se tem vagas livres no estacionamento
	 */
	public boolean temVaga(){
		int vagasOcupadas = filas.getVagas();
		
		return vagasOcupadas < lotacaoMaxima();
	}
	/**
	 * @param Carro - o carro retirado sera passado por parametro
	 * @return double- valor a ser cobrado por hora no estacionamento
	 */
	public double valorCobrado(Carro carro){
		estruturas.ListaSaida.No no = filas.consultarPlaca(carro.getPlaca());
		
		Duration tempo = Duration.between(no.item.gethoraEntrada(), no.horaSaida);
		return tempo.getSeconds() * taxaPorHora;
		
	}
	/**
	 * verifica se o cliente existe 
	 * @param nome 
	 * @param cpf
	 */
	public void verificarCliente(String nome, long cpf)
	{
		if(!listaClientes.possuiCliente(cpf))
		{
			Cliente cliente = new Cliente(nome, cpf);
			listaClientes.inserirOrdenado(cliente);
		}
	}
	/**
	 * @return String - indicando a posicao do estacionamento que foi inserida
	 * @param carro - o objeto carro que sera inserido no estacionamento
	 * @throws Exception 
	 */
	public String inserir(Carro carro, String simboloExcluir){
		estruturas.Filas.No fila = filas.getMelhorPosicao(simboloExcluir);
		fila.item.empilhar(carro);
		return fila.simbolo + fila.item.getTamanho();
	}
	/**
	 * @param carro -  objeto carro que sera removido do estacionamento
	 * @return String - movimentações que o manobrista deve fazer para retirar o carro
	 */
	private estruturas.ListaSaida.No removerPlaca(Carro carro){
		estruturas.ListaSaida.No no = filas.consultarPlaca(carro.getPlaca());
		if(no == null)
			return null;
		
		no.valorPago = valorCobrado(carro);
		
		no.passos = "Carro " + carro.getPlaca() + " estacionado na posição "+ no.posicao + "\n"; 
		
		PilhaCarro.No aux = no.fila.item.getTopo();
		while(aux != null){
			
			if(aux.item.getPlaca().equals(carro.getPlaca())){
				no.fila.item.desempilha();
				break;
			}
			else
			{
				no.passos += "mover carro " + aux.item.getPlaca() + " da posição " + no.fila.simbolo + aux.pos + " para " + inserir(aux.item, no.fila.simbolo) + ";\n";
			}
			no.fila.item.desempilha();
			aux = aux.prox;
		}
		
		no.passos += "Remover carro " + carro.getPlaca() + " da posição "+ no.posicao + " e entregar para cliente\n";
		no.passos += "Entrega finalizada.\n";
		
		return no;
	}
	/**
	 * remove o carro pesquisando o nome do proprietario
	 * @param cliente
	 * @return No ListaSaida
	 */
	private estruturas.ListaSaida.No removerNome(Cliente cliente){
		estruturas.ListaSaida.No no = filas.consultarCNome(cliente.getNome());
		if(no == null)
			return null;
		
		no.valorPago = valorCobrado(no.item);
		
		no.passos = "Carro " + no.item.getPlaca() + " estacionado na posi��o "+ no.posicao + "\n"; 
		
		PilhaCarro.No aux = no.fila.item.getTopo();
		while(aux != null){
			
			if(aux.item.getPlaca().equals(no.item.getPlaca())){
				no.fila.item.desempilha();
				break;
			}
			else
			{
				no.passos += "mover carro " + aux.item.getPlaca() + " da posi��o " + no.fila.simbolo + aux.pos + " para " + inserir(aux.item, no.fila.simbolo) + ";\n";
			}
			no.fila.item.desempilha();
			aux = aux.prox;
		}
		
		no.passos += "Remover carro " + no.item.getPlaca() + " da posi��o "+ no.posicao + " e entregar para cliente\n";
		no.passos += "Entrega finalizada.\n";
		
		return no;
	}
	/**
	 * remove o carro independe do tipo de remocao seja por nome ou por placa
	 * @param carro
	 * @return
	 */
	public estruturas.ListaSaida.No removerCarro(Carro carro){
		if (carro.getPlaca() != null){
			return removerPlaca(carro);
		}else{
			return removerNome(carro.getCliente());
			
		}
		
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
	 * @throws Exception - pilha vazia
	 */
	public estruturas.Filas.No verificaMelhorPosicao(){
		return filas.getMelhorPosicao("");
	}
	/**
	 * 
	 * @param valor - valor que pagou
	 * @param horaSaida - hora que o carro saiu
	 * @return string - com o lucro do dia 
	 */
	public String lucroDia(double valor,LocalDateTime horaSaida){
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy"+" "+"HH:mm:ss");
		lucro += valor;
		return String.valueOf(lucro)+ "    " + String.valueOf(horaSaida.format(formatador));
	}
	/**
	 * metodo grava o os clientes em um arquivo     
	 */
	public void gerarRelatorioCliente(String log){
		 File arquivo = new File("ClientesCadastrados.log");        
	        try {
	        	BufferedWriter out = new BufferedWriter(new FileWriter(arquivo, true));
	            out.append(log);
	            out.append(System.lineSeparator());
	            
	            out.close();
	        } catch (IOException ex) {
	            System.out.println("Erro ao gerar relatorio");
	        }
	}

	/**
	 * metodo grava os carros que sairam em um arquivo
	 */
	public void gerarRelatorioCarros(String log){
		 File arquivo = new File("carrosSairam.log");        
	        try {
	        	BufferedWriter out = new BufferedWriter(new FileWriter(arquivo, true));
	            out.append(log);
	            out.append(System.lineSeparator());
	            
	            out.close();
	        } catch (IOException ex) {
	            System.out.println("Erro ao gerar relatorio");
	        }
	}

	/**
	 * grava os lucros do dia em um arquivo
	 * 
	 */
	public void gerarRelatorioLucros(String log) {
		File arquivo = new File("lucroDia.log");
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(arquivo,
					true));
			out.append(log);
			out.append(System.lineSeparator());

			out.close();
		} catch (IOException ex) {
			System.out.println("Erro ao gerar relatorio");
		}

	}
	/**
	 * @return String - com a situacao da garagem
	 */
	public String situacaoAtual(){
		String situacao = "Total de Vagas Ocupadas: "+filas.getVagas()+"\n";
		situacao += "Vagas Desocupadas: "+(lotacaoMaxima()- filas.getVagas()) +"\n";
		
		return situacao;
	}
}
