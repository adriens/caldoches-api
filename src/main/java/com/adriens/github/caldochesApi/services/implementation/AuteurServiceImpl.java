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
    
    public void setAuteurRepository(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    @Override
    public List<Auteur> retrieveAuteurs() {
        List<Auteur> auteurs = auteurRepository.findAll();
        return auteurs;
    }

    @Override
    public Auteur getAuteur(Long auteurId) throws ResourceNotFoundException {
        Auteur auteur = auteurRepository.findById(auteurId).orElseThrow(
            () -> new ResourceNotFoundException("Aucun auteur trouvé avec l'id :: " + auteurId)
        );
        return auteur;
    }

    @Override
    public void saveAuteur(Auteur auteur) {
        auteurRepository.save(auteur);
    }
    
}
