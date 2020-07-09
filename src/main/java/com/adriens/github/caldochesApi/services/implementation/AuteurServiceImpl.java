/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.services.implementation;

import com.adriens.github.caldochesApi.entities.Auteur;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import com.adriens.github.caldochesApi.repositories.AuteurRepository;
import com.adriens.github.caldochesApi.services.AuteurService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author meilie
 */
@Service
public class AuteurServiceImpl implements AuteurService {
    
    @Autowired
    private AuteurRepository auteurRepository;
    
    /**
     * set the repository
     * @param auteurRepository
     */
    public void setAuteurRepository(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    /**
     * get the list of all the authors
     * @return the list of all the authors
     */
    @Override
    public List<Auteur> getAuteurs() {
        List<Auteur> auteurs = auteurRepository.findAll();
        return auteurs;
    }

    /**
     * get an author by id
     * @param auteurId
     * @return the author corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Auteur getAuteurById(Integer auteurId) throws ResourceNotFoundException {
        Auteur auteur = auteurRepository.findById(auteurId).orElseThrow(
            () -> new ResourceNotFoundException("Aucun auteur trouvé avec l'id :: " + auteurId)
        );
        return auteur;
    }
    
    /**
     * get an author by key
     * @param cleAuteur
     * @return the author corresponding to the cleAuteur parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Auteur getAuteurByKey(String cleAuteur) throws ResourceNotFoundException {
        Auteur auteur = auteurRepository.findByKey(cleAuteur);
        if (auteur == null) {
            throw new ResourceNotFoundException("Aucun auteur trouvé avec la clé :: " + cleAuteur);
        }
        return auteur;
    }
    
}
