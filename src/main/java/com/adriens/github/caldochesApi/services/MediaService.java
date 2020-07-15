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
    public List<Media> getMedias() throws ResourceNotFoundException;

    /**
     * get a media by id
     * @param mediaId
     * @return the media corresponding to the mediaId parameter
     * @throws ResourceNotFoundException
     */
    public Media getMedia(Integer mediaId) throws ResourceNotFoundException;

    /**
     * get a random media
     * @return a random media
     */
    public Media getRandomMedia() throws ResourceNotFoundException;
    
    /**
     * get the list of all the medias for an author
     * @param cleAuteur
     * @return the list of all the medias corresponding to the author corresponding to the cleAuteur parameter
     * @throws com.adriens.github.caldochesApi.exception.ResourceNotFoundException
     */
    public List<Media> getMediasByAuteur(String cleAuteur) throws ResourceNotFoundException;
    
    /**
     * get a media by id for an author
     * @param cleAuteur
     * @param mediaId
     * @return the media corresponding to the mediaId parameter for the author corresponding to the cleAuteur parameter
     * @throws ResourceNotFoundException
     */
    public Media getMediaByIdByAuteur(String cleAuteur, Integer mediaId) throws ResourceNotFoundException;
    
    /**
     * get a random media for an author
     * @param cleAuteur
     * @return a random media for the author corresponding to the cleAuteur parameter
     * @throws ResourceNotFoundException
     */
    public Media getRandomMediaByAuteur(String cleAuteur) throws ResourceNotFoundException;
}
