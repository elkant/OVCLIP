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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MANUEL
 */
public class saveStaff extends HttpServlet {

   HttpSession session=null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            session=request.getSession();

            String fname="";
            String lname="";
            String phone="";
            String Category="";
            
            String site="";
            
            fname=request.getParameter("fname");
            lname=request.getParameter("mname");
            phone=request.getParameter("phone");
            Category=request.getParameter("category");
            fname=fname.toUpperCase();
            lname=lname.toUpperCase();
            //assuming that category 2 is for non-aphiaplus staff and one must have a site
            if(Category.equals("2")){
                site=request.getParameter("site");
            }
            
            dbConn conn= new dbConn();
            
                String result="<font color='red'>Member "+fname+"  "+lname+" has already been added</font>";
            String checkexistance="select * from staff where fname like ? and mname like ? and phone like ?";
            
            conn.pst2=conn.conne.prepareStatement(checkexistance);
             conn.pst2.setString(1,fname);
             conn.pst2.setString(2,lname);
             conn.pst2.setString(3,phone);
            conn.rs2=conn.pst2.executeQuery();
            if(!conn.rs2.next()){
            
            
            
                             
            
            String insert="insert into staff (staff_id,fname,mname,phone,role_id,userid,site_id) values (?,?,?,?,?,?,?)";
            
            conn.pst1=conn.conne.prepareStatement(insert);
            
            gen g= new gen();
            
            String id=g.uniqueid().trim();
            String userid="session expired";
            if(session.getAttribute("userid")!=null){
            userid=session.getAttribute("userid").toString();
            }
            
            conn.pst1.setString(1,id);
            conn.pst1.setString(2,fname);
            conn.pst1.setString(3,lname);
            conn.pst1.setString(4,phone);
            conn.pst1.setString(5,Category);
            conn.pst1.setString(6,userid);
            conn.pst1.setString(7,site); 
            
        
            
            if(conn.pst1.executeUpdate()==1){
            
            result="<font color='green'>Member "+fname+" "+lname+" added succesfully </font>";
            
            }
                 }         
            try (PrintWriter out = response.getWriter()) {
                
                out.println(result);
            }
        }   catch (SQLException ex) {
            Logger.getLogger(saveStaff.class.getName()).log(Level.SEVERE, null, ex);
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
