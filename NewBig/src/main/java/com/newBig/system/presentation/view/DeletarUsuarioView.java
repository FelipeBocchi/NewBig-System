package com.newBig.system.presentation.view;

import com.newBig.system.Main;
import com.newBig.system.application.usecase.Verificar;
import com.newBig.system.domain.repository.ClienteRepo;
import com.newBig.system.domain.repository.CustomizerFactory;
import com.newBig.system.domain.repository.FuncionarioRepo;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class DeletarUsuarioView {
    EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
    ClienteView clienteView = new ClienteView();
    FuncionarioView funcionarioView = new FuncionarioView();
    Verificar verificar = new Verificar();
    Scanner sc = new Scanner(System.in);
    FuncionarioRepo funcionarioRepo = new FuncionarioRepo(em);
    ClienteRepo clienteRepo = new ClienteRepo(em);
    Long id = null;

    public void iniciar(){
        if(!verificar.acesso(verificar.login(), 1)){
            Main.main(null);
        }
        else{
            System.out.println("\n===============================");
            System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM ");
            System.out.println("===============================");
            System.out.println("        Deletar Usuarios       ");
            System.out.println("===============================");
            System.out.println("1 - Cliente");
            System.out.println("2 - Funcionarios");
            System.out.println("0 - Voltar");
            System.out.println("===============================");
            switch(verificar.opcao()) {
                case 1:
                    clienteView.print();
                    System.out.println("--!! Ao deletar algum usuario essa alteração será permanente !!--");
                    id = verificar.id();
                    if(!verificar.existe_id_cliente(id)){
                        iniciar();
                    }
                    clienteRepo.delete(clienteRepo.SelecionarCliente(id));
                    System.out.println("Enter para voltar: ");
                    sc.nextLine();
                    Main.main(null);
                    break;
                case 2:
                    funcionarioView.print();
                    System.out.println("--!! Ao deletar algum usuario essa alteração será permanente !!--");
                    id = verificar.id();
                    if(!verificar.existe_id(id)){
                        iniciar();
                    }
                    funcionarioRepo.delete(funcionarioRepo.SelecionarFuncionario(id));
                    System.out.println("Enter para voltar: ");
                    sc.nextLine();
                    Main.main(null);
                    break;
                case 0:
                    Main.main(null);
                    break;
                default:
                    System.out.println("Erro tente novamente");
                    iniciar();
                    break;
            }
        }
    }

}
