package com.example.demo1.beans;

import com.example.demo1.models.Conexion;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CreandoConexion {

    @Bean(name = "beanConexion")
    public Conexion getConexion(){
        Conexion conexion = new Conexion();
        conexion.setNameDB("mysql");
        conexion.setUlr("localhost");
        return conexion;
    }
}
