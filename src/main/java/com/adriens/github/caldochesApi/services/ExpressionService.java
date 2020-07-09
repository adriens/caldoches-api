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
    public List<Expression> getExpressions();
    
    /**
     * get a expression by id
     * @param expressionId
     * @return the expression corresponding to the expressionId parameter
     * @throws ResourceNotFoundException
     */
    public Expression getExpression(Integer expressionId) throws ResourceNotFoundException;
    
}
