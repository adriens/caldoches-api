/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.repositories.custom.implementation;

import com.adriens.github.caldochesApi.entities.Expression;
import com.adriens.github.caldochesApi.repositories.custom.ExpressionRepositoryCustom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author meilie
 */
@Repository
@Transactional(readOnly = true)
public class ExpressionRepositoryImpl implements ExpressionRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;
    
    /**
     * get the expression list for a tag key
     * @param cleTag
     * @return the expression list for a tag corresponding to the cleTag parameter
     */
    @Override
    public List<Expression> findByTag(String cleTag) {
        Query query = entityManager.createNativeQuery(
            "SELECT * "
            + "FROM EXPRESSION AS E, TAG AS T, EXPTAG AS ET "
            + "WHERE E.ID = ET.EXP "
            + "AND T.ID = ET.TAG "
            + "AND T.NOM = ?1",
            Expression.class);
        
        query.setParameter(1, cleTag);
        
        return query.getResultList();
    }

    /**
     * get an expression by id for a tag key
     * @param cleTag
     * @param idExpression
     * @return the media corresponding to the idExpression parameter for the tag corresponding to the cleTag parameter
     */
    @Override
    public Expression findByIdByTag(String cleTag, Integer idExpression) {
        Query query = entityManager.createNativeQuery(
        "SELECT * "
        + "FROM EXPRESSION AS E, TAG AS T, EXPTAG AS ET "
        + "WHERE E.ID = ET.EXP "
        + "AND T.ID = ET.TAG "
        + "AND T.NOM = ?1 "
        + "AND E.ID = ?2", 
        Expression.class);

        query.setParameter(1, cleTag);
        query.setParameter(2, idExpression);

        List<Expression> exps = query.getResultList();
        if (exps.isEmpty()) return null;
        else return exps.get(0);
    }

    @Override
    public List<Expression> findByMotcle(String motcle) {
        Query query = entityManager.createNativeQuery(
        "SELECT * "
        + "FROM EXPRESSION AS E "
        + "WHERE E.TEXTE LIKE '%"+motcle+"%' ",        
        Expression.class);

        List<Expression> exps = query.getResultList();
        return exps;
    }
    
}
