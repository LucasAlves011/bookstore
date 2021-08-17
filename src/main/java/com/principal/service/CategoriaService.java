package com.principal.service;

import com.principal.domain.Categoria;
import com.principal.repositories.CategoriaRepository;
import com.principal.service.excepcions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + id +
                ", Tipo:" + Categoria.class.getName()));
    }

}
