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
            
           // startdate=request.getParameter("startdate");
            //enddate=request.getParameter("enddate");
            
            
          
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
            
            
            shet2=wb.createSheet("LIP_REPORT");
            shet2.setColumnWidth(0, 8000);
            shet2.setColumnWidth(1, 5000);
            shet2.setColumnWidth(2, 5000);
            shet2.setColumnWidth(3, 5000);
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
            
            //create header one
            HSSFRow header=shet2.createRow(0);
            header.setHeightInPoints(30);
            HSSFCell cel1=header.createCell(0);
            cel1.setCellValue("Results on LIP Initial conducted from "+startdate+" to "+enddate);
            cel1.setCellStyle(style);
            for(int b=1;b<14;b++){
             cel1=header.createCell(b);
            cel1.setCellValue("");
            cel1.setCellStyle(style);
                                 }
            
            shet2.addMergedRegion(new CellRangeAddress(0,0,0,13));
            
            //create header two
            HSSFRow header2=shet2.createRow(1);
             header2.setHeightInPoints(28);
             HSSFCell cel2=null;
             for(int b=1;b<14;b++){
             cel2=header2.createCell(b);
            cel2.setCellValue("");
            cel2.setCellStyle(style);
                                  }
             
             cel2=header2.createCell(0);
            cel2.setCellValue("Percent Scores Per Domain");
            cel2.setCellStyle(style);
             
            
            shet2.addMergedRegion(new CellRangeAddress(1,1,0,13));
            
            //cbo name
            //create header three
            
            //==========DATE OF VISIT
            
            String mywhere=" ass_date between '"+startdate+"' and '"+enddate+"' ";
            //if the current countyid is 0, then the where code should not specify the county name 
          
            
           
           
               
           //===============================================================================================
           //===============================================================================================
           String getdomains="SELECT domain_id,domain_name,section_name FROM domains join sections on domains.section_id=sections.section_id";     
           conn.rs=conn.st.executeQuery(getdomains);
           
           
            ArrayList domainids=new ArrayList();    
     
            
            
            int r=2;
             HSSFRow theader=shet2.createRow(r);
             HSSFRow domainshd=shet2.createRow(r+1);
             
             
             //create a row with title lip
             
              HSSFCell tce=domainshd.createCell(0);
            tce.setCellValue("LIP");        
            tce.setCellStyle(Y);
            
            
            
            
             HSSFPatriarch patriarch = shet2.createDrawingPatriarch();
   HSSFClientAnchor a = new HSSFClientAnchor(0,0,1000,255,(short)1,2, (short) 1, 2 );
    HSSFSimpleShape shape1 = patriarch.createSimpleShape(a);
    shape1.setShapeType(HSSFSimpleShape.OBJECT_TYPE_RECTANGLE);
    shape1.setFillColor(90,10,200);
         
    HSSFTextbox textbox1 = patriarch.createTextbox(new HSSFClientAnchor(0,0,700,255,(short)1,4,(short)1,4));
    textbox1.setString(new HSSFRichTextString("70%") );
     textbox1.setFillColor(90,10,200);
         a = new HSSFClientAnchor(0,0,700,255,(short)1,3, (short) 1, 3 );
    HSSFSimpleShape shape2 = patriarch.createSimpleShape(a);
    shape2.setShapeType(HSSFSimpleShape.OBJECT_TYPE_RECTANGLE);
    shape2.setFillColor(90,10,200);   
            
             int cnt=1;
            while(conn.rs.next()){
                
            HSSFCell tcel=theader.createCell(cnt);
            tcel.setCellValue(conn.rs.getString("section_name"));        
            tcel.setCellStyle(Y);
             theader.setHeightInPoints(24);
            HSSFCell tcel1=domainshd.createCell(cnt);
            tcel1.setCellValue(conn.rs.getString("domain_name"));        
            tcel1.setCellStyle(Y);
            domainids.add(conn.rs.getString("domain_id"));            
            cnt++;
                                 }
            
            //create avarage header
            
            
             HSSFCell tcel=domainshd.createCell(cnt);
            tcel.setCellValue("Avarage");        
            tcel.setCellStyle(Y);
            
            
            
            
            
             shet2.addMergedRegion(new CellRangeAddress(r,r,1,5));
             shet2.addMergedRegion(new CellRangeAddress(r,r,6,12));
             cnt ++;
            
            
           // shet2.addMergedRegion(new CellRangeAddress(7,7,0,5));
            
           // String gettables = "SELECT domain_name,domains.domain_id as domainid,section_name,domains.section_id as secid,value as domainvalue,aggregate_sum,period,year,site FROM domains join sections on domains.section_id=sections.section_id join domain_totals on domains.domain_id=domain_totals.domainid where "+mywhere+" order by domainid";
            String gettables= "SELECT avg(value) as domainvalue,domain_totals.domainid as domainid,site_name,cbo,avg(aggregate_sum) as aggregate_sum FROM ovc_lip.domain_totals join (sites join cbo on sites.cbo_id=cbo.cboid) on domain_totals.site=sites.site_id where  date between '"+startdate+"' and '"+enddate+"' group by cbo.cboid,domainid order by cbo,domainid";
       //if its the first county, themn skip the county part
            
            System.out.println(gettables);
            conn.rs = conn.st.executeQuery(gettables);
            int rwcount=4;
            HSSFRow rwx=null;
             HSSFCell celx=null;
             String sectioncopy="";
             int rowcopy=8;
            while (conn.rs.next()) {
                //if the section has changed
                String domainid=conn.rs.getString("domainid");
             float domainvalue=conn.rs.getFloat("domainvalue");
                 domainvalue=domainvalue*100;
                 //BigDecimal bd=new BigDecimal(domainvalue).setScale(0,RoundingMode.HALF_EVEN);
                    //domainval=bd.doubleValue();
             domainvalue=Math.round(domainvalue);
             float totalsum=conn.rs.getFloat("aggregate_sum");
            // totalsum=totalsum*100;
             
             int dmn=(int)domainvalue;
             
             totalsum=Math.round(totalsum);
             //determine the cell to print data on
            int ttlsm=(int)totalsum;
            
               if(domainid.equals("1")){
                    rwx=shet2.createRow(rwcount);
                    rwx.setHeightInPoints(22);
            HSSFCell celx2=rwx.createCell(0);
            celx2.setCellValue(""+conn.rs.getString("cbo"));
            celx2.setCellStyle(dnamestyle);         
            
              rwcount++;
                                       }
             
           for(int t=0;t<domainids.size();t++){
               
               //if row is blank create it
               if(rwx==null){
               rwx=shet2.createRow(rwcount);
               
               }
               
                   if(domainids.get(t).equals(domainid)){
               int ct=t+1;       
            HSSFCell celx1=rwx.createCell(ct);
            celx1.setCellValue(""+dmn);
            celx1.setCellStyle(dnamestyle); 
            rwx.setHeightInPoints(22);
            
            //System.out.println("worked in row ============="+rwcount+"__col "+(ct)+"_"+domainvalue);
             
                                                        }
                  
                                             }
             //incement if the column is the last
           if(domainid.equals("12")){
               //create an avarage
           //  System.out.println("XXXXX LAST LOOP"); 
               
                if(rwx==null){ 
               rwx=shet2.createRow(rwcount);
               
               }
               
              celx=rwx.createCell(13);
              rwx.setHeightInPoints(23);
              celx.setCellValue(""+ttlsm);
              celx.setCellStyle(dnamestyle); 
               
            // rwcount++;   
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
            response.setHeader("Content-Disposition", "attachment; filename=OVC_LIP_COUNTY_REPORT_"+startdate+"_"+enddate+".xls");
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
