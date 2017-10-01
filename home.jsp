

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Design/default.css" rel="stylesheet" type="text/css" />
         <link rel="stylesheet" type="text/css" href="css/style.css" />
		<script src="js/modernizr.custom.63321.js"></script>
    </head>
    <body>
         <jsp:include page="/Design/header.jsp"/>
         <jsp:include page="/Design/menu.jsp"/>

       
         <jsp:include page="/Design/content.jsp"/>
         
         <jsp:include page="/Design/sidebar.jsp"/>
        
        
    </body>
</html>
