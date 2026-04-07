package com.newBig.system.application.usecase;

import com.newBig.system.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Verificar {
    Scanner sc = new Scanner(System.in);
    public int opcao(){
        try{
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
            return op;
        } catch (Exception e) {
            System.out.println("Erro ao escolher opcao");
            return 0;
        }
    }
    public int senha(){
        int senha = -1;
        while(senha < 1000 || senha > 9999){
            try{
                System.out.println("Digite a senha (somente numeros de 4 digitos): ");
                senha = sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Senha invalida, Tente Novamente");
                sc.nextLine();
            }

        }
        return senha;
    }
}
