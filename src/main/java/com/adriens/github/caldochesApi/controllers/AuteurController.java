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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author meilie
 */
@RestController
@RequestMapping("/auteurs")
public class AuteurController {
    
    @Autowired
    private AuteurService auteurService;

    /**
     * get the list of all the authors
     * @return authors list
     */
    @GetMapping("/auteurs")
    public List<Auteur> getAllAuteurs() { 
        return auteurService.retrieveAuteurs();
    }

    /**
     * get an author by id
     * @param auteurId
     * @return the author corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    @GetMapping("/auteurs/{id}")
    public ResponseEntity<Auteur> getAuteurById(@PathVariable(value = "id") Long auteurId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(auteurService.getAuteur(auteurId));
    }

    /**
     *
     * @param auteur
     */
    @PostMapping("/create")
    public void createAuteur(@Valid @RequestBody Auteur auteur) {
        auteurService.saveAuteur(auteur);
    }

}