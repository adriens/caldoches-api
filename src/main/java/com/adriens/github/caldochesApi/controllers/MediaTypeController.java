/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.controllers;

import com.adriens.github.caldochesApi.entities.MediaType;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import com.adriens.github.caldochesApi.services.MediaTypeService;

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
public class MediaTypeController {

    @Autowired
    private MediaTypeService typeService;

    /**
     * get the list of all media types
     * @return the list of all media types
     * @throws ResourceNotFoundException
     */
    @GetMapping("/types")
    public List<MediaType> getAllMediaTypes() throws ResourceNotFoundException { 
        return typeService.getMediaTypes();
    }

    /**
     * get a media type by id
     * @param typeId
     * @return the media type corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    @GetMapping("/types/type/{id}")
    public ResponseEntity<MediaType> getMediaTypeById(@PathVariable(value = "id") Integer typeId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(typeService.getMediaType(typeId));
    }
    
}