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
        Categoria romance = new Categoria(null,"Romance","Best Seller");
        Categoria ficcao = new Categoria(null,"Ficção","Livros de Ficção");
        Categoria biografia = new Categoria(null,"Biografia","Biografia mesmo");
        Categoria guerra = new Categoria(null,"Guerra","Guerras reais");
        Categoria ti = new Categoria(null,"Computação","Livros de Computação");

//        Livro livro2 = new Livro(null,"50 tons","E. L. James","Coisas que tem no livro",romance);
//        Livro livro3 = new Livro(null,"Castelos de Areia","Jõao David","Texto do livro",guerra);
//        Livro livro4 = new Livro(null,"Vida de Jogador","Cafú","Texto da vida de jogador",biografia);
//        Livro livro1 = new Livro(null,"Clean Code","Robert Martin","Text",cat1);
//        Livro livro5 = new Livro(null,"MySQL pra novos","Lucas Alves","pegadinha",cat1);
        Livro familia_inesperada = new Livro(null,"Uma família inesperada para o CEO","Danielle Viegas Martins","  ",romance);
        Livro redencao = new Livro(null,"Meu bebê, minha redenção","Jéssica Macedo","   ",romance);
        Livro destinos = new Livro(null,"Destinos e Fúrias","Lauren Groff","   ",romance);
        Livro gelato = new Livro(null,"Amor & Gelato","Jenna Evans Welch","   ",romance);
        Livro feitosSol = new Livro(null,"Feitos de Sol","Grossos Vinícius","  ",ficcao);
        Livro rebeldeGeneral = new Livro(null,"Tretos: A rebelde e o general","Elie Anjo","  ",ficcao);
        Livro maquinaTempo = new Livro(null,"A máquina do Tempo","H.G. Wells","   ",ficcao);
        Livro anne = new Livro(null,"O diário de Anne Frank","Anne Frank","  ",biografia);
        Livro cartas = new Livro(null,"Cartas para minha avó","Djamila Ribeiro","   ",biografia);
        Livro arteGuera = new Livro(null,"A Arte da Guerra","Sun Tzu","  ",biografia);
        Livro gatilhos = new Livro(null,"Gatilhos Mentais","Gustavo Ferreira","   ",ti);
        Livro formula = new Livro(null,"A fórmula do lançamento","Jeff Walker","   ",ti);
        Livro intel = new Livro(null,"Inteligência artificial","Kai-Fu Lee","   ",ti);
        Livro mA = new Livro(null,"Microsoft Azure","Gilson Banin","   ",ti);
        Livro fenix = new Livro(null,"O projeto fênix","Gene Kim","   ",ti);


        romance.getLivros().addAll(List.of(familia_inesperada,redencao,destinos,gelato));
        ficcao.getLivros().addAll(List.of(feitosSol,rebeldeGeneral,maquinaTempo));
        biografia.getLivros().addAll(List.of(anne,cartas,arteGuera));
        ti.getLivros().addAll(List.of(gatilhos,formula,intel,mA,fenix));
        guerra.getLivros().addAll(List.of());

        this.categoriaRepository.saveAll(List.of(ti,romance,guerra,biografia,ficcao));
        this.livroRepository.saveAll(List.of(familia_inesperada,redencao,destinos,gelato,feitosSol,rebeldeGeneral,
                maquinaTempo,anne,cartas,arteGuera,gatilhos,formula,intel,mA,fenix));

    }

}
