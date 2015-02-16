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
		<script type="text/javascript">
			Cufon.replace('h1',{textShadow: '1px 1px #fff'});
			Cufon.replace('h2',{textShadow: '1px 1px #fff'});
			Cufon.replace('h3',{textShadow: '1px 1px #000'});
			Cufon.replace('.back');
		</script>
    </head>
    <body>
		<div class="wrapper">
                  
			<h2 style="text-align: center;"><span>OVC LIP DATABASE CONFIGURATION</span></h2>
			<br/>
			<br/>
			<div class="content">
				<div id="form_wrapper" class="form_wrapper">
					
					<form class="login active" action="updatedbpword" method="POST" >
						<table style="width:390px;height:30px;"   cellpadding="8px" cellspacing="6px">
                        <tr>
                            <td style="text-align: right;">Host name:   <img src="resources/images/blguide.png" width="30px" title="enter the hostname followed by a ':' then port number e.g. localhost:3306. If there is no port number, just enter the host name alone e.g. localhost"/></td>
                            <td style="text-align: right">

                                <!--  username -->
                                <input id="hostname" type=text required name=hostname placeholder="e.g localhost:3306" value="localhost:3306" autofocus class="textbox"/></td>

                        </tr>
                        <tr> <td style="text-align: right;">Database : <img src="resources/images/blguide.png" width="30px" title="enter the database name e.g ovc_lip" /></td>
                            <td style="text-align: right;"><input id="database"  type=text required name=database value="ovc_lip" placeholder="e.g ovc_lip"  class="textbox"/></td>
                        </tr>

                        <tr> <td style="text-align: right;">User:   <img src="resources/images/blguide.png" width="30px" title="enter a database user name name e.g root"/></td>
                            <td style="text-align: right;"><input id="user"  type=text required name=user value="root" placeholder="e.g root"  class="textbox"/></td>
                        </tr>

                        <tr><td style="text-align: right;">Password:   <img src="resources/images/blguide.png" width="30px" title="enter the database password"/></td> 
                            <!--password-->
                            <td style="text-align: right;"><input id="dbpassword"  type=password  name=password placeholder="Password" class="textbox"></td>
                        </tr>
                        <tr>
                            <td style="text-align: right;"> </td>
                            <td style="text-align: center;">

                            </td>
                        </tr>
                    </table>
						
						<div class="bottom" style="width:400px;">
							
						<input type="submit"  value="Save"/>	
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
						width	: '400px',
						height	: '350px'
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
        </script>
    </body>
</html>