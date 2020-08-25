<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8"/>
		<link rel="stylesheet" href="static/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" href="static/css/stylec.css"> 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
		<title>Ivoire-money</title>
		<style type="text/css">
		    body { padding-top: 150px;}
		</style>
	</head>
	<!-- debut du body-->
	<body>
		<%@include file="../partials/navbar.jsp" %>
		<div class="container">
			<div class="row">
				 <c:out value="${ success }" />
				<h1 class="col-lg-offset-3 col-lg-6 text-center"> CONNEXION <h1>
				<div class="col-lg-offset-3 col-lg-9"> 
					<form class="horizontal form" method="post" action="connexion">
						<div class="col-lg-12 form-group">
							<label for="identifiant"> Identifiant:</label>
							<input type="texte" id="identifiant" name="identifiant" placeholder="Votre identifiant"value=<c:out value="${ user.getId() }"/>></input>
							
		                </div> 				
						<div class="col-lg-12 form-group">
							<label for="password"> Mot de passe:</label>
							<input type="password" id="password" name="password" placeholder="Votre mot de passe" value=<c:out value="${ user.getPass() }"/>></input>
		    					
		                </div> 
						<div class="col-lg-offset-4 col-lg-8 form-group">
							<button class="btn btn-primary" type="submit">Connexion</button>					
		                </div> 
						<p class="error text-center"><c:out value="${ form.getErrorMessage() }"/></p> 
					</form>
				</div>
			</div>
		</div>
		<%@include file="../partials/footer.jsp" %>
	</body>
</html>