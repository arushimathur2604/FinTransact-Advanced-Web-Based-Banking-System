Login.java 
========= 
 
@WebServlet("/s1") 
public class Login extends HttpServlet {  
 @Override 
 protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
   
  resp.setContentType("text/html"); 
  PrintWriter out=resp.getWriter(); 
  String uname = req.getParameter("uname"); 
  String pswd = req.getParameter("pswd"); 
   
  if(uname.equals("abcd") && pswd.equals("1234")) 
  { 
   RequestDispatcher rd=req.getRequestDispatcher("/Form.html"); 
   rd.forward(req, resp); 
  } 
  else 
  { 
   out.print("<h5><center style= 'color : red'>Invalid username or password</center><h5>"); 
   RequestDispatcher rd=req.getRequestDispatcher("/login.html"); 
   rd.include(req, resp); 
  } 
 } 
}
