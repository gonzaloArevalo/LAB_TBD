package com.tbd_grupo_8.lab_1.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;


@Configuration
public class DatabaseContext {
    @Bean
    public Sql2o sql2o() {
        return new Sql2o("jdbc:postgresql://localhost:5432/tbd_lab_1", "postgres", "postgres");
    }

//    @Bean
//    public SecretKey secretKey() {
//        return Jwts.SIG.HS256.key().build();
//    }
}
