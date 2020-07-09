/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.repositories.custom;

import com.adriens.github.caldochesApi.entities.Auteur;

import java.util.List;

/**
 *
 * @author meilie
 */
public interface AuteurRepositoryCustom {
    
    /**
     * get the author by key 
     * @param cleAuteur
     * @return the author corresponding to the cleAuteur parameter
     */
    public Auteur findByKey(String cleAuteur);
    
}
