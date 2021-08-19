package com.principal.repositories;

import com.principal.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Integer> {

    //@Query("SELECT object FROM Livro object WHERE object.categoria.id = :idCat ORDER BY titulo") ISSO NÃO É NECESSÁRIO
    List<Livro> findAllByCategoriaIdOrderByTitulo(Integer idCat);
}
