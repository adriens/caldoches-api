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

    /**
     * get the list of all the authors
     * @return authors list
     */
    @GetMapping("/auteurs")
    public List<Auteur> getAllAuteurs() { 
        return auteurService.getAuteurs();
    }

    /**
     * get an author by id
     * @param auteurId
     * @return the author corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    
    @GetMapping("/auteurs/{id}")
    public ResponseEntity<Auteur> getAuteurById(@PathVariable(value = "id") Integer auteurId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(auteurService.getAuteurById(auteurId));
    }
    
}