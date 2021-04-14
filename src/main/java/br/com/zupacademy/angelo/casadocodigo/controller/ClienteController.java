package br.com.zupacademy.angelo.casadocodigo.controller;

import br.com.zupacademy.angelo.casadocodigo.entity.Cliente;
import br.com.zupacademy.angelo.casadocodigo.form.ClienteForm;
import br.com.zupacademy.angelo.casadocodigo.repository.ClienteRepository;
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
    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository){
        this.clienteRepository= clienteRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid ClienteForm form){
        Cliente cliente = form.converter();
        cliente = clienteRepository.save(cliente);
        return ResponseEntity.ok().body(cliente);
    }

}
