/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author meilie
 */
@Entity
@Table(name = "tag")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "exps"})
public class Tag implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String nom;
    
    @Column(nullable = false)
    private String definition;
    
    @ManyToMany(mappedBy = "tags")
    private List<Expression> exps;
    
    /**
     * default constructor
     */
    public Tag() {
        // for JPA 
    }

    /**
     * constructor
     * @param nom
     * @param definition
     */
    public Tag(String nom, String definition) {
        this.nom = nom;
        this.definition = definition;
    }

    /**
     * get the tag id
     * @return the id of the tag
     */
    public Integer getId() { 
        return id; 
    }

    /**
     * set the tag id
     * @param id the tag's id to set
     */
    public void setId(Integer id) { 
        this.id = id; 
    }

    /**
     * get the tag name
     * @return the name of the tag
     */
    public String getNom() { 
        return nom; 
    }

    /**
     * set the tag name
     * @param nom the tag's name to set
     */
    public void setNom(String nom) { 
        this.nom = nom; 
    }

    /**
     * get the tag definition
     * @return the definition of the tag
     */
    public String getDefinition() { 
        return definition; 
    }

    /**
     * set the tag definition
     * @param definition the tag's definition to set
     */
    public void setDefinition(String definition) { 
        this.definition = definition; 
    }

    /**
     * get the tag expression's list
     * @return the expression's list of the tag
     */
    public List<Expression> getExps() {
        return exps;
    }

    /**
     * set the tag expression's list
     * @param exps the tag's expression's list to set
     */
    public void setExps(List<Expression> exps) {
        this.exps = exps;
    }

    /**
     * get the tag to String
     * @return the tag as text
     */
    @Override
    public String toString() {
        
        return "Tag{" +
                "id: " +this.getId()+ 
                ", nom: " +this.getNom()+ 
                ", definition: " +this.getDefinition()+ 
                "}";
    }

}