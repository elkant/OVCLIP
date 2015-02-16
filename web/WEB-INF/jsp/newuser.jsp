<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
    <head>
        <title>DATABASE SETUP</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
       	<link rel="shortcut icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/newstyle.css"/>" />
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.9.1.js"/>"></script>
         <!--tooltip-->
        <link href="<c:url value="/resources/js/css/start/jquery-ui-1.10.3.custom.css" />" rel="stylesheet"/>

        <script src="<c:url value="/resources/js/js/jquery-ui-1.10.3.custom.js" />" ></script>
        <link rel="stylesheet" href="<c:url value="/resources/js/demos.css" />" />  
        <script src="<c:url value="/resources/js/cufon-yui.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/ChunkFive_400.font.js" />" type="text/javascript"></script>
		
        <script type="text/javascript" src="<c:url value="/resources/js/noty/jquery.noty.js" />" ></script>
        <script type="text/javascript" src="<c:url value="/resources/js/noty/layouts/top.js" />" ></script>
        <script type="text/javascript" src="<c:url value="/resources/js/noty/layouts/center.js" />" ></script>
<!-- You can add more layouts if you want -->
<script type="text/javascript" src="<c:url value="/resources/js/noty/themes/default.js" />" ></script>
                  
                  
                  <script type="text/javascript">
			Cufon.replace('h1',{textShadow: '1px 1px #fff'});
			Cufon.replace('h2',{textShadow: '1px 1px #fff'});
			Cufon.replace('h3',{textShadow: '1px 1px #000'});
			Cufon.replace('.back');
		</script>
                
                <script>
                   function checkPasswords() {
                var password = document.getElementById('password');
                var conf_password = document.getElementById('conf_password');

                if (password.value != conf_password.value) {
                    conf_password.setCustomValidity('Passwords do not match');
                } else {
                    conf_password.setCustomValidity('');
                }
                
          
        
            }
            
            
            /**
             calculating date of birth
             **/
     

//var age = getAge('08/08/2000');
//alert(age);
        
     
$(function() {
$( "#datepicker" ).datepicker();
});

            
        </script> 
                
                
    </head>
    <body>
        
        
        
		<div class="wrapper">
                     <% if(session.getAttribute("level")!=null){
                         if(session.getAttribute("level").equals("2")){ 
            %>
<%--<%@include file="/menu/clerkmenu.jsp"%>--%>
<%} else{%>
<%--<%@include file="/menu/adminmenu.jsp"%>--%>
<%}}%>
                    
                  
			<h2 style="text-align: center;"><span>Adding A System User</span></h2>
			<br/>
			<br/>
			<div class="content">
                            
                            <%if (session.getAttribute("clerk_added") != null) { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("clerk_added")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 1800});
                    
                </script> <%
                session.removeAttribute("clerk_added");
                            }

                        %>
                        <!--creating random user id-->
                         <%!
    public int generateRandomNumber(int start, int end ){
        Random random = new Random();
        long fraction = (long) ((end - start + 1 ) * random.nextDouble());
        return ((int)(fraction + start));
    }
%>  
                        
                            
                            
				<div id="form_wrapper" class="form_wrapper" style="width:500px;">
					
				  
                                    <p><font color="red">*</font> indicates must fill fields</p>
                    <form action="saveUser" class="login active" method="post">
                        <br/>
                        <table cellpadding="2px" cellspacing="3px" border="0px" style="">
                       
                            
                            <tr>
                                <td class="align_button_left"><label for="first_name">Userid<font color="red">*</font></label></td>
                                <td><input id="first_name" type=text readonly value="<%=generateRandomNumber(1000,10888)%>" required name=userid class="textbox"/></td></tr><tr>

                               
                            </tr>
                            
                            <tr>
                                <td class="align_button_left"><label for="first_name">Surname<font color="red">*</font></label></td>
                                <td><input id="first_name" type=text required name="s_name" student_name class="textbox"/></td></tr><tr>

                               
                            </tr>
                            
                            
                            <tr>
                                <td class="align_button_left"><label for="first_name">First Name<font color="red">*</font></label></td>
                                <td><input id="first_name" type=text required name="f_name" student_name class="textbox"/></td></tr><tr>

                               
                            </tr>
                            
                           
                            
                            
                            <tr>
                               
                            <td class="align_button_left"><label for="email">Phone Number</label></td>
                            <td><input  type="text" name="phoneno" pattern="[0-9]{10,10}" class="textbox" /></td>
                            
                           
                            
                            </tr>
                            <tr>
                                <td>
                                    
                                    
                                                           
                                </td>
                                 
                            </tr>
                          
                     

                            
                         
                           <tr> <td class="align_button_left"><label for="town">Username <font color="red">*</font></label></td>
                            <td><input id="town" type=text required name=username class="textbox"/></td></tr>
                            
                           <tr>
                            <td class="align_button_left"><label for="password">Password<font color="red">*</font></label></td>
                            <td><input id="password" type=password required name=pass oninput="checkPasswords()" class="textbox"/></td>
                           </tr>
                           <tr>
                           
                                <td class="align_button_left"><label for="conf_password">Confirm Password<font color="red">*</font></label></td>
                                <td ><input id="conf_password" type=password required name=conf_password oninput="checkPasswords()" class="textbox"/></td>
                                <td></td>
                           </tr>      
            
                             <tr>
                           
                                <td class="align_button_left"><label for="conf_password">User Level<font color="red">*</font></label></td>
                                <td ><select id="ulevel"  required name="ulevel"  style="height:30px;">
                                    <option value="">user level</option>
                                    <option value="0">Administrator</option>
                                    <option value="2">System User</option>
                                    </select></td>
                                <td></td>
                           </tr>   
                           <tr><td></td></tr>
                             </table>
                        
                               
                                <div class="bottom" style="width:400px;">
                                      <input   type="reset" value="clear" />
					<input type="submit"  value="Add" />
                      		
							
							<!--<a href="register.jsp.html" rel="register" class="linkform">You don't have an account yet? Register here</a>-->
							<div class="clear"></div>
						</div>
                                
                    </form>
                                    
                                    
                                    
					
				</div>
				<div class="clear"></div>
			</div>
				</div>
		

		<!-- The JavaScript -->
		<!--<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>-->
		<script type="text/javascript">
			
        </script>
    </body>
</html>