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
     * get the media list for an author
     * @param cleAuteur
     * @return the media list corresponding to the cleAuteur parameter
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
     * get a media by id for an author
     * @param cleAuteur
     * @param mediaId
     * @return the media corresponding to the mediaId parameter for the author corresponding to the cleAuteur parameter
     */
    @Override
    public Expression findByIdByTag(String cleTag, Integer expId) {
        Query query = entityManager.createNativeQuery(
        "SELECT * "
        + "FROM EXPRESSION AS E, TAG AS T, EXPTAG AS ET "
        + "WHERE E.ID = ET.EXP "
        + "AND T.ID = ET.TAG "
        + "AND T.NOM = ?1 "
        + "AND E.ID = ?2", 
        Expression.class);

        query.setParameter(1, cleTag);
        query.setParameter(2, expId);

        List<Expression> exps = query.getResultList();
        if (exps.isEmpty()) {
            return null;
        } else {
            return exps.get(0);
        }
    }
    
}
