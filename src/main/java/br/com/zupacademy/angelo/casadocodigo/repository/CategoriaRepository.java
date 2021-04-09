package br.com.zupacademy.angelo.casadocodigo.repository;

import br.com.zupacademy.angelo.casadocodigo.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<Categoria,Long> {
Optional<Categoria> findByNome(String nome);
Categoria findCategoriaByNome(String nome);
}
