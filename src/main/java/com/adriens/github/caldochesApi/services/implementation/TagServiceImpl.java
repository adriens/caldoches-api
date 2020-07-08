/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.services.implementation;

import com.adriens.github.caldochesApi.entities.Tag;
import com.adriens.github.caldochesApi.exception.ResourceNotFoundException;
import com.adriens.github.caldochesApi.repositories.TagRepository;
import com.adriens.github.caldochesApi.services.TagService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author meilie
 */
@Service
public class TagServiceImpl implements TagService {
    
    @Autowired
    private TagRepository tagRepository;
    
    /**
     * set the repository
     * @param tagRepository
     */
    public void setTagRepository(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    /**
     * get the list of all the authors
     * @return the list of all the authors
     */
    @Override
    public List<Tag> retrieveTags() {
        List<Tag> tags = tagRepository.findAll();
        System.out.println(tags);
        return tags;
    }

    /**
     * get an author by id
     * @param tagId
     * @return the author corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Tag getTag(Integer tagId) throws ResourceNotFoundException {
        Tag tag = tagRepository.findById(tagId).orElseThrow(
            () -> new ResourceNotFoundException("Aucun tag trouvé avec l'id :: " + tagId)
        );
        return tag;
    }
    
}
