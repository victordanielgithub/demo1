package com.example.demo1;

import com.example.demo1.beans.PostComponent;
import com.example.demo1.models.Conexion;
import com.example.demo1.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {

	@Autowired
	@Qualifier("beanConexion")
	private Conexion conexion;

	@Autowired
	@Qualifier("com.example.demo1.beans.PostComponent")
	public PostComponent postComponent;

	@Autowired
	@Qualifier("servicesDecorado")
	public PostServices postServices;

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(conexion.getNameDB());

		postComponent.get_listPosts().forEach(post -> {
			System.out.println(post.getDescripcion());
		});

		System.out.println("*********POST SERVICE***********");
		try{
			postServices.validacion(postComponent.get_listPosts()).forEach(post -> {
				System.out.println(post.getTitulo());
			});
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
