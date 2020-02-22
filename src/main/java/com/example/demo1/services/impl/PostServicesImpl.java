package com.example.demo1.services.impl;

import com.example.demo1.models.Post;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
public class PostServicesImpl implements com.example.demo1.services.PostServices {

    @Override
    public List<Post> validacionId(List<Post> lista) {
        for(Post post : lista){
            if(post.getTitulo() == null){
                throw new NullPointerException("El titulo esta en null");
            }
        }
        return lista;
    }
}
