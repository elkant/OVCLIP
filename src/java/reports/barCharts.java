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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.hssf.usermodel.HSSFTextbox;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import ovc.gen;

/**
 *
 * @author MANUEL
 */
public class barCharts extends HttpServlet {
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
            String startdate="2015-01-01";
            String enddate="2015-03-30";
            
            startdate=request.getParameter("startdate");
            enddate=request.getParameter("enddate");
            
            
          
//            year=request.getParameter("year");
            //site=request.getParameter("sitecbo");
            //period=request.getParameter("period");
            //cbo=request.getParameter("staffcbo");
            
            
            String sitename="";
            String cboname="";
            
 //begin a loop that will create as many reports as possible
    
           
            
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
            
            
            //=========================ROW STYLE===============================
            
            
             HSSFCellStyle rowstyle = wb.createCellStyle();
            rowstyle.setWrapText(true);
            
            
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
  
            
               
            CellStyle orangestyle = wb.createCellStyle();
            orangestyle.setFont(bolfont);
            orangestyle.setWrapText(true);
            orangestyle.setAlignment(orangestyle.ALIGN_CENTER);
            orangestyle.setFillForegroundColor(HSSFColor.ORANGE.index);
            orangestyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//          innerdata_style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//          innerdata_style.setBorderTop(HSSFCellStyle.BORDER_THIN);
//          innerdata_style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//          innerdata_style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            orangestyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            
            
            
            //Code colors
            
            CellStyle lg = wb.createCellStyle();
            lg.setFont(bolfont);
            lg.setWrapText(true);
            lg.setAlignment(lg.ALIGN_CENTER);
            lg.setFillForegroundColor(HSSFColor.GREEN.index);
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
            Y.setFillForegroundColor(HSSFColor.WHITE.index);
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
            
            
            shet2=wb.createSheet("Column Charts Per Cbo");
            shet2.setColumnWidth(0, 12000);
            shet2.setColumnWidth(1, 12000);
            shet2.setColumnWidth(2, 4000);
            shet2.setColumnWidth(3, 10000);
            shet2.setColumnWidth(4, 5000);
            shet2.setColumnWidth(5, 5000);
            shet2.setColumnWidth(6, 5000);
            shet2.setColumnWidth(7, 5000);
            shet2.setColumnWidth(8, 5000);
            shet2.setColumnWidth(9, 5000);
            shet2.setColumnWidth(10, 5000);
            shet2.setColumnWidth(11, 5000);
            shet2.setColumnWidth(12, 5000);
            shet2.setColumnWidth(13, 5000);
 
//11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111           
 //11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111           
 //11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111           
 //11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111  
            
     
            
   String gettables= "SELECT avg(value) as domainvalue,domain_totals.domainid as domainid,domain_name, section_name,cbo,avg(aggregate_sum) as aggregate_sum FROM ovc_lip.domain_totals join (sites join cbo on sites.cbo_id=cbo.cboid) on domain_totals.site=sites.site_id join ( domains join sections on domains.section_id=sections.section_id ) on domain_totals.domainid=domains.domain_id where  date between '"+startdate+"' and '"+enddate+"' group by cbo.cboid,domainid order by cbo,domainid";
           
            System.out.println(gettables);
            conn.rs = conn.st.executeQuery(gettables);
            int rwcount=0;
            int rowcountcopy=0;
            String tableheaders[]={"Section","Domain","% Overall Achievement","Column chart"};
            
            HSSFRow rwx=null;
            int monitorrows=0;
            int secAcopy=0;
            int secBcopy=0;
            
            
            
            HSSFCell celx=null;
            int noofcols=3;
          boolean isrow1=true;
            while (conn.rs.next()) {                
                //if the section has changed
                 monitorrows++;
                String domainid = conn.rs.getString("domainid");
                float domainvalue = conn.rs.getFloat("domainvalue");
                domainvalue = domainvalue * 100;
                domainvalue = Math.round(domainvalue);
                float totalsum = conn.rs.getFloat("aggregate_sum");
                int dmn = (int) domainvalue;
                totalsum = Math.round(totalsum);
                //determine the cell to print data on
                int ttlsm = (int) totalsum;
                int hearderheight=40;
                //if its the first row in each 
                if(isrow1){
                    isrow1=false;
                rwx=shet2.createRow(rwcount);
                
                HSSFCell headercel=rwx.createCell(0);
                headercel.setCellValue(conn.rs.getString("cbo"));
                headercel.setCellStyle(style);
                rwx.setHeightInPoints(hearderheight);
                
                
                //create a blank
                 HSSFCell cel=null;
                
                for(int b=1;b<tableheaders.length;b++)
                {
             cel=rwx.createCell(b);
             cel.setCellValue("");
             cel.setCellStyle(style);
                 }
                //now merge the header cell
                shet2.addMergedRegion(new CellRangeAddress(rwcount,rwcount,0,tableheaders.length-1));
                rwcount++;
                
                //now create the header part
                
                HSSFRow headerrw=shet2.createRow(rwcount);
                rwx.setHeightInPoints(hearderheight);
                for(int b=0;b<tableheaders.length;b++)
                {
             HSSFCell cel1=headerrw.createCell(b);
             cel1.setCellValue(tableheaders[b]);
             cel1.setCellStyle(style);
                 }
                
                
                rwcount++;
                }
               
                
                
                //create the section part
                
                HSSFRow rw=shet2.createRow(rwcount);
       
                       rw.setHeightInPoints(25); 
                //column one --- section
                
               HSSFCell seccell=rw.createCell(0);
                seccell.setCellValue(conn.rs.getString("section_name"));
                seccell.setCellStyle(dnamestyle);
                
                HSSFCell domcell=rw.createCell(1);
                domcell.setCellValue(conn.rs.getString("domain_name"));
                domcell.setCellStyle(dnamestyle);
                
                //values only
                HSSFCell domval=rw.createCell(2);
                domval.setCellValue(dmn);
                domval.setCellStyle(dnamestyle);
                
                
                HSSFCell blank=rw.createCell(3);
                blank.setCellValue("");
                blank.setCellStyle(dnamestyle);
                
                //now, draw the chart
                 HSSFPatriarch patriarch = shet2.createDrawingPatriarch();                
                 HSSFTextbox textbox1 = patriarch.createTextbox(new HSSFClientAnchor(0,0,(dmn*10),255,(short)3,rwcount,(short)3,rwcount));
                 textbox1.setString(new HSSFRichTextString(""+dmn) );
                 textbox1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    //green 18,174,55
    //red 250 32 32
    //yellow 248 255 9
    if(dmn>=75){        
     textbox1.setFillColor(18,174,55);     
    } else if (dmn >59 &&dmn <75 ){
        
      textbox1.setFillColor(248,255,9);
      
    }
    
    else {
        
     textbox1.setFillColor(250,32,32);
  
    }
                rwcount++;
                
                if(monitorrows==4){
                   shet2.addMergedRegion(new CellRangeAddress(rwcount-4,rwcount-1,0,0));
                }
                
                if(monitorrows==12){
                    
                      shet2.addMergedRegion(new CellRangeAddress(rwcount-8,rwcount-1,0,0));
                    
                      HSSFRow lastrw=shet2.createRow(rwcount);
                       lastrw.setHeightInPoints(25);
                    //now create a row with average
                     HSSFCell avcell0=lastrw.createCell(0);
                avcell0.setCellValue("Average");
                avcell0.setCellStyle(dnamestyle);
                    
                     HSSFCell avcell=lastrw.createCell(1);
                     avcell.setCellValue("Average");
                     avcell.setCellStyle(dnamestyle);
                    
                     HSSFCell avcell1=lastrw.createCell(2);
                     avcell1.setCellValue(ttlsm);
                     avcell1.setCellStyle(dnamestyle);
                     
                     HSSFCell blank1=lastrw.createCell(3);
                blank1.setCellValue("");
                blank1.setCellStyle(dnamestyle);
                      HSSFTextbox textbox = patriarch.createTextbox(new HSSFClientAnchor(0,0,(dmn*(10)),255,(short)3,rwcount,(short)3,rwcount));
    textbox.setString(new HSSFRichTextString(""+ttlsm) );
     if(dmn>=75){
        
     textbox.setFillColor(18,174,55);
     
    } else if (dmn >59 &&dmn <75 ){
        
      textbox.setFillColor(248,255,9);
      
    }
    
    else {
        
     textbox.setFillColor(250,32,32);
  
    }
            textbox.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
                    
               isrow1=true;                    
                monitorrows=0;
                //dont print anything 
                rwcount++;
                
                //last blank cell
                
                HSSFRow blankrow=shet2.createRow(rwcount);
                blankrow.setHeightInPoints(30);
                   for(int b=0;b<tableheaders.length;b++)
                {
             HSSFCell cel1=blankrow.createCell(b);
             cel1.setCellValue("");
             cel1.setCellStyle(innerdata_style);
                 }
                   
                rwcount++;
                                   }
               
                
              
               
                                 } 
            
            ///=========================end of while loop 
            
            
            
            
            
            
            
           
                  
             
             
            
            //write it as an excel attachment
           
            ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
            wb.write(outByteStream);
            byte [] outArray = outByteStream.toByteArray();
            response.setContentType("application/ms-excel");
            response.setContentLength(outArray.length);
            response.setHeader("Expires:", "0"); // eliminates browser caching
            response.setHeader("Content-Disposition", "attachment; filename=OVC_CBO_CHARTS_FROM_"+startdate+"_TO_"+enddate+".xls");
            OutputStream outStream = response.getOutputStream();
            outStream.write(outArray);
            outStream.flush();
        } catch (SQLException ex) {
            Logger.getLogger(resultspercbo.class.getName()).log(Level.SEVERE, null, ex);
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
