

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
                <div class="headtext">

                    AGGREGATE PERCENTAGE
                </div>
                <div class="btn-group-vertical">
                    <br/>
                    <!--                    <a  href="dataentry.htm?t=sea" class="bt-sea btn btn-default">DeepSea</a>
                                            <a  href="dataentry.htm?t=sky" class="bt-sky btn btn-default">NightSky</a>
                                            <a  href="dataentry.htm?t=simple" class="bt-simple btn btn-default">Simple</a>
                                            <a  href="dataentry.htm?t=circle" class="bt-circle btn btn-default">Circle</a>-->
                    <a style="background:#46b8da;" href="#" class="bt-circle btn btn-default"><span id="agg_percentage" style="font-size: 30px">0%</span></a>
                    <a id="modal_trigger" style="color:red;background-color: white;" href="#modal" class="btn"><img src="<c:url value="/resources/images/add.gif" />" /> Add Staff </a>
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

            <br/>
            <br/>
            <div class="container" id="container1">


                <h4 style="text-align: center;background: orange;">Data Entry</h4>


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


                    <div id="modal" class="popupContainer" style="display:none;width:500px;">
                        <header class="popupHeader">
                          
                            <span class="header_title">Add APHIAplus Staff </span>
                            <span class="modal_close"><img src="<c:url value="/resources/images/close.png" />" width="24px"></i></span>
                        </header>

                        <section class="popupBody" style="width:550px;">
                            <div class="add_staff">
                                <form name="addStaff" id="addStaff" action='saveStaff' style="width:350px;">
                                    <table>
                                        <tr><td>First Name</td><td><input class="form-control" type="text" id="fname" name="fname"></td></td>
                                        <tr><td>Last Name</td><td><input class="form-control" type="text" id="mname" name="mname"></td></td>
                                        <tr><td>Phone Number</td><td><input placeholder="optional" class="form-control" onkeypress=" return numbers(event);" type="text" id="phone" name="phone"></td></td>
                                        <tr><td><span id="catlabel">Category</td><td><select onchange="togglesites();" class="form-control" name="position" id="position"><%=opts%></select></td></td>
                                      
                                        <tr><td><span style="display:none;" id="cbolabel">Cbo</span></td><td><select style="display:none;" class="form-control" onchange="loadsites();"  name="staffcbo" id="staffcbo" ><%=cbolists%></select></td></td>
                                        <tr><td><span style="display:none;" id="sitelabel">Site</span></td><td><select style="display:none;" class="form-control" name="sitecbo" id="sitecbo"></select></td></td>
                                        <tr><td>  <input type="reset" style="height:36px;width:100px;" value="reset fields"></td><td >
                                            
                                        <input type="text" value="Save" id="generate1" class ='generate1' onclick="savestaff();" readonly style=" cursor:pointer;margin-left: 50px; text-transform:uppercase ; height: 50px; width:140px;text-align:center ; color:white ;background:coral; border-style:ridge ;" />
                        
                                                        
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

            $(function () {

                $('.loading').show();
                $.ajax({
                    url: 'loadform1',
                    type: 'post',
                    dataType: 'html',
                    success: function (data) {
                        document.getElementById("wizard-example-5").innerHTML = data;

                      var rfr=  $("#wizard-example-5").stepFormWizard({
                            height: '500px',
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
  url: 'savedata',
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

                        $("#ass_date").datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2015', dateFormat: 'yy-mm-dd', maxDate: new Date()});

                        $('.loading').hide();
                    }

                });

            });


            //loaddata();





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
    function N(num, places) { 
      return +(Math.round(num + "e+" + places)  + "e-" + places);
                       
                            }
            
            
            function domaintotal(val, ele, mark, domain) {
                //create two arrays. one to store sent elements and another to store the value.   
                //add the value together    
                var submitedvalue = val.value;
                var elementname = ele;
                var marks = N(mark,4);
                var domainid = domain;

                //alert(submitedvalue+" "+ele+" "+mark+" "+domain);
                //if value is a yes , then mark is +ve 1, 
                //if value is a no, a mark is -ve 1
                //if value is a blank, a mark is 0

                var markstosent = 0;
                if (submitedvalue ==='Yes') {

                    markstosent = "" + marks;
                }
                else if (submitedvalue ==='No') {

                    markstosent = "-" + marks;

                }
                else {
                    markstosent = "-" + marks;

                }


                //check the value that was previuosly added so as to know how to handle a case of editing
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                //if editing , then you need to load the 2 arrays here with values from the database per domain and question.

                //    ;) I just hope the array will be fast while searching

                if (elementi.indexOf(ele) === -1) {

           //alert(ele+"  just added now. It didnt exist");

                    // alert(elementi);


                    //alert(elementi.indexOf(ele));
                    elementi.push(ele);
                    elementivalues.push(submitedvalue);
                    //now call the functions that do the updating of the totals.
                    //nb Dont update the totals if the selected value is a No..
                    if (submitedvalue === 'Yes') {
                        domainsum(markstosent, domainid);
                        //totalsum(markstosent);
                    }



                }
                else {
                    
                   //  alert(ele+"  existed. Its being edited");
                    
                    //get the index of the element, then update the value that was there previously...  
                    var pos = elementi.indexOf(ele);
                    //if the current option/value and the previous one are differing, then do a subtraction

                    if (elementivalues[pos] === submitedvalue || (elementivalues[pos] === "" && submitedvalue === "No") || (elementivalues[pos] === "No" && submitedvalue === "")) {
                        //then dont do anything
//alert("No change::: existing value "+elementivalues[pos]+" __ while __ "+submitedvalue);
                    }
                    else {
                        
                        //alert("There is change::: existing value "+elementivalues[pos]+" __ and new value is__ "+submitedvalue);
                        //replace with new value
                        elementivalues[pos] = submitedvalue;
                        //expect a change in here
                        domainsum(markstosent, domainid);
                        //totalsum(markstosent);
                    }

                }





            }

//=====================================================================================
//
//
  function staticdomaintotal(val, ele, mark, domain) {
                //create two arrays. one to store sent elements and another to store the value.   
                //add the value together    
                var submitedvalue = val;
                var elementname = ele;
               var marks = N(mark,4);
                var domainid =domain;

                //alert(submitedvalue+" "+ele+" "+mark+" "+domain);
                //if value is a yes , then mark is +ve 1, 
                //if value is a no, a mark is -ve 1
                //if value is a blank, a mark is 0

                var markstosent = 0;
                if (submitedvalue === 'Yes') {

                    markstosent = "" + marks;
                }
                else if (submitedvalue === 'No') {

                    markstosent = "-" + marks;

                }
                else {
                    markstosent = "-" + marks;

                }


                //check the value that was previuosly added so as to know how to handle a case of editing
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                //if editing , then you need to load the 2 arrays here with values from the database per domain and question.

                //    ;) I just hope the array will be fast while searching

                if (elementi.indexOf(ele)=== -1) {



                    


                    //alert(elementi.indexOf(ele));
                    elementi.push(ele);
                    elementivalues.push(submitedvalue);
                    //now call the functions that do the updating of the totals.
                    //nb Dont update the totals if the selected value is a No..
                    if (submitedvalue === 'Yes') {
                        domainsum(markstosent, domainid);
                       // totalsum(markstosent);
                    }



                }
                else {
                    
                      
                    //get the index of the element, then update the value that was there previously...  
                    var pos = elementi.indexOf(ele);
                    //if the current option/value and the previous one are differing, then do a subtraction

                    if (elementivalues[pos] === submitedvalue || (elementivalues[pos] === "" && submitedvalue === "No") || (elementivalues[pos] === "No" && submitedvalue === "")) {
                        //then dont do anything

                    }
                    else {
                        //replace with new value
                        elementivalues[pos] = submitedvalue;
                        //expect a change in here
                        domainsum(markstosent, domainid);
                        //totalsum(markstosent);
                    }

                }





            }
//
//
//
//=====================================================================================

            function domainsum(marks, doma) {
                
                var newvalue = marks;
                var curvalue = document.getElementById("domaininput" + doma).value;
                if (curvalue === '') {

                    curvalue = 0;

                }
                //alert(newvalue+" "+curvalue)
                var ttl = parseFloat(newvalue) + parseFloat(curvalue);
               // alert(newvalue+" "+curvalue+" = "+ttl);
                //set the input text value and the display purpose variable too.                
                document.getElementById("domaininput" + doma).value = N(ttl,4);
                
                
                var percttl=ttl*100;
                percttl=N(percttl,0);
                document.getElementById("domain" + doma).innerHTML = percttl + "%";
                    totalsum();

                                           }



//            function totalsum(marks) {
//                var newvalue = marks;
//                var curvalue = document.getElementById("totalsum").value;
//                if (curvalue === '') {
//
//                    curvalue = 0;
//
//                }
//                var ttl = parseFloat(newvalue) + parseFloat(curvalue);
//                  document.getElementById("totalsum").value = ttl;
//                var perct=ttl*100;
//                perct=N(perct,0);
//                perct=perct/12;
//              perct=N(perct,0)
//                document.getElementById("agg_percentage").innerHTML = perct + "%";
//
//            }
function totalsum(){
    var ttl=0;
    for (d=1;d<=12;d++){
      var nv=document.getElementById("domaininput" + d).value.trim();
      
     if(nv!==""){
         ttl=parseFloat(ttl)+parseFloat(nv);
           }   
       
    }
     //now devide by 12
        ttl=ttl/12;
        ttl=ttl*100;
        
       
  document.getElementById("totalsum").value = ttl;
  //round off to one decimal place
  ttl=N(ttl,1);
  
  document.getElementById("agg_percentage").innerHTML =ttl + "%";
    
}

function disableurl(ids,val,domain){
 
var res=ids.split("#"); 

var idnos=res[1].split("_");

 if(val.value==="Yes"){
  //enable the elements  
   for(a=0;a<idnos.length;a++){
   var curelem="element_"+idnos[a];
   
   document.getElementById(curelem).disabled =false;
   
     }
            
                      }
else if(val.value===res[0]){
    //No
    
       for(a=0;a<idnos.length;a++){
   var curelem="element_"+idnos[a];
   

  //deduct a value from the domain if the values were yes
  
  if(document.getElementById(curelem).value==='Yes'){
     
                    //assuming the mark will be one
                    
  staticdomaintotal('','element_'+idnos[a],'1',domain);
  }
   document.getElementById(curelem).value="";
  
   document.getElementById(curelem).disabled =true;
   
                                 }
                          }
                          
     if(val.value===""){
    //enable the elements      
       for(a=0;a<idnos.length;a++){
   var curelem="element_"+idnos[a];
   document.getElementById(curelem).disabled =true;
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
            $("#modal_trigger").leanModal({top: 200, overlay: 0.6, closeButton: ".modal_close"});

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
            
            function savestaff(){
                var fname=document.getElementById("fname").value;
                var mname=document.getElementById("mname").value;
                var phone=document.getElementById("phone").value;
                var site=document.getElementById("sitecbo").value;
                
                if(fname===''){
                  showerror(fname);  
                  noerror(fname);
                  showalert("first name");
                             }
                else if(mname===''){
                    showerror(mname);  
                  noerror(mname);
                  showalert("Last name");                    
                    
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
                    url: "saveStaff?fname="+fname+"&mname="+mname+"&phone="+phone+"&category="+site,
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
            
         document.getElementById("addStaff").reset();   
        }
    }
    
        });
                  
                  loadmembers();
                    
                
                        
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
                                         
                                         function loadmembers(){
                                             
                                          $.ajax({
                    url: "loadStaff",
                    type: 'post',
                    dataType: 'html',
                    success: function (data) {
                        
                        //document.getElementById("staffpresent").innerHTML=data;
                        document.getElementById("teammembers").innerHTML=data;
                        document.getElementById("teamleader").innerHTML=data;
                     
                        
                    }});   
                                             
                                             
                                         }
                                         
      //a function that checks whether entered data can be updated based on the date and site
                                         
         function checkupdate(){
         
             var dat=document.getElementById("ass_date").value;
             var site=document.getElementById("site").value;
             var quarters="";
             var year="";
             var cbo=document.getElementById("lip").value;
             if(site!==""&&dat!==""){
            var fulldates=dat.split("-");
                
if(fulldates[1]==="10"||fulldates[1]==="11"||fulldates[1]==="12"){ quarters="1";}
else if(fulldates[1]==="01"||fulldates[1]==="02"||fulldates[1]==="03"){ quarters="2";}
else if(fulldates[1]==="04"||fulldates[1]==="05"||fulldates[1]==="06"){ quarters="3";}
else if(fulldates[1]==="07"||fulldates[1]==="08"||fulldates[1]==="09"){ quarters="4";}
else{quarters="0";}
year=fulldates[0];
//now call an ajax function whose return
                 $.ajax({
                    url: "isupdatable?site="+site+"&period="+quarters+"&year="+year,
                    type: 'post',
                    dataType: 'text',
                    success: function (data) {
                     var da=data.trim();   
                     if(da==="update"){
                       
                    loadupdateform(site,quarters,year,cbo); 
                     }  
                     else
                     {
                         
                         
                     }
                        
                        
                    }
            
        });

                 
             }
         }
             
      
    
    
    
    
    
    
    
    
    
    
    
    //function
    
    function loadupdateform(site,quarters,year,cbo){
        
          
                         //initialize an update ajax to load data for that element
                       // alert("load existing data asap");
                       $('.loading').show(); 
                        
            $.ajax({
                    url: "loadformdata?site="+site+"&period="+quarters+"&year="+year+"&cbo="+cbo,
                    type: 'post',
                    dataType: 'text',
                    success: function (data) {
                      //document.getElementsByClassName("sf-wizard").innerHTML=""; 
                     $('#rw').html("<div class='col-md-12'><form id='wizard-example-5' action=''><fieldset><legend id='ab'></legend><div class='row'></div></fieldset></form></div>");
                    // $("#container1").load(
                      document.getElementById("wizard-example-5").innerHTML=data; 
                      document.getElementById("agg_percentage").innerHTML=document.getElementById("totalsum").value+"%";
                     //variables that help in preloading
                      var alle=document.getElementById("allelements").value;
                      var alleval=document.getElementById("allelementsvalue").value;
                      pushelements(alle,alleval);
                      //alert(alle);
                      
                      
                       $("#wizard-example-5").stepFormWizard({
                            height: '500px',
                            theme:'sky',
                            nextBtn: $('<a class="next-btn sf-right sf-btn" href="#">NEXT</a>'),
                            prevBtn: $('<a class="prev-btn sf-left sf-btn" href="#">PREVIOUS</a>'),
                            finishBtn: $('<a class="finish-btn sf-right sf-btn" href="#">UPDATE</a>'),
                            onFinish: function (i, wizard) {
                                if ($('form', wizard).parsley().validate() == true) {
                                    var form = $('form', wizard).serialize();
                                    
                                   // $.getJSON('updatedata', form, function (data) {wizard.html(data.html);});
                                    
                                    
                                    
                                    
           //=================================================================================
           
            
            $('.loading1').show();
                                   //__________________________________________
                                   
                                   $.ajax({
  type: 'POST',
  url: 'updatedata',
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
                                   
            
            
           //=================================================================================                         
                                    
                                    
                                    
                                }
                                else {
                                    return false;
                                }
                            },
                            onNext: function (i, wizard) {
                                return $('form', wizard).parsley().validate('block' + i);
                            }




                        });

                        $("#ass_date").datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2015', dateFormat: 'yy-mm-dd', maxDate: new Date()});

                        $('.loading').hide();
                      
                       
                        
                    }         
            
            });
        
        
    }
    
    
    function togglesites(){
        
         if(document.getElementById("position").value=='2'){
             
             document.getElementById("cbolabel").innerHTML='Cbo';
             document.getElementById("staffcbo").style.display='block';
             
             document.getElementById("sitelabel").innerHTML='Site';
             document.getElementById("sitecbo").style.display='block';
             
         }
         else{
             document.getElementById("staffcbo").value="";
             document.getElementById("cbolabel").innerHTML='';
             document.getElementById("staffcbo").style.display='none';
             
             document.getElementById("sitelabel").innerHTML='';
             document.getElementById("staffcbo").value="";
             document.getElementById("sitecbo").style.display='none';
             
         }
        
        
        
        
    }
        
    
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
