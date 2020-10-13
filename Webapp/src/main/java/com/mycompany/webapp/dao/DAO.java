/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webapp.dao;

import com.mycompany.webapp.domain.Vehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author gonza
 */
public class DAO {
    public static Connection cn = null;

    public DAO() {
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

    public Vehiculo insertVehiculo(Vehiculo vehiculo)throws SQLException{

        String marca=vehiculo.getMarca();
        String modelo=vehiculo.getModelo();
        String matricula=vehiculo.getMatricula();
        int plazas=vehiculo.getPlazas();
        
        Vehiculo insertado=new Vehiculo(marca, modelo, matricula, plazas);

        Statement sentencia=this.cn.createStatement();
        String sql="INSERT INTO vehiculos(marca,modelo,matricula,plazas) VALUES('"+marca+"','"+modelo+"','"+matricula+"','"+plazas+"')";
        int result;

        result=sentencia.executeUpdate(sql);

        String resultado="Se han insertado "+result+" filas, creando el vehiculo: "+vehiculo.getMarca()+ " "+ vehiculo.getModelo();

        sentencia.close();
        return insertado;
    }
    
    public Vehiculo selectVehiculo(int id) throws SQLException{
        Statement sentencia=this.cn.createStatement();
        
        String sqlSelect="SELECT * FROM vehiculos WHERE id="+id;
        ResultSet result=sentencia.executeQuery(sqlSelect);
        
        Vehiculo vehiculo=new Vehiculo();
        while(result.next()){
            Vehiculo u = new Vehiculo(result.getInt("id"),
                    result.getString("marca"),
                    result.getString("modelo"),
                    result.getString("matricula"),
                    result.getInt("plazas"));
            vehiculo=u;
        }
        return vehiculo;
    }

    public Vehiculo removeVehiculo(String id) throws SQLException{
        Statement sentencia=this.cn.createStatement();
        
        String sqlSelect="SELECT * FROM vehiculos WHERE id="+id;
        ResultSet result=sentencia.executeQuery(sqlSelect);
        
        Vehiculo vehiculo=new Vehiculo();
        while(result.next()){
            Vehiculo u = new Vehiculo(result.getInt("id"),
                    result.getString("marca"),
                    result.getString("modelo"),
                    result.getString("matricula"),
                    result.getInt("plazas"));
            vehiculo=u;
        }
        
        String sql="DELETE FROM vehiculos WHERE id="+id;
        int resultado;
        resultado=sentencia.executeUpdate(sql);
        System.out.println("Se han borrado "+resultado+" filas");

        sentencia.close();
        return vehiculo;
    }


    public List<Vehiculo> loadVehiculos() throws SQLException {
        List<Vehiculo> vehiculos=new ArrayList<>();
        Statement sentencia=this.cn.createStatement();
        String sql= "SELECT * FROM vehiculos";
        ResultSet result=sentencia.executeQuery(sql);

        while(result.next()){
            Vehiculo u = new Vehiculo(result.getInt("id"),
                    result.getString("marca"),
                    result.getString("modelo"),
                    result.getString("matricula"),
                    result.getInt("plazas"));

            vehiculos.add(u);
        }
        sentencia.close();
        return vehiculos;
    }
    
    public Vehiculo alterVehiculo(Vehiculo v) throws SQLException {

        Statement sentencia=this.cn.createStatement();
        String sql="UPDATE vehiculos SET marca='"+v.getMarca()+"',"
                + "modelo='"+v.getModelo()+"',"
                + "matricula='"+v.getMatricula()+"',"
                + "plazas='"+v.getPlazas()+"' WHERE id="+v.getId();
        int result;
        
        Vehiculo modificado=v;

        result=sentencia.executeUpdate(sql);
        String resultado="Se han modificado "+result+" filas";

        sentencia.close();
        return modificado;
    }

}
