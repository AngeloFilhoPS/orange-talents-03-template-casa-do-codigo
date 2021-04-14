package br.com.zupacademy.angelo.casadocodigo.repository;

import br.com.zupacademy.angelo.casadocodigo.entity.Pais;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PaisRepository extends CrudRepository<Pais,Long> {
    Optional<Pais> findByNome(String nome);
    Optional<Pais> findById(Long id);

    Pais findPaisById(Long idPais);
}
