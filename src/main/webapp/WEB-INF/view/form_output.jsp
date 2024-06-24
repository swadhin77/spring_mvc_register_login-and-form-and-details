<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Form Details...</h2>
<h3>First Name : ${form_details.getFnm()}</h3>
<h3>Last Name : ${form_details.getLnm()}</h3>
<h3>Email id : ${form_details.getEmail()}</h3>
<h3>Father's Name : ${form_details.getFanm()}</h3>
<h3>Mother's Name : ${form_details.getMonm()}</h3>
<h3>Phone no. : ${form_details.getPhno()}</h3>
<h3>Gender : ${form_details.getG1()}</h3>
<h3>Education : ${form_details.getEdu()}</h3>
</body>
</html>