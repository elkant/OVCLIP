/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author MANUEL
 */
 @Controller
public class ovc_controller {
    
   
    @RequestMapping("/index")
    public String index() {
        return "index";    
                           }

    @RequestMapping("/newuser")
    public String newuser() {        
        return "newuser";
                            }
    
     @RequestMapping("/index.htm")
    public String handleIndexGet() {
        return "index"; // forward to view index.jsp
                                   }
    @RequestMapping("/ovc_home.htm")
    public String handleovchome() {
        return "ovc_home"; // forward to view index.jsp
                                   }  

 @RequestMapping("/logout.htm")
    public String handlelogoutGet() {
        return "logout"; // forward to view index.jsp
                                   } 
    
    
     @RequestMapping("/actionpoint.htm")
    public String handleapGet() {
        return "actionpoint"; // forward to view index.jsp
                                   } 
    
    @RequestMapping("/addstaff.htm")
    public String handleaddstaffGet() {
        return "addstaff"; // forward to view index.jsp
                                   }
  
        @RequestMapping("/filterreports.htm")
    public String handlefrGet() {
        return "filterreports"; // forward to view index.jsp
                                   }
        @RequestMapping("/basicreport.htm")
    public String handlebrGet() {
        return "basicreport"; // forward to view index.jsp
                                   }
      @RequestMapping("/filtermultiplesitesreport.htm")
    public String handlemrGet() {
        return "filtermultiplesitesreport"; // forward to view index.jsp
                                   }
   
    //filtercountyreport
      @RequestMapping("/filtercountyreport.htm")
    public String handlecrGet() {
        return "filtercountyreport"; // forward to view index.jsp
                                   }
        @RequestMapping("/webcharts.htm")
    public String handlewcGet() {
        return "webcharts"; // forward to view index.jsp
                                   }
    
        @RequestMapping("/backup.htm")
    public String handlebuGet() {
        return "backup"; // forward to view index.jsp
                                   }
    
           @RequestMapping("/merge.htm")
    public String handlemdGet() {
        return "merge"; // forward to view index.jsp
                                   }
    
           @RequestMapping("/editstaff.htm")
    public String handleesGet() {
        return "editstaff"; // forward to view index.jsp
                                   }
    
    
   @RequestMapping("/wizardtest.htm")
    public String handlewtGet() {
        return "wizardtest"; // forward to view index.jsp
                                   }  
    
    @RequestMapping("/dataentry.htm")
    public String handledataentryGet() {
        return "dataentry"; // forward to view index.jsp
                                   }
    
    
    @RequestMapping("*")
@ResponseBody
public String fallbackMethod(){
    return "<h2 style='text-align:center;color:orange;'>Requested Page Not found</h3>";
                            }
    
    
}
