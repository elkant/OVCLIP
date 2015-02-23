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

/**
 *
 * @author MANUEL
 */
public class loadform1 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            String formedform="";
            String asses="<option value=''>Select Assesment</option>";
            String lip="<option value=''>Select LIP/CBO</option>";
            String staff="<option value=''>Select Staff Name</option>";
              dbConn conn= new dbConn();
              
              String getass="select * from asses_type";
            conn.rs0=conn.st0.executeQuery(getass);
            while(conn.rs0.next()){
            asses+="<option value='"+conn.rs0.getString(1)+"'>"+conn.rs0.getString(2)+"</option>";
            
            }
              
              String getlip="select * from cbo";
            conn.rs0=conn.st0.executeQuery(getlip);
            while(conn.rs0.next()){
            lip+="<option value='"+conn.rs0.getString(1)+"'>"+conn.rs0.getString(2)+"</option>";
            
                                 }
            
              String getstaff="select * from staff";
            conn.rs0=conn.st0.executeQuery(getstaff);
            while(conn.rs0.next()){
            staff+="<option value='"+conn.rs0.getString(1)+"'>"+conn.rs0.getString(2)+" "+conn.rs0.getString(3)+" ("+conn.rs0.getString(4)+") "+"</option>";
            
                                 }
            
            
            formedform+="<fieldset>" +
"                <legend> Section A: Background Information </legend>" +
"                <div class='row'>" +
"                    <div class='col-lg-6'>"
                    + ""
                    + "<div class=\"form-group\">\n"
                    + "<label for=\"exampleInputPassword6\">Assesment Type</label>\n"
                    + "<select class=\"form-control\" name=\"asses_type\" id='asses_type' data-parsley-group=\"block0\" required>\n"
                    + ""+asses
                    + "</select>\n"
                    + "</div>"
                    + ""
                    + ""
                    + "<div class=\"form-group\">\n"
                    + "<label for=\"exampleInputPassword6\">Name of LIP/CBO</label>\n"
                    + "<select class=\"form-control\" onchange='loadsites(this);' name=\"lip\" id='lip' data-parsley-group=\"block0\" required>\n"
                    + ""+lip
                    + "</select>\n"
                    + "</div>"
                    + ""
                    + ""
                    + "<div class=\"form-group\">"
                    + "<label for=\"exampleInputPassword6\">Site Visited</label>\n"
                    + "<select class=\"form-control\" name=\"site\" id='site' data-parsley-group=\"block0\" required>\n"
                    + "<option value=''>Select Site</option>"
                    + "</select>"
                    + "</div>"
                    + ""
                    + ""
                    + "<div class=\"form-group\">\n"
                    + "<label for=\"exampleInputPassword6\">LIP/CBO Staff Present</label>\n"
                    + "<select class=\"form-control\" name=\"staffpresent\" id='staffpresent' data-parsley-group=\"block0\" required>\n"
                    + ""+staff
                    + "</select><a href='addstaff.htm'> <img src=\"<c:url value=\"/resources/images/add.png\" width=\"27px\" />\"/></a>  "
                    + "</div>"
                    + ""
                    + "</div>"+
                    
                    
                    //begin column two
                    "<div class='col-lg-6'>"
                    +""
                    + "<div class=\"form-group\">\n"
                    + "<label for=\"exampleInputPassword6\">SuperVision Team Leader</label>\n"
                    + "<select class=\"form-control\" name=\"teamleader\" id='teamleader' data-parsley-group=\"block0\" required>\n"
                    + ""+staff
                    + "</select><img src=\"<c:url value=\"/resources/images/add.png\" />\">"
                    + "</div>"
                    + ""
                    +"<div class='form-group'>"
                    +"<label for='exampleInputPassword6'>Date of Assesment</label>"
                    +"<input type='text' class='form-control' name='ass_date' id='ass_date' >"
                    +"</div>"
                    + ""
                    +""
                    + "<div class=\"form-group\">\n"
                    + "<label for=\"exampleInputPassword6\">Other Team members</label>\n"
                    + "<select multiple class=\"form-control\" name=\"teammembers\" id='teammembers' data-parsley-group=\"block0\" required>\n"
                    + ""+staff
                    + "</select><img src=\"<c:url value=\"/resources/images/add.png\" />\">"
                    + "</div>"
                    + ""
                    + "</div>"
                    + "</div>"
                    + "</fieldset>";
            
            
          
            
            boolean createnewpage=true;
            String initdomain="0";
            
            String getdata="select * from question join domains on question.domain_id=domains.domain_id";
            conn.rs=conn.st.executeQuery(getdata);
            int count=0;
            while(conn.rs.next()){
            //create a new page
                
                if(conn.rs.getString("domain_id").equals(initdomain)){
                //dont create a new page/fieldset
                    createnewpage=false;
                    //add the form elements in here
                    
                
                }
                else{
                    //create a new page
                createnewpage=true;
                if(count==0){
                //create a new page without begining with a closing
                    
                    
                }
                else{
                //create a new page by closing what exists 
                
                }
                
                }
            
            
            count++;
            }
            
            
            
            
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
              
                out.println(formedform);
            }
        }   catch (SQLException ex) {
            Logger.getLogger(loadform1.class.getName()).log(Level.SEVERE, null, ex);
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
