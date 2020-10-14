/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webapp.services;

import com.mycompany.webapp.dao.DAOuser;
import java.sql.SQLException;

/**
 *
 * @author gonza
 */
public class ServiceUser {
    
    DAOuser daoUser;

    public ServiceUser() {
        this.daoUser = new DAOuser();
    }
        
    
   
    public boolean checkLogin(String name, String pass) throws SQLException{
        return daoUser.verificarUser(name,pass);
    }
}
