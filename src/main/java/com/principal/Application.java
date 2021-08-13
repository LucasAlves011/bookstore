package com.principal;

import com.principal.domain.Categoria;
import com.principal.domain.Livro;
import com.principal.repositories.CategoriaRepository;
import com.principal.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
//@EnableJpaRepositories("com.principal.repositories")
//@EntityScan("com.prinncipal.domain")
public class Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática","Livros de Ti");
		Livro livro1 = new Livro(null,"Clean Code","Robert Martin","Text",cat1);

		cat1.getLivros().addAll(List.of(livro1));

		this.categoriaRepository.saveAll(List.of(cat1));
		this.livroRepository.saveAll(List.of(livro1));

	}
}
