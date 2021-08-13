package com.principal.repositories;

import com.principal.domain.Categoria;
import com.principal.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Integer> {


}
