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

    /**
     * get the list of all the authors
     * @return authors list
     */
    @GetMapping("/expressions")
    public List<Expression> getAllExpressions() { 
        return expressionService.retrieveExpressions();
    }

    /**
     * get an author by id
     * @param expressionId
     * @return the author corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    @GetMapping("/expressions/{id}")
    public ResponseEntity<Expression> getExpressionById(@PathVariable(value = "id") Integer expressionId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(expressionService.getExpression(expressionId));
    }

}