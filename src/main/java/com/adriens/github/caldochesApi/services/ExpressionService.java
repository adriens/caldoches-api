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
    
    public List<Expression> retrieveExpressions();
    
    public Expression getExpression(Integer expressionId) throws ResourceNotFoundException;
    
}
