/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovc;

import database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;
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
public class saveSite extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                response.setContentType("text/html;charset=UTF-8");
                // url: "saveSite?county="+county+"&district="+district+"&cbo="+cbo+"&site="+site,
                String sitename=request.getParameter("site");
                String district=request.getParameter("district");
                String cbo=request.getParameter("cbo");
                
                
                dbConn conn= new dbConn();
                
                
                
                
                
                String result="<font color='red'>Site"+sitename+"  has already been added</font>";
                String checkexistance="select * from sites where site_name like ? and districtid like ? and cbo_id like ?";
                
                conn.pst2=conn.conne.prepareStatement(checkexistance);
                conn.pst2.setString(1,sitename);
                conn.pst2.setString(2,district);
                conn.pst2.setString(3,cbo);
                conn.rs2=conn.pst2.executeQuery();
                if(!conn.rs2.next()){
                    
                    
                    
                    
                    
                    try {
                        String insert="insert into sites (site_name,districtid,cbo_id) values (?,?,?)";
                        
                     int num=generateRandomNumber(100, 2000);
                    String siten=sitename.toUpperCase();
                     if(sitename.contains("MAIN")){
                      insert="insert into sites (site_id,site_name,districtid,cbo_id) values (?,?,?,?)";
                      conn.pst1=conn.conne.prepareStatement(insert);    
                          
                        gen g= new gen();
                        
                        String id=g.uniqueid().trim();
                        
                       String specialsiteid=num+"9999"; 
                     
                        conn.pst1.setString(1,specialsiteid);
                        conn.pst1.setString(2,sitename);
                        conn.pst1.setString(3,district);
                        conn.pst1.setString(4,cbo);
                        
                        
                        
                        if(conn.pst1.executeUpdate()==1){
                            
                            result="<font color='green'>Site "+sitename+" has been added succesfully </font>";
                            
                        } 
                     }
                     else {
                         
                         
                         
                         //=====THE NORMAL INSTERT WITHOUT MAIN=======================
                         
                     conn.pst1=conn.conne.prepareStatement(insert);
                        
                        gen g= new gen();
                        
                        String id=g.uniqueid().trim();
                        
                        
                     
                        conn.pst1.setString(1,sitename);
                        conn.pst1.setString(2,district);
                        conn.pst1.setString(3,cbo);
                        
                        
                        
                        if(conn.pst1.executeUpdate()==1){
                            
                            result="<font color='green'>Site "+sitename+" has been added succesfully </font>";
                            
                        }
                     
                     
                     
                     }
                        
                        
                     
                    } catch (SQLException ex) {
                        Logger.getLogger(saveSite.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try (PrintWriter out = response.getWriter()) {
                    
                    out.println(result);
                }
            }   catch (SQLException ex) {
            Logger.getLogger(saveSite.class.getName()).log(Level.SEVERE, null, ex);
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

    
    
      public int generateRandomNumber(int start, int end) {
        Random random = new Random();
        long fraction = (long) ((end - start + 1) * random.nextDouble());
        return ((int) (fraction + start));
    }
    
    
    
}
