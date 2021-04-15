package br.com.zupacademy.angelo.casadocodigo.controller;

import br.com.zupacademy.angelo.casadocodigo.entity.Estado;
import br.com.zupacademy.angelo.casadocodigo.entity.Pais;
import br.com.zupacademy.angelo.casadocodigo.form.EstadoForm;
import br.com.zupacademy.angelo.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.angelo.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;

    public EstadoController(){}

    public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository){
       this.estadoRepository= estadoRepository;
       this.paisRepository= paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoForm form) throws Exception{
        Pais pais = paisRepository.findPaisById(form.getIdPais());
        if(pais==null){
            Estado estado = form.convert(form.getNome(),pais);
            estado = estadoRepository.save(estado);
            return ResponseEntity.ok().body(estado);
        }
        return ResponseEntity.badRequest().build();
    }

}
