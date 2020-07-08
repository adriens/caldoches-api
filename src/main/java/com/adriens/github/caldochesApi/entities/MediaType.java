/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author meilie
 */
@Entity
@Table(name = "media_type")
public class MediaType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String nomType;
    
    /**
     * constructor
     */
    public MediaType() {
        // for JPA
    }
    
    /**
     * constructor
     * @param nomType
     */
    public MediaType(String nomType){
        this.nomType = nomType;
    }

    /**
     * get the mediatype id
     * @return the id of the mediatype
     */
    public Integer getId() {
        return id;
    }

    /**
     * set the mediatype id
     * @param id the mediatype's id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get the mediatype nomtype
     * @return the name of the mediatype
     */
    public String getNomType() {
        return nomType;
    }

    /**
     * set the mediatype nomtype
     * @param nomType the mediatype's name to set
     */
    public void setNomType(String nomType) {
        this.nomType = nomType;
    }
    
    /**
     * get the mediatype to String
     * @return the mediatype as text
     */
    @Override
    public String toString() {
        return "MediaType{" + 
                "id: " +id+ 
                ", nomType: " +nomType+ 
                "}";
    }
    
}
