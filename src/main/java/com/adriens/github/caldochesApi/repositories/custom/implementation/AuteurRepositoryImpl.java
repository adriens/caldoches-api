/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.repositories.custom.implementation;

import com.adriens.github.caldochesApi.entities.Auteur;
import com.adriens.github.caldochesApi.repositories.custom.AuteurRepositoryCustom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author meilie
 */
@Repository
@Transactional(readOnly = true)
public class AuteurRepositoryImpl implements AuteurRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;
    
    /**
     * get the author by cleAteur key 
     * @param cleAuteur
     * @return the author corresponding to the cleAuteur parameter
     */
    @Override
    public Auteur findByKey(String cleAuteur) {
        Query query = entityManager.createNativeQuery(
            "SELECT * "
            + "FROM AUTEUR AS A "
            + "WHERE A.CLE_AUTEUR = ?1",
            Auteur.class);
        
        query.setParameter(1, cleAuteur);
        
        List<Auteur> auteurs = query.getResultList();
        if (auteurs.isEmpty()) return null;
        else return auteurs.get(0);
    }
    
}