/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajax;

import database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MANUEL
 */
public class loadreportsites extends HttpServlet {

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
            try {
                response.setContentType("text/html;charset=UTF-8");
                
                /* TODO output your page here. You may use following sample code. */
                
                
                
                
                dbConn conn= new dbConn();
                String createdtable="<option value=''>No report available for this cbo</option>";
                String cbo=request.getParameter("cbo");
                String year=request.getParameter("year");
                String period=request.getParameter("period");
                String getsites="  select sites.site_id as sitesid,site_name from sites join backgroundinfor on sites.site_id=backgroundinfor.site where cbo_id='"+cbo+"' and year='"+year+"' and period='"+period+"' order by site_name";
                conn.rs=conn.st.executeQuery(getsites);
               int  count=0;
                while(conn.rs.next()){
                    if(count==0){
                      createdtable="<option value=''>Select Cbo</option>";  
                    }
                    createdtable+="<option value='"+conn.rs.getString(1)+"'>"+conn.rs.getString(2)+"</option>";
                    
                  count++;  
                }
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    
                    out.println(createdtable);
                }
                
            }   catch (SQLException ex) {
            Logger.getLogger(loadreportsites.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
