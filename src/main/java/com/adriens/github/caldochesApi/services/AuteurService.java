/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.services;

import com.adriens.github.caldochesApi.entities.Auteur;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;

import java.util.List;

/**
 *
 * @author meilie
 */
public interface AuteurService {
    
    /**
     * get the list of all the authors
     * @return the list of all the authors
     */
    public List<Auteur> retrieveAuteurs();
    
    /**
     * get an author by id
     * @param auteurId
     * @return the author corresponding to the auteurId parameter
     * @throws ResourceNotFoundException
     */
    public Auteur getAuteur(Integer auteurId) throws ResourceNotFoundException;
    
}
