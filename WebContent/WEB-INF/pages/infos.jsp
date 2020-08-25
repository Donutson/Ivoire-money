<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8"/>
		<link rel="stylesheet" href="static/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" href="static/css/styleinf.css"> 
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
		<div class="container" id="bas">
			<div class="row">
				<h1 class="col-lg-offset-3 col-lg-6 text-center"> INFORMATIONS DU COMPTE<h1>
				<div class="col-lg-offset-2 col-lg-8 elt"> 
					Nom: <span> <c:out value="${ sessionScope.user.getNom() }"/></span>
				</div>
				<div class="col-lg-offset-2 col-lg-8 elt"> 
					Prénom: <span><c:out value="${ sessionScope.user.getPrenom() }"/></span>
				</div>
				<div class="col-lg-offset-2 col-lg-8 elt"> 
					Mail: <span><c:out value="${ sessionScope.user.getMail() }"/></span>
				</div>
				<div class=" col-lg-offset-2 col-lg-8 elt"> 
					Téléphone: <span><c:out value="${ sessionScope.user.getPhone() }"/></span>
				</div>
				<div class="col-lg-offset-2 col-lg-8 elt"> 
					Identifiant: <span><c:out value="${ sessionScope.user.getId() }"/></span>
				</div>
				<div class="col-lg-offset-2 col-lg-8 elt"> 
					Solde: <span><c:out value="${ sessionScope.user.getSolde() }$"/></span>
				</div>
			</div>
		</div>
		<%@include file="../partials/footer.jsp" %>
	</body>
</html>