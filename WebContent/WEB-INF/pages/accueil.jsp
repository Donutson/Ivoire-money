
<%@include file="../partials/navbar.jsp" %>
<!-- Corps de la page-->
<!-- Petit message-->
<div class="container-fluid text-center">
<div class="row "  id="img-top"> 
	<div class="col-lg-offset-3 col-lg-6 col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6" >
		Avec Ivoire-money envoyer et recevoir de l'argent n'a jamais été aussi facile
	</div>
	<div class="col-lg-offset-3 col-lg-6 col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6">
		<a href="inscription"><button type="button" class="btn btn-primary bouton-rond" style="display: <?php if(!empty($_GET["see"])) echo "none"; ?>"> Ouvrir votre compte gratuitement</button></a>
	</div>
</div>
 <!-- Qualités du site-->
<div class="row " id="qs">
	<div class="col-lg-offset-2 col-lg-2 col-md-offset-2 col-md-2 col-sm-offset-2 col-sm-2 ">
	    <img src="static/images/p.PNG" alt="..."/>
		<p><h4>PLUS RAPIDE</h4> <br/> Transferer de l'argent à la vitesse de la lumière</p>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-2 ">
	    <img src="static/images/p1.PNG" alt="..."/>
		<p><h4>INTÉGRÉ</h4> <br/> La meilleure API de transfert d'argent sur le marché</p>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-2 ">
	    <img src="static/images/p2.PNG" alt="..."/>
		<p><h4>PROTÉGÉ</h4> <br/> Transfert et retrait sécurisés et réglementés</p>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-2 ">
	    <img src="static/images/p3.PNG" alt="..."/>
		<p><h4>TARIFICATION TRANSPARENTE</h4> <br/> Taux de change transparents</p>
	</div>
</div>
<!-- Processus-->
<div class="row" id="ps">
	<h1 class="col-lg-offset-2 col-lg-8 col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
		Envoyez et recevez des paiements internationaux comme s'il s'agissait de paiements nationaux
	</h1>
	<div class="col-lg-offset-2 col-lg-2 col-md-offset-2 col-md-2 col-sm-offset-2 col-sm-2 ">
	    <img src="static/images/book-payment.png" alt="..."/>
		<p><h4>ENREGISTREZ UN PAIEMENT</h4> <br/> <span>Taux de change</span> en temps réel</p>
	</div>
	<div class="col-lg-1 col-md-1 col-sm-1 ">
	    
	</div>
	<div class="col-lg-2 col-md-2 col-sm-2 ">
	    <img src="static/images/lodge-funds.png" alt="..." />
		<p><h4>DÉPOSEZ LES FONDS</h4> <br/> sur le compte de Ivoire-money dans votre pays</p>
	</div>
	<div class="col-lg-1 col-md-1 col-sm-1">
	    
	</div>
	<div class="col-lg-2 col-md-2 col-sm-2 ">
	    <img src="static/images/we-transfer-your-funds.png" alt="..." />
		<p><h4>NOUS TRANSFÉRONS VOS FONDS</h4> <br/>le pays de votre bénéficiaire</p>
	</div>
</div>
<!-- Votre argent au bon endroit-->
<div class="row" id="money">
	<h3 class="col-lg-offset-4 col-lg-4 col-md-offset-4 col-md-4 col-sm-offset-4 col-sm-4">
		Votre argent au bon endroit.
	</h3>
	<div class="col-lg-offset-4 col-lg-4 col-md-offset-4 col-md-4 col-sm-offset-4 col-sm-4 col-xs-offset-1">
		<a href="inscription"><button type="button" class="btn btn-primary bouton-rond" style="display: <?php if(!empty($_GET["see"])) echo "none"; ?>"> Ouvrir votre compte gratuitement</button></a>
	</div>
</div>
<!-- Service client-->
<div class="row" id="customer-service">
	<div class="col-lg-offset-3 col-lg-6 col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6">
		Service à la clientète 7 jours/7, 24h/24 <br/>
Si vous avez des questions, vous pouvez contacter notre équipe disponible 7 jours/7, 24h/24.
	</div>
	<div class="col-lg-offset-4 col-lg-4 col-md-offset-4 col-md-4 col-sm-offset-4 col-sm-4">
		<a class="btn btn-default" href="#">Contactez-nous</a> <a class="btn btn-default" href="#">Dialoguez avec nous</a>
	</div>
</div>
<!-- Télécharger l'appli-->
<div class="row" id="appli">
	<div class="col-lg-offset-4 col-lg-4 col-md-offset-4 col-md-4 col-sm-offset-4 col-sm-4">
		<span>Télécharger l'appli</span><br/>
Suivez vos transferts de n'importe où et faites-en de nouveaux en quelques taps.
	</div>
	<div class="col-lg-offset-4 col-lg-4 col-md-offset-4 col-md-4 col-sm-offset-4 col-sm-4">
		<a class="btn btn-default" href="#"><img src="static/images/app-store-icon.png" alt="app-store-icon"/></a> <a class="btn btn-default" href="#"> <img src="static/images/google-play-store-icon.png" alt="play-store-badge" /></a>
	</div>
</div>
</div>
<%@include file="../partials/footer.jsp" %>