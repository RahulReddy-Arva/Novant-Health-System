

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor log in</title>
       
                 <link rel="stylesheet" type="text/css" href="Design/css/style.css" />
         <link href="Design/default.css" rel="stylesheet" type="text/css" />
         
</head>
    <body>
          <div class="container">

			
            
                 <jsp:include page="/Design/header.jsp"/>
                
                	
                  <jsp:include page="/Design/menu.jsp"/>
                
                
            </div>

			<header>
 
				<div class="support-note">
					<span class="note-ie">Sorry, only modern browsers.</span>
				</div>

			</header>

			<section class="main">
                                             <%
                                String m2=request.getParameter("msg2");

                                if(m2!=null)
                                    {
                                   %>
                                   <center>  <i> <font size="5" color="white"><b>Successfully Logout!</b></font></i></center>
                                   <%
                                   }

                                %>

                                <br> <br><br><br>
                             
                            
                            <form class="form-4" action="/Novant_health/Authenticate">

                                <h1>Doctor Login</h1>
				    <p>
                                        <label for="login">Username</label>
				        <input type="text" name="username" placeholder="Username" required>
				    </p>
				    <p>
				        <label for="password">Password</label>
				        <input type="password" name='password' placeholder="Password" required>
				    </p>

				    <p>
				        <input type="submit" name="submit" value="Continue">
                                        
                                        
				    </p>
                                     <a href="pregis.jsp"><font size="4"> <b>New? Register!</b></font>
				</form>
                            </section>
    </div>
                                <%
                                String m=request.getParameter("msg");

                                if(m!=null)
                                    {
                                   %>
                                   <center>  <i> <font size="5" color="Red"><b>Incorrect UserName and Password!</b></font></i></center>
                                   <%
                                   }

                                %>
               

                               
			

        
        <br><br><br><br><br><br><Br>
        
    </body>
</html>
