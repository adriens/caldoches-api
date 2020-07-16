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
     * @throws ResourceNotFoundException
     */
    public List<Auteur> getAuteurs() throws ResourceNotFoundException;
    
    /**
     * get an author by id
     * @param auteurId
     * @return the author corresponding to the auteurId parameter
     * @throws ResourceNotFoundException
     */
    public Auteur getAuteurById(Integer auteurId) throws ResourceNotFoundException;
    
    /**
     * get a random author
     * @return a random author
     * @throws ResourceNotFoundException
     */
    public Auteur getRandomAuteur() throws ResourceNotFoundException;
    
    /**
     * get an author by key
     * @param cleAuteur
     * @return the author corresponding to the cleAuteur parameter
     * @throws ResourceNotFoundException
     */
    public Auteur getAuteurByKey(String cleAuteur) throws ResourceNotFoundException;
    
}
