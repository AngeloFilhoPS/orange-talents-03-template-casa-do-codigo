package br.com.zupacademy.angelo.casadocodigo.repository;


import br.com.zupacademy.angelo.casadocodigo.entity.Estado;
import br.com.zupacademy.angelo.casadocodigo.entity.Pais;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EstadoRepository extends CrudRepository<Estado,Long> {
    Optional<Estado> findById(Long id);
    Optional<Estado> findByNome(String nome);
    Optional<Estado> findByNomeAndPaisId(String nome, Long idPais);
}
