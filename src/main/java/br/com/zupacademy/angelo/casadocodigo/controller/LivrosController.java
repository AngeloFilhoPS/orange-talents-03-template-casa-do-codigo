package br.com.zupacademy.angelo.casadocodigo.controller;

import br.com.zupacademy.angelo.casadocodigo.form.LivroForm;
import br.com.zupacademy.angelo.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.angelo.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.angelo.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
//5
@RestController
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    private LivroRepository livroRepository;
    private CategoriaRepository categoriaRepository;
    private AutorRepository autorRepository;


    public LivrosController(LivroRepository livroRepository, CategoriaRepository categoriaRepository, AutorRepository autorRepository){
        this.livroRepository= livroRepository;
        this.categoriaRepository= categoriaRepository;
        this.autorRepository= autorRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarLivro(@RequestBody @Valid LivroForm form) throws Exception {

        ResponseEntity<?> livro = form.converteRetornaResponse(categoriaRepository,autorRepository,livroRepository);

        return livro;
    }
}
