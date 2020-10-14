/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

/**
 *
 * @author gonza
 */
public class DAOuser {
    public static Connection cn = null;

    public DAOuser() {
        try {
            String url = "jdbc:mysql://localhost:3306/empresa?serverTimezone=" + TimeZone.getDefault().getID();
            String user = "root";
            String clave = "admin";
            
            if(cn==null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                cn = DriverManager.getConnection(url, user, clave);
            }
            
            System.out.println("Conexión establecida.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.toString());
        }
    }
    
    public boolean verificarUser(String name,String pass) throws SQLException{
               
        String sql="SELECT * FROM uservehiculo WHERE nombre LIKE '"+name+"' AND contraseña LIKE '"+pass+"';";
            
        try(Statement sentencia=this.cn.createStatement()){
            ResultSet result=sentencia.executeQuery(sql);
            
            if(result.next()){
            return true;
            }
        }
        return false;
    }
}
