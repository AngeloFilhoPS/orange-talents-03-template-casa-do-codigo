package br.com.zupacademy.angelo.casadocodigo.controller;

import br.com.zupacademy.angelo.casadocodigo.entity.Categoria;
import br.com.zupacademy.angelo.casadocodigo.form.CategoriaForm;
import br.com.zupacademy.angelo.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @PersistenceContext
    private EntityManager manager;


    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarCategoria(@RequestBody @Valid CategoriaForm form){
        Categoria categoria = form.converter();
        manager.persist(categoria);
        return ResponseEntity.ok().body(categoria);

    }


}
