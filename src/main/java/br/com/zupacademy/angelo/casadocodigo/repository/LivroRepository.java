package br.com.zupacademy.angelo.casadocodigo.repository;

import br.com.zupacademy.angelo.casadocodigo.entity.Livro;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LivroRepository extends CrudRepository<Livro,Long> {

    Optional<Livro> findByTitulo(String titulo);

    Optional<Livro> existsLivroByTitulo(String titulo);
    Optional<Livro> existsLivroByIsbn(String isbn);


}
