package com.newBig.system;
import com.newBig.system.config.FlyWayConfig;
import com.newBig.system.service.Caixa;
import com.newBig.system.service.OperacaoCaixa;

public class Main {

    public static void main(String[] args) {
        FlyWayConfig.migrate();
        System.out.println("Ola");
        Caixa caixa = new Caixa();
        OperacaoCaixa operacaoCaixa = new OperacaoCaixa();
        operacaoCaixa.abrir();
    }
}

