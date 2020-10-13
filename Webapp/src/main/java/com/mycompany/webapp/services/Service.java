/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webapp.services;

import com.mycompany.webapp.dao.DAO;
import com.mycompany.webapp.domain.Vehiculo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gonza
 */
public class Service {
    DAO dao;

    public Service(){
        this.dao=new DAO();
    }

    public Vehiculo addVehiculo(Vehiculo vehiculo) throws SQLException {
        Vehiculo insertado=dao.insertVehiculo(vehiculo);
        return insertado;
    }

    public Vehiculo removeVehiculo(String id) throws SQLException {
        return dao.removeVehiculo(id);
    }
    
    public String loadVehiculosString() throws SQLException{
        List<Vehiculo> vehiculos= dao.loadVehiculos();
        StringBuilder sb=new StringBuilder();
        for(Vehiculo vehiculo:vehiculos){
            sb.append(vehiculo.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public List<Vehiculo> loadVehiculos() throws SQLException{
        List<Vehiculo> vehiculos= dao.loadVehiculos();
        return vehiculos;
    }
    
    public Vehiculo updateVehiculo(Vehiculo vehiculo) throws SQLException {
        Vehiculo modificado=dao.alterVehiculo(vehiculo);
        return modificado;
    }
    
    public Vehiculo selectVehiculo(int id) throws SQLException{
        Vehiculo seleccionado=dao.selectVehiculo(id);
        return seleccionado;
    }

}
