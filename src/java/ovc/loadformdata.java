/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovc;

import database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class loadformdata extends HttpServlet {

     private static String allelements="";
           private static String allelementsvalues="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");

             allelements="";
             allelementsvalues="";
            
            String fyear="";
            String fsite="";
            String fcbo="";
            String fperiod="";
           String datevalue="";
           String backgroundinforid="";
           String strengthsvalue="";
           String constraintsvalue="";
           //this will hold a string of element names and values for preloading purpose
          
            
            
           
            fyear=request.getParameter("year");
            fsite=request.getParameter("site");
            fperiod=request.getParameter("period");
            fcbo=request.getParameter("cbo");
            
            
            String formedform = "";
            String asses = "<option value=''>Select Assesment</option>";
            String lip = "<option value=''>Select LIP/CBO</option>";
            String staff = "<option value=''>Select Staff Name</option>";
            String cbostaff = "";
            String superviserstaff = "<option value=''>Select Staff Name</option>";
            String otherteamstaff = "<option value=''>Select Staff Name</option>";
            String domainvalue = "";
            double domainval=0;
            String domaintableid = "";
            String totalsum="";
            dbConn conn = new dbConn();

            String backginfor="select * from backgroundinfor where site='"+fsite+"' and period='"+fperiod+"' and year='"+fyear+"' ";
            conn.rs_6=conn.st_6.executeQuery(backginfor);
            while(conn.rs_6.next()){
             
                backgroundinforid=conn.rs_6.getString("backgroundid");
                if(conn.rs_6.getString("strengths")!=null){
                strengthsvalue=conn.rs_6.getString("strengths");
                }
                 if(conn.rs_6.getString("constraints")!=null){
                constraintsvalue=conn.rs_6.getString("constraints");
                   }
                
    //total sum
                
    totalsum=conn.rs_6.getString("totalsum");
               //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~assesment type 
              datevalue=conn.rs_6.getString("ass_date");
             String getass = "select * from asses_type";
            conn.rs0 = conn.st0.executeQuery(getass);
            while (conn.rs0.next()) {
                if(conn.rs0.getString(1).equals(conn.rs_6.getString("ass_type"))){
                 asses += "<option selected value='" + conn.rs0.getString(1) + "'>" + conn.rs0.getString(2) + "</option>";
                
                }
                else {
                asses += "<option value='" + conn.rs0.getString(1) + "'>" + conn.rs0.getString(2) + "</option>";
                    }
            }
            
            
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~staff~~~~~~~~~~~~~~~
             //---------cbo staff
                cbostaff=conn.rs_6.getString("staff_present");
            
             String getstaff = "select * from staff";
            conn.rs0 = conn.st0.executeQuery(getstaff);
            while (conn.rs0.next()) {
               
               //------------Supervisor
                if(conn.rs0.getString(1).equals(conn.rs_6.getString("supervisor"))){
                superviserstaff += "<option selected value='" + conn.rs0.getString(1) + "'>" + conn.rs0.getString(2) + " " + conn.rs0.getString(3) + " (" + conn.rs0.getString(4) + ") " + "</option>";
                }
                else {
                superviserstaff += "<option value='" + conn.rs0.getString(1) + "'>" + conn.rs0.getString(2) + " " + conn.rs0.getString(3) + " (" + conn.rs0.getString(4) + ") " + "</option>";
                
                }
               //--------other team members---------- 
                
                 if(conn.rs_6.getString("other_team_members").contains(conn.rs0.getString(1))){
                otherteamstaff += "<option selected value='" + conn.rs0.getString(1) + "'>" + conn.rs0.getString(2) + " " + conn.rs0.getString(3) + " (" + conn.rs0.getString(4) + ") " + "</option>";
                }
                else {
                otherteamstaff += "<option value='" + conn.rs0.getString(1) + "'>" + conn.rs0.getString(2) + " " + conn.rs0.getString(3) + " (" + conn.rs0.getString(4) + ") " + "</option>";
                
                }
                
                
            }
            
            
            
            }
           

            String getlip = "select * from cbo";
            conn.rs0 = conn.st0.executeQuery(getlip);
            while (conn.rs0.next()) {
                
                if(conn.rs0.getString(1).equals(fcbo)){
                lip += "<option selected value='" + conn.rs0.getString(1) + "'>" + conn.rs0.getString(2) + "</option>";
                }
                else 
                    
                {
                 lip += "<option value='" + conn.rs0.getString(1) + "'>" + conn.rs0.getString(2) + "</option>";
                
                
                }
            }

            //===================SITES================
            String sites="<option value=''>select site</option>";
           
            String getsites="  select * from sites where cbo_id='"+fcbo+"'";
            conn.rs=conn.st.executeQuery(getsites);
            while(conn.rs.next()){
            
                if(conn.rs.getString(1).equals(fsite)){
                
                sites+="<option selected value='"+conn.rs.getString(1)+"'>"+conn.rs.getString(2)+"</option>";
            
                }
                else {
                
            sites+="<option value='"+conn.rs.getString(1)+"'>"+conn.rs.getString(2)+"</option>";
            
                   }
                                  }
            
            
            
            
           
            
            
            
             //get the max no of elements 
            
            String maxelem="select MAX(questionid) from questions";
            int no_of_elements=0;
            conn.rs=conn.st.executeQuery(maxelem);
            while(conn.rs.next()){
            no_of_elements=conn.rs.getInt(1);
            
            }
            

           formedform="<fieldset>"
                    + "<legend> Section A: Background Information </legend>"
                    + "<div class='row'>"
                    + "<div class='col-lg-6'> <input type='hidden' name='backgroundid' value='"+backgroundinforid+"' id='backgroundid' /><input type='hidden' value='"+no_of_elements+"' name='no_of_elements' id='no_of_elements'>"
                    + "<input type='hidden' value='"+totalsum +"' name='totalsum' id='totalsum'>"
                    + "<div class=\"form-group\">\n"
                    + "<label for=\"exampleInputPassword6\">Assesment Type</label>\n"
                    + "<select class=\"form-control\" name=\"asses_type\" id='asses_type' data-parsley-group=\"block0\" required>\n"
                    + "" + asses
                    + "</select>\n"
                    + "</div>"
                    + ""
                    + ""
                    + "<div class=\"form-group\">\n"
                    + "<label for=\"exampleInputPassword6\">Name of LIP/CBO</label>\n"
                    + "<select class=\"form-control\" onchange='loadsites1();' name=\"lip\" id='lip' data-parsley-group=\"block0\" required>\n"
                    + "" + lip
                    + "</select>\n"
                    + "</div>"
                    + ""
                    + ""
                    + "<div class=\"form-group\">"
                    + "<label for=\"exampleInputPassword6\">Site Visited</label>\n"
                    + "<select class=\"form-control\" name=\"site\" id='site' onchange='checkupdate();' data-parsley-group=\"block0\" >\n"
                    + ""+sites
                    + "</select>"
                    + "</div>"
                    + ""
                    + ""
                    + "<div class=\"form-group\">\n"
                    + "<label for=\"exampleInputPassword6\">LIP/CBO Staff Present</label>\n"
                    + "<textarea cols='25' rows ='2' class=\"form-control\" name=\"staffpresent\" id='staffpresent' data-parsley-group=\"block0\" required>\n"
                    + "" + cbostaff
                    + "</textarea> "
                    + "</div>"
                    + ""
                    + "</div>"
                    + //begin column two
                    "<div class='col-lg-6'>"
                    + ""
                    + "<div class=\"form-group\">\n"
                    + "<label for=\"exampleInputPassword6\">SuperVision Team Leader</label>\n"
                    + "<select  class=\"form-control\" name=\"teamleader\" id='teamleader' data-parsley-group=\"block0\" required>\n"
                    + "" + superviserstaff
                    + "</select>"
                    + "</div>"
                    + ""
                    + "<div class='form-group'>"
                    + "<label for='exampleInputPassword6'>Date of Assesment</label>"
                    + "<input type='text' value='"+datevalue+"' onchange='checkupdate();' class='form-control' name='ass_date' id='ass_date' >"
                    + "</div>"
                    + ""
                    + ""
                    + "<div class=\"form-group\">\n"
                    + "<label for=\"exampleInputPassword6\">Other Team members</label>\n"
                    + "<select multiple class=\"form-control\" name=\"teammembers\" id='teammembers' data-parsley-group=\"block0\" required>\n"
                    + "" + otherteamstaff
                    + "</select>"
                    + "</div>"
                    + ""
                    + "</div>"
                    + "</div>"
                    + "</fieldset>";

            boolean createnewpage = true;
            String initdomain = "0";
//select data from the domain value
           
            String getdata = "select * from questions join domains on questions.domain_id=domains.domain_id order by questionid asc";
            conn.rs = conn.st.executeQuery(getdata);
            int count = 0;
            String domaintable="";
            String tableheader = "<tr><th>SN</th><th>Assesment Questions</th><th>Response</th><th>Comment</th></tr>";
            String middletable = "";
            String legendheader="";
            String questionvalue=""; 
            String questiontableid=""; 
            String commentvalue="";
            while (conn.rs.next()) {
            //create a new page
                  String functionname="";
                    String affectedelem=conn.rs.getString("affected_question");
                    
                       String getquestval="select * from marks where  site_id='"+fsite+"' and quest_id='"+conn.rs.getString("questionid")+"' and year='"+fyear+"' and period='"+fperiod+"'";
                  conn.rs_6=conn.st_6.executeQuery(getquestval);
                  while(conn.rs_6.next()){
                  questionvalue=conn.rs_6.getString("answer");
                  questiontableid=conn.rs_6.getString("marks_id");
                  if(conn.rs_6.getString("comment")!=null){
                  commentvalue=conn.rs_6.getString("comment");
                  }
                  
                  }
                    
                      // System.out.println("~~"+conn.rs.getString("affected_question"));
                   if(affectedelem!=null){
                     
                    functionname="disableurl('"+affectedelem+"',this,'"+conn.rs.getString("domain_id")+"');";
                                          }
                if (conn.rs.getString("domain_id").equals(initdomain)) {
                   // System.out.println(conn.rs.getString("domain_id")+"=="+initdomain);
                    
                    //dont create a new page/fieldset
                    createnewpage = false;
                    //add the form elements in here
                    middletable += "<tr><td><b>" + conn.rs.getString("sn") + "</b></td><td style='width:500px;'> <h4 style='color:black;'> <b>" + conn.rs.getString("question") +"</b>.</h4> <font color='red'><h4 >"+conn.rs.getString("comment")+"</h4></font> </td>";
                    String elemname = "element_" + conn.rs.getString("questionid") + "#" + conn.rs.getString("response_type");
                    String marks=conn.rs.getString("marks");
                    
                  String totalperdomain=conn.rs.getString("total");
                    float dcmlmark=(float)conn.rs.getInt("marks")/conn.rs.getInt("total");
                 
                   
                    middletable += "<td style='width:100px;'>"+elementcreator(questionvalue,questiontableid,functionname,elemname,""+dcmlmark,initdomain) + "</td>"
                           
                            + "<td style='width:500px;'> <textarea cols='25' rows='2'  class='form-control' name=\"comment"+conn.rs.getString("questionid") + "\" id=\"comment"+ conn.rs.getString("questionid") + "\"  >"+commentvalue+"</textarea>" 
                        + "</td>"
                        + "</tr>";

                } else {
                    //create a new page
                    
                                   
                    createnewpage = true;
                    if (count == 0) {

                //create a new page without begining with a closing
                                    } else {
                //create a new page by closing what exists 
            
                        
         domaintable="<fieldset> "
         + "<legend>"+legendheader+" <span style='padding:2px;color:red;font-size:25px;' id='domain"+initdomain+"'>"+domainval+"%</span></legend><input type='hidden' name='domaininput"+initdomain+"' value='"+domainvalue+"' id='domaininput"+initdomain+"'/><input type='hidden' name='domaintableid"+initdomain+"' value='"+domaintableid+"' id='domaintableid"+initdomain+"'/>  <table border='1' style='width:1030px;margin:6px;margin-right:2px;'><tr><th colspan='4'><b>Domain: "+legendheader+"</b></th></tr>"
               + ""+tableheader+middletable+"</table></fieldset>";
                 formedform+=domaintable;
                 //reset the middle table
                 middletable="";
                // System.out.println("Domain "+legendheader+" TABLE "+domaintable);
                    }

                }
   //change the legend header after a table copy has been created             
                if(conn.rs.getString("quest_no").equalsIgnoreCase("Q1")){
                   
                legendheader=conn.rs.getString("domain_name");
                initdomain=conn.rs.getString("domain_id");
  String getdomaintotals="select * from domain_totals where domainid='"+initdomain+"' and site='"+fsite+"' and period='"+fperiod+"' and year='"+fyear+"'";
   conn.rs_6=conn.st_6.executeQuery(getdomaintotals);
                    while(conn.rs_6.next()){
                    
                    domainvalue=conn.rs_6.getString("value");
                   
                    if(conn.rs_6.getString("value").equals("")){
                    
                    domainvalue="0";
                    }
                    
                     domainval=Float.parseFloat(domainvalue);
                 domainval=domainval*100;
                 BigDecimal bd=new BigDecimal(domainval).setScale(0,RoundingMode.HALF_EVEN);
                    //domainval=bd.doubleValue();
                    domainval=Math.round(domainval);
                    domaintableid=conn.rs_6.getString("tableid");
                    }
                
                    
                middletable += "<tr><td><b>" + conn.rs.getString("sn") + "</b></td><td> <h4 style='color:black;'> <b>" + conn.rs.getString("question") +"</b>.</h4> <font color='red'><h4 >"+conn.rs.getString("comment")+"</h4></font> </td>";
                String elemname = "element_" + conn.rs.getString("questionid") + "#" + conn.rs.getString("response_type");
                String marks=conn.rs.getString("marks");
                 String totalperdomain=conn.rs.getString("total");
                 float dcmlmark=(float)conn.rs.getInt("marks")/conn.rs.getInt("total"); 
                 
                middletable +="<td style='width:100px;'>"+elementcreator(questionvalue,questiontableid,functionname,elemname,""+dcmlmark,initdomain) + "</td>"
                            + "<td style='width:500px;'> <textarea cols='25' rows='2'  class='form-control' name=\"comment" + conn.rs.getString("questionid") + "\" id=\"comment"+ conn.rs.getString("questionid") + "\"  >"+commentvalue+"</textarea>" 
                            + "</td>"
                            + "</tr>";
                
                
                                                          }
                count++;
            }//end of while loop
           
              String extraqstn="<tr><td colspan='4'><h3 style='text-align:center;color:black;'>What has worked well in the areas observed</h3></td></tr>";
             extraqstn+="<tr><td colspan='4'><textarea cols='25' rows='2'  class='form-control' name='strengths' id='strengths'  >"+strengthsvalue+"</textarea></td></tr>";
            extraqstn+="<tr><td colspan='4'><h3 style='text-align:center;color:black;'>Critical Constraints affecting quality programming and data management</h3></td></tr>";
            extraqstn+="<tr><td colspan='4'><textarea cols='25' rows='2'  class='form-control' name='constraints' id='constraints'  >"+constraintsvalue+"</textarea></td></tr>";
            
            
            domaintable="<fieldset> <legend>"+legendheader+"  <span style='color:red;font-size:25px;' id='domain"+initdomain+"'>"+domainval+"%</span> </legend>"
                    + "<input type='hidden' value='"+domainvalue+"' name='domaininput"+initdomain+"' id='domaininput"+initdomain+"'> "
                    + "<input type='hidden' name='domaintableid"+initdomain+"' value='"+domaintableid+"' id='domaintableid"+initdomain+"'/>"
                    + "<input type='hidden' name='allelements' value='"+allelements+"' id='allelements'/>"
                    + "<input type='hidden' name='allelementsvalue' value='"+allelementsvalues+"' id='allelementsvalue'/>"
                    + "<table border='1' style='width:1030px;margin:6px;margin-right:2px;'>"
                    + "<tr><th colspan='4'><b>Domain: "+legendheader+"</b></th></tr>"
            + ""+tableheader+middletable+extraqstn+"</table></fieldset>";
                 formedform+=domaintable;
                 //reset the middle table
                 
            
            
            

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */

                out.println(formedform);
               // System.out.println("" + formedform);
            }
        } catch (SQLException ex) {
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

    //This function creates 
    public static String elementcreator(String qvalue,String qtableid,String functionname,String restype,String marks,String domainid) {

        String createdelem = "";

        //sample format element1#Select#__Yes_No i.e name#type#options
        String elemarr[] = restype.split("#");
        //index 0 is name
        //index 1 is type
        //index 2 is options => this should be split further using _ delimiter
        //for now we are dealing with input and select elements 
        allelements+=elemarr[0]+"~";
        allelementsvalues+=qvalue+"~";
        
        if (elemarr[1].equalsIgnoreCase("input")) {

            createdelem = "<div class='form-group'>"
                    + "<input type='text' class='form-control' name='" + elemarr[0] + "'  id='" + elemarr[0] + "' >"
                    + "</div>";
        } //input
        else if (elemarr[1].equalsIgnoreCase("select")) {

            //create an options list 
            String options = "";
            String opts[] = elemarr[2].split("_");
            for(int a = 0; a < opts.length; a++) {
                if(opts[a].equals(qvalue)){
                
                options += "<option selected value='" + opts[a] + "'>" + opts[a] + "</option>";
                }
                else {
                 options += "<option value='" + opts[a] + "'>" + opts[a] + "</option>";
                
                }
                                                 }
           // System.out.println(" ~~~~~~"+elemarr[0]);
            createdelem = "<div class=\"form-group\">"
                    + "<select onchange=\"domaintotal(this,'"+elemarr[0]+"','"+marks+"','"+domainid+"');"+functionname+"\"  class=\"form-control\" name='" + elemarr[0] + "' id='" + elemarr[0] + "'  >\n"
                    + "" + options  //data-parsley-group=\"block"+domainid+"\"
                    + "</select><input type='hidden' value='"+qtableid+"' name='qid"+ elemarr[0]+"' id='qid"+ elemarr[0]+"'>"
                    + "</div>";

        }//select
        return createdelem;
    }

}
