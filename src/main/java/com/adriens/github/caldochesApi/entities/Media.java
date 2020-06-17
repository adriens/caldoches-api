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
    
    /**
     * constructor
     */
    protected Media() {
        // for JPA
    }
    
    /**
     * constructor
     * @param id
     * @param url
     * @param date
     * @param titre
     * @param auteur
     * @param type
     */
    public Media(long id, String url, Date date, String titre, Auteur auteur, MediaType type) {
        this.id = id;
        this.url = url;
        this.date = date;
        this.titre = titre;
        this.auteur = auteur;
        this.type = type;
    }

    /**
     * get the media id
     * @return the id of the media
     */
    public long getId() {
        return id;
    }

    /**
     * set the media id
     * @param id the media's id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * get the media url
     * @return the url of the media
     */
    public String getUrl() {
        return url;
    }

    /**
     * set the media url
     * @param url the media's url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * get the media date
     * @return the date of the media
     */
    public Date getDate() {
        return date;
    }

    /**
     * set the media date
     * @param date the media's date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * get the media title
     * @return the title of the media
     */
    public String getTitre() {
        return titre;
    }

    /**
     * set the media title
     * @param titre the media's title to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * get the media author
     * @return the author of the media
     */
    public Auteur getAuteur() {
        return auteur;
    }

    /**
     * set the media author
     * @param auteur the media's author to set
     */
    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    /**
     * get the media type
     * @return the type of the media
     */
    public MediaType getType() {
        return type;
    }

    /**
     * set the media type
     * @param type the media's type to set
     */
    public void setType(MediaType type) {
        this.type = type;
    }
    
    /**
     * get the media to String
     * @return the media as text
     */
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

