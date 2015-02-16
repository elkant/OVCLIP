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

    
    @RequestMapping("*")
@ResponseBody
public String fallbackMethod(){
    return "<h2 style='text-align:center;color:orange;'>Requested Page Not found</h3>";
                            }
    
    
}
