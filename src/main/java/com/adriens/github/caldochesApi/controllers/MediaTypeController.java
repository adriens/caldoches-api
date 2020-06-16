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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author meilie
 */
@RestController
@RequestMapping("/types")
public class MediaTypeController {

    @Autowired
    private MediaTypeService typeService;

    @GetMapping("/get")
    public List<MediaType> getAllMediaTypes() { 
        return typeService.retrieveMediaTypes();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MediaType> getMediaTypeById(@PathVariable(value = "id") Long typeId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(typeService.getMediaType(typeId));
    }

    @PostMapping("/create")
    public void createMediaType(@Valid @RequestBody MediaType type) {
        typeService.saveMediaType(type);
    }
    
}