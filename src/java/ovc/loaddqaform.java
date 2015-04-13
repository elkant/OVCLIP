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
public class loaddqaform extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          //this is a page to create a form that is used to enter data for the action point
            
            String createdtable="";
            
            createdtable="<fieldset><legend style='text-align:center;'>DQA ACTION POINT</legend>"
                    + "<div class='row'><nobr><span><input type=\"text\" value=\"Add 1 Row\" id=\"generate1\" class ='generate1' onclick=\"createrows('1');\" readonly style=\" cursor:pointer;margin-left: 50px; text-transform:uppercase ; height: 40px; width:140px;text-align:center ; color:white ;background:green; border-style:ridge ;\" /></span>"
                   + "<span><input type=\"text\" value=\"Delete Row\" id=\"generate1\" class ='generate1' onclick=\"deleteRow('1');\" readonly style=\" cursor:pointer;margin-left: 50px; text-transform:uppercase ; height: 40px; width:170px;text-align:center ; color:white ;background:coral; border-style:ridge ;\" /></span>"
                     + "<a id='modal_trigger' style='page-break-before: avoid;color:red;background-color:white;margin:0px;' href='#rowsmodal' ><input type='text' value='Add Custom No of Rows' id='generate2'   readonly style='cursor:pointer;margin-left: 50px; text-transform:uppercase ; height: 40px; width:180px;text-align:center ; color:white ;background:#00CC00; border-style:ridge ;'/></a></nobr>"
                     + "<a id='delrows_trigger' style='page-break-before: avoid;color:red;background-color:white;margin:0px;' href='#delrowsmodal' ><input type='text' value='Delete Custom No of Rows' id='generate3'   readonly style='cursor:pointer;margin-left: 50px; text-transform:uppercase ; height: 40px; width:180px;text-align:center ; color:white ;background:#FF0000; border-style:ridge ;'/></a></nobr>"
                    
                    + "<table id='actionpointtable' name='actionpointtable'  style='width:1030px;margin-left:20px;margin-right:2px;'  border='1'><tr><th><h4><b>SN</b></h4></th><th><h4><font color='red'><b>*</font>Follow up Actions recommended </b></h4></th><th><h4><font color='red'>*</font><b>Responsible person</b></h4></th><th><h4><font color='red'>*</font> <b>1st Expected <br/>Completion Date</b></h4></th><th><h4>2nd Expected <br/>Completion Date</h4></th></tr>";
           //get the questions from a specified table. 
            
            //summary of 
            
            dbConn conn=new dbConn();
            
            
            //get a list of designations
            
            String fetchdesignation="select * from designation";
            
            
         
//        .. text or inputs for second step ..
//    </fieldset>
            
            
            String getactions="select * from followup_actions ";
            conn.rs0=conn.st0.executeQuery(fetchdesignation);
            
            String design="<option value=''>select designation</option>";
            
                  while(conn.rs0.next()){                 
                 
                 design+="<option value='"+conn.rs0.getString(1)+"'>"+conn.rs0.getString(2)+"</option>";
                 
                                        }
            
        
            int counter=0;
            while(counter<3){
            //create the entire table in this page..
             counter++;  
             
             
             
             createdtable+="<tr><td><h3>"+counter+"</h3></td><td style='color:black;'><div class='form-group'>" +               
             "<Textarea rows='2' cols='30' class='form-control' name='actionid"+counter+"' id='actionid"+counter+"' >" +
             "</TextArea>" +
             "</div></td><td><div class=\"form-group\"><select name='select"+counter+"' class=\"form-control\" id='select"+counter+"'>"+design+"</select></div></td><td><div class=\"form-group\"><input class=\"form-control\"  type='text' id='fdate"+counter+"' name='fdate"+counter+"'></div></td><td> <div class=\"form-group\"><input type='text' id='sdate"+counter+"' class=\"form-control\" name='sdate"+counter+"'></div></td></tr>";   
            
                       
                                  }  
            createdtable+="</table><input type='hidden' name='counter' id='counter' value='"+counter+"'></div>";
            
            out.println(createdtable);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(loaddqaform.class.getName()).log(Level.SEVERE, null, ex);
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
