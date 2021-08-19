package com.principal.service;

import com.principal.domain.Livro;
import com.principal.repositories.LivroRepository;
import com.principal.service.excepcions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id){
        Optional<Livro> temp = livroRepository.findById(id);
        return temp.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado. Id: "+
                id + ", Tipo: "+ Livro.class.getName()));
    }

    public List<Livro> findAll(Integer id) {
        categoriaService.findById(id);
        return livroRepository.findAllByCategoriaIdOrderByTitulo(id);
    }


}
