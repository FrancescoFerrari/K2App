<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>K2-App</title>

 <!-- Bootstrap core CSS -->
   

     <style type="text/css">
      <!-- Custom fonts for this template -->
       
       <%@ include file="../template/vendor/bootstrap/css/bootstrap.min.css" %>    
       <%@ include file="../template/vendor/font-awesome/css/font-awesome.css" %>
       <%@ include file="../template/css/grayscale.css"%>

     </style>
     
     <style type="text/css">
        .error {
	     color: red;
	     font-weight: bold;
        }
</style>


    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Cabin:700' rel='stylesheet' type='text/css'>



  </head>


<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="${pageContext.request.contextPath}/home">Home</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<!-- <li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#about">About</a></li> -->
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#contact">Carica</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="${pageContext.request.contextPath}/show">Visualizza</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Intro Header -->
	<header class="masthead">
		<div class="intro-body">
			<div class="container">
				<div class="row">
					<div class="col-lg-8 mx-auto">
						<h1 class="brand-heading">Caricamento File</h1>
						<p class="intro-text">
                         Qui è possibile caricare il tuo File	</p>
						<a href="#contact" class="btn btn-circle js-scroll-trigger"> <i
							class="fa fa-angle-double-down animated"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	

	<!-- UploadSection -->
	<section id="contact" class="content-section text-center">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2>Inserisci Il File da Elaborare </h2>
					

					
					
	<div class="container">
		<form method="post" class="form-horizontal" name="submit"
			onsubmit=" return validate()"
			action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">


			<div class="form-group">
			 <br>
				<div>
					<input type="file" id="ISTATLoader" name="ISTATLoader" value="" class="btn btn-default btn-lg">

					<div id="errFile1" style="color: red; font-weight: bold;"></div>
				</div>
			</div>
				
			<ul class="list-inline banner-social-buttons">
			
			<li class="list-inline-item">
			<button type="submit" class="btn btn-default btn-lg">Inserisci
					File</button> 
					</li>
			<li class="list-inline-item"><a class="btn btn-default btn-lg"
				href="${pageContext.request.contextPath}/home">Torna indietro</a>
			
			</li>
			</ul>
				
			
		</form>
	</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Map Section -->
	<div id="map"></div>

	<!-- Footer -->
	<footer>
		<div class="container text-center">
			<p>Copyright &copy; Your Website 2017</p>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="../WEB-INF/template/vendor/jquery/jquery.js"></script>
	<script src="../WEB-INF/template/vendor/popper/popper.js"></script>
	<script src="../WEB-INF/template/vendor/bootstrap/js/bootstrap.js"></script>
	
	

	<!-- Plugin JavaScript -->
	<script src="../WEB-INF/template/vendor/jquery-easing/jquery.easing.js"></script>

	<!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

	<!-- Custom scripts for this template -->
	<script src="${pageContext.request.contextPath}/WEB-INF/template/js/grayscale.js"></script>
	
		<script type="text/javascript">
		function validate() {

			var  ISTATLoader, errFile1;

			ISTATLoader = document.getElementById("ISTATLoader").value;

			document.getElementById("errFile1").innerHTML = "";
			
				if (ISTATLoader == "") {
					errFile = "*Per favore inserire il file con i dati ISTAT sulla popolazione da caricare";
					document.getElementById("errFile1").innerHTML = errFile;
					return false;
				}
			return true;
		}
	</script>

</body>

</html>

