<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>tastebuzz - Dashboard</title>
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
			<li><a href="#" class="username"><c:out value="${user.first}"/> <c:out value="${user.last}"/></a></li>
			<li><a href="/register">Register</a></li>
			<li><a href="/login">Login</a></li>
			<li><a href="/logout">Logout</a>
		</ul>	
	</div>
</nav>
<body>
	<div class="user-dash-container">
		<div class="user-dash">
			<div class="user-photo"></div>
			<h3><c:out value="${user.first}"/> <c:out value="${user.last}"/></h3>
			<ul>
				<li><a href="/add-recipe"><button>Add a Recipe</button></a></li>
				<li><a href=""><button>My Recipes</button></a></li>
				<li><a href="/dashboard/users/${user.id}/edit-profile"><button>Edit Profile</button></a>
			</ul>
		</div>
		<div class="dash-feed-container">
			<c:forEach items="${recipes}" var="recipe">
			<div class="dash-recipe-info">
				<div class="dash-recipe-photo">
					<a href="/recipes/${recipe.id}"></a>
				</div>
				<div class="recipe-cap">
					<h3><a href="/recipes/${recipe.id}"><c:out value="${recipe.nor}"/></a></h3>
					<tagname style="font-size: 10pt;">Posted by: <c:out value="${recipe.creator.first}"/></tagname>
				</div>
			</div>
			</c:forEach>
		</div>
		<div class="dash-friends">
		</div>
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