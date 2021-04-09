package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.compartilhado.ExistValue;
import br.com.zupacademy.angelo.casadocodigo.compartilhado.UniqueValue;
import br.com.zupacademy.angelo.casadocodigo.entity.Autor;
import br.com.zupacademy.angelo.casadocodigo.entity.Categoria;
import br.com.zupacademy.angelo.casadocodigo.entity.Livro;
import br.com.zupacademy.angelo.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.angelo.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.angelo.casadocodigo.repository.LivroRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Optional;

public class LivroForm {
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(min = 5,max = 400,message = "O resumo deve ter de 5 a 500 caracteres")
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(value = 20, message = "O preço do livro deve ser no mínimo de R$20")
    private double preco;

    @NotNull
    @Min(value = 100, message = "O livro deve ter no minimo, 100 páginas")
    private Integer numeroPaginas;

    @NotNull
    @NotBlank
    @Size(min = 13, max = 13, message = "O código Isbn tem 10 digitos")
    private String isbn;


    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;

    @NotNull
    @ExistValue(entity = Categoria.class, campo = "nome")
    private String categoria;

    @NotBlank
    @NotNull
    @ExistValue(entity = Autor.class, campo = "email")
    private String autor;

    private Object LivroForm;

    //    Hibernate Only
    public LivroForm(){

    }

    public LivroForm(@NotBlank String titulo,
                     @NotBlank @Size(min = 5, max = 400, message = "O resumo deve ter de 5 a 500 caracteres") String resumo,
                     @NotBlank String sumario,
                     @NotBlank @NotNull @Min(value = 20, message = "O preço do livro deve ser no mínimo de R$20") double preco,
                     @NotNull @Min(value = 100, message = "O livro deve ter no minimo, 100 páginas") Integer numeroPaginas,
                     @NotNull @NotBlank @Size(min = 13, max = 13, message = "O código Isbn tem 10 digitos") String isbn,
                     @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING) LocalDate dataLancamento,
                     @NotNull String categoria,
                     @NotBlank @NotNull String autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return  sumario;
    }

    public double getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }


    public ResponseEntity<?> converte(CategoriaRepository categoriaRepository, AutorRepository autorRepository, LivroRepository livroRepository) throws Exception {

        Optional<Categoria> categoriaEncontrada = categoriaRepository.findByNome(categoria);
        Optional<Autor> autorEncontrado = autorRepository.findByNome(autor);

        if(categoriaEncontrada.isEmpty()){
            throw new Exception();
        }
        if (autorEncontrado.isEmpty()){
            throw new Exception();
        }
        Categoria categoriaReturn = categoriaRepository.findCategoriaByNome(categoria);
        Autor autorReturn = autorRepository.findAutorByNome(autor);
        Livro livro = new Livro(titulo,resumo,sumario,preco,numeroPaginas,isbn,dataLancamento,categoriaReturn, autorReturn);

        Livro livroSalvo = livroRepository.save(livro);
        return ResponseEntity.ok().body(livro);

    }

    @Override
    public String toString() {
        return "LivroForm{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumuario=" + sumario +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", categoria='" + categoria + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
