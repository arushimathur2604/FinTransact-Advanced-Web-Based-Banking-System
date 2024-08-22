Done.jsp 
======== 
 
<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>Payment successful</title> 
<style type="text/css"> 
body 
{ 
background :url(bank1.jfif) ; 
margin-top: 10%; 
background-size: 100% 430px ; 
background-repeat: no-repeat; 
} 
h4 
{ 
margin-top: 1%; 
} 
margin-left: 30%; 
.aa 
{  
} 
margin-left:42%; 
width :20% ; 
</style> 
</head> 
<body> 
<h3><center style= 'color : green'>Payment Successful!</center></h3> 
<h3><center style= 'color : black'>The payment of Rs.${requestScope.amount} has been done 
successfully</center></h3> 
<h4> 
<div id="From"> 
<h3>From</h3> 
<pre> 
A/c number : ${param.a1}  
name : ${requestScope.name1} 
available balance : ${requestScope.total1} </pre> 
</div> 
<div id="To"> 
<h3>To</h3> 
<pre> 
A/c number : ${param.a2} 
name : ${requestScope.name2}</pre> 
</div> 
</h4> 
<div class="aa"> 
<tr> 
</td> 
<td> <form action="Form.html"> <input type="submit" value="Pay again"></form> 
<td> <form action="login.html"> <input type="submit" value="logout"></form> 
</td> 
</tr> 
</div> 
</body> 
</html>
