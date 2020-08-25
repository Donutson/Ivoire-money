<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8"/>
		<link rel="stylesheet" href="static/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" href="static/css/stylei.css"> 
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
				<h1 class="col-lg-offset-3 col-lg-6 text-center"> INSCRIPTION: <c:out value="${ phone }"/><h1>
				<div class="col-lg-offset-3 col-lg-8"> 
					<form class="horizontal form" method="post" action="inscription" enctype="multipart/form-data">
					
						 <div class="col-lg-12 form-group">
							<input class="form-control" type="file" name="photo" placeholder="Votre photo" value="<c:out value="${ user.getPhoto() }"/>" required></input>
		                    				
		                </div>
		                
						 <div class="col-lg-12 form-group">
							<input class="form-control" type="texte" name="nom" placeholder="Votre nom" value="<c:out value="${ user.getNom() }"/>" required></input>
		                    				
		                </div> 
		                
						<div class="col-lg-12 form-group">
							<input class="form-control" type="texte" name="prenom" placeholder="Votre prenom" value="<c:out value="${ user.getPrenom() }"/>" required></input>
		                    
		                </div> 
		                
						<div class="col-lg-12 form-group">
							<input class="form-control" type="email" name="mail" placeholder="Votre mail" value="<c:out value="${ user.getMail() }"/>" required></input>
		                    <p class="error"> <c:out value="${ form.getMailMessage() }"/> </p>
		                </div> 
		                
						<div class="col-lg-12 form-group">
							<input class="form-control" type="tel" name="phone" placeholder="Votre téléphone" value="<c:out value="${ user.getPhone() }"/>" required></input>
		                      <p class="error"> <c:out value="${ form.getPhoneMessage() }"/> </p>
		                </div> 
		                
						<div class="col-lg-12 form-group">
							<input class="form-control" type="texte" name="identifiant" placeholder="Votre identifiant" value="<c:out value="${ user.getId() }"/>" required></input>
		                    <p class="error"> <c:out value="${ form.getIdMessage() }"/> </p>
		                </div> 
		                
						<div class="col-lg-12 form-group">
							<input class="form-control" type="password"  name="password" placeholder="Votre mot de passe" value="<c:out value="${ user.getPass() }"/>" required></input>
		                   
		                </div> 
		                
		                <div class="col-lg-12 form-group">
							<input class="form-control" type="password"  name="confirm" placeholder="confirmer mot de passe" required></input>
		                    <p class="error"> <c:out value="${ form.getConfirmMessage() }"/> </p>						
		                </div>
		                
		                <div class="col-lg-offset-2 col-lg-8 form-group">
							<button class="btn btn-primary form-control" type="submit">S'inscrire</button>  
		                </div>
		                		
					</form>
				</div>
			</div>
		</div>
		<%@include file="../partials/footer.jsp" %>
	</body>
</html>