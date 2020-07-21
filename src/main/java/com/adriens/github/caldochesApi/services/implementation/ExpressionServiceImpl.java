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
import java.util.ArrayList;

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
     * @throws ResourceNotFoundException
     */
    @Override
    public List<Expression> getExpressions() throws ResourceNotFoundException {
        List<Expression> exps = expRepository.findAll();
        
        if (exps.isEmpty()) throw new ResourceNotFoundException("Aucune expression enregistrée");
        else return exps;
    }

    /**
     * get an expression by id
     * @param idExpression
     * @return the expression corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Expression getExpression(Integer idExpression) throws ResourceNotFoundException {
        Expression exp = expRepository.findById(idExpression).orElseThrow(
            () -> new ResourceNotFoundException("Aucune expression trouvée avec l'id :: " + idExpression)
        );
        return exp;
    }
    
    /**
     * get a random expression
     * @return a random expression
     * @throws ResourceNotFoundException
     */
    @Override
    public Expression getRandomExpression() throws ResourceNotFoundException {
        int listSize;
        List<Expression> exps = expRepository.findAll();
        
        if (exps.isEmpty()) throw new ResourceNotFoundException("Aucune expression enregistrée");
        else {
            listSize = exps.size();
            Random random = new Random();
            int randomValue = random.nextInt(listSize);
            return exps.get(randomValue);
        }
    }
    
    /**
     * get a list of all the expression with motscles in it
     * @param motscles
     * @return an expression's list corresponding to motscles in parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public List<Expression> getExpressionsByMotscles(String motscles) throws ResourceNotFoundException {
        List<Expression> exps = new ArrayList<>();
        String[] t_motcles = motscles.split(",");
        for (String motcle : t_motcles) {
            exps.addAll(expRepository.findByMotcle(motcle));
        }
        if (exps.isEmpty()) throw new ResourceNotFoundException("Aucune expression trouvée avec les mots-clés :: " + motscles);
        else return exps;
    }
    
    /**
     * get a random expression with motscles in it
     * @param motscles
     * @return a random expression corresponding to motscles in parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Expression getRandomExpressionByMotscles(String motscles) throws ResourceNotFoundException {
        int listSize;
        List <Expression> exps = getExpressionsByMotscles(motscles);
        if (exps.isEmpty()) throw new ResourceNotFoundException("Aucune expression trouvée pour les mots-clés :: " + motscles);
        else {
            listSize = exps.size();
            Random random = new Random();
            int randomValue = random.nextInt(listSize);
            return exps.get(randomValue);
        }
    }
    
    /**
     * get all expressions for a tag
     * @param cleTag
     * @return a expression's list for the tag corresponding to the cleTag parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public List<Expression> getExpressionsByTag(String cleTag) throws ResourceNotFoundException {
        List<Expression> exps = expRepository.findByTag(cleTag);
        if (exps.isEmpty()) throw new ResourceNotFoundException("Aucune expression trouvée avec le tag :: " + cleTag);
        else return exps;
    }
    
    /**
     * get an expression by idExpression for a tag key
     * @param cleTag
     * @param idExpression
     * @return the expression corresponding to the idExpression parameter for the tag corresponding to the cleTag parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Expression getExpressionByIdByTag(String cleTag, Integer idExpression) throws ResourceNotFoundException {
        Expression exp = expRepository.findByIdByTag(cleTag, idExpression);
        if (exp == null) throw new ResourceNotFoundException("Aucune expression trouvée avec l'id :: " + idExpression + " pour le tag :: " + cleTag);
        else return exp;
    }

    /**
     * get a random expression for a tag key
     * @param cleTag
     * @return a random expression for the tag corresponding to the cleTag parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Expression getRandomExpressionByTag(String cleTag) throws ResourceNotFoundException {
        int listSize;
        List<Expression> exps = getExpressionsByTag(cleTag);
        
        if (exps.isEmpty()) throw new ResourceNotFoundException("Aucune expression trouvée pour le tag :: " + cleTag);
        else {
            listSize = exps.size();
            Random random = new Random();
            int randomValue = random.nextInt(listSize);
            return exps.get(randomValue);
        }
    }
}
