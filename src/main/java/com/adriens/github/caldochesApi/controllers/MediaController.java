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

    /**
     * get the list of all the medias
     * @return the list of all the medias
     */
    @GetMapping("/medias")
    public List<Media> getAllMedias() { 
        return mediaService.getMedias();
    }

    /**
     * get the list of all the medias for an author
     * @param cleAuteur
     * @return the media's list for an author
     * @throws ResourceNotFoundException
     */
    @GetMapping("/medias/auteur/{cleAuteur}")
    public ResponseEntity<List<Media>> getAllMediasByAuteur(@PathVariable(value = "cleAuteur") String cleAuteur) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(mediaService.getMediasByAuteur(cleAuteur));
    }

    /**
     * get a media by id
     * @param mediaId
     * @return a media corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    @GetMapping("/medias/{id}")
    public ResponseEntity<Media> getMediaById(@PathVariable(value = "id") Integer mediaId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(mediaService.getMedia(mediaId));
    }

    /**
     * get the media by id for an author
     * @param cleAuteur
     * @param mediaId
     * @return a media corresponding to the id parameter for an author
     * @throws ResourceNotFoundException
     */
    @GetMapping("/medias/auteur/{cleAuteur}/{id}")
    public ResponseEntity<Media> getMediaByIdByAuteur(@PathVariable(value = "cleAuteur") String cleAuteur, @PathVariable(value = "id") Integer mediaId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(mediaService.getMediaByIdByAuteur(cleAuteur, mediaId));
    }
    
    /**
     * get a random media for an author
     * @param cleAuteur
     * @return a random media for an author
     * @throws ResourceNotFoundException
     */
    @GetMapping("/medias/auteur/{cleAuteur}/random")
    public ResponseEntity<Media> getRandomMediaByAuteur(@PathVariable(value = "cleAuteur") String cleAuteur) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(mediaService.getRandomMediaByAuteur(cleAuteur));
    }

}