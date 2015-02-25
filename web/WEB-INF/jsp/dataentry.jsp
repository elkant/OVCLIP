<%-- 
    Document   : dataentry
    Created on : Feb 22, 2015, 4:01:51 PM
    Author     : MANUEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/all-1424208788.css' />" />
        <link rel="stylesheet" type="text/css" href="<c:url value='/menu/ovc lip user menu_files/css3menu1/style.css' />" /> 
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/css/start/jquery-ui-1.10.3.custom.css' />" />
      
        
<!--         <link href="js/css/blitzer/jquery-ui-1.10.4.custom.css" rel="stylesheet"/>
        <script src="js/js/jquery-ui-1.10.4.custom.js"></script>-->
        
        <link rel="shortcut icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon"/>
        <title>Dat Entry Form</title> 
 

    </head>
    <body>
        <div style="margin-left:270px;font-size: 17px;">
        
                     <% if(session.getAttribute("level")!=null){
                         if(session.getAttribute("level").equals("2")){ 
            %>
<%@include file="../../menu/ovc lip user menu.html"%>

<%} else{%>
<%@include file="../../menu/ovc lip user menu.html"%>
<%}}%>
                    
</div>

                  <br/>
                   <br/>
        <div class="container">
            
      
			<h4 style="text-align: center;background: orange;">Data Entry</h4>
                       
            <div class="theme-changer">
                <div class="theme-inner">
                    <div class="headtext">
                         
                        THEMES
                    </div>
                    <div class="btn-group-vertical">
                        <a  href="dataentry.htm?t=sea" class="bt-sea btn btn-default">DeepSea</a>
                        <a  href="dataentry.htm?t=sky" class="bt-sky btn btn-default">NightSky</a>
                        <a  href="dataentry.htm?t=simple" class="bt-simple btn btn-default">Simple</a>
                        <a  href="dataentry.htm?t=circle" class="bt-circle btn btn-default">Circle</a>
                    </div>
                </div>
            </div>
        <style>
                .theme-changer {
                    position: fixed;
                    z-index: 9999;
                    top: 55px;;
                    right: 0;;
                }
                .theme-changer .headtext {
                    font-size: 14px;
                    font-weight: 700;
                    color: #959595;
                    text-transform: uppercase;
                    letter-spacing: 1px;
                    padding: 20px 0 15px 0;
                    text-align: center;;
                    background: rgba(255,255,255,0.5);
                }
            
            </style>   

            <div class="body-content">





            </div>
        </div>




    </div>




    <footer class="footer">
        <div class="container">

    <img src="<c:url value="/resources/images/loading.gif" />" class="loading" style="display:none;" /> 

<div class="row">
    <div class="col-md-12">
       
        
        <form id="wizard-example-5" action="#">
            <fieldset>
                <legend id="ab"></legend>
                <div class="row">
                    
               
                   
                </div>
            </fieldset>
            
           
        </form>
    </div>
</div>



        </div>
    </footer>


    <script type="text/javascript" src='<c:url value="/resources/js/jquery-1.9.1.js" />'></script>
    <script type="text/javascript" src="<c:url value='/resources/js/all-1424208788.js' />"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/bootstrap.js' />"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/js/jquery-ui-1.10.3.custom.js' />" /></script>
<script>
//$(window).load(function(){
//    
//});

$(function () {
    
    $('.loading').show();
    $.ajax({
                    url:'loadform1',                         
                    type:'post',  
                    dataType: 'html',  
                    success: function(data) {
                       document.getElementById("wizard-example-5").innerHTML=data; 
                       
                       $("#wizard-example-5").stepFormWizard({      
        
    height: 'auto',
    nextBtn: $('<a class="next-btn sf-right sf-btn" href="#">FORWARD</a>'),
    prevBtn: $('<a class="prev-btn sf-left sf-btn" href="#">BACK</a>'),
    finishBtn: $('<a class="finish-btn sf-right sf-btn" href="#">DONE</a>'),
    onFinish: function(i, wizard) {
        if($('form', wizard).parsley().validate()==true){
        var form = $('form', wizard).serialize();
        $.getJSON('savedata', form, function(data) {
            wizard.html(data.html);
        });}
    else{
        return false;
    }
    },
        
        onNext: function(i, wizard) {
            return $('form', wizard).parsley().validate('block' + i);
        }
        
        
        
        
    });

                     $("#ass_date").datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2015', dateFormat: 'dd-M-yy',maxDate: new Date()});
     
                        $('.loading').hide();
                                            }
                        
        });

});


//loaddata();

</script>
</body>

</html>
