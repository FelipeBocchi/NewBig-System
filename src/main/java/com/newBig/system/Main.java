package com.newBig.system;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import com.newBig.system.config.FlyWayConfig;
import com.newBig.system.repository.CustomizerFactory;
import jakarta.persistence.EntityManager;


public class Main {
    static boolean aux;
    static Long id = 0L;

    public static void main(String[] args) {
        FlyWayConfig.migrate();
        //  = Conecção com o banco e inicialização
        EntityManager em = CustomizerFactory.getEntityManager();

    }
}

