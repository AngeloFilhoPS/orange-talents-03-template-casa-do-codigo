package br.com.zupacademy.angelo.casadocodigo.controller;

import br.com.zupacademy.angelo.casadocodigo.entity.Categoria;
import br.com.zupacademy.angelo.casadocodigo.form.CategoriaForm;
import br.com.zupacademy.angelo.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;
import java.util.function.Function;

@Component
public class ProibeCategoriaDuplicada<T,P> implements Validator {
    private String campo;
    private String codigoErro;
    private Class<? extends  T> classeParaValidar;
    private Function<P, Boolean> metodoQueConsultaBd;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz){
        return CategoriaForm.class.isAssignableFrom(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        CategoriaForm categoriaForm = (CategoriaForm) target;
        Optional<Categoria> possivelCategoria = categoriaRepository
                .findByNome(categoriaForm.getNome());
        if (possivelCategoria.isPresent()){
            errors.rejectValue("Nome", null, "Já existe essa categoria "
            + categoriaForm.getNome());
        }
    }
}
