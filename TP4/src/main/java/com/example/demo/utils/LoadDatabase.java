package com.example.demo.utils;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

//    private static final String log = null;
//Carga de datos
	@Bean
    CommandLineRunner initDatabase(@Qualifier("clientRepository") ClientRepository repository) {
        return args -> {
            System.out.println("Preloading " + repository.save(new Client((long) 1234,"Seba", "Perez")));
        };
    }
}