package com.example.demo1.components;

import com.example.demo1.models.Post;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("com.example.demo1.components.PostComponents")      // @Component: Es el estereotipo general y permite anotar un bean para que Spring lo considere uno de sus objetos
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PostComponents {
    public List<Post> get_listPosts(){
        ArrayList<String> descipciones= new ArrayList<>();
        descipciones.add("Angular is a platform for building mobile and desktop web applications. Join the community of millions of developers who build compelling user interfaces with");
        descipciones.add("React (también llamada React.js o ReactJS) es una biblioteca Javascript de código abierto diseñada para crear interfaces de usuario con el objetivo de facilitar");
        descipciones.add("es un entorno de ejecución para JavaScript construido con el motor de JavaScript V8 de Chrome. New security releases now available for all release ");
        descipciones.add("Vue.js es un marco JavaScript de código abierto Modelo-vista-modelo de vista para construir interfaces de usuario y aplicaciones de una sola página.");

        ArrayList<String> imagenes= new ArrayList<>();
        imagenes.add("http://localhost:9000/img/angular.png");
        imagenes.add("http://localhost:9000/img/react.png");
        imagenes.add("http://localhost:9000/img/node.jpg");
        imagenes.add("http://localhost:9000/img/vue.png");

        ArrayList<Date> dates= new ArrayList<>();
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());

        ArrayList<String> titulos= new ArrayList<>();
        titulos.add("ANGULAR");
        titulos.add("REACT");
        titulos.add("NODE JS");
        titulos.add("VUE JS");

        ArrayList<Post> listaPosts= new ArrayList<>();
        // Post(int id, String descripcion, String urlImg, Date fecha, String titulo)
        listaPosts.add(new Post(1, descipciones.get(0), imagenes.get(0), dates.get(0), titulos.get(0)));
        listaPosts.add(new Post(2, descipciones.get(1), imagenes.get(1), dates.get(1), titulos.get(1)));
        listaPosts.add(new Post(3, descipciones.get(2), imagenes.get(2), dates.get(2), titulos.get(2)));
        listaPosts.add(new Post(4, descipciones.get(3), imagenes.get(3), dates.get(3), titulos.get(3)));

        return listaPosts;
    }
}
