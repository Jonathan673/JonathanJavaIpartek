package com.floristeria.presentation.backend.listeners;

import com.floristeria.entities.Carrito;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SesionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
         se.getSession().setAttribute("carrito", new Carrito());
    }
}
