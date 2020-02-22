package com.example.demo1.services.impl;

import com.example.demo1.models.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServicesImpl implements com.example.demo1.services.PostServices {

    @Override
    public List<Post> validacion(List<Post> lista) {
        for(Post post : lista){
            if(post.getTitulo() == null){
                throw new NullPointerException("El titulo esta en null");
            }
        }
        System.out.println("Primer servicio");
        return lista;
    }
}
