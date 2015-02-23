/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ovc;

import database.dbConn;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class saveUser extends HttpServlet {

    HttpSession session;
    String f_name, m_name, s_name, phoneno, username, password, userid, userlevel;
    boolean statuz = false;
    MessageDigest m;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");


            session = request.getSession();
            userid = request.getParameter("userid");
            f_name = request.getParameter("f_name");
            m_name = request.getParameter("m_name");
            s_name = request.getParameter("s_name");
            userlevel = request.getParameter("ulevel");

            //random id generator





            if (request.getParameter("phoneno") != null) {
                phoneno = request.getParameter("phoneno");
            } else {
                phoneno = "none";
            }
            username = request.getParameter("username");
            password = request.getParameter("pass");

            
            //encrypt password

            m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes(), 0, password.length());
            String pw = new BigInteger(1, m.digest()).toString(16);

            dbConn conn = new dbConn();
            
            
//save details to clerk table
//String save="insert into clerks(clerk_id, first_name,sur_name, phone) "
//+ "values ('"+userid+"','"+f_name+"','"+s_name+"','"+phoneno+"')";
//                        
//                            
//String save="insert into users( username,fname,mname, phone) "
//                                    + "values ('"+userid+"','"+f_name+"','"+s_name+"','"+phoneno+"')";
//                        

            String save = "insert into users (userid,username,fname,mname, phonenumber,password,userlevel) "
                    + "values ('"+userid+"','" + username + "','" + f_name + "','" + s_name + "','" + phoneno + "','" + pw + "','" + userlevel + "')";


            //save details to the usewrs table
//                                String add_to_users="insert into users(userid,password,username,level) "
//                                    + "values ('"+userid+"','"+pw+"','"+username+"','"+userlevel+"')";
//                        

            String checker = "select * from users where username='" + username + "'";



            conn.rs = conn.st.executeQuery(checker);

            //check if username is already used 
            if (!conn.rs.next()) {


                conn.st1.executeUpdate(save);

                //add top users table
                // conn.st.executeUpdate(add_to_users);  



                session.setAttribute("clerk_added", "<font color=\"green\">User added succesfully</font>");
            } else {
                session.setAttribute("clerk_added", "<b><font color=\"yellow\">Sorry, That username is already used.Use a different one</font></b>");


            }
            response.sendRedirect("adduser.htm");

        } catch (SQLException ex) {
            Logger.getLogger(saveUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(saveUser.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public int generateRandomNumber(int start, int end) {
        Random random = new Random();
        long fraction = (long) ((end - start + 1) * random.nextDouble());
        return ((int) (fraction + start));
    }

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
    }
    // </editor-fold>
}
