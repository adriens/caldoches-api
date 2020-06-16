/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.services.implementation;

import com.adriens.github.caldochesApi.entities.Media;
import com.adriens.github.caldochesApi.services.MediaService;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import com.adriens.github.caldochesApi.repositories.MediaRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author meilie
 */
@Service
public class MediaServiceImpl implements MediaService {
    
    @Autowired
    private MediaRepository mediaRepository;
    
    public void setMediaRepository(MediaRepository auteurRepository) {
        this.mediaRepository = auteurRepository;
    }

    @Override
    public List<Media> retrieveMedias() {
        List<Media> medias = mediaRepository.findAll();
        return medias;
    }

    @Override
    public Media getMedia(Long mediaId) throws ResourceNotFoundException {
        Media media = mediaRepository.findById(mediaId).orElseThrow(
            () -> new ResourceNotFoundException("Aucun média trouvé avec l'id :: " + mediaId)
        );
        return media;
    }

    @Override
    public void saveMedia(Media media) {
        mediaRepository.save(media);
    }
    
}
