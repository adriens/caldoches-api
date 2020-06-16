/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.services.implementation;

import com.adriens.github.caldochesApi.entities.MediaType;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import com.adriens.github.caldochesApi.repositories.MediaTypeRepository;
import com.adriens.github.caldochesApi.services.MediaTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author meilie
 */
@Service
public class MediaTypeServiceImpl implements MediaTypeService {

    @Autowired
    private MediaTypeRepository typeRepository;
    
    public void setMediaRepository(MediaTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }
    
    @Override
    public List<MediaType> retrieveMediaTypes() {
        List<MediaType> types = typeRepository.findAll();
        return types;
    }

    @Override
    public MediaType getMediaType(Long typeId) throws ResourceNotFoundException {
        MediaType type = typeRepository.findById(typeId).orElseThrow(
            () -> new ResourceNotFoundException("Aucun type de média trouvé avec l'id :: " + typeId)
        );
        return type;
    }

    @Override
    public void saveMediaType(MediaType type) {
        typeRepository.save(type);
    }
    
}
