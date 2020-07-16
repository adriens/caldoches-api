/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.controllers;

import com.adriens.github.caldochesApi.entities.Media;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import com.adriens.github.caldochesApi.services.MediaService;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author meilie
 */
@RestController
public class MediaController {
    
    @Autowired
    private MediaService mediaService;
    
    private Media lastRandomMedia = new Media();

    /**
     * get the list of all the medias
     * @return the list of all the medias
     * @throws ResourceNotFoundException
     */
    @GetMapping("/medias")
    public List<Media> getAllMedias() throws ResourceNotFoundException { 
        return mediaService.getMedias();
    }
    
    /**
     * get a media by id
     * @param mediaId
     * @return a media corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    @GetMapping("/medias/media/{id}")
    public ResponseEntity<Media> getMediaById(@PathVariable(value = "id") Integer mediaId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(mediaService.getMedia(mediaId));
    }
    
    /**
     * get a random media
     * @return a random media
     * @throws ResourceNotFoundException
     */
    @GetMapping("/medias/random")
    public ResponseEntity<Media> getRandomMedia() throws ResourceNotFoundException {
        Media media = mediaService.getRandomMedia();
        if(lastRandomMedia.getId()!=null) 
            while(Objects.equals(media.getId(), lastRandomMedia.getId())) { media = mediaService.getRandomMedia(); }
        lastRandomMedia = media;
        return ResponseEntity.ok().body(media);
    }

    /**
     * get the list of all the medias for an author
     * @param cleAuteur
     * @return the media's list for an author corresponding to the cleAuteur parameter
     * @throws ResourceNotFoundException
     */
    @GetMapping("/medias/auteur/{cleAuteur}")
    public ResponseEntity<List<Media>> getAllMediasByAuteur(@PathVariable(value = "cleAuteur") String cleAuteur) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(mediaService.getMediasByAuteur(cleAuteur));
    }

    /**
     * get the media by id for an author
     * @param cleAuteur
     * @param mediaId
     * @return a media corresponding to the id parameter for an author corresponding to the cleAuteur parameter
     * @throws ResourceNotFoundException
     */
    @GetMapping("/medias/auteur/{cleAuteur}/media/{id}")
    public ResponseEntity<Media> getMediaByIdByAuteur(@PathVariable(value = "cleAuteur") String cleAuteur, @PathVariable(value = "id") Integer mediaId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(mediaService.getMediaByIdByAuteur(cleAuteur, mediaId));
    }
    
    /**
     * get a random media for an author
     * @param cleAuteur
     * @return a random media for an author corresponding to the cleAuteur parameter
     * @throws ResourceNotFoundException
     */
    @GetMapping("/medias/auteur/{cleAuteur}/random")
    public ResponseEntity<Media> getRandomMediaByAuteur(@PathVariable(value = "cleAuteur") String cleAuteur) throws ResourceNotFoundException {
        Media media = mediaService.getRandomMediaByAuteur(cleAuteur);
        if(lastRandomMedia.getId()!=null) 
            while(Objects.equals(media.getId(), lastRandomMedia.getId())) { media = mediaService.getRandomMediaByAuteur(cleAuteur); }
        lastRandomMedia = media;
        return ResponseEntity.ok().body(media);
    }

}