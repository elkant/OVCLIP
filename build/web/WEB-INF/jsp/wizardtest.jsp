<%-- 
    Document   : wizardtest
    Created on : Feb 20, 2015, 1:09:35 PM
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
        
      
      
   
<!------------------------------------------------------------------------------------------------->
<!------------------------------------------------------------------------------------------------->
<!------------------------------------------------------------------------------------------------->
<!------------------------------------------------------------------------------------------------->
<!------------------------------------------------------------------------------------------------->
<!------------------------------------------------------------------------------------------------->
<!------------------------------------------------------------------------------------------------->

	<title>Dat Entry Form</title>
	<meta name="csrf-param" content="_csrf">
<!--<meta name="csrf-token" content="Y0J5Ni5HZ0kINB4bdhcrJQ8sCGB.cBEsWi1NAWEjDwc1CBJkWHRTFg==">-->
<!--<link href="css/all-1424208788.css" rel="stylesheet">-->
<!--<script type="text/javascript">var yii_site_finis_url = 'getFinish.html';</script>-->	
	
</head>
<body>
	<div class="container">
				<div class="theme-changer">
    <div class="theme-inner">
        <div class="headtext">
            THEMES
        </div>
        <div class="btn-group-vertical">
            <a  href="wizardtest.htm?t=sea" class="bt-sea btn btn-default">DeepSea</a>
            <a  href="wizardtest.htm?t=sky" class="bt-sky btn btn-default">NightSky</a>
            <a  href="wizardtest.htm?t=simple" class="bt-simple btn btn-default">Simple</a>
            <a  href="wizardtest.htm?t=circle" class="bt-circle btn btn-default">Circle</a>
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
<div class="site-index">

	

	<div class="body-content">

        


        

        
<div class="row">
    <div class="col-md-12">
        <h2>Custom buttons, flexibile height and Ajax request after done</h2>
        <form id="wizard_example_4" action="#">
            <fieldset>
                <legend>Basic information</legend>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email address</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password again</label>
                            <input type="password" class="form-control" id="exampleInputPasswordAgain1" placeholder="Password">
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="exampleInputPassword1">Favorite number</label>
                            <select class="form-control">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Own animals</label>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Goat
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Cow
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Rooster
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Crocodile
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        In publishing and graphic design, lorem ipsum is common placeholder text used to demonstrate the graphic elements of a document or visual presentation, such as web pages, typography, and graphical layout. It is a form of "greeking".
                    </div>
                </div>
            </fieldset>
            <fieldset>
                <legend>Condition</legend>
                In publishing and graphic design, lorem ipsum is common placeholder text used to demonstrate the graphic elements of a document or visual presentation, such as web pages, typography, and graphical layout. It is a form of "greeking".
                Even though using "lorem ipsum" often arouses curiosity due to its resemblance to classical Latin, it is not intended to have meaning. Where text is visible in a document, people tend to focus on the textual content rather than upon overall presentation, so publishers use lorem ipsum when displaying a typeface or design in order to direct the focus to presentation. "Lorem ipsum" also approximates a typical distribution of letters in English.
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" value="option1" checked>
                        Yes, it is totaly right.
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" value="option2">
                        No, I check it twice and it is not right.
                    </label>
                </div>
            </fieldset>
            <fieldset>
                <legend>Final step</legend>
                <div class="row">
                    <div class="col-lg-12">
                        <p>
                            Even though using "lorem ipsum" often arouses curiosity due to its resemblance to classical Latin, it is not intended to have meaning. Where text is visible in a document, people tend to focus on the textual content rather than upon overall presentation, so publishers use lorem ipsum when displaying a typeface or design in order to direct the focus to presentation. "Lorem ipsum" also approximates a typical distribution of letters in English.
                        </p>
                    </div>
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputName1">Your name</label>
                                    <input type="email" class="form-control" id="exampleInputName1" placeholder="Your name">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputCat1">Name of your cat</label>
                                    <input type="email" class="form-control" id="exampleInputCat1" placeholder="Name of your cat">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputHam1"></label>
                                    <input type="email" class="form-control" id="exampleInputHam1" placeholder="Name of your hamster">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputGrocer1"></label>
                                    <input type="email" class="form-control" id="exampleInputGrocer1" placeholder="Name of your grocery seller">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios" value="option1" checked>
                                        Option one is this and that&mdash;be sure to include why it's great
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios" value="option2">
                                        Option two can be something else and selecting it will deselect option one
                                    </label>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> I want have super-power
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value=""> I have one or more super-power already
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <p>
                            Even though using "lorem ipsum" often arouses curiosity due to its resemblance to classical Latin, it is not intended to have meaning. Where text is visible in a document, people tend to focus on the textual content rather than upon overall presentation, so publishers use lorem ipsum when displaying a typeface or design in order to direct the focus to presentation. "Lorem ipsum" also approximates a typical distribution of letters in English.
                        </p>
                        <p>
                            Using "lorem ipsum" often arouses curiosity due to its resemblance to classical Latin, it is not intended to have meaning. Where text is visible in a document, people tend to focus on the textual content rather than upon overall presentation, so publishers use lorem ipsum when displaying a typeface or design in order to direct the focus to presentation. "Lorem ipsum" also approximates a typical distribution of letters in English.
                        </p>
                    </div>
                    <noscript>
                        <input class="nocsript-finish-btn sf-right nocsript-sf-btn" type="submit" value="finish"/>
                    </noscript>
                </div>
            </fieldset>
        </form>
    </div>
</div>
        <div class="row">
            <div class="col-md-12 up-20">
                <pre><code>$("#wizard-example-4").stepFormWizard({
    showNav: 'right',
    height: 'auto',
    nextBtn: $('&lt;a class="next-btn sf-right sf-btn" href="#">FORWARD&lt;/a>'),
    prevBtn: $('&lt;a class="prev-btn sf-left sf-btn" href="#">BACK&lt;/a>'),
    finishBtn: $('&lt;a class="finish-btn sf-right sf-btn" href="#">DONE&lt;/a>'),
    onFinish: function(i, wizard) {
        var form = $('form', wizard).serialize();
        $.getJSON('form/get-finish-url', form, function(data) {
            wizard.html(data.html);
        });
        return false;
    }
});</code></pre>
            </div>
        </div>
        
        

        
<div class="row">
    <div class="col-md-12">
        <h2>Too much steps</h2>
        <form id="wizard_example_5" action="#">
            <fieldset>
                <legend>Basic information</legend>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email address</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password again</label>
                            <input type="password" class="form-control" id="exampleInputPasswordAgain1" placeholder="Password">
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="exampleInputPassword1">Favorite number</label>
                            <select class="form-control">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Own animals</label>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Goat
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Cow
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Rooster
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Crocodile
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        In publishing and graphic design, lorem ipsum is common placeholder text used to demonstrate the graphic elements of a document or visual presentation, such as web pages, typography, and graphical layout. It is a form of "greeking".
                    </div>
                </div>
            </fieldset>
            <fieldset>
                <legend>Condition</legend>
                In publishing and graphic design, lorem ipsum is common placeholder text used to demonstrate the graphic elements of a document or visual presentation, such as web pages, typography, and graphical layout. It is a form of "greeking".
                Even though using "lorem ipsum" often arouses curiosity due to its resemblance to classical Latin, it is not intended to have meaning. Where text is visible in a document, people tend to focus on the textual content rather than upon overall presentation, so publishers use lorem ipsum when displaying a typeface or design in order to direct the focus to presentation. "Lorem ipsum" also approximates a typical distribution of letters in English.
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" value="option1" checked>
                        Yes, it is totaly right.
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" value="option2">
                        No, I check it twice and it is not right.
                    </label>
                </div>
            </fieldset>
            <fieldset>
                <legend>Final step</legend>
                <div class="row">
                    <div class="col-lg-12">
                        <p>
                            Even though using "lorem ipsum" often arouses curiosity due to its resemblance to classical Latin, it is not intended to have meaning. Where text is visible in a document, people tend to focus on the textual content rather than upon overall presentation, so publishers use lorem ipsum when displaying a typeface or design in order to direct the focus to presentation. "Lorem ipsum" also approximates a typical distribution of letters in English.
                        </p>
                    </div>
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputName1">Your name</label>
                                    <input type="email" class="form-control" id="exampleInputName1" placeholder="Your name">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputCat1">Name of your cat</label>
                                    <input type="email" class="form-control" id="exampleInputCat1" placeholder="Name of your cat">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputHam1"></label>
                                    <input type="email" class="form-control" id="exampleInputHam1" placeholder="Name of your hamster">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputGrocer1"></label>
                                    <input type="email" class="form-control" id="exampleInputGrocer1" placeholder="Name of your grocery seller">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios" value="option1" checked>
                                        Option one is this and that&mdash;be sure to include why it's great
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios" value="option2">
                                        Option two can be something else and selecting it will deselect option one
                                    </label>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> I want have super-power
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value=""> I have one or more super-power already
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <p>
                            Even though using "lorem ipsum" often arouses curiosity due to its resemblance to classical Latin, it is not intended to have meaning. Where text is visible in a document, people tend to focus on the textual content rather than upon overall presentation, so publishers use lorem ipsum when displaying a typeface or design in order to direct the focus to presentation. "Lorem ipsum" also approximates a typical distribution of letters in English.
                        </p>
                        <p>
                            Using "lorem ipsum" often arouses curiosity due to its resemblance to classical Latin, it is not intended to have meaning. Where text is visible in a document, people tend to focus on the textual content rather than upon overall presentation, so publishers use lorem ipsum when displaying a typeface or design in order to direct the focus to presentation. "Lorem ipsum" also approximates a typical distribution of letters in English.
                        </p>
                    </div>
                    <noscript>
                        <input class="nocsript-finish-btn sf-right nocsript-sf-btn" type="submit" value="finish"/>
                    </noscript>
                </div>
            </fieldset>
            <fieldset>
                <legend>Ha, Final step is liar</legend>
                <div class="row">
                    <div class="col-lg-12">
                        <p>
                            text
                        </p>
                    </div>
                    <noscript>
                        <input class="nocsript-finish-btn sf-right nocsript-sf-btn" type="submit" value="finish"/>
                    </noscript>
                </div>
            </fieldset>
            <fieldset>
                <legend>I will be final step</legend>
                <div class="row">
                    <div class="col-lg-12">
                        <p>
                            text
                        </p>
                    </div>
                    <noscript>
                        <input class="nocsript-finish-btn sf-right nocsript-sf-btn" type="submit" value="finish"/>
                    </noscript>
                </div>
            </fieldset>
            <fieldset>
                <legend>This must be endless wizard</legend>
                <div class="row">
                    <div class="col-lg-12">
                        <p>
                            text
                        </p>
                    </div>
                    <noscript>
                        <input class="nocsript-finish-btn sf-right nocsript-sf-btn" type="submit" value="finish"/>
                    </noscript>
                </div>
            </fieldset>
            <fieldset>
                <legend>Yes, indeed</legend>
                <div class="row">
                    <div class="col-lg-12">
                        <p>
                            text
                        </p>
                    </div>
                    <noscript>
                        <input class="nocsript-finish-btn sf-right nocsript-sf-btn" type="submit" value="finish"/>
                    </noscript>
                </div>
            </fieldset>
            <fieldset>
                <legend>No, indeedidn't</legend>
                <div class="row">
                    <div class="col-lg-12">
                        <p>
                            text
                        </p>
                    </div>
                    <noscript>
                        <input class="nocsript-finish-btn sf-right nocsript-sf-btn" type="submit" value="finish"/>
                    </noscript>
                </div>
            </fieldset>
            <fieldset>
                <legend>Ninth is maximum for numbers</legend>
                <div class="row">
                    <div class="col-lg-12">
                        <p>
                            text
                        </p>
                    </div>
                    <noscript>
                        <input class="nocsript-finish-btn sf-right nocsript-sf-btn" type="submit" value="finish"/>
                    </noscript>
                </div>
            </fieldset>
        </form>
    </div>
</div>
        <div class="row">
            <div class="col-md-12 up-20">
                <pre><code>$("#wizard-example-5").stepFormWizard(); </code></pre>
            </div>
        </div>

        
<div class="row">
    <div class="col-md-12">
        <h2>Validation example</h2>
        <p class="lead">
            You can use your favorite validation plugin, but it must support validation on groups or sections of form.
            <br/>
            This example shows you, how you can use Step Form Wizard with form validation library Parsley.
            <br/>
            For more information about library look at <a href="http://parsleyjs.org/">parsleyjs.org</a>
        </p>
        <form id="wizard_example_6" action="#">
            <fieldset>
                <legend>Basic information</legend>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="exampleInputEmail6">Email address</label>
                            <input type="email" class="form-control" id="exampleInputEmail6" placeholder="Enter email" required data-parsley-group="block0">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword6">Password</label>
                            <input type="password" class="form-control" id="exampleInputPassword6" placeholder="Password" required data-parsley-group="block0" data-parsley-equalto="#exampleInputPasswordAgain6">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword6">Password again</label>
                            <input type="password" class="form-control" id="exampleInputPasswordAgain6" placeholder="Password" required data-parsley-group="block0" data-parsley-equalto="#exampleInputPassword6">
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="exampleInputPassword6">Favorite number</label>
                            <select class="form-control" name="favorite" data-parsley-group="block0" required>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Own animals</label>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="animal[]" data-parsley-mincheck="3" required data-parsley-group="block0"> Goat
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="animal[]" data-parsley-mincheck="3" required data-parsley-group="block0"> Cow
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="animal[]" data-parsley-mincheck="3" required data-parsley-group="block0"> Rooster
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="animal[]" data-parsley-mincheck="3" required data-parsley-group="block0"> Crocodile
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        In publishing and graphic design, lorem ipsum is common placeholder text used to demonstrate the graphic elements of a document or visual presentation, such as web pages, typography, and graphical layout. It is a form of "greeking".
                    </div>
                </div>
            </fieldset>
            <fieldset>
                <legend>Condition</legend>
                In publishing and graphic design, lorem ipsum is common placeholder text used to demonstrate the graphic elements of a document or visual presentation, such as web pages, typography, and graphical layout. It is a form of "greeking".
                Even though using "lorem ipsum" often arouses curiosity due to its resemblance to classical Latin, it is not intended to have meaning. Where text is visible in a document, people tend to focus on the textual content rather than upon overall presentation, so publishers use lorem ipsum when displaying a typeface or design in order to direct the focus to presentation. "Lorem ipsum" also approximates a typical distribution of letters in English.
                <div class="radio">
                    <label>
                        <input type="radio" value="option1" name="condition" data-parsley-group="block1" required>
                        Yes, it is totaly right.
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" value="option2" name="condition" data-parsley-group="block1" required>
                        No, I check it twice and it is not right.
                    </label>
                </div>
            </fieldset>
            <fieldset>
                <legend>Final step</legend>
                <div class="row">
                    <div class="col-lg-12">
                        <p>
                            Even though using "lorem ipsum" often arouses curiosity due to its resemblance to classical Latin, it is not intended to have meaning. Where text is visible in a document, people tend to focus on the textual content rather than upon overall presentation, so publishers use lorem ipsum when displaying a typeface or design in order to direct the focus to presentation. "Lorem ipsum" also approximates a typical distribution of letters in English.
                        </p>
                    </div>
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputName6">Your name</label>
                                    <input type="text" class="form-control" id="exampleInputName6" placeholder="Your name" name="your_name" data-parsley-group="block2" required="">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputCat6">Name of your cat</label>
                                    <input type="text" class="form-control" id="exampleInputCat6" placeholder="Name of your cat">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputHam6"></label>
                                    <input type="text" class="form-control" id="exampleInputHam6" placeholder="Name of your hamster">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputGrocer6"></label>
                                    <input type="text" class="form-control" id="exampleInputGrocer6" placeholder="Name of your grocery seller">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios" value="option1" checked>
                                        Option one is this and that&mdash;be sure to include why it's great
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios" value="option2">
                                        Option two can be something else and selecting it will deselect option one
                                    </label>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> I want have super-power
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value=""> I have one or more super-power already
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <p>
                            Even though using "lorem ipsum" often arouses curiosity due to its resemblance to classical Latin, it is not intended to have meaning. Where text is visible in a document, people tend to focus on the textual content rather than upon overall presentation, so publishers use lorem ipsum when displaying a typeface or design in order to direct the focus to presentation. "Lorem ipsum" also approximates a typical distribution of letters in English.
                        </p>
                        <p>
                            Using "lorem ipsum" often arouses curiosity due to its resemblance to classical Latin, it is not intended to have meaning. Where text is visible in a document, people tend to focus on the textual content rather than upon overall presentation, so publishers use lorem ipsum when displaying a typeface or design in order to direct the focus to presentation. "Lorem ipsum" also approximates a typical distribution of letters in English.
                        </p>
                    </div>
                    <noscript>
                        <input class="nocsript-finish-btn sf-right nocsript-sf-btn" type="submit" value="finish"/>
                    </noscript>
                </div>
            </fieldset>
        </form>
    </div>
</div>
<div class="row">
    <div class="col-md-12 up-20">
                <pre><code>$(window).load(function(){
    $("#wizard_example").stepFormWizard({
        onNext: function(i, wizard) {
            return $('form', wizard).parsley().validate('block' + i);
        },
        onFinish: function(i) {
            return $('form', wizard).parsley().validate();
        }
    });
});</code></pre>
    </div>
</div>

<script>

</script>

        



	</div>
   
</div>
	</div>

	<footer class="footer">
		<div class="container">
			
		</div>
	</footer>


  <script type="text/javascript" src='<c:url value="/resources/js/jquery-1.9.1.js" />'></script>
     <script type="text/javascript" src="<c:url value='/resources/js/all-1424208788.js' />"></script>
        <script type="text/javascript" src="<c:url value='/resources/js/bootstrap.js' />"></script></body>
     

</html>
