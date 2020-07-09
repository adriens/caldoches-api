/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.services.implementation;

import com.adriens.github.caldochesApi.entities.Expression;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import com.adriens.github.caldochesApi.repositories.ExpressionRepository;
import com.adriens.github.caldochesApi.services.ExpressionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author meilie
 */
@Service
public class ExpressionServiceImpl implements ExpressionService {
    
    @Autowired
    private ExpressionRepository expRepository;
    
    /**
     * set the repository
     * @param expRepository
     */
    public void setExpressionRepository(ExpressionRepository expRepository) {
        this.expRepository = expRepository;
    }

    /**
     * get the list of all the expressions
     * @return the list of all the expressions
     */
    @Override
    public List<Expression> getExpressions() {
        List<Expression> exps = expRepository.findAll();
        return exps;
    }

    /**
     * get an expression by id
     * @param expressionId
     * @return the expression corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Expression getExpression(Integer expressionId) throws ResourceNotFoundException {
        Expression exp = expRepository.findById(expressionId).orElseThrow(
            () -> new ResourceNotFoundException("Aucune expression trouvée avec l'id :: " + expressionId)
        );
        return exp;
    }
}
