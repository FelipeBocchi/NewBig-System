package com.newBig.system;
import com.newBig.system.config.FlyWayConfig;
import com.newBig.system.service.Caixa;
import com.newBig.system.view.TelaLogin;

public class Main {

    public static void main(String[] args) {
        FlyWayConfig.migrate();
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }
}

