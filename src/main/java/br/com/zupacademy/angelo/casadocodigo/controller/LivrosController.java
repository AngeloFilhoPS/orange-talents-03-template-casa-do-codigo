package br.com.zupacademy.angelo.casadocodigo.controller;

import br.com.zupacademy.angelo.casadocodigo.entity.Livro;
import br.com.zupacademy.angelo.casadocodigo.form.LivroForm;
import br.com.zupacademy.angelo.casadocodigo.form.LivroResponse;
import br.com.zupacademy.angelo.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.angelo.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.angelo.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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
    @GetMapping
    public Page<LivroResponse> listaLivro(@RequestParam(required = false)String nomeLivro,
                                          @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0,size = 10)
                                          Pageable paginacao){
        Page<LivroResponse> livros  = (Page<LivroResponse>) livroRepository.findAll(paginacao);
        return livros;
    }
    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> detalha(@PathVariable Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isPresent()){
            Livro livroR = livroRepository.findLivroById(id);
            return ResponseEntity.ok().body(new LivroResponse(livroR));
        }
        return ResponseEntity.notFound().build();
    }

}
