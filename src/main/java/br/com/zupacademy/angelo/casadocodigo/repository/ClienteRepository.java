package br.com.zupacademy.angelo.casadocodigo.repository;

import br.com.zupacademy.angelo.casadocodigo.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente,Long> {

}
