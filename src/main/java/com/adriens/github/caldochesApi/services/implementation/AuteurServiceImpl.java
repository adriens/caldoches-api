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
import java.util.Random;

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
     * @throws ResourceNotFoundException
     */
    @Override
    public List<Auteur> getAuteurs() throws ResourceNotFoundException{
        List<Auteur> auteurs = auteurRepository.findAll();
        
        if (auteurs.isEmpty()) throw new ResourceNotFoundException("Aucun auteur enregistré");
        else return auteurs;
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
    
    @Override
    public Auteur getRandomAuteur() throws ResourceNotFoundException {
        int listSize;
        List<Auteur> auteurs = auteurRepository.findAll();
        
        if (auteurs.isEmpty()) {
            throw new ResourceNotFoundException("Aucun auteur enregistré");
        } else {
            listSize = auteurs.size();
            Random random = new Random();
            int randomValue = random.nextInt(listSize);
            return auteurs.get(randomValue);
        }
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
        
        if (auteur == null) throw new ResourceNotFoundException("Aucun auteur trouvé avec la clé :: " + cleAuteur);
        return auteur;
    }
    
}
