package br.com.zupacademy.angelo.casadocodigo.repository;

import br.com.zupacademy.angelo.casadocodigo.entity.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AutorRepository extends CrudRepository<Autor,Long> {
    Optional<Autor> findByEmail(String email);

    Optional<Autor> findByNome(String autor);
    Autor findAutorByNome(String autor);
}
