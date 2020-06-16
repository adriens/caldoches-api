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
    
    public List<Auteur> retrieveAuteurs();
    
    public Auteur getAuteur(Long auteurId) throws ResourceNotFoundException;
    
    public void saveAuteur(Auteur auteur);
    
}
