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
@Table(name = "auteur")
public class Auteur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    private String nom;
    
    @Column(nullable = false)
    private String cleAuteur;
    
    /**
     * constructor
     */
    protected Auteur() {
        // for JPA
    }
    
    /**
     * constructor
     * @param id
     * @param nom
     * @param cleAuteur
     */
    public Auteur(long id, String nom, String cleAuteur) {
        this.id = id;
        this.nom = nom;
        this.cleAuteur = cleAuteur;
    }

    /**
     * get the author id
     * @return the id of the author
     */
    public long getId() {
        return id;
    }

    /**
     * set the author id
     * @param id the author's id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * get the author name
     * @return the name of the author
     */
    public String getNom() {
        return nom;
    }

    /**
     * set the author name
     * @param nom the author's name to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * get the author keyword
     * @return the keyword of the author
     */
    public String getCleAuteur() {
        return cleAuteur;
    }

    /**
     * set the author keyword
     * @param cleAuteur the author's keyword to set
     */
    public void setCleAuteur(String cleAuteur) {
        this.cleAuteur = cleAuteur;
    }
    
    /**
     * get the author to String
     * @return the author as text
     */
    @Override
    public String toString() {
        return "Auteur{id: "+id+", nom: "+nom+"}";
    }

}
