/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.repositories.custom.implementation;

import com.adriens.github.caldochesApi.entities.Tag;
import com.adriens.github.caldochesApi.repositories.custom.TagRepositoryCustom;

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
public class TagRepositoryImpl implements TagRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;
    
    /**
     * get the tag by key
     * @param cleTag
     * @return the tag corresponding to the cleTag parameter
     */
    @Override
    public Tag findByKey(String cleTag) {
        Query query = entityManager.createNativeQuery(
            "SELECT * "
            + "FROM TAG AS A "
            + "WHERE A.NOM = ?1",
            Tag.class);
        
        query.setParameter(1, cleTag);
        
        List<Tag> tags = query.getResultList();
        if (tags.isEmpty()) return null;
        else return tags.get(0);
    }
    
}
