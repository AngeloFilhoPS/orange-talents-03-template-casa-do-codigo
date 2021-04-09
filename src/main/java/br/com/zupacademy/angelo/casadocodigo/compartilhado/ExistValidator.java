package br.com.zupacademy.angelo.casadocodigo.compartilhado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistValidator implements ConstraintValidator<ExistValue,String> {
    @PersistenceContext
    private EntityManager manager;

    private Class<?> entity;
    private String campo;


    @Override
    public boolean isValid(String valor, ConstraintValidatorContext context){
        Query query = manager.createQuery("SELECT 1 FROM "+entity.getName()+" WHERE LOWER("+campo+") = LOWER(:valor)");
        query.setParameter("valor",valor);
        List<?> listResult = query.getResultList();
        return !listResult.isEmpty();
    }

    @Override
    public void initialize(ExistValue constraintAnnotation) {
        this.campo= constraintAnnotation.campo();
        this.entity= constraintAnnotation.entity();
    }
}
