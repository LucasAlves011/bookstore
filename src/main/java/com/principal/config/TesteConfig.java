package com.principal.config;

import com.principal.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("teste")
public class TesteConfig {
    @Autowired
    private DBService dbService;

    @Bean
    public void instaciaDados(){
        this.dbService.instanciaDados();
    }
}
