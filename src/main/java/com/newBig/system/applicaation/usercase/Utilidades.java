package com.newBig.system.applicaation.usercase;

import java.util.Scanner;

public class Utilidades {
    Scanner sc = new Scanner(System.in);
    public void limparBuffer(){
        sc.nextLine();
    }

    public void limpar(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


}

