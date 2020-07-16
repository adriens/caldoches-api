/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.controllers;

import com.adriens.github.caldochesApi.entities.Expression;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import com.adriens.github.caldochesApi.services.ExpressionService;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author meilie
 */
@RestController
public class ExpressionController {
    
    @Autowired
    private ExpressionService expressionService;
    
    private Expression lastRandomExpression = new Expression();

    /**
     * get the list of all the expressions
     * @return expressions list
     * @throws ResourceNotFoundException
     */
    @GetMapping("/expressions")
    public List<Expression> getAllExpressions() throws ResourceNotFoundException { 
        return expressionService.getExpressions();
    }

    /**
     * get an expression by id
     * @param idExpression
     * @return the expression corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    @GetMapping("/expressions/expression/{idExpression}")
    public ResponseEntity<Expression> getExpressionById(@PathVariable(value = "idExpression") Integer idExpression) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(expressionService.getExpression(idExpression));
    }
    
    /**
     * get a random expression
     * @return a random expression
     * @throws ResourceNotFoundException
     */
    @GetMapping("/expressions/random")
    public ResponseEntity<Expression> getRandomExpression() throws ResourceNotFoundException {
        Expression exp = expressionService.getRandomExpression();
        if(lastRandomExpression.getId()!=null) 
            while(Objects.equals(exp.getId(), lastRandomExpression.getId())) { exp = expressionService.getRandomExpression(); }
        lastRandomExpression = exp;
        return ResponseEntity.ok().body(exp);
    }
    
    /**
     * get the list of all the expressions for a tag
     * @param cleTag
     * @return the expression's list for a tag
     * @throws ResourceNotFoundException
     */
    @GetMapping("/expressions/tag/{cleTag}")
    public ResponseEntity<List<Expression>> getExpressionByTag(@PathVariable(value = "cleTag") String cleTag) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(expressionService.getExpressionsByTag(cleTag));
    }
    
    /**
     * get the expression by id for a tag key
     * @param cleTag
     * @param idExpression
     * @return an expression corresponding to the expId parameter for a tag with cleTag key
     * @throws ResourceNotFoundException
     */
    @GetMapping("/expressions/tag/{cleTag}/expression/{idExpression}")
    public ResponseEntity<Expression> getExpressionByIdByTag(@PathVariable(value = "cleTag") String cleTag, @PathVariable(value = "idExpression") Integer idExpression) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(expressionService.getExpressionByIdByTag(cleTag, idExpression));
    }
    
    /**
     * get a random expression for a tag key
     * @param cleTag
     * @return a random expression for a tag
     * @throws ResourceNotFoundException
     */
    @GetMapping("/expressions/tag/{cleTag}/random")
    public ResponseEntity<Expression> getRandomMediaByAuteur(@PathVariable(value = "cleTag") String cleTag) throws ResourceNotFoundException {
        Expression exp = expressionService.getRandomExpressionByTag(cleTag);
        if(lastRandomExpression.getId()!=null) 
            while(Objects.equals(exp.getId(), lastRandomExpression.getId())) { exp = expressionService.getRandomExpressionByTag(cleTag); }
        lastRandomExpression = exp;
        return ResponseEntity.ok().body(exp);
    }
}