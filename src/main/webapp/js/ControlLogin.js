window.onload=onSignIn;
//window.onload=

$(document).ready(function(){
		$('#logIn').click(function(){
			var user = $('#inputEmail').val();
			var password = $('#inputPassword').val();
			var tipo;
			if( $('.admi').prop('checked') ) {
			    tipo="admi";
			    alert(Correcto);
			}
			if( $('.estu').prop('checked') ) {
				tipo="estu";
			}
			
			$.ajax({
				type:'POST',
				data: {user: user,password:password,tipo:tipo, tipoFuncion:"logIn"},
				url:'controlVista',
				success: function(resultado){
					if(resultado!=null){
						window.location = ("homeAdmi.html"); 
					}
					else{
						alert("Inicio de sesion erroneo!"); 
					}
				}
			});
		});
	});


$(document).ready(function(){
	$('#logIn').click(function(){
		var user = $('#inputEmail').val();
		var password = $('#inputPassword').val();
		var tipo;
		if( $('.admi').prop('checked') ) {
		    tipo="admi";
		    alert(Correcto);
		}
		if( $('.estu').prop('checked') ) {
			tipo="estu";
		}
		
		$.ajax({
			type:'POST',
			data: {user: user,password:password,tipo:tipo, tipoFuncion:"logIn"},
			url:'controlVista',
			success: function(resultado){
				if(resultado!=null){
					window.location = ("homeAdmi.html"); 
				}
				else{
					alert("Inicio de sesion erroneo!"); 
				}
			}
		});
	});
});




function onSignIn(googleUser) {
    // Useful data for your client-side scripts:
    var profile = googleUser.getBasicProfile();

    var apellidos =(profile.getFamilyName()).split(" ");
    $.ajax({
		type:'POST',
		data: {id: profile.getId(),nombre:profile.getGivenName(),fNacimiento:null,email:profile.getEmail(),pApellido:apellidos[0],sApellido:apellidos[1], tipoFuncion:"RegistrarProfesor"},
		url:'controlVista',
		success: function(resultado){
			if(resultado!=null){
				window.location = ("homeAdmi.html"); 
			}
			else{
				alert("NO entra a la funcion"); 
			}
		}
	});
    // The ID token you need to pass to your backend:
    var id_token = googleUser.getAuthResponse().id_token;
    console.log("ID Token: " + id_token);
  };
  
  function signOut() {
	    var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signOut().then(function () {
	      console.log('User signed out.');
	    });
	  };
