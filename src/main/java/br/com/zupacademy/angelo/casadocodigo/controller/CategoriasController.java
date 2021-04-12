package br.com.zupacademy.angelo.casadocodigo.controller;

import br.com.zupacademy.angelo.casadocodigo.entity.Categoria;
import br.com.zupacademy.angelo.casadocodigo.entity.Livro;
import br.com.zupacademy.angelo.casadocodigo.form.CategoriaForm;
import br.com.zupacademy.angelo.casadocodigo.form.CategoriaResponseForm;
import br.com.zupacademy.angelo.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.angelo.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Cacheable;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public CategoriasController(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCategoria(@RequestBody @Valid CategoriaForm form){
        Categoria categoria = form.converter();
        categoria = categoriaRepository.save(categoria);
        return ResponseEntity.ok().body(new CategoriaResponseForm(categoria));
    }

}
