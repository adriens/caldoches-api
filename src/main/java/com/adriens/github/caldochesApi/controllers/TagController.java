/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.controllers;

import com.adriens.github.caldochesApi.entities.Tag;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import com.adriens.github.caldochesApi.services.TagService;

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
public class TagController {
    
    @Autowired
    private TagService tagService;

    /**
     * get the list of all the authors
     * @return authors list
     */
    @GetMapping("/tags")
    public List<Tag> getAllTags() { 
        return tagService.retrieveTags();
    }

    /**
     * get an author by id
     * @param tagId
     * @return the author corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    @GetMapping("/tags/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable(value = "id") Integer tagId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(tagService.getTag(tagId));
    }

}