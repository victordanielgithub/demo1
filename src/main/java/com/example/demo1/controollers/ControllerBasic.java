package com.example.demo1.controollers;

import com.example.demo1.components.PostComponents;
import com.example.demo1.configuration.Paginas;
import com.example.demo1.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class ControllerBasic {

    @Autowired
    @Qualifier("com.example.demo1.components.PostComponents")
    private PostComponents postComponents;

    @GetMapping(path = {"/","/home", "/inicio"})       // para obtener recursos
    public String home(Model model){     // MODEL ES UNA INTERFAZ
        model.addAttribute("listaPosts", this.postComponents.get_listPosts());         // CREAMOS UN ATRIBUTO PARA LA INTERFAZ
        return "index";
    }

    @GetMapping(path = "/public")
    public ModelAndView post(){
        ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
        modelAndView.addObject("listaPosts", this.postComponents.get_listPosts());
        return modelAndView;
    }

    // 1er METODO PARA PASAR PARAMETROS
    @GetMapping(path = {"/post"})
    public ModelAndView getPostIndividual1(
            @RequestParam(defaultValue = "1", name = "id", required = false) int id     // PARAMETRO DE INGRESO DESDE EL INDEX
        ){
        ModelAndView modelAndView = new ModelAndView((Paginas.POST));
        List<Post> listaPostFiltrados = this.postComponents.get_listPosts().stream().filter(
                (p) -> {
                    return p.getId() == id;
                }).collect(Collectors.toList());
        modelAndView.addObject(listaPostFiltrados.get(0));
        return modelAndView;
    }
    // 2do METODO PARA PASAR PARAMETROS
    @GetMapping(path = {"/post/{post}"})
    public ModelAndView getPostIndividual2(
            @PathVariable(required = true, name = "post") int id     // PARAMETRO DE INGRESO DESDE EL INDEX
        ){
        ModelAndView modelAndView = new ModelAndView((Paginas.POST));
        List<Post> listaPostFiltrados = this.postComponents.get_listPosts().stream().filter(
                (p) -> {
                    return p.getId() == id;
                }).collect(Collectors.toList());
        modelAndView.addObject(listaPostFiltrados.get(0));
        return modelAndView;
    }

    @GetMapping(path = "/postNew")
    public ModelAndView getForm_newPost(){
        Post x = new Post();
        x.mostrar();
        return new ModelAndView("postNew").addObject("post", x);
    }
    @PostMapping(path = "/postNewAdd")
    public String postNewAdd(Post post, Model model){
        List<Post> listaPosts = this.postComponents.get_listPosts();
        listaPosts.add(post);
        model.addAttribute("listaPosts", listaPosts);
        return "index";
    }
}
