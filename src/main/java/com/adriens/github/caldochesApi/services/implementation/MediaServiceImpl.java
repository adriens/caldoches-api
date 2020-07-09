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
import java.util.Random;

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
    
    /**
     * set repository
     * @param auteurRepository
     */
    public void setMediaRepository(MediaRepository auteurRepository) {
        this.mediaRepository = auteurRepository;
    }

    /**
     * get all medias list
     * @return the list of all the medias
     */
    @Override
    public List<Media> getMedias() {
        List<Media> medias = mediaRepository.findAll();
        return medias;
    }

    /**
     * get a media by id
     * @param mediaId
     * @return a media corresponding to the mediaId parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Media getMedia(Integer mediaId) throws ResourceNotFoundException {
        Media media = mediaRepository.findById(mediaId).orElseThrow(
            () -> new ResourceNotFoundException("Aucun média trouvé avec l'id :: " + mediaId)
        );
        return media;
    }
    
    /**
     * get all medias for an author
     * @param cleAuteur
     * @return a medias list for the author corresponding to the cleAuteur parameter
     * @throws com.adriens.github.caldochesApi.exception.ResourceNotFoundException
     */
    @Override
    public List<Media> getMediasByAuteur(String cleAuteur) throws ResourceNotFoundException {
        List<Media> medias = mediaRepository.findByAuteur(cleAuteur);
        if (medias.isEmpty()) {
            throw new ResourceNotFoundException("Aucun média trouvé avec l'auteur :: " + cleAuteur);
        }
        return medias;
    }

    /**
     * get a media by id for an author
     * @param cleAuteur
     * @param mediaId
     * @return the media corresponding to the mediaId parameter for the author corresponding to the cleAuteur parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Media getMediaByIdByAuteur(String cleAuteur, Integer mediaId) throws ResourceNotFoundException {
        Media media = mediaRepository.findByIdByAuteur(cleAuteur, mediaId);
        if (media == null) {
            throw new ResourceNotFoundException("Aucun média trouvé avec l'id :: " + mediaId + " pour l'auteur :: " + cleAuteur);
        }
        return media;
    }

    /**
     * get a random media for an author
     * @param cleAuteur
     * @return a random media for the author corresponding to the cleAuteur parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Media getRandomMediaByAuteur(String cleAuteur) throws ResourceNotFoundException {
        int listSize = 0;
        List<Media> medias = mediaRepository.findByAuteur(cleAuteur);
        
        if (medias.isEmpty()) {
            throw new ResourceNotFoundException("Aucun média trouvé pour l'auteur :: " + cleAuteur);
        } else {
            listSize = medias.size();
            Random random = new Random();
            int randomValue = random.nextInt(listSize);
            return medias.get(randomValue);
        }
    }
    
}
