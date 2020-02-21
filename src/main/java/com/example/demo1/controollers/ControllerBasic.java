package com.example.demo1.controollers;

import com.example.demo1.configuration.Paginas;
import com.example.demo1.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class ControllerBasic {

    // ATRIBUTOS:
    ArrayList<Post> listaPosts;

    @GetMapping(path = {"/","/home", "/inicio"})       // para obtener recursos
    public String saludar(Model model){     // MODEL ES UNA INTERFAZ
        model.addAttribute("listaPosts", this.get_listPosts());         // CREAMOS UN ATRIBUTO PARA LA INTERFAZ
        return "index";
    }

    @GetMapping(path = "/public")
    public ModelAndView post(){
        ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
        modelAndView.addObject("listaPosts", this.get_listPosts());
        return modelAndView;
    }

    // getPostIndividual(IN PARAMETRO PARA FILTRAR) = RETURN OBJETCT POST WHERE ID=IN_ID
    @GetMapping(path = {"/post"})
    public ModelAndView getPostIndividual(
            @RequestParam(defaultValue = "1", name = "id", required = false) int id     // PARAMETRO DE INGRESO DESDE EL INDEX
            ){
        ModelAndView modelAndView = new ModelAndView((Paginas.POST));
        List<Post> listaPostFiltrados = this.get_listPosts().stream().filter(
                (p) -> {
                    return p.getId() == id;
                }).collect(Collectors.toList());
        modelAndView.addObject(listaPostFiltrados.get(0));
        return modelAndView;
    }

    public void obtienePostDesdeDB(){
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

        listaPosts = new ArrayList<>();
        // Post(int id, String descripcion, String urlImg, Date fecha, String titulo)
        listaPosts.add(new Post(1, descipciones.get(0), imagenes.get(0), dates.get(0), titulos.get(0)));
        listaPosts.add(new Post(2, descipciones.get(1), imagenes.get(1), dates.get(1), titulos.get(1)));
        listaPosts.add(new Post(3, descipciones.get(2), imagenes.get(2), dates.get(2), titulos.get(2)));
        listaPosts.add(new Post(4, descipciones.get(3), imagenes.get(3), dates.get(3), titulos.get(3)));
    }
    // get_listPost()   =>  CREA UNA LISTA DE POST'S Y NOS DEVUELVE ESA LISTA
    public List<Post> get_listPosts(){
        this.obtienePostDesdeDB();
        return listaPosts;
    }

}
