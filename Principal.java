package principal;

import cadastro.Carro;
import cadastro.Cliente;
import estruturas.Lista;
import estruturas.Pilha;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erikson
 */
public class Principal {
    public static void main(String agrs[]){
        boolean sair = false;
        Scanner teclado = new Scanner(System.in);
        Lista cadastros = new Lista();
        Pilha pilhaCarros = new Pilha();
        while(sair != true){
            System.out.print("Digite 1 para inserir carro\n"
                             + "Digite 2 para consultar clientes\n"
                             + "Digite 3 para remover carro\n"
                             + "Digite 4 para alterar valor cobrado por hora\n"
                             + "Digite 5 gerar relatório de clientes\n"
                             + "Digite 6 relatório de carros da garagem\n"
                             + "Digite 7 relatório de lucros\n"
                             + "Digite 8 para sair\n"
                             + "Digite: ");
            int opc = teclado.nextInt();
            switch(opc){
                case 1:
                    Cliente cliente = new Cliente();
                    Carro carro = new Carro();
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
                    cliente.setCarro(carro);
                    cadastros.inserirOrdenado(cliente);
                    pilhaCarros.empilhar(carro);
                    }catch(NumberFormatException e){
                    	System.out.println("Erro no digito informado");
                    }
                    break;
                    
                case 2:
                    cadastros.imprime();
                    break;
                
                case 3:
            {
                try {
                    pilhaCarros.desempilha();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
                    break;
                case 4:
                    
            }       
        }
        
    }
}
