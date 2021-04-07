package br.com.zupacademy.angelo.casadocodigo.controller;

import br.com.zupacademy.angelo.casadocodigo.entity.Autor;
import br.com.zupacademy.angelo.casadocodigo.form.AutorForm;
import br.com.zupacademy.angelo.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutoresController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    public AutoresController(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AutorForm form){



        Autor autor = form.converter();
        autor = autorRepository.save(autor);
        return ResponseEntity.ok().body(autor);
    }
    //Boolean existByEmail = autorRepository.existsByEmail(form.getEmail)
   /* @PostMapping
    public String cadastrarAutor(@RequestBody @Valid AutorForm form){

        Autor autor = form.converter();
        autor = autorRepository.save(autor);
        return "ok";
    }*/


}
