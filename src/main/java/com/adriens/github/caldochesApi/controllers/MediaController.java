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
    public List<Media> getAllMedias() { 
        return mediaService.retrieveMedias();
    }

    /**
    public ResponseEntity<Media> getMediaById(@PathVariable(value = "id") Long mediaId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(mediaService.getMedia(mediaId));
    }

    /**
     * get the media by id for an author
     * @param cleAuteur
    }

}