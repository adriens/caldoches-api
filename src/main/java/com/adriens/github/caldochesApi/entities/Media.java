/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author meilie
 */
@Entity
@Table(name = "media")
public class Media {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable = false)
    private String url;
    
    @Column(nullable = false)
    private Date date;
    
    @Column(nullable = false)
    private String titre;
    
    @ManyToOne
    @JoinColumn(name = "auteur")
    private Auteur auteur;
    
    @ManyToOne
    @JoinColumn(name = "media_type")
    private MediaType type;
    
    protected Media() {
        // for JPA
    }
    
    public Media(long id, String url, Date date, String titre, Auteur auteur, MediaType type) {
        this.id = id;
        this.url = url;
        this.date = date;
        this.titre = titre;
        this.auteur = auteur;
        this.type = type;
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
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the auteur
     */
    public Auteur getAuteur() {
        return auteur;
    }

    /**
     * @param auteur the auteur to set
     */
    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    /**
     * @return the type
     */
    public MediaType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(MediaType type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return "Media{" +
                "id: " +this.id+ 
                ", url: " +this.url+ 
                ", date: " +this.date+ 
                ", titre: " +this.titre+ 
                ", auteur: " +this.auteur+ 
                ", mediaType: " +this.type+ 
                "}";
    }
    
}

