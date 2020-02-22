package com.example.demo1.services.impl;

import com.example.demo1.models.Post;
import com.example.demo1.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicesDecorado")
public class PostServicesDecorado implements PostServices {

    @Autowired
    private PostServicesImpl postServicesImp;

    @Autowired
    private PostServicesImplDos postServicesImplDos;

    @Override
    public List<Post> validacion(List<Post> lista) {
        lista = postServicesImp.validacion(lista);
        lista = postServicesImplDos.validacion(lista);

        for(Post post : lista){
            if(post.getDescripcion() == null)
                throw new NullPointerException("La descripcion esta en null");
            if(post.getFecha() == null)
                throw new NullPointerException("La fecha esta en null");
        }
        System.out.println("Esta es la clase decorada");
        return lista;
    }
}
