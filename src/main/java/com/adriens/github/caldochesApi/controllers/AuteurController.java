/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.controllers;

import com.adriens.github.caldochesApi.entities.Auteur;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import com.adriens.github.caldochesApi.services.AuteurService;

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
public class AuteurController {
    
    @Autowired
    private AuteurService auteurService;
    
    private Auteur lastRandomAuteur = new Auteur();
    
    /**
     * get the list of all the authors
     * @return authors list
     * @throws ResourceNotFoundException
     */
    @GetMapping("/auteurs")
    public List<Auteur> getAllAuteurs() throws ResourceNotFoundException { 
        return auteurService.getAuteurs();
    }

    /**
     * get an author by id
     * @param auteurId
     * @return the author corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    
    @GetMapping("/auteurs/auteur/{id}")
    public ResponseEntity<Auteur> getAuteurById(@PathVariable(value = "id") Integer auteurId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(auteurService.getAuteurById(auteurId));
    }
    
    /**
     * get an author by cleAuteur
     * @param cleAuteur
     * @return the author corresponding to the cleAuteur parameter
     * @throws ResourceNotFoundException
     */
    @GetMapping("/auteurs/{cleAuteur}")
    public ResponseEntity<Auteur> getAuteurByKey(@PathVariable(value = "cleAuteur") String cleAuteur) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(auteurService.getAuteurByKey(cleAuteur));
    }
    
    /**
     * get a random author
     * @return a random author
     * @throws ResourceNotFoundException
     */
    
    @GetMapping("/auteurs/random")
    public ResponseEntity<Auteur> getRandomAuteur() throws ResourceNotFoundException {
        Auteur auteur = auteurService.getRandomAuteur();
        if(lastRandomAuteur.getId()!=null) 
            while(Objects.equals(auteur.getId(), lastRandomAuteur.getId())) { auteur = auteurService.getRandomAuteur(); }
        lastRandomAuteur = auteur;
        return ResponseEntity.ok().body(auteur);
    }

}