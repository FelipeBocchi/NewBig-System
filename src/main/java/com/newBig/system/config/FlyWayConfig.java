package com.newBig.system.config;

import org.flywaydb.core.Flyway;

public class FlyWayConfig {
    public static void migrate(){
        Flyway flyway = Flyway.configure()
                .dataSource(
                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "1212"
                )
                .baselineOnMigrate(true) /*Começa a controlar apartir de agora, tirando o que já existe*/
                .load(); /*Finaliza a configuração*/

        flyway.migrate(); /*Executa*/
    }
}
