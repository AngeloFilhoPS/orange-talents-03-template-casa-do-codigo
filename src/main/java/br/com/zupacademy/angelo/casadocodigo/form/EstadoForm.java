package br.com.zupacademy.angelo.casadocodigo.form;

import br.com.zupacademy.angelo.casadocodigo.compartilhado.ExistValue;
import br.com.zupacademy.angelo.casadocodigo.compartilhado.UniqueValue;
import br.com.zupacademy.angelo.casadocodigo.entity.Estado;
import br.com.zupacademy.angelo.casadocodigo.entity.Pais;
import br.com.zupacademy.angelo.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.angelo.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public class EstadoForm {
    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    private Long idPais;

    public EstadoForm(){
    }

    public EstadoForm(
            @NotBlank String nome,
            @NotNull Long idPais
            ){
        this.nome= nome;
        this.idPais=idPais;
    }

    public String getNome() {
        return nome;
    }

//    public ResponseEntity<?>converteDevolveAlgo(PaisRepository paisRepository, EstadoRepository estadoRepository) throws Exception {
//
//
//
//        //        Optional<Pais>paisEncontrado =paisRepository.findById(idPais);
////        if(paisEncontrado.isPresent()){
////
////            Pais paisReturn = paisRepository.findPaisById(idPais);
////
////            Estado estado = new Estado(nome,paisReturn);
////            estado = estadoRepository.save(estado);
////            return ResponseEntity.ok().body(estado);
////        }
////        throw new Exception();
//
//    }

    public Long getIdPais() {
        return idPais;
    }

    @Override
    public String toString() {
        return "EstadoForm{" +
                "nome='" + nome + '\'' +
                ", idPais=" + idPais +
                '}';
    }

    public Estado convert(String nome, Pais pais) {
        return new Estado(nome,pais);
    }
}
