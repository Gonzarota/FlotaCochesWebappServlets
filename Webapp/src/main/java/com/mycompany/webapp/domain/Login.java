/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webapp.domain;

/**
 *
 * @author gonza
 */
public class Login {
    private String name;
    private boolean logeado;

    public Login(String name, boolean logeado) {
        this.name = name;
        this.logeado = logeado;
    }
    
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the logeado
     */
    public Boolean getLogeado() {
        return isLogeado();
    }

    /**
     * @param logeado the logeado to set
     */
    public void setLogeado(Boolean logeado) {
        this.setLogeado((boolean) logeado);
    }

    /**
     * @return the logeado
     */
    public boolean isLogeado() {
        return logeado;
    }

    /**
     * @param logeado the logeado to set
     */
    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    
    
    
    
    
}
