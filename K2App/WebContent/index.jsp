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
       
       <%@ include file="../WEB-INF/template/vendor/bootstrap/css/bootstrap.min.css" %>    
       <%@ include file="../WEB-INF/template/vendor/font-awesome/css/font-awesome.css" %>
       <%@ include file="../WEB-INF/template/css/grayscale.css"%>
       
      
     </style>
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Cabin:700' rel='stylesheet' type='text/css'>



  </head>


<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">Home</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#about">About</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#download">Carica</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#contact">Visualizza</a></li>
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
						<h1 class="brand-heading">K2</h1>
						<p class="intro-text">
							Demo del progetto 
						</p>
						<a href="#about" class="btn btn-circle js-scroll-trigger"> <i
							class="fa fa-angle-double-down animated"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- About Section -->
	<section id="about" class="content-section text-center">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2>About </h2>
		
					<p id="fontp">Lorem ipsum .....</p>
				</div>
			</div>
		</div>
	</section>

	<!-- Upload Section -->
	<section id="download"
		class="download-section content-section text-center">
		<div class="container">
			<div class="col-lg-8 mx-auto">
				<h2>Carica Un File </h2>
				<p id="fontp">
				Puoi caricare qui un file da far analizzare, riempiendo una breve form.</p>
				<a href="${pageContext.request.contextPath}/upload"
					class="btn btn-default btn-lg">Carica</a>
			</div>
		</div>
	</section>

	<!-- List Section -->
	<section id="contact" class="content-section text-center">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2>Visualizza I File Caricati</h2>
					
					<ul class="list-inline banner-social-buttons">
						<li class="list-inline-item"><a
							href="${pageContext.request.contextPath}/show"
							class="btn btn-default btn-lg"> <span class="network-name">Mostra</span>
						</a></li>
						<li class="list-inline-item"><a
							href="${pageContext.request.contextPath}/rest/code/{code}"
							class="btn btn-default btn-lg"> 
								<span class="network-name">Opzione2</span>
						</a></li>
						<li class="list-inline-item"><a
							href="https://plus.google.com/+Startbootstrap/posts"
							class="btn btn-default btn-lg">  <span class="network-name">Opzione3</span>
						</a></li>
					</ul>
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

</body>

</html>
