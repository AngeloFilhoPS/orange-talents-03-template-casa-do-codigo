package br.com.zupacademy.angelo.casadocodigo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estadoList = new ArrayList<>();

    @Deprecated
    public Pais(){}

    public Pais(String nome){
        this.nome=nome;
    }

    public Long getId(){return id;}

    public String getNome(){return nome;}


}
