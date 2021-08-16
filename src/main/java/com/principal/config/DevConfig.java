package com.principal.config;

import com.principal.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public void instanciaBaseDados(){
        this.dbService.instanciaDados();
    }
//    @Value()
//    private String
}
