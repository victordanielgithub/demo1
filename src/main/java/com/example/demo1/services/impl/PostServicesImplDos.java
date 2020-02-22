package com.example.demo1.services.impl;

import com.example.demo1.models.Post;
import com.example.demo1.services.PostServices;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("")
public class PostServicesImplDos implements PostServices {
    // LOG
    private final Log log = LogFactory.getLog(getClass());
    // END LOG

    @Override
    public List<Post> validacion(List<Post> lista) throws NullPointerException {
        log.info("Servicio 2");
        for(Post post : lista){
            if(post.getId() == 0){
                throw new NullPointerException("El id esta en 0");
            }
        }
        return lista;
    }
}
