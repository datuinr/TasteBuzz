<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>tastebuzz - Edit Account</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<nav>
	<div class="brand-title">
		<a href="/">tastebuzz</a>
	</div>
	<a href="#" class="toggle-button">
		<span class="bar"></span>
		<span class="bar"></span>
		<span class="bar"></span>
	</a>
	<div class="navbar-links">
		<ul class="navlinks">
			<li><a href="/dashboard" class="username"><c:out value="${user.first}"/> <c:out value="${user.last}"/></a></li>
			<li><a href="/register">Register</a></li>
			<li><a href="/login">Login</a></li>
			<li><a href="/logout">Logout</a>
		</ul>	
	</div>
</nav>
<body>
	<div class="container">
		<b>Edit User Profile</b>
		    <form:form method="PUT" action="/dashboard/users/${user.id}/edit-profile" modelAttribute="userObj">
		    <div class="formLine">
		        <form:input class="regInput" path="first" placeholder="first name"/>
		        <form:errors path="first" style="color:#44814e; font-size:12px;"/>
		    </div>
		    <div class="formLine">
		        <form:input class="regInput" path="last" placeholder="last name"/>		    
		        <form:errors path="last" style="color:#44814e; font-size:12px;"/>
		    </div>
			<div class="formLine">			
		        <form:input class="regInput" type="email" path="email" placeholder="email"/>
		        <form:errors path="email" style="color#44814e; font-size:12px;"/>
			</div>
			<div class="formLine">
		        <form:password class="regInput" path="password" placeholder="password"/>
		        <form:errors path="password" style="color:#44814e; font-size:12px;"/>
			</div>
		    <div class="formLine">
		        <form:password class="regInput" path="passwordConfirmation" placeholder="password confirmation"/>
		        <form:errors path="passwordConfirmation" style="color:#44814e; font-size:12px;"/>
		    </div>
		        <input class="submit" type="submit" value="Create Account"/>
		    </form:form>
	</div>
</body>
<footer>
	<div class="social-links">
		<h2>Stay Conneted.</h2>
		<ul >
			<li><a href="http://www.facebook.com">Facebook</a></li>
			<li><a href="http://www.pinterest.com">Pinterest</a></li>
			<li><a href="http://www.twitter.com">Twitter</a></li>
			<li><a href="http://www.youtube.com">Youtube</a></li>
		</ul>
	</div>
	<div class="questions">
		<h2>Contact Us.</h2>
		<p><a href="">Careers</a></p>
		<p><a href="">Chat</a></p>
		<p><a href="">Email</a></p>
		<p><a href="">Feedback</a>
	</div>
	<div>
		<h2>About Us.</h2>
		<p><a href="">About Us</a></p>
		<p><a href="">Advertise</a></p>
		<p><a href="">News</a></p>
		<p><a href="">Suscribe</a></p>
	</div>
</footer>
</html>