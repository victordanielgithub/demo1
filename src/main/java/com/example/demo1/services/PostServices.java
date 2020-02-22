package com.example.demo1.services;

import com.example.demo1.models.Post;

import java.util.List;

public interface PostServices {
    public List<Post> validacion(List<Post> lista) throws NullPointerException;
}
