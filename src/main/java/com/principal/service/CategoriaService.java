package com.principal.service;

import com.principal.domain.Categoria;
import com.principal.dtos.CategoriaDTO;
import com.principal.repositories.CategoriaRepository;
import com.principal.service.excepcions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria categoria){
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Integer id, CategoriaDTO categoria){
        Categoria x = findById(id);
        x.setNome(categoria.getNome());
        x.setDescricao(categoria.getDescricao());
        return categoriaRepository.save(x);
    }

    public void delete(Integer id){
        findById(id);

        try {
            categoriaRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new com.principal.service.excepcions.DataIntegrityViolationException("Categoria não pode ser deteleta." +
                    "Possui livros associados");
        }
    }

}
