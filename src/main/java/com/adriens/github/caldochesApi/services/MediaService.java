/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.services;

import com.adriens.github.caldochesApi.entities.Media;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import java.util.List;

/**
 *
 * @author meilie
 */
public interface MediaService {
    
    /**
     * get the list of all the medias
     * @return the list of all the medias
     */
    public List<Media> retrieveMedias();
    
    /**
     * get a media by id
     * @param mediaId
     * @return the media corresponding to the mediaId parameter
     * @throws ResourceNotFoundException
     */
    public Media getMedia(Long mediaId) throws ResourceNotFoundException;

    /**
    
}
