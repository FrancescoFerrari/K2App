var codice = "";
$( document ).ready(function() {
  // Handler for .ready() called.
	
	$('select#regioni').on('change', function() {
		  alert( "value=" + this.value + ", key=" + this.key);
	});
	$('select#provincie').on('change', function() {
		  alert( "value=" + this.value + ", key=" + this.key);
	})
	$('select#comuni').on('change', function() {
		  alert( "value=" + this.value + ", key=" + this.key);
	})
});


$.ajax({ 
   type: "GET",
   dataType: "",
   url: "http://localhost:8080/K2App-0.0.1/rest/code/"+codice,
   success: function(data){        
     alert(data);
   }
});

// error: function(xhr, textStatus, errorThrown) {   alert(xhr.responseText);  }
