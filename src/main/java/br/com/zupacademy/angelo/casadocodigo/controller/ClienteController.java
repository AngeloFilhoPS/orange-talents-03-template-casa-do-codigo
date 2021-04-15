package br.com.zupacademy.angelo.casadocodigo.controller;

import br.com.zupacademy.angelo.casadocodigo.entity.Cliente;
import br.com.zupacademy.angelo.casadocodigo.entity.Estado;
import br.com.zupacademy.angelo.casadocodigo.form.ClienteForm;
import br.com.zupacademy.angelo.casadocodigo.repository.ClienteRepository;
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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private  ClienteRepository clienteRepository;
    @Autowired
    private  PaisRepository paisRepository;
    @Autowired
    private  EstadoRepository estadoRepository;

    public ClienteController(){

    }

    public ClienteController(ClienteRepository clienteRepository,PaisRepository paisRepository, EstadoRepository estadoRepository){
        this.clienteRepository= clienteRepository;
        this.paisRepository=paisRepository;
        this.estadoRepository=estadoRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid ClienteForm form){
        Cliente cliente = form.converter(paisRepository,estadoRepository);
        cliente = clienteRepository.save(cliente);
        return ResponseEntity.ok().body(cliente);
    }

}
