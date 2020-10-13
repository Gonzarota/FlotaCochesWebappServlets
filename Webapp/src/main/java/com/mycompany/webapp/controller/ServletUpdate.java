/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webapp.controller;

import com.mycompany.webapp.domain.Vehiculo;
import com.mycompany.webapp.services.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gonza
 */
public class ServletUpdate extends HttpServlet {
    
    Service service=new Service();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletUpdate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletUpdate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            int id=Integer.parseInt(request.getParameter("id"));
            
            Vehiculo vehiculo=service.selectVehiculo(id);
            
            HttpSession mySession=request.getSession(true);
            mySession.setAttribute("vehiculo", vehiculo);
            
            RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/update.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
        
            Vehiculo modificado=new Vehiculo(Integer.valueOf(request.getParameter("id")),
                    request.getParameter("marca"),
                    request.getParameter("modelo"),
                    request.getParameter("matricula"),
                    Integer.valueOf(request.getParameter("plazas")));
            
            
        try {
            service.updateVehiculo(modificado);
            List<Vehiculo> vehiculos=service.loadVehiculos();
            HttpSession mySession=request.getSession(true);
            mySession.setAttribute("vehiculos", vehiculos);
       
            RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/list.jsp");
            rd.forward(request, response);
       
        } catch (SQLException ex) {
            Logger.getLogger(ServletUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
