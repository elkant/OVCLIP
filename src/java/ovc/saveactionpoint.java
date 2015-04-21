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
public class saveactionpoint extends HttpServlet {

  HttpSession session=null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        session=request.getSession();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          
            //receive the various fields to be saved 
            //actionid
            //responsible person
            //expecteddate
            //expecteddate2
            //sessionofjoiningnumber
            //controllerofloop
            
            
           String action="";
           String responsibleperson="";
           String expecteddate="";
           String expecteddate2="";
           String joiningnumber="";
           String counter=request.getParameter("counter");
           
           //
           
           
            String period="";
            String year="";
            String ass_date="";
            String markstableid="";
            String siteid="";
            
            
            
            if(session.getAttribute("period")!=null){
            period=session.getAttribute("period").toString();
            }
             if(session.getAttribute("year")!=null){
            year=session.getAttribute("year").toString();
            }
            if(session.getAttribute("ass_date")!=null){
            ass_date=session.getAttribute("ass_date").toString();
                                                      }  
       
            if(session.getAttribute("markstableid")!=null){
            markstableid=session.getAttribute("markstableid").toString();
                                                      }   
                  if(session.getAttribute("site")!=null){
            siteid=session.getAttribute("site").toString();
                                                      } 
            
            dbConn conn= new dbConn();
            
            gen g= new gen();
           
         String msg="<font color='orange'>Data for the DQA action point for the selected site and period has already been added</font>";  
           
           int cnt=Integer.parseInt(counter);
            for(int a=1;a<=cnt;a++){
           
            responsibleperson=request.getParameter("select"+a);   
            expecteddate=request.getParameter("fdate"+a);   
            expecteddate2=request.getParameter("sdate"+a);   
            action=request.getParameter("actionid"+a);  
           
            String uniqid=g.uniqueid().trim();
            
            String checkexist="select * from action_points where site_id='"+siteid+"' and period='"+period+"' and year='"+year+"' limit 1";
            
            conn.rs2=conn.st2.executeQuery(checkexist);
            if(!conn.rs2.next()){
            
            
            String insertdata="insert into action_points (tableid,followupaction,responsible_person,expected_date,expected_date2,site_id,marks_table_id,period,year,ass_date) values(?,?,?,?,?,?,?,?,?,?)";
            
            
                 conn.pst2=conn.conne.prepareStatement(insertdata);
             conn.pst2.setString(1,uniqid);
             conn.pst2.setString(2,action);
             conn.pst2.setString(3,responsibleperson);
             conn.pst2.setString(4,expecteddate);
             conn.pst2.setString(5,expecteddate2);
             conn.pst2.setString(6,siteid);
             conn.pst2.setString(7,markstableid);
             conn.pst2.setString(8,period);
             conn.pst2.setString(9,year);
             conn.pst2.setString(10,ass_date);
            conn.pst2.executeUpdate();
            
            
                                  }
             else {
       msg="<font color='green'>Data added succesfully </font>";  
          
                    }
            
            }//end of checker of if data has already been inserted
           
           session.setAttribute("actionmsg",msg); 
            System.out.println(msg);
           //response.sendRedirect("dataentry.htm");
        } catch (SQLException ex) {
            Logger.getLogger(saveactionpoint.class.getName()).log(Level.SEVERE, null, ex);
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
