package com.example.demo1.services.impl;

import com.example.demo1.models.Post;
import com.example.demo1.services.PostServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("")
public class PostServicesImplDos implements PostServices {
    @Override
    public List<Post> validacion(List<Post> lista) {
        for(Post post : lista){
            if(post.getId() == 0){
                throw new NullPointerException("El id esta en 0");
            }
        }
        System.out.println("Segundo servicio");
        return lista;
    }
}
