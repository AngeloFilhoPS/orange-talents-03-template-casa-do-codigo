package br.com.zupacademy.angelo.casadocodigo.controller;

import br.com.zupacademy.angelo.casadocodigo.entity.Autor;
import br.com.zupacademy.angelo.casadocodigo.form.AutorForm;
import br.com.zupacademy.angelo.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AutorForm form, BindingResult result){
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result);
        };
        Autor autor = form.converter();
        autor = autorRepository.save(autor);
        return ResponseEntity.ok().body(autor);
    }

}
