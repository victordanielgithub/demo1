package com.example.demo1.services.impl;

import com.example.demo1.models.Post;
import com.example.demo1.services.PostServices;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicesDecorado")
@Scope("singleton")
public class PostServicesDecorado implements PostServices {
    // LOG
    private final Log log = LogFactory.getLog(getClass());
    // END LOG

    @Autowired
    private PostServicesImpl postServicesImp;

    @Autowired
    private PostServicesImplDos postServicesImplDos;

    @Override
    public List<Post> validacion(List<Post> lista) throws NullPointerException {
        log.debug(lista);

        lista = postServicesImp.validacion(lista);
        lista = postServicesImplDos.validacion(lista);

        for(Post post : lista){
            if(post.getDescripcion() == null)
                throw new NullPointerException("La descripcion esta en null");
            if(post.getFecha() == null)
                throw new NullPointerException("La fecha esta en null");
        }
        return lista;
    }
}
