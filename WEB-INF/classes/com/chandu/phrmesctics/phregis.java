package com.chandu.phrmesctics;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shara
 */
public class phregis extends HttpServlet {
   
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

        String uname=request.getParameter("username");
        String pass=request.getParameter("password");
        String name=request.getParameter("Name");
        String address=request.getParameter("address");
        String mobile= request.getParameter("Mobile");
       String email=request.getParameter("Email");
     
       


          pbean bean= new pbean();
           pdaos dao=new pdaos();
           if(uname!=null && pass!=null && name!=null && address!=null && email!=null && mobile!=null )
           {
               bean.setUsername(uname);
               bean.setPassword(pass);
               bean.setName(name);
               bean.setAddress(address);
               bean.setMobile(mobile);
               bean.setEmail(email);
               
}
        try {

          String opn=request.getParameter("opn");

          if(opn.equals("Add"))
          {

             dao.create(bean);
          }
          response.sendRedirect("phlogin.jsp?msg3=shara");

           
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
