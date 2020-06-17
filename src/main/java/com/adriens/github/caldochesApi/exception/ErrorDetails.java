/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.exception;

import java.util.Date;

/**
 *
 * @author meilie
 */
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;

    /**
     * constructor
     * @param timestamp
     * @param message
     * @param details
     */
    public ErrorDetails(Date timestamp, String message, String details) {
         super();
         this.timestamp = timestamp;
         this.message = message;
         this.details = details;
    }

    /**
     * get the timestamp
     * @return the timestamp
     */
    public Date getTimestamp() { 
        return timestamp; 
    }

    /**
     * get the message
     * @return the message
     */
    public String getMessage() { 
        return message; 
    }

    /**
     * get the details
     * @return the details
     */
    public String getDetails() { 
        return details; 
    }
}
