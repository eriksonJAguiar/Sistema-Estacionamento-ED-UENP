package principal;


import cadastro.Carro;
import cadastro.Cliente;
import cadastro.Estacionamento;
import estruturas.Filas;
import estruturas.ListaCliente;
import estruturas.PilhaCarro;

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
        
        System.out.println("Informe o Tamamanho do Estacionamento: ");
        System.out.print("Digite o numero de filas: ");
        int numeroFilas = teclado.nextInt();
        System.out.print("Digite o Numero de Carros por Fila: ");
        int numeroCarrosPorFila = teclado.nextInt();
        System.out.print("Informe a Taxa Cobrada por hora :");
        double taxaPorHora = teclado.nextDouble();
        Estacionamento estacionamento = new Estacionamento(numeroFilas, numeroCarrosPorFila, taxaPorHora);
        System.out.println("--------------------------------------------------------------------------");
        
        while(sair != true){
        	
        	if(estacionamento.temVaga() == false){
        		System.out.println("Estacionamento cheio ! Não é Possivel Inserir mais Carros");
        	}
        	
            System.out.print("Digite 1 para Cadastrar Cliente\n"
                             + "Digite 2 Inserir um Carro\n"
                             + "Digite 3 para Remover Carro\n"
                             + "Digite 4 para Alterar Valor Cobrado por Hora\n" 
                             + "Digite 5 para Ver Situacao da Garagem\n"
                             + "Digite 6 gerar relatório de clientes\n"
                             + "Digite 7 relatório de carros da garagem\n"
                             + "Digite 8 relatório de lucros\n"
                             + "Digite 9 para sair\n"
                             + "Digite: ");
            int opc = teclado.nextInt();
            switch(opc){
                case 1:
                	// obs falta indentificar se o usuário já existe 
                	carro = new Carro();
                	cliente = new Cliente();
                    try{
                    System.out.println("Informe o Nome do Cliente: ");
                    String nome = teclado.next();
                    teclado.nextLine();
                    cliente.setNome(nome);
                    System.out.println("Informe o cpf: ");
                    cliente.setCpf(Long.parseLong(teclado.nextLine()));
                    System.out.println("Informe o modelo do carro: ");
                    carro.setModelo(teclado.nextLine());
                    System.out.println("Informe o ano do carro: ");
                    carro.setAno(Integer.parseInt(teclado.nextLine()));
                    System.out.println("Infome a placa do carro: ");
                    carro.setPlaca(teclado.nextLine());
                    System.out.println("Informe as observacoes: ");
                    String obs = teclado.next();
                    teclado.nextLine();
                    carro.setObservacoes(obs);
                    carro.setCliente(cliente);
                    
                    }catch(NumberFormatException e){
                    	System.out.println("Erro no digito informado");
                    }
                    catch(Exception ex){
                    	System.out.println("Erro :" + ex);
                    }
                    break;
                    
                case 2:
                    try{
                	estacionamento.inserir(carro);
                	System.out.println("Carro Estacionado com sucesso");
                	//tera que retornar a posição que foi inserido, ainda falta esse detalhe
                    }catch(Exception ex){
                    	System.out.println("Erro : "+ex);
                    }
                    break;
                
                case 3:
                	// na retirada do carro poderei consultar o por placa, por nome e irei calcular o valor a ser pago
                    //falta construir esse método que irá mostrar os passos para o manobrista ;
                    break;
                case 4:
                	try{
                	double novaTaxa = teclado.nextDouble();
                    estacionamento.alterarTaxa(novaTaxa);
                	}catch(NumberFormatException e){
                		System.out.println("O Erro no digito inserido");
                	}
                	catch(Exception ex){
                		System.out.println("Erro: "+ex);
                	}
                	break;
                case 5:
                	// ver situação da garagem ainda precisa ser implementado
                	break;
                case 6:	
                	// irá gerar os relatorio de carros e grava em um arquivo
                	// porem ainda não está implementado
                	estacionamento.gerarRelatorioCarros();
                	break;
                case 7:
                	// irá gerar os relatorio de clientes e grava em um arquivo
                	// porem ainda não está implementado
                	estacionamento.gerarRelatorioCliente();
                	break;
                case 8:
                	// irá gerar os relatorio de luros do dia e grava em um arquivo
                	// porem ainda não está implementado
                	estacionamento.gerarRelatorioLucros();
                	break;
                case 9:
                	sair  = true;
                	break;
                default :
                	System.out.println("Opcao Nao Encontrada, Por Favor Digite Novamente");
                	break;
            }          
        }
        
    }
}
