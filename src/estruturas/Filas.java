package estruturas;

import cadastro.Carro;
import cadastro.Estacionamento;
import estruturas.PilhaCarro.No;

public class Filas {
	public class No {
		public PilhaCarro item;
		public No prox;
		public String simbolo; // posicao da lista que o no representa
	}

	private No primeiro;
	private No ultimo;
	private int tamanho;

	public Filas(int numeroFilas) {
		primeiro = new No();
		primeiro.prox = null;
		primeiro.item = new PilhaCarro();
		primeiro.simbolo = "A"; // o primeiro no recebe o A como nome 
		ultimo = primeiro;

		// insere os simbolos no No quando a filas são criadas 
		for (int x = 2; x <= numeroFilas; x++) {
			No aux = new No();
			aux.item = new PilhaCarro();
			aux.simbolo = Character.toString((char) (x + 64));// insere o valor de x que contará de 2 ate o numero de filas + 64 que representamos na tabela ASCII
			ultimo.prox = aux;
			ultimo = aux;
		}
	}
	/**
	 * insere na ultima posição, serve como referencia para o metodo insereOrdenado
	 * @param carros 
	 */
	private void inserirUltimo(PilhaCarro carros) {
		ultimo.prox = new No();
		ultimo = this.ultimo.prox;
		ultimo.item = carros;
		ultimo.prox = null;
		tamanho++;
	}
	/**
	 * 
	 * @param simboloExcluir - passa como referencia o simbolo que foi excluido, pois naquela posicao nao podera sera melhor
	 * @return No - com a melhor posicao
	 */
	public No getMelhorPosicao(String simboloExcluir) {
		No aux = primeiro;
		No aux2 = aux;

		if (aux.simbolo.equals(simboloExcluir))
			aux = aux2 = aux.prox;

		while (aux != null) {
			if (aux.simbolo.equals(simboloExcluir)) {
				aux = aux.prox;
				continue;
			}

			if (aux.item.getTamanho() < aux2.item.getTamanho())
				aux2 = aux;
			aux = aux.prox;
		}
		;

		return aux2;
	}
	/**
	 * pesquisa quantas vagas ocupadas tem 
	 * @return int - vagas ocupadas
	 */
	public int getVagas() {
		No aux = primeiro;
		int vagas = 0;

		do {
			vagas += aux.item.getTamanho();
			aux = aux.prox;
		} while (aux != null);

		return vagas;
	}

	/**
	 * metodo insere pilhas de carro em uma fila indentificando a posicao da fila com uma letra de "A" a "Z"
	 *  @param carros - pilha com varios carros
	 */
	public void inserir(PilhaCarro carros) {
		if (tamanho == 0) {
			No novo = new No();
			novo.item = carros;
			primeiro.prox = novo;
			ultimo = novo;
			ultimo.prox = null;

			tamanho++;
		} else {
			No novo = new No();
			novo.item = carros;
			novo.prox = primeiro.prox;
			primeiro.prox = novo;
			tamanho++;
		}
	}

	/**
	 * metodo remove a ultima pilha da lista de carros
	 * @return PilhaCarro - se a lista estiver vazia não remove
	 */
	public PilhaCarro removeUltimo() {
		if (primeiro == ultimo) {
			return null;
		}
		No aux = primeiro;
		int pos = 0;
		while (aux.prox != null) {
			pos++;
			aux = aux.prox;
		}
		PilhaCarro dado = ultimo.item;
		ultimo = aux;
		aux.prox = null;
		ultimo.prox = null;
		tamanho--;
		return dado;
	}

	/**
	 * @return int - tamanho da fila
	 */
	public int getTamanho() {
		return tamanho;
	}

	/**
	 * 
	 * @param nome - procura pelo nome
	 * @return String - com os dados do cliente
	 */
	public String consultarNome(String nome){
		No aux = primeiro.prox;
		while (aux != null) {
			Carro car = aux.prox.item.desempilha();
			if (car.getCliente().getNome().equalsIgnoreCase(nome)) {
	String consulta = "-------------------------------------------------------"+"\n"
                    + "NOME: "+car.getCliente().getNome()+"\n"
                    + "CPF: "+car.getCliente().getCpf()+"\n"
                    + "MODELO CARRO: "+car.getModelo()+"\n"
                    + "ANO CARRO: "+ car.getAno()+"\n"
                    + "PLACA DO CARRO: "+car.getPlaca()+"\n"
                    + "HORARIO DE ENTRADA: "+ car.gethoraEntrada()+"\n"
                    + "--------------------------------------------------------"+"\n";
   
   			return consulta;
    		}
    	}
    	return "Nome não encontrado";
    }
    /**
     * consulta por placa
     * @param placa- placa que serve como referencia 
     * @return NoLista - que contem o No consultado
     */
    public estruturas.ListaSaida.No consultarPlaca(String placa){
		No aux = primeiro;
		do {
			estruturas.ListaSaida.No no = aux.item.buscarPlaca(placa);
			if (no != null) {
				no.posicao = aux.simbolo + no.posicao;
				no.fila = aux;
				return no;
			}
			aux = aux.prox;
		} while (aux != null);
		return null;
	}
    /**
     * pega o nome como parametro para pesquisar um No da Lista de Saida de carros
     * @param nome
     * @return No ListaSaia - o retorno é uma nó da lista de saída
     */
    public estruturas.ListaSaida.No consultarCNome(String nome){
		No aux = primeiro;
		do {
			estruturas.ListaSaida.No no = aux.item.buscarNome(nome);
			if (no != null) {
				no.posicao = aux.simbolo + no.posicao;
				no.fila = aux;
				return no;
			}
			aux = aux.prox;
		} while (aux != null);
		return null;
	}
}

