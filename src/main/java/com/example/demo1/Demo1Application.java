package com.example.demo1;

import com.example.demo1.beans.PostComponent;
import com.example.demo1.models.Conexion;
import com.example.demo1.services.PostServices;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
		// LOG
		Log log = LogFactory.getLog(getClass());
		// END LOG

		postComponent.get_listPosts().forEach(post -> {
			System.out.println(post.getDescripcion());
		});

		try{
			postServices.validacion(postComponent.get_listPosts()).forEach(post -> {
				//System.out.println(post.getTitulo());
				log.info(post.getTitulo());
			});
		}catch (Exception e){
			//System.out.println(e.getMessage());
			log.error(e);
		}
	}
}
