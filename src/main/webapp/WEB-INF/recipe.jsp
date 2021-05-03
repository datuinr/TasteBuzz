<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>tastebuzz - create recipe</title>
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
	<form:form method="POST" action="/add-recipe" modelAttribute="recipeObj">
		<div class="new-recipe-container">
			<div class="form-container">
				<div>
					<b>New Recipe</b><br><br>
				</div>
				<div class="recipe-formLine">
					<form:input class="recipe-input" path="nor" placeholder="title"/>
					<form:errors path="nor" style="color:#44814e; font-size:12px;"/>
				</div>
				<div class="ta-recipe-formLine">
					<form:textarea class="recipe-textarea" path="description" placeholder="description"/>
					<form:errors path="description" style="color:#44814e; font-size:12px;"/>
				</div>
				<div class="ta-recipe-formLine">
					<form:textarea  class="recipe-textarea" path="ingredients" placeholder="ingredients - put each ingredient in its own line"/>
					<form:errors path="ingredients" style="color:#44814e; font-size:12px;"/>
				</div>
				<div class="ta-recipe-formLine">
					<form:textarea class="recipe-textarea" path="directions" placeholder="directions - put each step on its own line"/>
					<form:errors path="directions" style="color:#44814e; font-size:12px;"/>
				</div>
				<div class="ta-recipe-formLine">
					<form:textarea class="recipe-textarea" path="notes" placeholder="Notes"/>
				</div>
				<input class="submit" type="submit" value="Save"/>
			</div>
			<div class="subform-container">
				<div>
					<b>include a photo somehow.</b><br><br>
				</div>
				<div class="subrecipe-formLine">
					<form:input class="subrecipe-input" path="preptime" placeholder="prep time"/>
					<form:errors path="preptime" style="color:#44814e; font-size:12px;"/>
				</div>
				<div class="subrecipe-formLine">
					<form:input class="subrecipe-input"  path="cooktime" placeholder="cook time"/>
					<form:errors path="cooktime" style="color:#44814e; font-size:12px;"/>
				</div>
				<div class="subrecipe-formLine">
					<form:input class="subrecipe-input"  path="servings" placeholder="servings"/>
					<form:errors path="servings" style="color:#44814e; font-size:12px;"/>
				</div>
				<div class="subrecipe-formLine">
					<form:input class="subrecipe-input"  path="yield" placeholder="yield"/>
					<form:errors path="yield"/>
				</div>
			</div>
		</div>
	</form:form>
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
			<p><a href="">Careers</p>
			<p><a href="">Chat</a></p>
			<p><a href="">Email</a></p>
			<p><a href="">Feedback</a>
		</div>
		<div>
			<h2>About Us.</h2>
			<p><a href="">About Us</p>
			<p><a href="">Advertise</p>
			<p><a href="">News</p>
			<p><a href="">Suscribe</p>
		</div>
	</footer>
</body>
</html>