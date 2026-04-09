package com.newBig.system;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import com.newBig.system.application.usecase.BuscarUsuarioVenda;
import com.newBig.system.application.usecase.Verificar;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.repository.StockMovementRepository;
import com.newBig.system.domain.repository.StockRepository;
import com.newBig.system.infrastructure.persistence.*;
import com.newBig.system.presentation.view.Cadastros;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.newBig.system.presentation.view.ExibirMenus;

import com.newBig.system.presentation.view.Morv.CaixaView;
import jakarta.persistence.EntityManager;

import java.util.Scanner;


public class Main {
    static boolean aux;
    static Long id = 0L;

    public static void main(String[] args) {

        //  = Conecção com o banco e inicialização
        EntityManager em = CustomizerFactory.getEntityManager();

        StockRepository stockRepository = new StockRepositoryImpl(em);
        StockMovementRepository movementRepository = new MovementRepositoryImpl(em);
        ProductRepository productRepository = new ProductRepositoryImpl(em);

        //ProductRepository repository = new ProductMemoryRepository();
        //StockRepository stockRepository = new StockMemoryRepository();
        //StockMovementRepository stockMovementRepository = new MovementMemoryRepository();

        Cadastros cadastros = new Cadastros();
        ExibirMenus menu = new ExibirMenus();
        //IniciarUsuario iniciarUsuario = new IniciarUsuario();

        Verificar verificar = new Verificar();
        CaixaView caixaView = new CaixaView();
        Scanner sc = new Scanner(System.in);
        BuscarUsuarioVenda buscarUsuarioVenda = new BuscarUsuarioVenda();
        //FlyWayConfig.migrate();
        if(!aux){
            System.out.println("\n===============================");
            System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
            System.out.println("===============================");
            id = verificar.login();
            aux = verificar.acesso(id, 2);
        }

        menu.principal(id);
        int op;
        while(true){
            if(sc.hasNextInt()){
                op = sc.nextInt();
                break;
            }
            else{
                System.out.println("Digite algo valido!!!");
                sc.nextLine();
            }
        }
        sc.nextLine();
        switch (op){
            case 1:
                cadastros.execute(productRepository, stockRepository, movementRepository);
                break;
            case 2:
                // vendas
                break;

            case 3:
                caixaView.iniciar();
                break;
            case 4:
                /*trocar usuario*/
                aux = false;
                main(null);
                break;
            case 5:
                buscarUsuarioVenda.cliente();
                buscarUsuarioVenda.funcionario();
                break;
            case 0:
                /*Sair*/
                em.close();
                break;
            default:
                System.out.println("Escolha uma opcao valida!!");
                main(null);
        }


    }
}

