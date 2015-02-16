/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ovc;


import database.dbConn;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Geofrey Nyabuto
 */
public class login extends HttpServlet {

    String uname, pass, error_login, nextPage, current_time;
    String computername;
    MessageDigest m;
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException, SQLException {


        dbConn conn = new dbConn();

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        String yr, mnth, dater, hr, mn, sc, action = "";
        yr = Integer.toString(year);
        mnth = Integer.toString(month);
        dater = Integer.toString(date);
        hr = Integer.toString(hour);
        mn = Integer.toString(min);
        sc = Integer.toString(sec);
        session = request.getSession();

//____________________COMPUTER NAME____________________________________
        computername = InetAddress.getLocalHost().getHostName();
        System.out.println("Computer name " + computername);
        session.setAttribute("computer_name", computername);





//current_time=sc+"-"+mn+"-"+hr+"-"+dater+"-"+mnth+"-"+yr;

//current_time=yr+"-"+mnth+"-"+dater+"-"+hr+":"+mn+":"+sc;

        current_time = yr + "-" + mnth + "-" + dater + "-" + hr + ":" + mn + ":" + sc;
        //get username and password

        uname = request.getParameter("uname");

        pass = request.getParameter("pass");






        //encrypt password

        m = MessageDigest.getInstance("MD5");
        m.update(pass.getBytes(), 0, pass.length());
        String pw = new BigInteger(1, m.digest()).toString(16);


        //connection to database class instance


        //query for checking user existance in the database
        String select1 = "select * from users";




//System.out.println("worked up to here 1;");

        conn.rs = conn.st.executeQuery(select1);

        // System.out.println("username:"+uname+"  Password :"+pw );


        while (conn.rs.next()) {
            if (conn.rs.getString("username").equals(uname) && conn.rs.getString("password").equals(pw)) {

                error_login = null;
                if (conn.rs.getString("userlevel").equals("1")) {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                      System.out.println("level:"+conn.rs.getString("userlevel"));
                    String inserter = "insert into audit set host_comp='" + computername + " " + ip + "' , action='Logged in ',time='" + current_time + "',actor_id='" + conn.rs.getString("userid") + "'";

                    //String inserter="insert into audit  (action,time,actor_id,host_comp) values ('"++"','"+"')";

                    conn.st3.executeUpdate(inserter);
                    //the next page to be opened based on user level
                    nextPage = "newuser.htm";

                  error_login=null;
//String fulname=""+conn.rs.getString("firstname") + " "+conn.rs.getString("lastname");
//audit="Insert into audit (Action,User) values('Logged in','"+fulname+"')";



                    //save current user details into a session

                   
                    session.setAttribute("fname",conn.rs.getString("fname"));
                    session.setAttribute("lname",conn.rs.getString("mname"));
                    session.setAttribute("level",conn.rs.getString("userlevel"));
                    session.setAttribute("userid",conn.rs.getString("userid"));
                    session.setAttribute("username",conn.rs.getString("username"));
                   

                    System.out.println( session.getAttribute("fname")+" __"+session.getAttribute("lname"));
                    
                    //get teacher details from the teacher registration table 


                    /** code for auditing  */
                    // conn.st.executeUpdate(audit);
                    break;
                }//end of admin level
                //****************************Clerk module**********************************************        
                else if (conn.rs.getString("userlevel").equals("2")) {
                    // System.out.println("level 2");      
                    nextPage = "ovc_home.htm";



                    session.setAttribute("userid", conn.rs.getString(1));
                    session.setAttribute("username", conn.rs.getString("username"));
                    session.setAttribute("level", conn.rs.getString("userlevel"));
                    session.setAttribute("fname", conn.rs.getString("fname"));
                    session.setAttribute("lname", conn.rs.getString("mname"));
                    //save other session details to dbase

                    String clerk = "select * from users";

                    conn.rs1 = conn.st1.executeQuery(clerk);

                    while (conn.rs1.next()) {

                        if (conn.rs1.getString("userid").equals(session.getAttribute("userid"))) {

                            session.setAttribute("f_name", conn.rs1.getString("fname"));
                            session.setAttribute("s_name", conn.rs1.getString("mname"));
                            String ip = InetAddress.getLocalHost().getHostAddress();
                            String inserter = "insert into audit set host_comp='" + computername + " " + ip + "' , action='Logged in',time='" + current_time + "',actor_id='" + conn.rs.getString("userid") + "'";
                           error_login=null; 
                            conn.st3.executeUpdate(inserter);

                            break;
                        }
                        else{
                   error_login = "<b><font color=\"red\">ooops! wrong username and / or password combination</font></b>";

                        }

                    }
                 
                    break;

                } //         ^^^^^^^^^^^^^^^^ IF  USER EXIST  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^              
                else if (conn.rs.getString("userlevel").equals("5")) {
                    nextPage = "guest_home.htm";

                    session.setAttribute("userid", conn.rs.getString(1));
                    session.setAttribute("username", conn.rs.getString("username"));
                    session.setAttribute("level", conn.rs.getString("userlevel"));
                      session.setAttribute("fname", conn.rs.getString("fname"));
                    session.setAttribute("lname", conn.rs.getString("mname"));
                    //save other session details to dbase

                    String guest = "select * from guest";

                    conn.rs = conn.st.executeQuery(guest);

                    while (conn.rs.next()) {

                        if (conn.rs.getString("user_id").equals(session.getAttribute("userid"))) {
                            session.setAttribute("who", "guest");
                            session.setAttribute("f_name", conn.rs.getString("first_name"));
                            session.setAttribute("s_name", conn.rs.getString("last_name"));
               
                            String ip = InetAddress.getLocalHost().getHostAddress();
                            String inserter = "insert into audit set host_comp='" + computername + " " + ip + "' , action='Logged in(guest)',time='" + current_time + "',actor_id='" + conn.rs.getString("user_id") + "'";
                            conn.st3.executeUpdate(inserter);
                       error_login=null;
                            break;
                        }
                        else{
                         error_login = "<b><font color=\"red\">ooops! wrong username and / or password combination</font></b>";

                        }

                    }
                   
                    break;
                } //****************************wrong username password                        
                else {

                    nextPage = "index.htm";

                    System.out.println("third level");

                    error_login = "<b><font color=\"red\">ooops! wrong username and / or password combination</font></b>";

                }








            }//end of first if
            else {

                //System.out.println("worked up to here 6;");

                nextPage = "index.htm";

                error_login = "<b><font color=\"red\">wrong username and or password</font></b>";

                System.out.println(">>" + nextPage);

            }



        }


        session.setAttribute("error_login", error_login);
        response.sendRedirect(nextPage);


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
