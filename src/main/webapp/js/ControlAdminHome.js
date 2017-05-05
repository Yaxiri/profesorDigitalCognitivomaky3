var tablaElementos = document.getElementById('tablaCursos');

$(document).ready(function(){
	$("#tipoPregunta").change(function(){
			var seleccion = $('select[id=tipoPregunta]').val();
			
			if(seleccion =="marqueX"){
				document.getElementById("MarqueX").style.display='block';
				document.getElementById("RespuestaCorta").style.display='none';
				document.getElementById("Desarrollo").style.display='none';
			}
			else if(seleccion == "complete"){
				document.getElementById("RespuestaCorta").style.display='block';
				document.getElementById("Desarrollo").style.display='none';
				document.getElementById("MarqueX").style.display='none';
			}
			else if(seleccion=="desarrollo"){
				document.getElementById("Desarrollo").style.display='block';
				document.getElementById("MarqueX").style.display='none';
				document.getElementById("RespuestaCorta").style.display='none';
			}
	});
});

$(document).ready(function(){
	$("#RegistrarPregunta").change(function(){
			var seleccion = $('select[id=tipoPregunta]').val();
			
			if(seleccion =="marqueX"){
				var pregunta = $('#eliminarCurso').val();
				var respuesta1 = $('#eliminarCurso').val();
				var respuesta2 = $('#eliminarCurso').val();
				var respuesta3 = $('#eliminarCurso').val();
				var respuesta4 = $('#eliminarCurso').val();
				$.ajax({
					type:'POST',
					data: {pregunta: pregunta,respuesta:respuesta ,tipoFuncion:"RegistrarEstudiantes"},
					url:'controlVista',
					success: function(resultado){
						alert("Registro exitoso!");
					}
				});
			}
			else if(seleccion == "complete"){
				var pregunta = $('preguntaRespuestaCorta').val();
				var respuesta = $('RespuestaCortaR').val();
				$.ajax({
					type:'POST',
					data: {pregunta: pregunta,respuesta:respuesta ,tipoFuncion:"RegistrarEstudiantes"},
					url:'controlVista',
					success: function(resultado){
						alert("Registro exitoso!");
					}
				});
			}
			else if(seleccion=="desarrollo"){
				var pregunta = $('#preguntaDesarrollo').val();
				var respuesta = $('#RespuestaDesarrollo').val();
				$.ajax({
					type:'POST',
					data: {pregunta: pregunta,respuesta:respuesta ,tipoFuncion:"RegistrarEstudiantes"},
					url:'controlVista',
					success: function(resultado){
						alert("Registro exitoso!");
					}
				});
			}
	});
});

$(document).ready(function(){
	$('#RegistrarEstudiantes').click(function(){
		var numeroIdentificacion = $('#numIdentificacion').val();
		var numeroCarnet = $('#numCarnet').val();
		var fNacimiento = $('#fNacimiento').val();
		var pApellido = $('#pApellido').val();
		var sApellido = $('#sApellido').val();
		var nombre = $('#nombre').val();
		var email = $('#email').val();
		var password = $('#password').val();
		
		if(numeroIdentificacion.equals("") || numeroIdentificacion == null || numeroIdentificacion == ""){
			$('warningIdentificacion').style.display="visible";
			$('warningIdentificacion').innerHTML ="***No ha ingresado la identificacion";
			return;
		}
		if(numeroCarnet.equals("")){
			$('#warningCarnet').style.display="visible";
			$('#warningCarnet').innerHTML ="***No ha ingresado el carnet";
			return;
		}
		if(fNacimiento.equals("")){
			$('#warningFNacimiento').style.display="visible";
			$('#warningFNacimiento').innerHTML ="***No ha ingresado la fecha de nacimiento";
			return;
		}
		if(pApellido.equals("")){
			$('#warningpApellido').style.display="visible";
			$('#warningpApellido').innerHTML ="***No ha ingresado la primer Apellido";
			return;
		}
		if(sApellido.equals("")){
			$('#warningsApellido').style.display="visible";
			$('#warningsApellido').innerHTML ="***No ha ingresado la segundo Apellido";
			return;
		}
		if(nombre.equals("")){
			$('#warningNombre').style.display="visible";
			$('#warningNombre').innerHTML ="***No ha ingresado la Nombre";
			return;
		}
		if(email.equals("")){
			$('#warningEmail').style.display="visible";
			$('#warningEmail').innerHTML ="***No ha ingresado la Email";
			return;
		}
		if(password.equals("")){
			$('#warningPassword').style.display="visible";
			$('#warningPassword').innerHTML ="***No ha ingresado la Contraseña";
			return;
		}
		
		$.ajax({
			type:'POST',
			data: {numeroIdentificacion: numeroIdentificacion,numeroCarnet:numeroCarnet,fNacimiento: fNacimiento,pApellido:pApellido,sApellido: sApellido,nombre:nombre,email: email,password:password ,tipoFuncion:"RegistrarEstudiantes"},
			url:'controlVista',
			success: function(resultado){
				alert("Registro exitoso!");
			}
		});
	});
});


$(document).ready(function(){
	$('#RegistrarCurso').click(function(){
		var codigo = $('#CodigoCurso').val();
		var descripcion = $('#DescripcionCurso').val();

		/**
		if(codigo.equals("") || numeroIdentificacion == null || numeroIdentificacion == ""){
			$('warningIdentificacion').style.display="visible";
			$('warningIdentificacion').innerHTML ="***No ha ingresado la identificacion";
			return;
		}
		if(descripcion.equals("")){
			$('#warningCarnet').style.display="visible";
			$('#warningCarnet').innerHTML ="***No ha ingresado el carnet";
			return;
		}*/
		
		$.ajax({
			type:'POST',
			data: {codigo: codigo,descripcion:descripcion ,tipoFuncion:"RegistrarCurso"},
			url:'controlVista',
			success: function(resultado){
				alert(resultado);
			}
		});
	});
});

$(document).ready(function(){
	$('#EliminarCurso').click(function(){
		var codigo = $('#eliminarCurso').val();
		
		$.ajax({
			type:'POST',
			data: {codigo: codigo,tipoFuncion:"eliminarCurso"},
			url:'controlVista',
			success: function(resultado){
				alert(resultado);
			}
		});
	});
});

$(document).ready(function(){
	$('#RegistrarEvaluacion').click(function(){
		var tipo = $('select[id=tipoEvaluacion]').val();
		var descripcion = $('#DescripcionEvaluacion').val();
		var puntaje = $('#puntajeTotalEvaluacion').val();
		var porcentaje = $('#PorcentajeTotalEvaluacion').val();
		var fecha = $('#fechaEvaluacion').val();
		var tiempo = $('#TiempoEvaluacion').val();
		
		$.ajax({
			type:'POST',
			data: {tipo: tipo,descripcion: descripcion,puntaje: puntaje,porcentaje: porcentaje,fecha: fecha,tiempo: tiempo,tipoFuncion:"RegistrarEvaluacion"},
			url:'controlVista',
			success: function(resultado){
				alert(resultado);
			}
		});
	});
});

function mostrarCursos(){
	 
		$.ajax({
			type:'POST',
			data: {tipoFuncion:"cargarCursos"},
			url:'controlVista',
			success: function(resultado){
				$("#tablaCursos").empty();
				
	            var trColumna = document.createElement('tr');
	            var td1Columna = document.createElement('td');
	            var td2Columna = document.createElement('td');
	        	
	        	trColumna.appendChild(td1Columna);
	            trColumna.appendChild(td2Columna);


	            td1Columna.textContent = "Codigo";
	            td2Columna.textContent = "Descripcion";

	            
	            tablaElementos.appendChild(trColumna);
	            
	            
	            
	            
	            var objeto = JSON.parse(resultado);
	            
	            for (var i = 0; i < objeto.length; i++) {
		        var elemento = objeto[i];
		        	
					var tr = document.createElement('tr');
		            var td1 = document.createElement('td');
		            var td2 = document.createElement('td');
		        	
		        	tr.appendChild(td1);
		            tr.appendChild(td2);


		            td1.textContent = elemento.id;
		            td2.textContent = elemento.descripcion;

		            
		            tablaElementos.appendChild(tr);
	            }
				
			}
		});
}
function mostrarCursosT(){
	 
	$.ajax({
		type:'POST',
		data: {tipoFuncion:"cargarCursos"},
		url:'controlVista',
		success: function(resultado){
			$("#tablaCursos").empty();
			
            var trColumna = document.createElement('tr');
            var td1Columna = document.createElement('td');
            var td2Columna = document.createElement('td');
        	
        	trColumna.appendChild(td1Columna);
            trColumna.appendChild(td2Columna);


            td1Columna.textContent = "Codigo";
            td2Columna.textContent = "Descripcion";

            tablaElementos2.appendChild(trColumna);
            
            
            
            
            var objeto = JSON.parse(resultado);
            
            for (var i = 0; i < objeto.length; i++) {
	        var elemento = objeto[i];
	        	
				var tr = document.createElement('tr');
	            var td1 = document.createElement('td');
	            var td2 = document.createElement('td');
	            var btn = document.createElement('button');
	        	
	        	tr.appendChild(td1);
	            tr.appendChild(td2);
	            tr.appendChild(btn);


	            td1.textContent = elemento.id;
	            td2.textContent = elemento.descripcion;
	            btn.textContent = "agregar";

	            tablaElementos2.appendChild(tr);
            }
			
		}
	});
}
