<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="styles1.css">
<title>Register</title>
</head>
<body>
	<div class="background-image"></div>
    <div class="register-box">
    		<h2 style="margin:40px 0px 20px 0px;text-align:center;">REGISTRATION FORM</h2>
       		 <form action="RegisterServlet" method="post">
       		 
       		 <label style="margin:0px 0px 10px 30px;font-size:20px;">Name </label><br>
            <input type="text" name="name" required class="div3"><br>
            
            <label style="margin:0px 0px 10px 30px;font-size:20px;">Email </label><br>
            <input type="email" name="email" required class="div3"><br>
            
            <label style="margin:0px 0px 10px 30px;font-size:20px;">Mobile </label><br>
            <input type="number" name="mobile" required class="div3"><br>
            
            <label style="margin:0px 0px 10px 30px;font-size:20px;">Gender </label><br>
            <input type="text" name="gender" required class="div3"><br>
            
            <label style="margin:0px 0px 10px 30px;font-size:20px;">City </label><br>
            <input type="text" name="city" required class="div3"><br>
            
            <input type="submit" value="SUBMIT" class="div4"><br>
          
        </form>
    	</div>
</body>
</html>