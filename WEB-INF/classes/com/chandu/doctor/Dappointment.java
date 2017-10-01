package com.chandu.doctor;

import com.chandu.pappointment.Pappointment;
import com.chandu.pappointment.Pappointmentdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shara
 */
public class Dappointment extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       

        try {
  HttpSession session=request.getSession();

            String users=(String) session.getAttribute("username");
            String pass=(String) session.getAttribute("password");
           Integer id=(Integer)session.getAttribute("id");

       Pappointment p=new Pappointment();
       Pappointmentdao d=new Pappointmentdao();
        
      
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Dappointment</title>");
            out.println("<link href=\"Design/default.css\" rel=\"stylesheet\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
            
           

           
          out.println("</ul></div>");
             RequestDispatcher rds=request.getRequestDispatcher("Design/page.jsp");
            rds.include(request, response);
               String m1=request.getParameter("msg");
            

                       out.println("<center><font  color=black size=8><b>Appointment List</b></font></center>");
                     
               out.println("<table align=\"center\" border=\"5\" width=800>");

                    out.println("<tr bgcolor=\"orange\"><th>Name</th><th>Contact Number</th><th>Address</th><th>Date</th></tr>");

ArrayList<Pappointment> al=d.findAllPatient(id);
       for(Pappointment c: al)
        {


                       out.println("<tr><td>&nbsp;&nbsp;&nbsp;"+c.getName()+"</td>"

                            + "<td>"+c.getMobile()+"</td>"
                            + "<td>"+c.getAddress()+"</td>"
                            + "<td>"+c.getDate()+"</td>");


                }
                     out.println("</table>");




            out.println("</body>");
           
           
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
