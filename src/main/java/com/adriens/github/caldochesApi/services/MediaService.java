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
    
    public List<Media> retrieveMedias();
    
    public Media getMedia(Long mediaId) throws ResourceNotFoundException;
    
    public void saveMedia(Media media);
    
}
