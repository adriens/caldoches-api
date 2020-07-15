/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.services;

import com.adriens.github.caldochesApi.entities.MediaType;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import java.util.List;

/**
 *
 * @author meilie
 */
public interface MediaTypeService {
    
    /**
     * get the list of all mediatypes
     * @return the list of all mediatypes
     */
    public List<MediaType> getMediaTypes() throws ResourceNotFoundException;
    
    /**
     * get a mediatype by id
     * @param typeId
     * @return the mediatype corresponding to the typeId parameter
     * @throws ResourceNotFoundException
     */
    public MediaType getMediaType(Integer typeId) throws ResourceNotFoundException;
    
}
