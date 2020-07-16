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
     * get the list of all the tags
     * @return the list of all the tags
     * @throws ResourceNotFoundException
     */
    @Override
    public List<Tag> getTags() throws ResourceNotFoundException {
        List<Tag> tags = tagRepository.findAll();
        if (tags.isEmpty()) throw new ResourceNotFoundException("Aucun tag enregistré");
        else return tags;
    }

    /**
     * get an tag by id
     * @param tagId
     * @return the tag corresponding to the id parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Tag getTagById(Integer tagId) throws ResourceNotFoundException {
        Tag tag = tagRepository.findById(tagId).orElseThrow(
            () -> new ResourceNotFoundException("Aucun tag trouvé avec l'id :: " + tagId)
        );
        return tag;
    }
    
    /**
     * get an tag by key
     * @param cleTag
     * @return the tag corresponding to the cleTag parameter
     * @throws ResourceNotFoundException
     */
    @Override
    public Tag getTagByKey(String cleTag) throws ResourceNotFoundException {
        Tag tag = tagRepository.findByKey(cleTag);
        if (tag == null) throw new ResourceNotFoundException("Aucun tag trouvé avec la clé :: " + cleTag);
        return tag;
    }
    
}
