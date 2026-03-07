package org.example;
import org.example.dados.DadosUsuario;
import java.util.Scanner;
import java.util.InputMismatchException;

public class OperacaoUsuario {
    Scanner sc = new Scanner(System.in);
    Verificacoes verificar = new Verificacoes();
    Utilidades util = new Utilidades();
    ExibirMenus print;
    AtualizarUsuario atualizar;
    //    Outras classes
    public void setMenu(ExibirMenus print){
        this.print = print;
    }
    public void setAtualizar(AtualizarUsuario atualizar){
        this.atualizar = atualizar;
    }

    public void iniciar(){
        DadosUsuario.usuario.add(new Funcionario("Admin", "000000000000", 1, "100", 1000));
        DadosUsuario.usuario.add(new Cliente("Cliente", "11111111111", "85856460", "Rua avenida", 570, "Panorama", "45998557442"));
        print.printUsarios();
        System.out.println("--Usuarios--");
        System.out.println("1 - Novo cadastro");
        System.out.println("2 - Atualizar ");
        System.out.println("3 - Relatorio");
        System.out.println("0 - Voltar");
        int op;
        while(true){
            if(sc.hasNextInt()){
                op = sc.nextInt();
                break;
            }
            else{
                System.out.println("Digite algo valido!!!");
                limparBuffer();
            }
        }
        limparBuffer();
        switch (op){
            case 1:
                novo();
                break;
            case 2:
                atualizar.iniciar();
                break;
            case 3:
                relatoriosUsuarios();
                break;
            case 0:
                /*Volta ao menu*/
                break;
            default:
                System.out.println("Escolha uma opcao valida!!");
        }
    }

    public void novo(){
        System.out.println("--Novo--");
        String nome;
        String cpf;
        System.out.println("Digite o Nome: ");
        nome = sc.nextLine();
        System.out.println("Digite o CPF: ");
        cpf = sc.nextLine();
        for (int i = 0; i < DadosUsuario.usuario.size(); i++) {
            if (DadosUsuario.usuario.get(i).getCpf().equals(cpf)){
                System.out.println("Erro!! Cpf já cadastrado");
            }
        }
        System.out.println("--Novo--");
        System.out.println("1 - Cliente");
        System.out.println("2 - Funcionario");
        System.out.println("3 - Voltar");
        int op = sc.nextInt();
        limparBuffer();
        switch (op){
            case 1:
                String cep;
                String rua;
                int numero;
                String bairro;
                String telefone;
                System.out.println("Cep: ");
                cep = sc.nextLine();
                System.out.println("Rua: ");
                rua = sc.nextLine();
                System.out.println("Numero: ");
                numero = sc.nextInt();
                limparBuffer();
                System.out.println("Bairro: ");
                bairro = sc.nextLine();
                System.out.println("Telefone: ");
                telefone = sc.nextLine();
                DadosUsuario.usuario.add(new Cliente(nome,cpf,cep,rua,numero,bairro,telefone));
                iniciar();
                break;
            case 2:
                int acesso;
                String login;
                int senha;
                System.out.println("Digite o nivel de acesso: ");
                acesso = sc.nextInt();
                limparBuffer();
                System.out.println("Digite o Login: ");
                login = sc.nextLine();
                senha = verificar.senha();
                DadosUsuario.usuario.add(new Funcionario(nome,cpf,acesso,login,senha));
                iniciar();
                break;

            case 3:
                iniciar();
                break;
            default:
                System.out.println("Escolhe uma opcao disponivel");
                novo();
                break;

        }

    }

    public void relatoriosUsuarios(){
        util.limpar();
        print.printUsarios();
        System.out.println("--Relatorio Usuario--");
        System.out.println("Id do usuario que deseja ver os dados complementares (0 para sair): ");
        int op = sc.nextInt();
        limparBuffer();
        print.dadosComplementares(op);
        iniciar();
    }





    public void limparBuffer(){sc.nextLine();}




}
