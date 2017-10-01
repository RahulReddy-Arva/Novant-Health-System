
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.chandu.mail.SendMail"%>
<%@ page import="javax.mail.MessagingException"%>
<%
	String message = null;
	String status = null;
	if (request.getParameter("submit") != null) {
		SendMail javaEmail = new SendMail();
		javaEmail.setMailServerProperties();
		String emailSubject = "Message Hospital Management Contact";
		String emailBody = "";
		if (request.getParameter("name") != null) {
			emailBody = "Sender Name: " + request.getParameter("name")
					+ "<br>";
		}
		if (request.getParameter("email") != null) {
			emailBody = emailBody + "Sender Email: "
					+ request.getParameter("email") + "<br>";
		}
		if (request.getParameter("phone") != null) {
			emailBody = emailBody + "Sender Phone: "
					+ request.getParameter("phone") + "<br>";
		}
		if (request.getParameter("message") != null) {
			emailBody = emailBody + "Message: " + request.getParameter("message")
					+ "<br>";
		}
		javaEmail.createEmailMessage(emailSubject, emailBody);
		try {
			javaEmail.sendEmail();
			status = "success";
			message = "Email sent Successfully!";
		} catch (MessagingException me) {
			status = "error";
			message = "Error in Sending Email!";
		}
	}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Us</title>
     
                 <link rel="stylesheet" type="text/css" href="Design/css/style.css" />
         <link href="Design/default.css" rel="stylesheet" type="text/css" />

</head>
    <body>
          <div class="container">
			<!-- Codrops top bar -->
                 <jsp:include page="/Design/header.jsp"/>
                  <jsp:include page="/Design/menu.jsp"/>
           </div><!--/ Codrops top bar -->
			<header>
				<div class="support-note">
					<span class="note-ie">Sorry, only modern browsers.</span>
				</div>
			</header>
			<section class="main">
 				
			<div id="message">
				<form class="form-4" id="frmContact" name="frmContact" action="" method="POST"
					novalidate="novalidate">
                                    
			<p>Send your comments through this form and we will get back to you.</p>
					<div class="label">Name:</div>
					<div class="field">
                                                <input type="text" name="Name" placeholder="Please enter your name" required>
					</div>
					<div class="label">Email:</div>
					<div class="field">
						<input type="text" id="pp-email" name="email"
							placeholder="enter your email address here"
							title="Please enter your email address" class="required email"
							aria-required="true" required>
					</div>
					<div class="label">Phone Number:</div>
					<div class="field">
						 <input type="text" name="Phone_number" placeholder="Please enter your phone number" required>
					</div>
					<div class="label">Message:</div>
					<div class="field">
						 <input type="text" name="Message" placeholder="Please enter your message" required>
					</div>
					<div id="mail-status"></div>
					<input type="submit" name="submit" value="Send Message"
						id="send-message" style="clear: both;">
					<%
						if (null != message) {
							out.println("<div class='" + status + "'>"
									+ message + "</div>");
						}
					%>
				</form>
                                
			</div>
                            </section>
   </div>
          
        <br><br><br><br><br><br><Br>
    </body>
</html>

