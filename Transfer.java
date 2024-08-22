Transfer.java 
=========== 
 
@WebServlet("/s2") 
public class AmtTransfer extends HttpServlet {  
 @Override 
 protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
   
  resp.setContentType("text/html"); 
  PrintWriter out=resp.getWriter(); 
  int a1 = Integer.parseInt(req.getParameter("a1")); 
  int a2 = Integer.parseInt(req.getParameter("a2")); 
  float amt = Float.parseFloat(req.getParameter("amt")); 
   
  float bal1, bal2, total1=0, total2=0; 
  String name1, name2; 
   
  try { 
   Class.forName("com.mysql.cj.jdbc.Driver"); 
    
  Connection 
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prsoftwares","root","root"); 
 
   PreparedStatement pst1=con.prepareStatement("select * from bank where acc = ?"); 
   pst1.setInt(1, a1); 
    
   ResultSet rs1=pst1.executeQuery(); 
   if(rs1.next()) 
   { 
    bal1 = rs1.getFloat(3); 
    total1 = bal1-amt; 
    name1 = rs1.getString(2); 
    req.setAttribute("name1", name1); 
    req.setAttribute("amount", amt); 
    req.setAttribute("total1", total1); 
   } 
 
   PreparedStatement pst11=con.prepareStatement("update bank set bal=? where acc=(?) "); 
   pst11.setFloat(1, total1); 
   pst11.setInt(2, a1); 
   pst11.execute(); 
    
   PreparedStatement pst2=con.prepareStatement("select * from bank where acc = (?)"); 
   pst2.setInt(1, a2); 
    
   ResultSet rs2=pst2.executeQuery(); 
   if(rs2.next()) 
   { 
    bal2 = rs2.getFloat(3); 
    total2 = bal2+amt; 
    name2 = rs2.getString(2); 
    req.setAttribute("name2", name2); 
   } 
    
   PreparedStatement pst22=con.prepareStatement("update bank set bal=(?) where acc=(?) "); 
   pst22.setFloat(1, total2); 
   pst22.setInt(2, a2); 
   pst22.execute(); 
    
   //out.print(""); 
   RequestDispatcher rd=req.getRequestDispatcher("/Done.jsp"); 
   rd.include(req, resp); 
    
    
  } catch (ClassNotFoundException | SQLException e) { 
   e.printStackTrace(); 
  } 
 } 
} 
