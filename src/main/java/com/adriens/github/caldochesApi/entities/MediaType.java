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
    private long id;
    
    @Column(nullable = false)
    private String nomType;
    
    protected MediaType() {
        // for JPA
    }
    
    public MediaType(long id, String nomType){
        this.id = id;
        this.nomType = nomType;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nomType
     */
    public String getNomType() {
        return nomType;
    }

    /**
     * @param nomType the nomType to set
     */
    public void setNomType(String nomType) {
        this.nomType = nomType;
    }
    
    @Override
    public String toString() {
        return "MediaType{" +
                "id: " +this.id+
                ", nomType: " +this.nomType+
                "}";
    }
    
}
