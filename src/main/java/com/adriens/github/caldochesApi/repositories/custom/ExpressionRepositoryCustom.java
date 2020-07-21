/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.repositories.custom;

import com.adriens.github.caldochesApi.entities.Expression;

import java.util.List;

/**
 *
 * @author meilie
 */
public interface ExpressionRepositoryCustom {
    
    /**
     * get an expression by id for a tag key
     * @param motcle
     * @return the expression corresponding to the expId parameter for the tag corresponding to the cleTag parameter
     */
    public List<Expression> findByMotcle(String motcle);
    
    /**
     * get the expression's list for a tag
     * @param cleTag
     * @return the expression's list corresponding to the tag with cleTag parameter
     */
    public List<Expression> findByTag(String cleTag);
    
    /**
     * get an expression by id for a tag key
     * @param cleTag
     * @param expId
     * @return the expression corresponding to the expId parameter for the tag corresponding to the cleTag parameter
     */
    public Expression findByIdByTag(String cleTag, Integer expId);
    
}
