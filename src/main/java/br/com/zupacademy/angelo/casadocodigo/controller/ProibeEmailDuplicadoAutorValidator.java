package br.com.zupacademy.angelo.casadocodigo.controller;

import br.com.zupacademy.angelo.casadocodigo.entity.Autor;
import br.com.zupacademy.angelo.casadocodigo.form.AutorForm;
import br.com.zupacademy.angelo.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;
@Component
public class  ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz){
        return AutorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        if(errors.hasErrors()){
            return;
        }

        AutorForm autorForm = (AutorForm) target;

        Optional<Autor> posssivelAutor = autorRepository
                .findByEmail(autorForm.getEmail());
        if(posssivelAutor.isPresent()){
            errors.rejectValue("email",null,"Já existe um autor com esse email"
            + autorForm.getEmail());
        }
    }
}
