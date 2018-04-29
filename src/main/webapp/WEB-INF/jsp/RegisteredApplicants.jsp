<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registered Applicants</title>
</head>
<body>
<p><b>Applicant Details</b></p>
	<ul>
    <c:forEach var="listValue" items="${applicantList}">
     	<li>Transaction Id  	 : ${listValue.getId()}</li>
        <li>Name 				 : ${listValue.getName()}</li>
        <li>Age					 : ${listValue.getAge()}</li>
        <li>Gender 				 : ${listValue.getGender()}</li>
        <li>Visa Status 		 : ${listValue.getVisaStatus()}</li>
        <li>Country Of Residence : ${listValue.getCountry()}</li>
        =================================================
    </c:forEach>
</ul>
</body>
</html>