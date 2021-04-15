package br.com.zupacademy.angelo.casadocodigo.repository;

import br.com.zupacademy.angelo.casadocodigo.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais,Long> {
    Optional<Pais> findByNome(String nome);
    Optional<Pais> findById(Long id);
    Pais findPaisById(Long id);

}
