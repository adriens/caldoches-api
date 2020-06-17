/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.repositories.custom;

import com.adriens.github.caldochesApi.entities.Media;

import java.util.List;

/**
 *
 * @author meilie
 */
public interface MediaRepositoryCustom {
    
    /**
     * get the media list for an author
     * @param cleAuteur
     * @return the media list corresponding to the cleAuteur parameter
     */
    public List<Media> findByAuteur(String cleAuteur);
    
    /**
     * get a media by id for an author
     * @param cleAuteur
     * @param mediaId
     * @return the media corresponding to the mediaId parameter for the author corresponding to the cleAuteur parameter
     */
    public Media findByIdByAuteur(String cleAuteur, Long mediaId);
    
}
