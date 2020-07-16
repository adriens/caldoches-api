/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.services;

import com.adriens.github.caldochesApi.entities.Tag;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import java.util.List;

/**
 *
 * @author meilie
 */
public interface TagService {
    
    /**
     * get the list of all the tags
     * @return the list of all the tags
     * @throws ResourceNotFoundException
    */
    public List<Tag> getTags() throws ResourceNotFoundException;
    
    /**
     * get an tag by id
     * @param tagId
     * @return the tag corresponding to the tagId parameter
     * @throws ResourceNotFoundException
     */
    public Tag getTagById(Integer tagId) throws ResourceNotFoundException;
    
    /**
     * get an tag by key
     * @param cleTag
     * @return the tag corresponding to the cleTag parameter
     * @throws ResourceNotFoundException
     */
    public Tag getTagByKey(String cleTag) throws ResourceNotFoundException;
    
}
