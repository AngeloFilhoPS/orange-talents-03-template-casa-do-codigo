package br.com.zupacademy.angelo.casadocodigo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.w3c.dom.Text;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String titulo;

    @NotNull
    @NotBlank
    @Size(min = 5,max = 400,message = "O resumo deve ter de 5 a 500 caracteres")
    private String resumo;

    @NotNull
    @Lob
    @Column(columnDefinition = "text")
    private String sumario;

    @NotNull
    @Min(value = 20, message = "O preço do livro deve ser no mínimo R$20")
    private double preco;

    @NotNull
    @Min(value = 100, message = "O livro deve ter no minimo, 100 páginas")
    private Integer numeroPaginas;

    @NotNull
    @NotBlank
    @Size(min = 13, max = 13, message = "O código Isbn tem 10 digitos")
    private String isbn;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;


    public Livro(
                 @NotNull @NotBlank String titulo,
                 @NotNull @NotBlank @Size(min = 5, max = 400, message = "O resumo deve ter de 5 a 500 caracteres") String resumo,
                 @NotNull String sumario, @Min(value = 20, message = "O preço do livro deve ser no mínimo 20") double preco,
                 @Min(value = 100, message = "O livro deve ter no minimo, 100 páginas") Integer numeroPaginas,
                 @Size(min = 10, max = 10, message = "O código Isbn tem 10 digitos") String isbn,
                 @NotNull @NotBlank LocalDate dataLancamento,
                 Categoria categoria, Autor autor) {
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
}
