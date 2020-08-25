<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8"/>
		<link rel="stylesheet" href="static/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" href="static/css/stylet.css"> 
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
				<h1 class="col-lg-offset-3 col-lg-6 text-center"> TRANSFERT D'ARGENT<h1>
				<div class="col-lg-offset-3 col-lg-8"> 
					<form class="horizontal form" method="post" action="transfert">
						 <div class="col-lg-12 form-group">
							<input class="form-control" type="texte" name="identifiant" placeholder="Identifiant destinataire"/> 
							<p class="error"> <c:out value="${ form.getIdErrorMessage() }"/></p>
		                </div> 
						<div class="col-lg-12 input-group">
							<input class="form-control" type="texte" name="amount" placeholder="Montant" value=	"0"/><span class="input-group-addon">€</span>					
		                </div>
		                <p class="error"> <c:out value="${ form.getAmountErrorMessage() }"/></p>				
		                <div class="col-lg-offset-2 col-lg-8 form-group">
							<button class="btn btn-primary form-control" type="submit">Valider</button>  
		                </div>
		                <p class="error"> <c:out value="${ form.getSuccessMessage() }"/></p> 				
					</form>
				</div>
			</div>
		</div>
		<%@include file="../partials/footer.jsp" %>
	</body>
</html>