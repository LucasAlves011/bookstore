package com.principal.resources;

import com.principal.domain.Categoria;
import com.principal.dtos.CategoriaDTO;
import com.principal.service.CategoriaService;
import net.bytebuddy.implementation.bytecode.assign.primitive.VoidAwareAssigner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> list = categoriaService.findAll();
        List<CategoriaDTO> listDTO = list.stream().map(CategoriaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria obj){
        obj = categoriaService.create(obj);
        /*
          Por boas práticas de programação é recomendado sempre que criado alguma classe no back-end, retornar
          uma URI de acesso a esse novo objeto ao client.
         */
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        /* Entendi oque esse método faz, mas não entendi absolutamente nada de como construir esse método.
         Sla Java às vezes têm umas coisas que são bem esquisitas */
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO catedto){
       Categoria temp = categoriaService.update(id,catedto);
       return ResponseEntity.ok().body(new CategoriaDTO(temp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
