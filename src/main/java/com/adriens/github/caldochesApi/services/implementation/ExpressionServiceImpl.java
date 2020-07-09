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
import java.util.Random;

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
    
    /**
     * get all expressions for a tag
     * @param cleTag
     * @return a expression's list for the tag corresponding to the cleTag parameter
     * @throws com.adriens.github.caldochesApi.exception.ResourceNotFoundException
     */
    @Override
    public List<Expression> getExpressionsByTag(String cleTag) throws ResourceNotFoundException {
        List<Expression> exps = expRepository.findByTag(cleTag);
        if (exps.isEmpty()) {
            throw new ResourceNotFoundException("Aucune expression trouvée avec le tag :: " + cleTag);
        }
        return exps;
    }
    
    /**
     * get a media by id for an author
     * @param cleAuteur
     * @param mediaId
     * @return the media corresponding to the mediaId parameter for the author corresponding to the cleAuteur parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Expression getExpressionByIdByTag(String cleTag, Integer expId) throws ResourceNotFoundException {
        Expression exp = expRepository.findByIdByTag(cleTag, expId);
        if (exp == null) {
            throw new ResourceNotFoundException("Aucune expression trouvée avec l'id :: " + expId + " pour le tag :: " + cleTag);
        }
        return exp;
    }

    /**
     * get a random expression for a tag key
     * @param cleTag
     * @return a random expression for the tag corresponding to the cleTag parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Expression getRandomExpressionByTag(String cleTag) throws ResourceNotFoundException {
        int listSize = 0;
        List<Expression> exps = expRepository.findByTag(cleTag);
        
        if (exps.isEmpty()) {
            throw new ResourceNotFoundException("Aucune expression trouvée pour le tag :: " + cleTag);
        } else {
            listSize = exps.size();
            Random random = new Random();
            int randomValue = random.nextInt(listSize);
            return exps.get(randomValue);
        }
    }
}
