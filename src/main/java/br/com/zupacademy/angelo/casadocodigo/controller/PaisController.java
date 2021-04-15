package br.com.zupacademy.angelo.casadocodigo.controller;

import br.com.zupacademy.angelo.casadocodigo.entity.Pais;
import br.com.zupacademy.angelo.casadocodigo.form.PaisForm;
import br.com.zupacademy.angelo.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private PaisRepository paisRepository;

    public PaisController(){}

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarPais(@RequestBody @Valid PaisForm form) throws Exception {
        Pais pais = form.converter();
        pais = paisRepository.save(pais);
        return ResponseEntity.ok().body(pais);
    }

}
