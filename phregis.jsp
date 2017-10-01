

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>

        <head>

<title>
Address Book
</title>


<meta charset="utf-8">
<meta name="generator" content="Wufoo">
<meta name="robots" content="index, follow">


<link href="css/structure1.css" rel="stylesheet">
<link href="css/form.css" rel="stylesheet">
<link href="Design/default.css" rel="stylesheet" type="text/css" />

<script src="scripts/wufoo.js"></script>


</head>

<body id="public">
     <jsp:include page="/Design/header.jsp"/>
         <jsp:include page="/Design/menu.jsp"/>
         <br><br><br><br><br><br><br>
<div id="container" class="ltr">

 <br><br>
    <center>  <font size="6" color="black"  >  <i> Registration Form</i></font></center>

<form id="form16" name="form16" action="phregis?opn=Add"  method="post" class="wufoo  page"  autocomplete="off" >

<ul>
 <li id="foli0" class="name notranslate ">
     <label class="desc" id="title0" for="Field0">Username</label>
<span><input id="Field0" name="username" type="text" class="field text" placeholder="Username" size="30" tabindex="10" /></span></li>


 <li id="foli0" class="name notranslate      ">
<label class="desc" id="title0" for="Field0">Password</label>
<span> <input id="Field0" name="password" type="password" class="field text" placeholder="Password" size="30" maxlength="6" tabindex="10" />
<label for="Field0">Maximum Length of Password will be only 6</label></span></li>


<input type="hidden" name="did">


<li id="foli0" class="name notranslate      ">
<label class="desc" id="title0" for="Field0">Name</label>
<span><input id="Field0" name="Name" type="text" class="field text" placeholder="Name" size="30" tabindex="10" />
<label for="Field0"></label></span></li>


<li id="foli4" class="complex notranslate ">
 <label class="desc" id="title4" for="Field4">Address</label>
<div><span class="full addr1"><input id="Field4" name="address" type="text" class="field text addr" value="" placeholder="Address" tabindex="6" />
<label for="Field6"></label></span></div></li>


<li id="foli36" class="phone notranslate      ">
<label class="desc" id="title36" for="Field36">Cell phone</label>
<span><input id="Field36" name="Mobile" type="tel" class="field text" placeholder="Don't Include 0" size="30" maxlength="11" tabindex="17" />
<label for="Field36"></label></span></li>


<li id="foli12" class="notranslate      ">
<label class="desc" id="title12" for="Field12">Email Address</label>
<div><input id="Field12" name="Email" type="email" spellcheck="false" class="field text medium" value="" placeholder="E-mail" maxlength="255" tabindex="13" />
</div>
</li></div>


 <li class="buttons "><div>
<input id="saveForm" name="saveForm" class="btTxt submit" type="submit" value="Submit"/></div>
 </li>

         </ul>
</form>

</div><!--container-->
</body>
 
</html>
