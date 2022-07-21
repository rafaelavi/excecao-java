package exercicio;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcao = 1;

        while(opcao != 3){
            int opcaoMenu = obterOpcaoMenu(ler);

            if(opcaoMenu == 1){
                consultarContato(ler ,agenda);
            } else if (opcaoMenu == 2) {
                adicionarContato(ler, agenda);
            } else if (opcaoMenu == 3) {
                System.exit(0);
            }
        }
    }

    public static void adicionarContato(Scanner scan, Agenda agenda){
        try {
            System.out.println("Criando um contato, entre com as informações");
            String nome = leInformacaoString(scan,"Entre com o nome do contato");
            String telefone = leInformacaoString(scan,"Entre com o telefone do contato");
            String email = leInformacaoString(scan,"Entre com o email do contato");

            Contato contato = new Contato();
            contato.setNome(nome);
            contato.setTelefone(telefone);
            contato.setEmail(email);

            System.out.println("Contato a ser criado: ");
            System.out.println(contato);

            agenda.adiciona(contato);
        } catch (AgendaCheiaException e) {
            System.out.println(e.getMessage());

            System.out.println("Contatos da agenda");
            System.out.println(agenda);
        }
    }

    public static void consultarContato(Scanner scan, Agenda agenda){
        String nomeContato = leInformacaoString(scan, "Entre com o nome do contato a ser pesquisado: ");
        try {
            if(agenda.pesquisaPorNome(nomeContato) >= 0){
                System.out.println("Contato existe");
            }
        } catch (ContatoNaoExisteException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String leInformacaoString(Scanner scan, String msg){
        System.out.println(msg);
        String entrada = scan.nextLine();

        return entrada;
    }

    public static int obterOpcaoMenu(Scanner scan){
        boolean entradaValida = false;
        int opcao = 3;

        while(!entradaValida) {
            System.out.println("-- MENU --");
            System.out.println("1- consultar um contato na agenda");
            System.out.println("2- adicionar um contato na agenda");
            System.out.println("3- sair");
            System.out.println("---------------------------------");

            try {
                String entrada = scan.nextLine();
                opcao = Integer.parseInt(entrada);

                if(opcao ==1 || opcao == 2|| opcao == 3){
                    entradaValida = true;
                }else if(opcao !=1 || opcao != 2 || opcao != 3){
                    throw new Exception("Entrada inválida");
                }
            }catch (Exception e){
                System.out.println("Entrada inválida, digite novamente");
            }
        }

        return opcao;
    }
}
