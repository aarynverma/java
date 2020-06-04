/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/Record"})
public class Record extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            String name = request.getParameter("url");
            String mobile = request.getParameter("no");
            String aadhar = request.getParameter("aad");
            String location = request.getParameter("lo");
            String Hometown = request.getParameter("ho");
            String sick = request.getParameter("any");
            String meal  = request.getParameter("me");
            String birth = request.getParameter("date");
            /*out.println(name);
            out.println(mobile);
            out.println(aadhar);
            out.println(location);
            out.println(Hometown);
            out.println(sick);
            out.println(meal);
            out.println(birth);*/
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/entry","root","ROOT");
            
            PreparedStatement ps = con.prepareStatement("insert into entry values(?,?,?,?,?,?,?,?)");
           
            ps.setString(1, name);
            
            ps.setString(2, mobile);
            ps.setString(3, aadhar);
            ps.setString(4, location);
            ps.setString(5, Hometown);
            ps.setString(6, sick);
            ps.setString(7, meal);
            ps.setString(8, birth);
            if(ps.executeUpdate()==0){
                out.println("Patient Added Successfully!!!");
            }
            else{
                out.println("Sorry, try again!!!");
            }
            out.println("hello");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
