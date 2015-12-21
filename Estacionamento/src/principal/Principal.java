package principal;


import cadastro.Carro;
import cadastro.Cliente;
import cadastro.Estacionamento;
import estruturas.Filas;
import estruturas.ListaCliente;
import estruturas.ListaSaida.No;
import estruturas.PilhaCarro;

import java.time.format.DateTimeFormatter;
//
//import java.time.format.DateTimeFormatter;
//import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author erikson
 */
public class Principal {
    public static void main(String agrs[]){
        boolean sair = false; 
        Scanner teclado = new Scanner(System.in);
        ListaCliente cadastrosCliente = new ListaCliente();
        Carro carro = new Carro();
        Cliente cliente = new Cliente();
        String log = new String();
        
        System.out.println(" ------------------------------------------------ ");
        System.out.println("| Informe o Tamanho do Estacionamento;");
        System.out.print("| Digite o numero de filas --> ");
        int numeroFilas = teclado.nextInt();
        System.out.print("| Digite o Numero de Carros por Fila --> ");
        int numeroCarrosPorFila = teclado.nextInt();
        System.out.print("| Informe a Taxa Cobrada por hora --> ");
        double taxaPorHora = teclado.nextDouble();
        Estacionamento estacionamento = new Estacionamento(numeroFilas, numeroCarrosPorFila, taxaPorHora);
        System.out.println(" ------------------------------------------------ ");
        while(!sair){
        	
        	System.out.println(" ------------------------------------------------ ");
            System.out.print("| 1 Inserir um Carro\n"
                             + "| 2 para Remover Carro\n"
                             + "| 3 para Alterar Valor Cobrado por Hora\n" 
                             + "| 4 para Ver Situacao da Garagem\n"
                             + "| 5 para sair\n"
                             + "| Digite uma opcao --> ");
            int opc = 0;
            
            try
            {
            	opc = teclado.nextInt();
            }
            catch(Exception ex)
            {
            	opc = 0;
            	teclado.next();
            }
            System.out.println(" ------------------------------------------------ ");
            switch(opc){
                case 1:
                	if(!estacionamento.temVaga()){
    	        		System.out.println("Estacionamento cheio ! Nao foi Possivel Inserir mais Carros");
    	        		break;
    	        	}
                	
                	carro = new Carro();
                	cliente = new Cliente();
                	boolean digitoCorreto = false;
                
               // caso o usurário iserir um valor que gere exceção a mensagem para digitar novamente é inserida	
				while (!digitoCorreto) {
					try {
						System.out.print("| Informe o Nome do Cliente --> ");
						String nome = teclado.next();
						teclado.nextLine();
						cliente.setNome(nome);
						System.out.print("| Informe o cpf --> ");
						cliente.setCpf(Long.parseLong(teclado.nextLine()));
						estacionamento.verificarCliente(cliente.getNome(),
								cliente.getCpf());

						System.out.print("| Informe o modelo do carro --> ");
						carro.setModelo(teclado.nextLine());
						System.out.print("| Informe o ano do carro --> ");
						carro.setAno(Integer.parseInt(teclado.nextLine()));
						System.out.print("| Infome a placa do carro --> ");
						carro.setPlaca(teclado.nextLine());
						System.out.print("| Informe as observacoes --> ");
						String obs = teclado.next();
						teclado.nextLine();
						carro.setObservacoes(obs);
						carro.setCliente(cliente);
						digitoCorreto = true;
					} catch (Exception ex) {
						System.out.println("Digito errado digite novamente");
					}
                	}
                	
                	
                	String vaga = estacionamento.inserir(carro, "");
                	System.out.println("| Carro Estacionado na vaga " + vaga);
                	
                	String cadastroCliente = "-------------------------------------------------------"+"\n"
    	                    				+ "NOME: "+ cliente.getNome() +"\n"
    	                    				+ "CPF: "+cliente.getCpf()+"\n"
                							+"-------------------------------------------------------"+"\n";
                	//gera relatorio de clientes que foram inseridos
                	estacionamento.gerarRelatorioCliente(cadastroCliente);
                    
                	break;
                
                case 2:
				carro = new Carro();
				
				// o while volta caso o usuario inserir uma opção errada ou seja insira o try catch nessa e faça o metodo de inserir 
				int opcao = 0;
				digitoCorreto = false;
				while (digitoCorreto != true) {
					System.out.println("| 1 para remover por placa"+"\n" 
									  +"| 2 para remover por nome"+"\n"
									  +"| Digite uma opcao --> ");
					
					opcao = teclado.nextInt();
					switch (opcao) {
					case 1:
						System.out.print("| Infome a placa do carro --> ");
						carro.setPlaca(teclado.next());
						teclado.nextLine();
						digitoCorreto = true;
						break;
					case 2:
						System.out.print("| Infome o nome do Cliente --> ");
						carro.getCliente().setNome(teclado.next());
						carro.setPlaca(null);
						teclado.nextLine();
						digitoCorreto = true;
						break;
					default:
						System.out.print("| Digito invalido --> ");
						teclado.next();
					}
				}
					estruturas.ListaSaida.No no = estacionamento.removerCarro(carro);
                    
				String consulta = new String();
				if (opcao == 1)
					consulta = "Placa nao encontrada";
				else if (opcao == 2)
					consulta = "Nome nao encontrado";
				
                    if(no != null)
                    {
                    	// insere o lucro do dia no log, caso sair do programa gera os lucros
                    	log = estacionamento.lucroDia(no.valorPago, no.horaSaida);
                    	
                    	
                    	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy"+" "+"HH:mm:ss");
                    	Carro car = no.item;
                    	consulta = "-------------------------------------------------------"+"\n"
        	                    + "NOME: "+car.getCliente().getNome()+"\n"
        	                    + "CPF: "+car.getCliente().getCpf()+"\n"
        	                    + "MODELO CARRO: "+car.getModelo()+"\n"
        	                    + "ANO CARRO: "+ car.getAno()+"\n"
        	                    + "PLACA DO CARRO: "+car.getPlaca()+"\n"
        	                    +"OBSERVACOES: "+car.getObservacoes()+"\n"
        	                    + "HORARIO DE ENTRADA: "+ car.gethoraEntrada().format(formatador) +"\n"
        	                    + "HORARIO DE SAIDA: "+ no.horaSaida.format(formatador) +"\n"
        	                    + "VALOR PAGO: "+ no.valorPago +"\n"
        	                    + "POSI��O: "+ no.posicao +"\n"
     	                    + "----------------------------------------------------------"+"\n";
                    	
                    	// grava no arquivo os carros que sairam recebendo consulta como parametro
                    	estacionamento.gerarRelatorioCarros(consulta);
                        
                    	System.out.println(no.passos);
                    }
                    System.out.println(consulta);
                    break;
                case 3:
                	System.out.print("| Informe a nova taxa a ser cobrada --> ");
                	double novaTaxa = teclado.nextDouble();
                    estacionamento.alterarTaxa(novaTaxa);
                	break;
                case 4: 
                	System.out.println("| Situacao Atual");
                	System.out.println(estacionamento.situacaoAtual());
                	break;
                case 5:
                	sair  = true;
                	estacionamento.gerarRelatorioLucros(log); // gera o aquivo de lucros do dia 
                	System.out.println("Programa Finalizado !");
                	break;
                default :
                	System.out.println("Opcao Nao Encontrada, Por Favor Digite Novamente");
                	break;
            }          
        }
        
    }
}
