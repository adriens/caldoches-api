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
     * @return the id
     */
    public Integer getId() { 
        return id; 
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) { 
        this.id = id; 
    }

    /**
     * @return the nom
     */
    public String getNom() { 
        return nom; 
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) { 
        this.nom = nom; 
    }

    /**
     * @return the definition
     */
    public String getDefinition() { 
        return definition; 
    }

    /**
     * @param definition the definition to set
     */
    public void setDefinition(String definition) { 
        this.definition = definition; 
    }

    /**
     * @return the exps
     */
    public List<Expression> getExps() {
        return exps;
    }

    /**
     * @param exps the exps to set
     */
    public void setExps(List<Expression> exps) {
        this.exps = exps;
    }

    @Override
    public String toString() {
        
        return "Tag{" +
                "id: " +this.getId()+ 
                ", nom: " +this.getNom()+ 
                ", definition: " +this.getDefinition()+ 
                "}";
    }

}