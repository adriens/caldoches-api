/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author meilie
 */
@Entity
@Table(name = "expression")
public class Expression implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String texte;
    
    @Column(nullable = false)
    private int points;
   
    @ManyToMany
    @JoinTable(name = "exptag", joinColumns = { @JoinColumn(name = "exp") }, inverseJoinColumns = { @JoinColumn(name = "tag") })
    private List<Tag> tags;
    
    /**
     * default constructor
     */
    public Expression() {
        // for JPA
    }
    
    /**
     * constructor
     * @param texte
     * @param points
     */
    public Expression(String texte, int points) {
        this.texte = texte;
        this.points = points;
    }
    
    /**
     * get the expression id
     * @return the id of the expression
     */
    public Integer getId() {
        return id;
    }

    /**
     * set the expression id
     * @param id the expression's id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get the expression text
     * @return the text of the expression
     */
    public String getTexte() {
        return texte;
    }

    /**
     * set the expression text
     * @param texte the expression's text to set
     */
    public void setTexte(String texte) {
        this.texte = texte;
    }

    /**
     * get the expression points
     * @return the points of the expression
     */
    public int getPoints() {
        return points;
    }

    /**
     * set the expression points
     * @param points the expression's points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * get the expression tag's list
     * @return the tag's list of the expression
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * set the expression tag's list
     * @param tags the expression's tag's list to set
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    
    /**
     * get the expression to String
     * @return the expression as text
     */
    @Override
    public String toString() {
        
        return "Expression{" +
                "id: " +getId()+ 
                ", texte: " +getTexte()+ 
                ", points: " +getPoints()+ 
                "}";
    }
}
