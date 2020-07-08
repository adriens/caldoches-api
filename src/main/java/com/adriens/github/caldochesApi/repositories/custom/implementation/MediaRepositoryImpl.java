/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.repositories.custom.implementation;

import com.adriens.github.caldochesApi.entities.Media;
import com.adriens.github.caldochesApi.repositories.custom.MediaRepositoryCustom;

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
public class MediaRepositoryImpl implements MediaRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;
    
    /**
     * get the media list for an author
     * @param cleAuteur
     * @return the media list corresponding to the cleAuteur parameter
     */
    @Override
    public List<Media> findByAuteur(String cleAuteur) {
        Query query = entityManager.createNativeQuery(
            "SELECT * "
            + "FROM MEDIA AS M, AUTEUR AS A "
            + "WHERE A.ID = M.AUTEUR "
            + "AND A.CLE_AUTEUR = ?1",
            Media.class);
        
        query.setParameter(1, cleAuteur);
        
        return query.getResultList();
    }

    /**
     * get a media by id for an author
     * @param cleAuteur
     * @param mediaId
     * @return the media corresponding to the mediaId parameter for the author corresponding to the cleAuteur parameter
     */
    @Override
    public Media findByIdByAuteur(String cleAuteur, Integer mediaId) {
        Query query = entityManager.createNativeQuery(
        "SELECT * "
        + "FROM MEDIA AS M, AUTEUR AS A "
        + "WHERE A.ID = M.AUTEUR "
        + "AND A.CLE_AUTEUR = ?1 "
        + "AND M.ID = ?2", 
        Media.class);

        query.setParameter(1, cleAuteur);
        query.setParameter(2, mediaId);

        List<Media> medias = query.getResultList();
        if (medias.isEmpty()) {
            return null;
        } else {
            return medias.get(0);
        }
    }
    
}
