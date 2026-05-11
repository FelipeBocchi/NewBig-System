package com.newBig.system;
import com.newBig.system.config.FlyWayConfig;

public class Main {

    public static void main(String[] args) {
        FlyWayConfig.migrate();
        System.out.println("Ola");
    }
}

