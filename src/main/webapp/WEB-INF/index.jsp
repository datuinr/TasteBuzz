<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>tastebuzz</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/script.js" defer></script>
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
	<div class="hero">
		<video autoplay loop>
  			<source src="video/video.mp4" type="video/mp4">
  		</video>
	</div>
	<div class="tcontainer">
	    <div class="ticker-wrap">
	        <div class="ticker-move">
	            <div class="ticker-item">Try it. Taste it. Buzz about it.</div>
	            <div class="ticker-item">Join the tastebuzz community.</div>
	            <div class="ticker-item">Browse the most current recipes everyone is enjoying!</div>
	            <div class="ticker-item">Share your recipes or your experience with others.</div>
	        </div>
		</div>	
	</div>
	<div class="searchbar">
		<form action="/search" method="post">
			<input type="text" name="nor" placeholder=" search for a recipe">
			<c:out value="${error}"/>
			<button>Submit</button>
		</form>
	</div>
	<div class="recipe-container">
		<h3>Try these recipes out:</h3>
		<div class="recipe-flex">
			<c:forEach items="${recipes}" var="recipe">
			<div class="recipe-name">
				<h3><a href="/recipes/${recipe.id}"><c:out value="${recipe.nor}"/></a></h3>
			</div>
			</c:forEach>
		</div>
		<a href="" style="float:right; padding-right:23px"><button>View More</button></a>
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