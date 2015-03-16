/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import database.dbConn;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 *
 * @author MANUEL
 */
public class basicreports extends HttpServlet {
    HSSFWorkbook wb=null;
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
            dbConn conn = new dbConn();
            
            wb=new HSSFWorkbook();
            
            HSSFSheet shet2=null;
            
            String year="";
            String site="";
            String period="";
            String cbo="";
            
            year=request.getParameter("year");
            site=request.getParameter("sitecbo");
            period=request.getParameter("period");
            cbo=request.getParameter("staffcbo");
            
            String sitename="";
            String cboname="";
            
            
            conn.rs=conn.st.executeQuery("select cbo from cbo where cboid='"+cbo+"'");
            if(conn.rs.next()){
                cboname=conn.rs.getString(1);
            }
            
            conn.rs=conn.st.executeQuery("select site_name from sites where site_id='"+site+"'");
            if(conn.rs.next()){
                sitename=conn.rs.getString(1);
            }
            
            HSSFFont font=wb.createFont();
            font.setFontHeightInPoints((short)12);
            font.setFontName("Cambria");
//    font.setItalic(true);
            font.setBoldweight((short)02);
            font.setColor(HSSFColor.BLACK.index);
            CellStyle style=wb.createCellStyle();
            style.setFont(font);
            style.setWrapText(true);
            style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            
            style.setAlignment(style.ALIGN_CENTER);
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            
            
//%%%%%%%%%%%%%%%%HEADER FONTS AND COLORATION%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
            HSSFFont font_header=wb.createFont();
            font_header.setFontHeightInPoints((short)10);
            font_header.setFontName("Eras Bold ITC");
//    font.setItalic(true);
            font_header.setBoldweight((short)05);
            font_header.setColor(HSSFColor.BLACK.index);
            CellStyle style_header=wb.createCellStyle();
            style_header.setFont(font_header);
            style_header.setWrapText(true);
            style_header.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
            style_header.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            style_header.setAlignment(style_header.ALIGN_CENTER);
            
            
//            style_header.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//            style_header.setBorderTop(HSSFCellStyle.BORDER_THIN);
//            style_header.setBorderRight(HSSFCellStyle.BORDER_THIN);
//            style_header.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            
            
            //%%%%%%%%%%%%%%%%%%%%%%%%%DATA FONT%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
            
            
            //font data
            HSSFFont datafont = wb.createFont();
            datafont.setBoldweight((short) 03);
            datafont.setColor(HSSFColor.BLACK.index);
            datafont.setFontHeightInPoints((short) 10);
            datafont.setFontName("Cambria");
            datafont.setItalic(true);
            
            //bold font 
             HSSFFont bolfont = wb.createFont();
             
            bolfont.setBoldweight((short) 05);
            bolfont.setColor(HSSFColor.BLACK.index);
            bolfont.setFontHeightInPoints((short) 12);
            bolfont.setFontName("Cambria");
            
            //=======INNER DATA STYLING===========================

            CellStyle innerdata_style = wb.createCellStyle();
            innerdata_style.setFont(datafont);
            innerdata_style.setWrapText(true);
            innerdata_style.setAlignment(innerdata_style.ALIGN_CENTER);
            innerdata_style.setFillForegroundColor(HSSFColor.WHITE.index);
            innerdata_style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//            innerdata_style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//            innerdata_style.setBorderTop(HSSFCellStyle.BORDER_THIN);
//            innerdata_style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//            innerdata_style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            innerdata_style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            
 

            CellStyle lastcellrighborder = wb.createCellStyle();
            lastcellrighborder.setFont(datafont);
            lastcellrighborder.setWrapText(true);
            lastcellrighborder.setAlignment(lastcellrighborder.ALIGN_CENTER);
            lastcellrighborder.setFillForegroundColor(HSSFColor.WHITE.index);
            lastcellrighborder.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//            lastcellrighborder.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//            lastcellrighborder.setBorderTop(HSSFCellStyle.BORDER_THIN);
            lastcellrighborder.setBorderRight(HSSFCellStyle.BORDER_THIN);
//            lastcellrighborder.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            lastcellrighborder.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);            
            
            
            
            
            CellStyle innerdata_style2 = wb.createCellStyle();
            innerdata_style2.setFont(bolfont);
            innerdata_style2.setWrapText(true);
            innerdata_style2.setAlignment(innerdata_style.ALIGN_LEFT);
            innerdata_style2.setFillForegroundColor(HSSFColor.WHITE.index);
            innerdata_style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//            innerdata_style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//            innerdata_style.setBorderTop(HSSFCellStyle.BORDER_THIN);
//            innerdata_style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//            innerdata_style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            innerdata_style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
         
            
            //Code colors
            
            CellStyle lg = wb.createCellStyle();
            lg.setFont(bolfont);
            lg.setWrapText(true);
            lg.setAlignment(lg.ALIGN_CENTER);
            lg.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
            lg.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            lg.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            lg.setBorderTop(HSSFCellStyle.BORDER_THIN);
            lg.setBorderRight(HSSFCellStyle.BORDER_THIN);
            lg.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            lg.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            
           
            CellStyle Y = wb.createCellStyle();
            Y.setFont(bolfont);
            Y.setWrapText(true);
            Y.setAlignment(Y.ALIGN_CENTER);
            Y.setFillForegroundColor(HSSFColor.YELLOW.index);
            Y.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            Y.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            Y.setBorderTop(HSSFCellStyle.BORDER_THIN);
            Y.setBorderRight(HSSFCellStyle.BORDER_THIN);
            Y.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            Y.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);    
            
            
               
            CellStyle R = wb.createCellStyle();
            R.setFont(bolfont);
            R.setWrapText(true);
            R.setAlignment(R.ALIGN_CENTER);
            R.setFillForegroundColor(HSSFColor.RED.index);
            R.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            R.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            R.setBorderTop(HSSFCellStyle.BORDER_THIN);
            R.setBorderRight(HSSFCellStyle.BORDER_THIN);
            R.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            R.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            
            
            //=======INNER LEFT DATA STYLING===========================

            CellStyle binnerdata_style2 = wb.createCellStyle();
            binnerdata_style2.setFont(datafont);
            binnerdata_style2.setWrapText(true);
            binnerdata_style2.setAlignment(binnerdata_style2.ALIGN_LEFT);
            binnerdata_style2.setFillForegroundColor(HSSFColor.WHITE.index);
            binnerdata_style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            binnerdata_style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            binnerdata_style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
            binnerdata_style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
            binnerdata_style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            binnerdata_style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            //create a header
            
            //=======================Domainname styles
            CellStyle dnamestyle = wb.createCellStyle();
            dnamestyle.setFont(bolfont);
            dnamestyle.setWrapText(true);
            dnamestyle.setAlignment(dnamestyle.ALIGN_LEFT);
            dnamestyle.setFillForegroundColor(HSSFColor.WHITE.index);
            dnamestyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            dnamestyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            dnamestyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            dnamestyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            dnamestyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            dnamestyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            
            
            
            shet2=wb.createSheet("Report");
            shet2.setColumnWidth(0, 10000);
            shet2.setColumnWidth(1, 5000);
            shet2.setColumnWidth(2, 5000);
            shet2.setColumnWidth(3, 5000);
            shet2.setColumnWidth(4, 8000);
            
            //create header one
            HSSFRow header=shet2.createRow(0);
            header.setHeightInPoints(30);
            HSSFCell cel1=header.createCell(0);
            cel1.setCellValue("APHIAplus NURU YA BONDE");
            cel1.setCellStyle(style);
            for(int b=1;b<=5;b++){
             cel1=header.createCell(b);
            cel1.setCellValue("");
            cel1.setCellStyle(style);
            }
            
            shet2.addMergedRegion(new CellRangeAddress(0,0,0,5));
            
            //create header two
            HSSFRow header2=shet2.createRow(1);
             header2.setHeightInPoints(28);
             HSSFCell cel2=null;
             for(int b=1;b<=5;b++){
             cel2=header2.createCell(b);
            cel2.setCellValue("");
            cel2.setCellStyle(style);
            }
             
             cel2=header2.createCell(0);
            cel2.setCellValue("OVC LIP SUPPORT SUPERVISION DASH BOARD");
            cel2.setCellStyle(style);
             
            
            shet2.addMergedRegion(new CellRangeAddress(1,1,0,5));
            
            //cbo name
            //create header three
            HSSFRow header3=shet2.createRow(2);
            HSSFCell cel3=header3.createCell(0);
            cel3.setCellValue("Name of LIP/CBO");
            cel3.setCellStyle(innerdata_style2);
            
            
            HSSFCell cel4=header3.createCell(1);
            cel4.setCellValue(""+cboname);
            cel4.setCellStyle(innerdata_style);
            //blank cells for purpose of clear worksheet only
            for(int x=2;x<=3;x++){
            HSSFCell cel=header3.createCell(x);
            cel.setCellValue("");
            cel.setCellStyle(innerdata_style);
            }
            
            HSSFCell cel5=header3.createCell(4);
            cel5.setCellValue("Site Visited:");
            cel5.setCellStyle(innerdata_style2);
            
            
            HSSFCell cel6=header3.createCell(5);
            cel6.setCellValue(""+sitename);
            cel6.setCellStyle(lastcellrighborder);
            
            //create a blank row whose last cell has a border
            
            HSSFRow blankrw=shet2.createRow(3);
            for(int z=0;z<5;z++){
            
                HSSFCell cl=blankrw.createCell(z);
                cl.setCellValue("");
                cl.setCellStyle(innerdata_style);
            }
            HSSFCell cl=blankrw.createCell(5);
                cl.setCellValue("");
                cl.setCellStyle(lastcellrighborder);
            //==========DATE OF VISIT
            
            String mywhere="site='"+site+"' and period='"+period+"' and year='"+year+"' ";
            
            String supervisor="";
            String dateofvisit="";
            
            String strengths="";
            String constraints="";
            
            String loadbasicdetails="select * from backgroundinfor join staff on backgroundinfor.supervisor=staff.staff_id where "+mywhere+" ";
            System.out.println(loadbasicdetails);
            conn.rs=conn.st.executeQuery(loadbasicdetails);
            while(conn.rs.next()){
            supervisor=conn.rs.getString("fname")+" "+conn.rs.getString("mname");
            dateofvisit=conn.rs.getString("ass_date");
            strengths=conn.rs.getString("strengths");
            constraints=conn.rs.getString("constraints");
            
            }
            
            
            //================Create the second header=================
            //create header three
            HSSFRow header4=shet2.createRow(4);
            HSSFCell cel=header4.createCell(0);
            cel.setCellValue("Date of Visit");
            cel.setCellStyle(innerdata_style2);
            
            
            HSSFCell cell=header4.createCell(1);
            cell.setCellValue(""+dateofvisit);
            cell.setCellStyle(innerdata_style);
            
            
            //blank cells for purpose of clear worksheet only
            for(int x=2;x<=3;x++){
            HSSFCell ceel=header4.createCell(x);
            ceel.setCellValue("");
            ceel.setCellStyle(innerdata_style);
            }
            
            HSSFCell cell5=header4.createCell(4);
            cell5.setCellValue("Supervision Team Lead:");
            cell5.setCellStyle(innerdata_style2);
            
            
            HSSFCell cell6=header4.createCell(5);
            cell6.setCellValue(""+supervisor);
            cell6.setCellStyle(lastcellrighborder);
            
            
            
            //another blank row
              HSSFRow blankrw2=shet2.createRow(5);
            for(int z=0;z<5;z++){
            
                HSSFCell cl2=blankrw2.createCell(z);
                cl2.setCellValue("");
                cl2.setCellStyle(innerdata_style);
            }
            HSSFCell cl2=blankrw2.createCell(5);
                cl2.setCellValue("");
                cl2.setCellStyle(lastcellrighborder);
            
          //create a header
            
            String theaderar[]={"Assesment Domain","LG","Y","R","Comments/Action",""};
            
             HSSFRow theader=shet2.createRow(6);
             
             for(int x=0;x<theaderar.length;x++){
            HSSFCell tcel=theader.createCell(x);
            tcel.setCellValue(theaderar[x]);
            if(theaderar[x].equalsIgnoreCase("LG")){
            tcel.setCellStyle(lg);
            }
            else if(theaderar[x].equalsIgnoreCase("Y")){
            tcel.setCellStyle(Y);
            }
            else if(theaderar[x].equalsIgnoreCase("R")){
            tcel.setCellStyle(R);
            }
            else {
             tcel.setCellStyle(style);
            }
            
             }
             shet2.addMergedRegion(new CellRangeAddress(6,6,4,5));
            //SECTION A HEADER
              HSSFRow seca=shet2.createRow(7);
            HSSFCell tcel1=seca.createCell(0);
            tcel1.setCellValue("Section A: Data management and Reporting Systems");
            tcel1.setCellStyle(style);
            for(int b=1;b<=5;b++){
             cel1=seca.createCell(b);
            cel1.setCellValue("");
            cel1.setCellStyle(style);
            }
            
            shet2.addMergedRegion(new CellRangeAddress(7,7,0,5));
            
            String gettables = "SELECT domain_name,domains.domain_id as domainid,section_name,domains.section_id as secid,value as domainvalue,aggregate_sum,period,year,site FROM domains join sections on domains.section_id=sections.section_id join domain_totals on domains.domain_id=domain_totals.domainid where "+mywhere+" order by domainid";
            System.out.println(gettables);
            conn.rs = conn.st.executeQuery(gettables);
            int rwcount=8;
            HSSFRow rwx=null;
             HSSFCell celx=null;
             String sectioncopy="";
            while (conn.rs.next()) {
            if(sectioncopy.equals("")){sectioncopy=conn.rs.getString("section_name");}    
                //if the section has changed
                if(!sectioncopy.equals(conn.rs.getString("section_name"))){                
                //create a section header
       //``````````````````````````````INNER SECTION HEADERS``````````````````            
       //``````````````````````````````INNER SECTION HEADERS``````````````````            
       //``````````````````````````````INNER SECTION HEADERS``````````````````            
           HSSFRow secb=shet2.createRow(rwcount);
            HSSFCell t=secb.createCell(0);
            t.setCellValue("Section "+conn.rs.getString("section_name"));
            t.setCellStyle(style);
            //for purpose of merging
            for(int b=1;b<=5;b++){
             cel1=secb.createCell(b);
            cel1.setCellValue("");
            cel1.setCellStyle(style);
                                 }
             //equalize copy and current value       
             sectioncopy=conn.rs.getString("section_name");
             shet2.addMergedRegion(new CellRangeAddress(rwcount,rwcount,0,5));
             
             //increment rowcount to skip the current row 
             rwcount++;
                }
               
             
               String valu[]={conn.rs.getString("domain_name"),"","","","",""}; 
                
              rwx=shet2.createRow(rwcount);
             for(int t=0;t<valu.length;t++){
            celx=rwx.createCell(t);
            celx.setCellValue(""+valu[t]);
            celx.setCellStyle(dnamestyle);   
                                 }
              shet2.addMergedRegion(new CellRangeAddress(rwcount,rwcount,4,5));
             //get the value of percentange achievement per domian
             //multiply by 100
             //round off
             float domainvalue=conn.rs.getFloat("domainvalue");
             
                 domainvalue=domainvalue*100;
                 //BigDecimal bd=new BigDecimal(domainvalue).setScale(0,RoundingMode.HALF_EVEN);
                    //domainval=bd.doubleValue();
             domainvalue=Math.round(domainvalue);
             
             //determine the cell to print data on
             if(domainvalue>=75){
             
             celx=rwx.createCell(1);
            celx.setCellValue(""+domainvalue+"%");
            celx.setCellStyle(lg);   
             
             }
             else if(domainvalue>=60 && domainvalue<75){
              celx=rwx.createCell(2);
            celx.setCellValue(""+domainvalue+"%");
            celx.setCellStyle(Y);  
             
             }
             else if(domainvalue<60){
             
              celx=rwx.createCell(3);
            celx.setCellValue(""+domainvalue+"%");
            celx.setCellStyle(R);  
             }
             
             
             rwcount++;   
                                 } 
            
            ///=========================end of while loop 
            
            
            
            
            
            
            
           //====================STRENGTHS=========================== 
          HSSFRow secb=shet2.createRow(rwcount);
          
           //for purpose of merging
            for(int b=1;b<=5;b++){
             cel1=secb.createCell(b);
            cel1.setCellValue("");
            cel1.setCellStyle(style);
                                 }
          
            HSSFCell t=secb.createCell(0);
            t.setCellValue("What has worked well and key areas of strengths observed");
            t.setCellStyle(style);    
              shet2.addMergedRegion(new CellRangeAddress(rwcount,rwcount,0,5)); 
           
              rwcount++;
             
            HSSFRow str=shet2.createRow(rwcount);
            
               for(int b=1;b<=5;b++){
             cel1=str.createCell(b);
            cel1.setCellValue("");
            cel1.setCellStyle(dnamestyle);
                                 }
            
            HSSFCell t1=str.createCell(0);
            t1.setCellValue(""+strengths);
            t1.setCellStyle(dnamestyle);    
            shet2.addMergedRegion(new CellRangeAddress(rwcount,rwcount,0,5));  
            //for purpose of merging
         
               str.setHeightInPoints(50); 
             rwcount++;
             
             
             
             
             
             
             
            //=======Contraints
             HSSFRow sec3=shet2.createRow(rwcount);
             
            //for purpose of merging
            for(int b=1;b<=5;b++){
             cel1=sec3.createCell(b);
            cel1.setCellValue("");
            cel1.setCellStyle(style);
                                 }
             
            HSSFCell t2=sec3.createCell(0);
            t2.setCellValue("Critical consraints affecting quality programming and data management");
            t2.setCellStyle(style);    
              shet2.addMergedRegion(new CellRangeAddress(rwcount,rwcount,0,5)); 
            
              rwcount++;
             
            HSSFRow str2=shet2.createRow(rwcount);
            
            for(int b=1;b<=5;b++){
             cel1=str2.createCell(b);
            cel1.setCellValue("");
            cel1.setCellStyle(dnamestyle);
                                 }
            
            
            HSSFCell t4=str2.createCell(0);
            t4.setCellValue(""+constraints);
            t4.setCellStyle(dnamestyle);    
            shet2.addMergedRegion(new CellRangeAddress(rwcount,rwcount,0,5));   
            str2.setHeightInPoints(50); 
              
            rwcount++;
            //a line of codes
            String codes[]={"LG - Meets Expectations (>=75%); "," Y- Needs Improvement (60%- 74%);","R - Needs Urgent Attention (<=59%);"};
            HSSFRow rwl=shet2.createRow(rwcount);
            HSSFCell ce=rwl.createCell(0);
            ce.setCellValue("CODES");
            ce.setCellStyle(dnamestyle);
             for(int b=0;b<codes.length;b++){
              ce=rwl.createCell(b+1);
            ce.setCellValue(""+codes[b]);
            if(b==1){
            ce.setCellStyle(lg);
            }
            else if(b==2){
                
            ce.setCellStyle(Y);
            }
             else {
             ce.setCellStyle(R);
                   }
                                 }
          ce=rwl.createCell(4);
            ce.setCellValue("");   
             ce.setCellStyle(dnamestyle); 
            ce=rwl.createCell(5);
            ce.setCellValue("");   
             ce.setCellStyle(dnamestyle); 
          shet2.addMergedRegion(new CellRangeAddress(rwcount,rwcount,4,5));   
             
             
             
             
             
             
             
             
             
            
            //write it as an excel attachment
            sitename=sitename.replace(" ", "_");
            sitename=sitename.replace("'", "");
            cboname=cboname.replace(" ","_");
            cboname=cboname.replace("'","_");
            ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
            wb.write(outByteStream);
            byte [] outArray = outByteStream.toByteArray();
            response.setContentType("application/ms-excel");
            response.setContentLength(outArray.length);
            response.setHeader("Expires:", "0"); // eliminates browser caching
            response.setHeader("Content-Disposition", "attachment; filename=OVC_LIP_REPORT_"+cboname+"_"+sitename+".xls");
            OutputStream outStream = response.getOutputStream();
            outStream.write(outArray);
            outStream.flush();
        } catch (SQLException ex) {
            Logger.getLogger(basicreports.class.getName()).log(Level.SEVERE, null, ex);
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
