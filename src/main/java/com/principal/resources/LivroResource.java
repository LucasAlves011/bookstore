package com.principal.resources;

import com.principal.domain.Livro;
import com.principal.dtos.LivroDTO;
import com.principal.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value ="/livros")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id){
        Livro tempo = livroService.findById(id);
        return ResponseEntity.ok().body(tempo);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria",defaultValue = "0") Integer idCat){
        List<Livro> temp = livroService.findAll(idCat);
        List<LivroDTO> listDTO = temp.stream().map(LivroDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


}
