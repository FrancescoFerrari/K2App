<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>K2-App</title>

 
<!-- Bootstrap core CSS -->
   
     <style type="text/css">
      <!-- Custom fonts for this template -->
       
       <%@ include file="../template/vendor/bootstrap/css/bootstrap.min.css" %>    
       <%@ include file="../template/vendor/font-awesome/css/font-awesome.css" %>
       <%@ include file="../template/css/grayscale.css"%>
       
     </style>
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Cabin:700' rel='stylesheet' type='text/css'>
    
		<script type="text/javascript">
		var codice = "";
		$( document ).ready(function() {
		  // Handler for .ready() called.
			
			$('select#regioni').on('change', function() {
				//alert( "value=" + this.value);
				//alert( $(this).find(":selected").val() );
				codice = this.value;
				$('select#provincie')
			    .find('option')
			    .remove()
			    .end();
			    //.append('<option value="-">text</option>')
			    //.val('-');
				$('select#comuni')
			    .find('option')
			    .remove()
			    .end();
				callrest (codice, 1, "provincie");
			});
			$('select#provincie').on('change', function() {
				  //alert( "value=" + this.value);
					codice = this.value;
					$('select#comuni')
				    .find('option')
				    .remove()
				    .end();
					callrest (codice, 2, "comuni");
			})
			$('select#comuni').on('change', function() {
				  //alert( "value=" + this.value);
					codice = this.value;
			})

			$("form#elabora").submit(function(e){
				var code = "";
				var regioneSel = $('select#regioni').find(":selected").val();//.text();
				var provinciaSel = $('select#provincie').find(":selected").val();//.text();
				var comuneSel = $('select#comuni').find(":selected").val();//.text();
				if (comuneSel == null){
					if (provinciaSel == null){
						code = regioneSel;
					}
					else {
						code = provinciaSel;
					}
				}
				else {
					code = comuneSel;
				}

				$('input[name="codeSelected"]').val(code);
				alert(('input[name="codeSelected"]').val());
				$(this).submit();
				//return false;
			});
		});

		function callrest (code, tipo, selectId) {
			var restcallurl = "http://localhost:8080/K2App-0.0.1/rest/code/"+code+"/"+tipo;
			var selectObj = "select#"+selectId;
			//alert( "restcallurl="+restcallurl);
			$.ajax({ 
			   type: "GET",
			   headers: {          
				    Accept: "application/json; charset=utf-8",         
				    "Content-Type": "application/json; charset=utf-8"   
				  },
			   dataType: "",
			   url: "http://localhost:8080/K2App-0.0.1/rest/code/"+code+"/"+tipo,
			   success: function(data){       
				 //alert(data);
				 //data = $.parseJSON(data);//già in formato json
			     //alert("inizio");
				 $.each(data, function(i, item) {
				     /*
				     alert(item.nome);
				     alert(item.codice);
				     alert(item.tipo);
				     return false;
					*/
					var keySel = item.codice;
					var textSel = item.nome;
				     $(selectObj)
			         .append($("<option></option>")
			                    .attr("value",keySel)
			                    .text(textSel)); 
				 });
			     //alert("fine");
			   },
			   error: function(xhr, textStatus, errorThrown) {   alert(xhr.responseText);  }
			});
		}
		// error: function(xhr, textStatus, errorThrown) {   alert(xhr.responseText);  }
		</script>


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
		<!-- About Section -->
	<section id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<div class="container-fluid" style="border: solid black 1px">

						<%-- 			<input type="hidden" value="${regione.id }" name="id" /> --%>

						<form id="elabora" method="post" class="form-horizontal"
							name="submit" action="${pageContext.request.contextPath}/elabora">
							<nav>
								<select id="regioni" class="btn btn-default btn-lg">
									<c:forEach var="regione" items="${regioni}">
										<option value="${regione.codice}"> ${regione.nome} </option>

									</c:forEach>
								</select> <select id="provincie" class="btn btn-default btn-lg">
									<c:forEach var="provincia" items="${provincie}">
										<option value=""> </option>

									</c:forEach>
								</select> <select id="comuni" class="btn btn-default btn-lg">
									<c:forEach var="comune" items="${comuni}">
										<option value=""> </option>

									</c:forEach>
								</select>
							</nav>
							<div>
								<nav>
									<input type="hidden"  id="codeSelected" value="${selected}" name="codeSelected" />

									<input type="submit" class="btn btn-default btn-lg"
										value="Elabora" /> 
								
									<a class="btn btn-default btn-lg"
										href="${pageContext.request.contextPath}/home">Torna indietro</a>
								</nav>
							</div>

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

</body>

</html>



