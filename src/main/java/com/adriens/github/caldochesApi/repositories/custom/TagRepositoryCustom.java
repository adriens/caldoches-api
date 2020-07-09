/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.repositories.custom;

import com.adriens.github.caldochesApi.entities.Tag;

/**
 *
 * @author meilie
 */
public interface TagRepositoryCustom {
    
    /**
     * get the tag by key 
     * @param cleTag
     * @return the tag corresponding to the cleTag parameter
     */
    public Tag findByKey(String cleTag);
    
}
