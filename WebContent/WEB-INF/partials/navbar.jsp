<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- création du menu-->
 <nav class="navbar navbar-default navbar-static-top navbar-fixed-top">
    <div class="container-fluid">
	   <div class="navbar-header">
	   <!-- bouton contenant le menu pour les petits écrans-->
	     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
		     <span class="icon-bar"></span>
			 <span class="icon-bar"></span>
			 <span class="icon-bar"></span>
		 </button>
		 <!-- logo dans le menu-->
	      <a class="navbar-brand" href="index.jsp">
		      <img alt="logo-ivoire-money" src="static/images/logo.png"/>
		  </a>
	   </div>
	   <!-- éléments du menu-->
	   <div class="collapse navbar-collapse" id="menu">
	      <ul class="nav navbar-nav">
				<li class=<c:if test="${ isRegister }" >active</c:if>> <a href="inscription" style="display: <c:choose> <c:when test="${sessionScope.isConnected}">none</c:when> <c:otherwise>block</c:otherwise> </c:choose>"> S'INSCRIRE </a> </li>
				<li class=<c:if test="${ isConnect }" >active</c:if>> <a href="connexion" style="display: <c:choose> <c:when test="${sessionScope.isConnected}">none</c:when> <c:otherwise>block</c:otherwise> </c:choose>">SE CONNECTER </a> </li>
				<li class=<c:if test="${ isTransfer }" >active</c:if>><a href="transfert" style="display: <c:choose> <c:when test="${sessionScope.isConnected}">block</c:when> <c:otherwise>none</c:otherwise> </c:choose>">TRANSFERER</a> </li>
				<li class=<c:if test="${ isInfo }" >active</c:if>><a href="infos" style="display: <c:choose> <c:when test="${sessionScope.isConnected}">block</c:when> <c:otherwise>none</c:otherwise> </c:choose>">MES INFOS</a> </li>
				<li class=""><a href="deconnexion" style="display:<c:choose> <c:when test="${sessionScope.isConnected}">block</c:when> <c:otherwise>none</c:otherwise> </c:choose>">DECONNEXION</a> </li>
		   </ul>
	   </div>
     </div>
 </nav>
 <div class="modal fade text-center" id="solde">
	<div class="modal-dialog">
		<div class="modal-content">
		</div>
	</div>
 </div>