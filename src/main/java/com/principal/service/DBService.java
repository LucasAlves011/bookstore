package com.principal.service;

import com.principal.domain.Categoria;
import com.principal.domain.Livro;
import com.principal.repositories.CategoriaRepository;
import com.principal.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instanciaDados(){
        Categoria cat1 = new Categoria(null,"Informática","Livros de Ti");
        Categoria biografia = new Categoria(null,"Biografia","Biografia mesmo");
        Categoria romance = new Categoria(null,"Romance","Best Seller");
        Categoria guerra = new Categoria(null,"Guerra","Guerras reais");

        Livro livro2 = new Livro(null,"50 tons","E. L. James","Coisas que tem no livro",romance);

        Livro livro3 = new Livro(null,"Castelos de Areia","Jõao David","Texto do livro",guerra);

        Livro livro4 = new Livro(null,"Vida de Jogador","Cafú","Texto da vida de jogador",biografia);

        Livro livro1 = new Livro(null,"Clean Code","Robert Martin","Text",cat1);

        cat1.getLivros().addAll(List.of(livro1));
        romance.getLivros().addAll(List.of(livro2));
        guerra.getLivros().addAll(List.of(livro3));
        biografia.getLivros().addAll(List.of(livro4));

        this.categoriaRepository.saveAll(List.of(cat1,romance,guerra,biografia));
        this.livroRepository.saveAll(List.of(livro1,livro2,livro3,livro4));
    }

}
