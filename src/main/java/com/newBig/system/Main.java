package com.newBig.system;
import com.newBig.system.config.FlyWayConfig;
import com.newBig.system.service.Caixa;

public class Main {

    public static void main(String[] args) {
        FlyWayConfig.migrate();
        System.out.println("Ola");
        Caixa caixa = new Caixa();
    }
}

