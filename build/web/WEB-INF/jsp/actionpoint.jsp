

<%@page import="database.dbConn"%>
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


        <!-------------------------------------------------------------------------------->
        <!-------------------------------------------------------------------------------->

        <link rel="stylesheet" href="<c:url value='/resources/css/font-awesome.min.css' />"  />
        <link type="text/css" rel="stylesheet"  href="<c:url value='/resources/css/style.css' />"  />
        <!-------------------------------------------------------------------------------->
        <!-------------------------------------------------------------------------------->

        <link rel="shortcut icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon"/>
        <title>Data Entry Form</title> 


    </head>
    <body>






        <div class="theme-changer">
            <div class="theme-inner">
                
                <div class="btn-group-vertical">
                    <br/>
                    <!--                    <a  href="dataentry.htm?t=sea" class="bt-sea btn btn-default">DeepSea</a>
                                            <a  href="dataentry.htm?t=sky" class="bt-sky btn btn-default">NightSky</a>
                                            <a  href="dataentry.htm?t=simple" class="bt-simple btn btn-default">Simple</a>
                                            <a  href="dataentry.htm?t=circle" class="bt-circle btn btn-default">Circle</a>-->
                   <% if(session.getAttribute("level") != null) {
                        if (session.getAttribute("level").equals("1")) {
                %>
                    <a id="modal_trigger1" style="color:red;background-color: white;" href="#sitemodal" class="btn"><img src="<c:url value="/resources/images/add.gif" />" />Add Designation</a>
                    <a id="d_trigger1" style="color:red;background-color: white;" href="#sitemodal" class="btn"><img src="<c:url value="/resources/images/add.gif" />" />Add Designation</a>
                    <a id="coutertotal" style="color:red;background-color: white;" href="#" class="btn"><h3><b>3</b> Rows</h3></a>
                <%}}%>
                </div>
            </div>
        </div>
        <style>
            .theme-changer {
                position: fixed;
                z-index: 9999;
                top: 55px;;
                left: 0;;
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





        <div class="cont" style="width:1420px;">    
            <div style="font-size: 17px; margin-left: 10%;">

                <% if (session.getAttribute("level") != null) {
                        if (session.getAttribute("level").equals("2")) {
                %>
                <%@include file="../../menu/ovc lip user menu.html"%>

                <%} else {%>
                <%@include file="../../menu/ovc lip user menu.html"%>
                <%}
    }%>

            </div>

            
            <div class="container" id="container1">


                <h4 style="text-align: center;background: orange;">DQA Action Point</h4>


                <div class="body-content">





                </div>
            </div>









            <footer class="footer">
                <div class="container">

                    <img src="<c:url value="/resources/images/loading.gif" />" class="loading" style="display:none;" /> 

                    <img src="<c:url value="/resources/images/wait2.gif" />" class="loading1" style="display:none;" /> 

                    
                    <div class="row" id="rw">
                        <div class="col-md-12">


                            <form id="wizard-example-5" action="" data-parsley-validate>
                                <fieldset>
                                    <legend id="ab"></legend>
                                    <div class="row">
                                      </div>
                                </fieldset>
                              </form>
                        </div>
                    </div>

<%

                dbConn conn= new dbConn();
                String getcategories="select * from staff_roles ";
               String opts="<option value=''>select category</option>";
               String cbolists="<option value=''>select cbo</option>";
conn.rs=conn.st.executeQuery(getcategories);
while(conn.rs.next()){

opts+="<option value='"+conn.rs.getString(1)+"'>"+conn.rs.getString(2)+"</option>";

}

String getcbo="select * from cbo";
conn.rs1=conn.st1.executeQuery(getcbo);
while(conn.rs1.next()){
cbolists+="<option value='"+conn.rs1.getString(1)+"'>"+conn.rs1.getString(2)+"</option>";

}


%>


                   

                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                        <div id="sitemodal" class="popupContainer" style="display:none;width:500px;">
                        <header class="popupHeader">
                          
                            <span class="header_title">Add A Designation </span>
                            <span class="modal_close"><img src="<c:url value="/resources/images/close.png" />" width="24px"></i></span>
                        </header>

                        <section class="popupBody" style="width:550px;">
                            <div class="add_staff">
                                <form name="adddesination" id="adddesination" action='saveDesignation' style="width:350px;">
                                    
       
                                    
                                    
                                    <table>
                                        
                                        <tr><td>Designation</td><td><input class="form-control" type="text" id="designation" name="designation"></td></td>
                                       <tr><td>  <input type="reset" style="height:36px;width:100px;" value="reset fields"></td><td >
                                            
                                        <input type="text" value="Save" id="generate1" class ='generate1' onclick="savesite();" readonly style=" cursor:pointer;margin-left: 50px; text-transform:uppercase ; height: 50px; width:140px;text-align:center ; color:white ;background:coral; border-style:ridge ;" />
                        
                                                        
                                            </td><td><p id="msg"></p></td></tr>
                                    </table>   


                                </form>
                            </div>
                        </section>
                    </div>
                                        
                                        
                   <div id="rowsmodal" class="popupContainer" style="display:none;width:500px;">
                        <header class="popupHeader">
                          
                            <span class="header_title">Enter Number of Rows To Add</span>
                            <span class="submitrows"><img src="<c:url value="/resources/images/close.png" />" width="24px"></i></span>
                        </header>

                        <section class="popupBody" style="width:550px;">
                            <div class="add_staff">
                                <form name="addrowsform" id="addrowsform" action='#' style="width:350px;">
                                    
       
                                    
                                    
                                    <table>
                                        
                                        <tr><td>No of Rows</td><td><input class="form-control" type="text" id="custrows" name="custrows"></td></td>
                                       <tr><td>  </td><td >
                                            
                                        <input type="text" value="ADD" id="submitrows" class ='submitrows' onclick="customrows();" readonly style=" cursor:pointer;margin-left: 50px; text-transform:uppercase ; height: 50px; width:140px;text-align:center ; color:white ;background:coral; border-style:ridge ;" />
                        
                                                        
                                            </td><td><p id="msg"></p></td></tr>
                                    </table>   


                                </form>
                            </div>
                        </section>
                    </div>                      
                                        
                      
                        
                            <div id="delrowsmodal" class="popupContainer" style="display:none;width:500px;">
                        <header class="popupHeader">
                          
                            <span class="header_title">Enter Number of Rows To Delete</span>
                            <span class="submitrows1"><img src="<c:url value="/resources/images/close.png" />" width="24px"></i></span>
                        </header>

                        <section class="popupBody" style="width:550px;">
                            <div class="add_staff">
                                <form name="delrowsform" id="delrowsform" action='#' style="width:350px;">
                                    
       
                                    
                                    
                                    <table>
                                        
                                        <tr><td>No of Rows</td><td><input class="form-control" type="text" id="delcustrows" name="delcustrows"></td></td>
                                       <tr><td>  </td><td >
                                            
                                        <input type="text" value="DELETE" id="submitrows1" class ='submitrows1' onclick="delcustomrows();" readonly style=" cursor:pointer;margin-left: 50px; text-transform:uppercase ; height: 50px; width:140px;text-align:center ; color:white ;background:coral; border-style:ridge ;" />
                        
                                                        
                                            </td><td><p id="msg"></p></td></tr>
                                    </table>   


                                </form>
                            </div>
                        </section>
                    </div> 
                        
                        
                                        
                </div>
            </footer>


            <script type="text/javascript" src='<c:url value="/resources/js/jquery-1.9.1.js" />'></script>
            <script type="text/javascript" src="<c:url value='/resources/js/all-1424208788.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/bootstrap.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/parsley.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/js/jquery-ui-1.10.3.custom.js' />" /></script>
            <!--<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>-->
            <script type="text/javascript" src="<c:url value='/resources/js/jquery.leanModal.min.js' />" ></script>

            
            <script type="text/javascript" src="<c:url value='/resources/js/noty/jquery.noty.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/noty/layouts/top.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/noty/layouts/center.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/noty/themes/default.js' />"></script>
            
            
            
            
        <script>
            //$(window).load(function(){
            //    
            //});
 var rfr=null;
            $(function () {

                $('.loading').show();
                $.ajax({
                    url: 'loaddqaform',
                    type: 'post',
                    dataType: 'html',
                    success: function (data) {
                    document.getElementById("wizard-example-5").innerHTML = data;
                      rfr=  $("#wizard-example-5").stepFormWizard({
                            height: 'auto',
                            theme:'sky',
                            nextBtn: $('<a class="next-btn sf-right sf-btn" href="#">NEXT</a>'),
                            prevBtn: $('<a class="prev-btn sf-left sf-btn" href="#">PREVIOUS</a>'),
                            finishBtn: $('<a class="finish-btn sf-right sf-btn" href="#">SAVE</a>'),
            onNext: function(i, wizard) {
            return $('form', wizard).parsley().validate('block' + i);
                                        },                
            onFinish: function (i, wizard) {
                                if ($('form', wizard).parsley().validate() == true) {
                                    var form = $('form', wizard).serialize();
           //$.getJSON('savedata', form, function (data) {wizard.html(data.html);});
                                    $('.loading1').show();
                                   //__________________________________________
                                   
                                   $.ajax({
  type: 'POST',
  url: 'saveactionpoint',
  data:form,
  dataType: 'text',
  success: function(data) {
      
       $('.loading1').hide();
    //alert(data);
              var n = noty({text:"<h3>"+data+"</h3>",
                        layout: 'center',
                        type: 'Success',
                        timeout: 2800,
         animation: {
        open: {height: 'toggle'}, // jQuery animate function property object
        close: {height: 'toggle'}, // jQuery animate function property object
        easing: 'swing', // easing
        speed: 500 // opening & closing animation speed
    },
    callback: {
   
        afterShow: function() {
            location.reload();
            
        }
    }
    
        }); 
    
  },
  error: function() {
    alert('Error occured');
  }
});
                                   //__________________________________________
                                   
            //return true;
                                }
                                else {
                                    return false;
                                }
                            }




                        });
//have a loop that creates many date pickers using a loop
 $("#modal_trigger").leanModal({top: 200, overlay: 0.6, closeButton: ".submitrows"});
 $("#delrows_trigger").leanModal({top: 200, overlay: 0.6, closeButton: ".submitrows1"});

var ttl=document.getElementById("counter").value;
for ( a=1;a<=ttl;a++){
                        $("#fdate"+a).datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2015', dateFormat: 'yy-mm-dd', maxDate: new Date()});
                        $("#sdate"+a).datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2015', dateFormat: 'yy-mm-dd', maxDate: new Date()});
                        }
                        $('.loading').hide();
                    }

                });

            });


            //loaddata();


      function loaddes(rw){
          
          
        $.ajax({
                    url: "loaddesignation",
                    type: 'post',
                    dataType: 'html',
                    success: function (data) {
                        
                  document.getElementById("select"+rw).innerHTML=data;  
                        
                    }
                });
      }  
      
    function customrows(){
     var noofrows=document.getElementById("custrows").value;
     createrows(noofrows);
     document.getElementById("custrows").value="";   
    }
    
    function delcustomrows(){
     var noofrows=document.getElementById("delcustrows").value;
     deleteRow(noofrows);
     document.getElementById("delcustrows").value="";   
    }
    
  
  function createrows(num){
   for( a=0;a<num;a++){  
 var allrows=document.getElementById("counter").value;
allrows=parseInt(allrows)+1;
 var rws2=allrows;

   document.getElementById("counter").value=rws2;
document.getElementById("coutertotal").innerHTML="<h3><b>"+rws2+"</b> Rows</h3>";
var tbl = document.getElementById('actionpointtable');
var lastRow=tbl.rows.length;
//alert(lastRow);
var x=document.getElementById('actionpointtable').insertRow(lastRow);
//now insert columns

var y=x.insertCell(0);
var z=x.insertCell(1);
var v=x.insertCell(2);
var b=x.insertCell(3);
var c=x.insertCell(4);
//var m=x.insertCell(4);

loaddes(rws2);
y.innerHTML="<h3>"+rws2+"</h3>";
z.innerHTML="<div class='form-group'><Textarea rows='2' cols='30' class='form-control' name='actionid"+rws2+"' id='actionid"+rws2+"' ></TextArea></div>";
v.innerHTML="<div class='form-group'><select name='select"+rws2+"' class='form-control' id='select"+rws2+"'></select></div>";
b.innerHTML="<div class='form-group'><input class='form-control' type='text' id='fdate"+rws2+"' name='fdate"+rws2+"'></div>";
c.innerHTML="<div class='form-group'><input class='form-control' type='text' id='sdate"+rws2+"' name='sdate"+rws2+"'></div>";
   
        $("#fdate"+rws2).datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2015', dateFormat: 'yy-mm-dd', maxDate: new Date()});
        $("#sdate"+rws2).datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2015', dateFormat: 'yy-mm-dd', maxDate: new Date()});
                        
        }
   
rfr.refresh();
//var sfw = $("#wizard_example").stepFormWizard();
//sfw.refresh();
   //now call the wizard method again

      
  }
  //===================end of Adding Rows====================
    
    
    
    
    //delete rows
    function deleteRow(num)
{
    for( a=0;a<num;a++){
    var all_rows=document.getElementById("counter").value;
 
     if(all_rows==="1"){
     //dont delete   
    }
    else{
    var rws2=all_rows-1;
    if(rws2<0){
        //dont go beyond 0
       rws2=0 ;
    }
document.getElementById('actionpointtable').deleteRow(all_rows);
document.getElementById("counter").value=rws2;
document.getElementById("coutertotal").innerHTML="<h3><b>"+rws2+"</b> Rows</h3>";
}

}

rfr.refresh();
}
    
    
    
    function loadsites1(cboid)
            {
                       var cboname=document.getElementById("lip").value;
               
         $.ajax({
                    url: "loadsites?cbo="+cboname,
                    type: 'post',
                    dataType: 'html',
                    success: function (data) {
                        
                    document.getElementById("site").innerHTML=data;    
                        
                    }
                });
        

            }

            //=========ADDITION FUNCTIONS THAT SHOW THE PERCENTAGE PER DOMAIN
            var elementi = [];
            var elementivalues = [];
            
    //create a function to push elements only after loading an update form
    function pushelements(allele,allsubmitedvalue){
        
        elementi=allele.split("~");
        elementivalues=allsubmitedvalue.split("~");
        
      //elementi.push(ele);
                    //elementivalues.push(submitedvalue);  
        
    }        
   
            
  
//=====================================================================================
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//



//=====================================================================================
//
//
//
//
//
//
//
//
//
//
  
          


function disableurl(ids,val,domain){
 //val is the value of the selected element that controls the others
var res=ids.split("#"); 

var idnos=res[1].split("_");

 if(val.value==="Yes"){
  //enable the elements  
   for(a=0;a<idnos.length;a++){
   var curelem="element_"+idnos[a];
   var curcomment="comment"+idnos[a];
   document.getElementById(curelem).disabled =false;
   document.getElementById(curcomment).disabled =false;
   //make required false
     }
            
                      }
else if(val.value===res[0]){
    //if the set value is ano, then you have to disable this field
    //No
    
       for(a=0;a<idnos.length;a++){
   var curelem="element_"+idnos[a];
    var curcomment="comment"+idnos[a];

  //deduct a value from the domain if the values were yes
  
  if(document.getElementById(curelem).value==='Yes'){
      
      //i hope at this point a deduction will be done automatically because of changing the input field
     if(document.getElementById(curelem).value==="Yes"){
         document.getElementById(curelem).value="";
         $("#"+curelem).change();
         //JESUS YOU ARE MIGHTY.. THIS CODE WORKED , THATS WHY I LOVE YOU
         //I WILL PRAISE YOUR NAME FOREVER
                }
   document.getElementById(curcomment).value="";
                    //assuming the mark will be one
 //__________________________________________________________________________                   
 //__________________________________________________________________________                   
 //__________________________________________________________________________                   
 //__________________________________________________________________________                   
 //__________________________________________________________________________ 
 
  //staticdomaintotal('','element_'+idnos[a],'1',domain);
  //$("#element_"+idnos[a]).html();
  //HAPA KUNA SHIDA .. THIS PART SHOUD CHANGE
   //__________________________________________________________________________                   
 //__________________________________________________________________________                   
 //__________________________________________________________________________                   
 //__________________________________________________________________________                   
 //__________________________________________________________________________                   
  //staticdomaintotal('','element_'+idnos[a],'1',domain);
  
  }
   
  
   document.getElementById(curelem).disabled =true;
   document.getElementById(curcomment).disabled="disabled";
   //disable required status for the inpu field
   document.getElementById(curelem).required=false;
       //document.getElementById(curelem).removeAttribute("required");
                                 }
                          }
                          
     if(val.value===""){
    //enable the elements      
       for(a=0;a<idnos.length;a++){
   var curelem="element_"+idnos[a];
   var curcomment="comment"+idnos[a];
   document.getElementById(curelem).disabled =false;
   document.getElementById(curcomment).disabled =false;

   document.getElementById(curelem).required=true;
                                   }   
         
                        }
                        
                        
                        }
        </script>

  <script type="text/javascript" language="en">
   function numbers(evt){
var charCode=(evt.which) ? evt.which : event.keyCode
if(charCode > 31 && (charCode < 48 || charCode>57))
return false;
return true;
}
//-->
</script> 



        <script type="text/javascript">
            $("#modal_trigger1").leanModal({top: 200, overlay: 0.6, closeButton: ".modal_close"});
           
            //	$(function(){
            //		// Calling Login Form
            //		$("#login_form").click(function(){
            //			//$(".social_login").hide();
            //			$(".user_login").show();
            //			return false;
            //		});
            //
            //		
            //
            //	})
            
            
            function loadsites(){
                var cboname=document.getElementById("staffcbo").value;
               
         $.ajax({
                    url: "loadsites?cbo="+cboname,
                    type: 'post',
                    dataType: 'html',
                    success: function (data) {
                        
                    document.getElementById("sitecbo").innerHTML=data;    
                        
                    }
                });
        
                
            }
            
            function saveDesignation(){
                var designation=document.getElementById("designation").value;
               
                
                if(designation===''){
                  showerror(designation);  
                  noerror(designation);
                  showalert("Designation");
                             }
               
//                  else if(phone===''){
//                      
//                  showerror(phone);  
//                  noerror(phone);
//                  showalert("Phone Number");                    
//                    
//                                    }
                
//                 else if(site===''){                      
//                  showerror(site);  
//                  noerror(site);
//                  showselectalert("Site");                  
//                    
//                                    }
                                    else {
                                        
                                        
                                  $.ajax({
                    url: "saveDesignation?dis="+designation,
                    type: 'post',
                    dataType: 'html',
                    success: function (data) {
                        //now reload the staff list
                  //document.getElementById("msg").innerHTML=data;
                    var n = noty({text:"<h3>"+data+"</h3>",
                        layout: 'center',
                        type: 'Success',
                        timeout: 2800,
         animation: {
        open: {height: 'toggle'}, // jQuery animate function property object
        close: {height: 'toggle'}, // jQuery animate function property object
        easing: 'swing', // easing
        speed: 500 // opening & closing animation speed
    },
    callback: {
   
        afterShow: function() {
            
        // document.getElementById("addStaff").reset();   
        }
    }
    
        });
                  
                  //loadmembers();
                    
                
                        
                                          }
                                          });       
                                        
                                        
                                        
                                    }
                
            }
            
       
   
    
    
    
            
            function showerror(elem){
                
                        $("#"+elem).css("border-color","#FF0000");
                        $("#"+elem).css("background-color","#FFFFFF");             
                        $("#"+elem).slideToggle("slow",function() {});
                        $("#"+elem).slideToggle("slow",function() {});  
                                     }
            
             function noerror(elem){
                
                        $("#"+elem).css("border-color","#000000");
                        $("#"+elem).css("background-color","#FFFFFF");             
                                    }
                                    
             function showalert(name){
                 
                                   alert("Enter "+name);   
                                        
                                     }
                                    
           function showselectalert(name){
               
                                   alert("Enter "+name);     
                                         
                                         }
                                         
                                   
                                         
      //a function that checks whether entered data can be updated based on the date and site
                                         
        
      
    
    
    
    
    
    
    
    
    
    
    
    //function

    
    
 
        
    
$(document).keyup(function(event){

if((event.which== 13) && ($(event.target)[0]!=$("textarea")[0])) {
console.log("dont submit");
    }
    else{
    console.log("submit");
    }

});
    
   
    
 
    
    
    
        </script>




    </div>
</body>

</html>
