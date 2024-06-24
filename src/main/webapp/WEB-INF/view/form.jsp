<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="submitform" method="post">
First Name. :  <input type="text" name="fnm" placeholder="Enter Your First name"><br><br>
Last Name :  <input type="text" name="lnm" placeholder="Enter Your Last name"><br><br>
Email Id.:  <input type="email" name="email" placeholder="Enter Your mail-id"><br><br>
Father's Name :  <input type="text" name="fanm" placeholder="Enter Your father name"><br><br>
Mother's Name :  <input type="text" name="monm" placeholder="Enter Your mother name"><br><br>
phone number:  <input type="number" name="phno" placeholder="Enter Your phno."><br><br>
Gender : <input type="radio" name="g1" value="male">Male<input type="radio" name="g1" value="female">Female<br><br>
Education :
<select name="edu">
<option >Choose Your Education</option>
<option value="pg">Post Graduate</option>
<option value="g">Graduate</option>
<option value="ug">Under Graduate</option>
<option value="m">Matriculation</option>
</select><br><br>
<input type="submit" value="Submit">
</form>
</body>
</html>