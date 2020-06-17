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
    
    @Column(nullable = true)
    private String urlFb;
    
    @Column(nullable = true)
    private String urlInsta;
    
    @Column(nullable = true)
    private String urlYt;
    
    
    /**
     * constructor
     */
    public Auteur() {
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
     * get the author facebook url
     * @return the facebook url of the author
     */
    public String getUrlFb() {
        return urlFb;
    }

    /**
     * set the author facebook url
     * @param urlFb the author's facebook url to set
     */
    public void setUrlFb(String urlFb) {
        this.urlFb = urlFb;
    }

    /**
     * get the author instagram url
     * @return the instagram url of the author
     */
    public String getUrlInsta() {
        return urlInsta;
    }

    /**
     * set the author instagram url
     * @param urlInsta the author's instagram url to set
     */
    public void setUrlInsta(String urlInsta) {
        this.urlInsta = urlInsta;
    }

    /**
     * get the author youtube url
     * @return the youtube url of the author
     */
    public String getUrlYt() {
        return urlYt;
    }

    /**
     * set the author youtube url
     * @param urlYt the author's youtube url to set
     */
    public void setUrlYt(String urlYt) {
        this.urlYt = urlYt;
    }
    
    /**
     * get the author to String
     * @return the author as text
     */
    @Override
    public String toString() {
        return "Auteur{" + 
                "id: " +id+ 
                ", nom: " +nom+ 
                ", cleAuteur: " +cleAuteur+
                ", urlFb: " +urlFb+
                ", urlInsta: " +urlInsta+
                ", urlYt: " +urlYt+
                "}";
    }

}
