<%@page import="java.util.Calendar"%>
<%@page import="database.dbConn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
    <head>
        <title>IP Reports (Charts)</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
       	<link rel="shortcut icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/newstyle.css"/>" />
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.9.1.js"/>"></script>
         <script type="text/javascript" src="<c:url value='/resources/js/noty/jquery.noty.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/noty/layouts/top.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/noty/layouts/center.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/noty/themes/default.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/html2canvas.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/html2canvas.svg.js' />"></script>
            <!--tooltip-->
            <link href="<c:url value='resources/js/css/start/jquery-ui-1.10.3.custom.css' />" rel="stylesheet"/>
	
            <script src="<c:url value='resources/js/js/jquery-ui-1.10.3.custom.js' />"></script>
             <link rel="stylesheet" href="<c:url value="/menu/ovc lip user menu_files/css3menu1/style.css" />" /> 
       
            
        <script src="<c:url value="/resources/js/cufon-yui.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/ChunkFive_400.font.js" />" type="text/javascript"></script>
	
        <style>
            
            td {
                width:100%;
                white-space: nowrap; 
                
                
                border-color: #fff #fff #e8e8e8 #e8e8e8;
                border-left: 1px solid #e8e8e8;
                border-right: 1px solid #fff;
                border-style: solid;
                border-width: 1px;
                padding: 2px 5px;
                position: relative;
                transition: all 300ms ease 0s;
            }
            
            th {
                
                background-color: #72ce3f;
                background-image: linear-gradient(#72ce3f, #62bc30);
                border-radius: 3px;
                box-shadow: 0 1px 0 rgba(255, 255, 255, 0.5), 0 2px 0 rgba(0, 0, 0, 0.7);
                color: #fff;
                white-space: nowrap; 
                font: bold 14px Arial,Helvetica;
                position: relative;
                text-decoration: none;
                text-shadow: 0 1px 0 rgba(0, 0, 0, 0.3);
                text-transform: uppercase;
              padding: 8px 8px;
            }
            
            table {
                
                border:1px solid  #62bc30;
            }
        </style>  
        
        <script type="text/javascript">
			Cufon.replace('h1',{textShadow: '1px 1px #fff'});
			Cufon.replace('h2',{textShadow: '1px 1px #fff'});
			Cufon.replace('h3',{textShadow: '1px 1px #000'});
			Cufon.replace('.back');
   
    
     function loadcbos()
            {
                      // var cboname=document.getElementById("lip").value;
            
        var year=document.getElementById("year").value;
        
         $.ajax({
                    url: "loadrreportcbos?year="+year,
                    type: 'post',
                    dataType: 'html',
                    success: function (data) {
                     document.getElementById("staffcbo").innerHTML=data;     
                        
                    }
                });
        

            }
    
    
                   
    
    
    
                         function loadsites()
            {
                       var cboname=document.getElementById("staffcbo").value;
                         var year=document.getElementById("year").value;
                         var period=document.getElementById("period").value;
         $.ajax({
                    url: "loadreportsites?cbo="+cboname+"&year="+year+"&period="+period,
                    type: 'post',
                    dataType: 'html',
                    success: function (data) {
                        
                    document.getElementById("sitecbo").innerHTML=data;    
                        
                    }
                });
        

            }

              
    function changeAction() {

                var curaction = document.getElementById("reporttype").value;

                document.getElementById("formid").action = curaction;


            }
    
                        
		</script>
    </head>
    <body >
        
           <%
                            if (session.getAttribute("error_login") != null)  { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("error_login")%>',
                        layout: 'center',
                        type: 'Error', 
                         timeout: 1800});
                    
                </script> <%
                
                session.removeAttribute("error_login");
                            }

                        %>
        
        
        <div class="cont">
                
<div class="header" style="margin-left: 10%;margin-right: 2px;">
    <br/>
            <% if(session.getAttribute("level")!=null){
                         if(session.getAttribute("level").equals("2")){ 
            %>
<%@include file="../../menu/ovc lip user menu.html"%>

<%} else{%>
<%@include file="../../menu/ovc lip user menu.html"%>
<%}}%>                  
</div>
		<div class="wrapper" >
                  
			<h2 style="text-align: center;"><span>OVC LIP SUPERVISION COUNTY REPORT </span></h2>
			<br/>
			<br/>
			<div class="content">
				<div id="form_wrapper" class="form_wrapper" style="display:none;">
					
					<form class="login active" action="countyreport" id="formid" style="width:400px;">
						<h3>Start and End Date </h3>
				
                                        
                                        <div class="column">  
                                        
                                         
                                         <div>
  <label><b>(1) Start Date</b><font color="red">  *</font></label>
  <input type="text" style="width:280px;" readonly required class="form-control"  name="startdate" id="startdate" > 
                                        
                                        
                                                
                                        <label><b>(2) End Date</b><font color="red">  *</font></label>
                                        <input type="text" style="width:280px;" required class="form-control"  name="enddate" id="enddate" >
                                           <br/>
                                        </div> 
                                        
                                        
                                        
                                        </div>
                                        <div class="bottom">
							<!--<div class="remember"><input type="checkbox" /><span>Keep me logged in</span></div>-->
							<input type="submit" value="Generate"></input>
							<!--<a href="register.jsp.html" rel="register" class="linkform">You don't have an account yet? Register here</a>-->
							<div class="clear"></div>
						</div>
						
					</form>
					
				</div>
                          <div id="mydiv">
                              <h6 id="myx"></h6>
                              <h6 id="myy"></h6>
                            <table ><tr><th>Section</th><th>Domain</th><th>Overal Achievement</th><th>Column Chart</th></tr>
                            <tr><td rowspan="5">Data Management And Reporting Systems</td><td>Benefitiary Records</td><td>38</td><td rowspan="14"> <canvas id="myCanvas" width="200" height="400"></canvas></td></tr>
                            <tr><td>Data Analysis and Usage</td><td>50</td></tr>
                                <tr><td>Reporting Systems</td><td>68</td></tr>                               
                            <tr><td>Data Quality Assurance</td><td>50</td></tr>
                             <tr><td>SOPs/Guidelines</td><td>68</td></tr>
                            
                        
                             <tr><td rowspan="8">Program and technical Performance</td><td>Quality Improvement</td><td>50</td></tr>
                             <tr><td>Quality Improvement</td><td>50</td></tr>
                              <tr><td>Health and Nutrition </td><td>68</td></tr>
                             <tr><td>Protection Services</td><td>57</td></tr>
                             <tr><td>Education Services</td><td>70</td></tr>
                              <tr><td>Psychosocial Services </td><td>68</td></tr>
                               <tr><td>Economic Strengthening Services </td><td>68</td></tr>
                                <tr><td>Supporting Role of Community Volunteers</td><td>68</td></tr>
                             <tr><td colspan='2'>Average</td><td>70</td></tr></table>
                            </div>
                            <div class="clear"></div>
                            <br/>
                            <br/>
                                            
				<div class="clear"></div>
			</div>
                             <br/>
                             <br/>
                             
      <div id="results"></div>
                          
				</div>
		

		<!-- The JavaScript -->
		<!--<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>-->
		<script type="text/javascript">
			$(function() {
					//the form wrapper (includes all forms)
				var $form_wrapper	= $('#form_wrapper'),
					//the current form is the one with class active
					$currentForm	= $form_wrapper.children('form.active'),
					//the change form links
					$linkform		= $form_wrapper.find('.linkform');
						
				//get width and height of each form and store them for later						
				$form_wrapper.children('form').each(function(i){
					var $theForm	= $(this);
					//solve the inline display none problem when using fadeIn fadeOut
					if(!$theForm.hasClass('active'))
						$theForm.hide();
					$theForm.data({
						width	: $theForm.width(),
						height	: $theForm.height()
					});
				});
				
				//set width and height of wrapper (same of current form)
				setWrapperWidth();
				
				/*
				clicking a link (change form event) in the form
				makes the current form hide.
				The wrapper animates its width and height to the 
				width and height of the new current form.
				After the animation, the new form is shown
				*/
				$linkform.bind('click',function(e){
					var $link	= $(this);
					var target	= $link.attr('rel');
					$currentForm.fadeOut(400,function(){
						//remove class active from current form
						$currentForm.removeClass('active');
						//new current form
						$currentForm= $form_wrapper.children('form.'+target);
						//animate the wrapper
						$form_wrapper.stop()
									 .animate({
										width	: $currentForm.data('width') + 'px',
										height	: $currentForm.data('height') + 'px'
									 },500,function(){
										//new form gets class active
										$currentForm.addClass('active');
										//show the new form
										$currentForm.fadeIn(400);
									 });
					});
					e.preventDefault();
				});
				
				function setWrapperWidth(){
					$form_wrapper.css({
						width	: $currentForm.data('width') + 'px',
						height	: $currentForm.data('height') + 'px'
					});
				}
				
				/*
				for the demo we disabled the submit buttons
				if you submit the form, you need to check the 
				which form was submited, and give the class active 
				to the form you want to show
				*/
				$form_wrapper.find('input[type="submit"]')
							 .click(function(e){
								//e.preventDefault();
							 });	
			});
                             
    document.getElementById("formid").reset(); 
      $("#startdate").datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2015', dateFormat: 'yy-mm-dd', maxDate: new Date()});
      $("#enddate").datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2015', dateFormat: 'yy-mm-dd', maxDate: new Date()});
                  
        </script>
        
     
    
    
    <script>
        var canvas = document.getElementById("myCanvas");
function createchart(){


var ctx = canvas.getContext("2d");
var y=-27;
var x=0;

var height=23;
//the widths should be 14, organized per section


var widths = new Array("38", "50", "68","50","68","50","50","68","57","70","68","68","68","70"); 
var width=widths[0];
for( a=0;a<widths.length;a++){
    
  //alert(y); 
  if(a<5){
ctx.fillStyle = "#FF0000";
  }
  else {
     ctx.fillStyle = "#0000FF"; 
      
  }
ctx.fillRect(x,y,width,height);
 

y=y+28.8;

width=widths[a];

//draw rectangular graph
//ctx.fillStyle = "#000000";
ctx.fillRect(x,y,parseInt(widths[a])*2,height);
//ctx.fillRect(x,y,horizontal_width,vertical_height);
//writhe the name of the graph
ctx.font="10px Verdana";
ctx.fillText(widths[a],(parseInt(width)*2)+3,y+8);
//ctx.fillText("text",x,y);



}
}
createchart();
canvas.onmousemove = function(e) {

    var pos = getMousePos(this, e), /// provide this canvas and event
        x = pos.x,
        y = pos.y;

document.getElementById("myx").innerHTML=x;
document.getElementById("myy").innerHTML=y;

    /// check x and y against the grid
};


function getMousePos(canvas, e) {

    /// getBoundingClientRect is supported in most browsers and gives you
    /// the absolute geometry of an element
    var rect = canvas.getBoundingClientRect();

    /// as mouse event coords are relative to document you need to
    /// subtract the element's left and top position:
    return {x: e.clientX - rect.left, y: e.clientY - rect.top};
}



html2canvas($("#mydiv"),{ 
  onrendered: function(canvas) {
    var img = canvas.toDataURL();
           window.open(img);
  }
});


</script>

    
        </div>
    </body>
</html>