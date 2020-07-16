/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.github.caldochesApi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Redirect to Swagger documentation
 * @author meilie
 */
@RestController
public class MainController {
    
    @GetMapping("/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public RedirectView getDefault() throws Exception {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/doc.kalolo.html");
        return redirectView;
    }
    
}
