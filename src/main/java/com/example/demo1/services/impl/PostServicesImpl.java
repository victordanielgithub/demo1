package com.example.demo1.services.impl;

import com.example.demo1.models.Post;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServicesImpl implements com.example.demo1.services.PostServices {
    // LOG
    private final Log log = LogFactory.getLog(getClass());
    // END LOG

    @Override
    public List<Post> validacion(List<Post> lista) throws NullPointerException {
        log.info("Servicio 1");
        for(Post post : lista){
            if(post.getTitulo() == null){
                throw new NullPointerException("El titulo esta en null");
            }
        }
        return lista;
    }
}
