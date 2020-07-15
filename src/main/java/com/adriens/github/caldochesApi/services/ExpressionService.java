/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.services;

import com.adriens.github.caldochesApi.entities.Expression;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import java.util.List;

/**
 *
 * @author meilie
 */
public interface ExpressionService {
    
    /**
     * get the list of all the expressions
     * @return the list of all the expressions
     */
    public List<Expression> getExpressions() throws ResourceNotFoundException;
    
    /**
     * get a expression by id
     * @param expressionId
     * @return the expression corresponding to the expressionId parameter
     * @throws ResourceNotFoundException
     */
    public Expression getExpression(Integer expressionId) throws ResourceNotFoundException;
 
    /**
     * get a random expression
     * @return a random expression
     */
    public Expression getRandomExpression() throws ResourceNotFoundException;
    
    /**
     * get the list of all the expressions for a tag
     * @param cleTag
     * @return the list of all the expressions corresponding to the tag corresponding to the cleTag parameter
     * @throws com.adriens.github.caldochesApi.exception.ResourceNotFoundException
     */
    public List<Expression> getExpressionsByTag(String cleTag) throws ResourceNotFoundException;
    
    /**
     * get an expression by id for a tag key
     * @param cleTag
     * @param expId
     * @return the expression corresponding to the expId parameter for the tag corresponding to the cleTag parameter
     * @throws ResourceNotFoundException
     */
    public Expression getExpressionByIdByTag(String cleTag, Integer expId) throws ResourceNotFoundException;
    
    /**
     * get a random expression for a tag key
     * @param cleTag
     * @return a random expression for the tag corresponding to the cleTag parameter
     * @throws ResourceNotFoundException
     */
    public Expression getRandomExpressionByTag(String cleTag) throws ResourceNotFoundException;
    
}
