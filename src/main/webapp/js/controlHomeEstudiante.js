var t = 0;
var minutos = 20;

var nombre;
var porcentaje;
var puntajeTotal;
var tipo;
var fecha;

function interval(){
	    setInterval(function(){
	    document.getElementById("testdiv1").innerHTML=":";
	    if (minutos<0){
	    	document.getElementById("testdiv").innerHTML="termino";
	    }
	    else{
	    	document.getElementById("testdiv").innerHTML=t--;
	    	document.getElementById("testdiv2").innerHTML=minutos;
	    	if(t==-1){
	    		t=59;
	    		minutos--;
	    	}
	    }   
    },1000,"JavaScript");
}

function timeout(){
    setTimeout(function(){
        document.getElementById("testdiv").innerHTML="Pasaron 2 segundos antes de que pudieras ver esto.";
    },2000,"JavaScript");
}

var marqueConX = document.getElementById('MarqueConX');
var complete = document.getElementById('Complete');
var desarrollo = document.getElementById('Desarrollo');

var txtPregunta = document.getElementById('Pregunta');
var txtRespuesta1 = document.getElementById('Respuesta1');
var txtRespuesta2 = document.getElementById('Respuesta2');
var txtRespuesta3 = document.getElementById('Respuesta3');

function iniciar() {
	var evaluacion;
	$.ajax({
		type:'POST',
		data: {tipoFuncion:"IniciarEvaluacion"},
		url:'controlVista',
		success: function(resultado){
			evaluacion = resultado;
			console.log(resultado);
			
			var objeto = JSON.parse(evaluacion);
			var preguntas = objeto.preguntas
		    for (var i = 0; i < preguntas.length; i++) {
		        var elemento = preguntas[i];
		        
		        if(elemento.tipo == "marqueconx"){
		        	var cont1 = document.createElement('h4');
		        	var cont2 = document.createElement('label');
		        	var cont3 = document.createElement('label');
		        	var cont4 = document.createElement('label');
		        	var cont5 = document.createElement('label');
		        	var cont6 = document.createElement('label');
		        	var espacio1 = document.createElement('h5');
		        	var espacio2 = document.createElement('h5');
		        	var espacio3 = document.createElement('h5');
		        	var espacio4 = document.createElement('h5');
		        	
		        	cont1.textContent = i+1 + "." + elemento.descripcion;
		        	cont2.textContent = elemento.respuestaCorrecta;
		        	cont3.textContent = elemento.posiblesRespuestas[0];
		        	cont4.textContent = elemento.posiblesRespuestas[1];
		        	cont5.textContent = elemento.posiblesRespuestas[2];
		        	espacio1.textContent = "    ";
		        	espacio2.textContent = "    ";
		        	espacio3.textContent = "    ";
		        	espacio4.textContent = "    ";
		        	
		        	var checkbox1 = document.createElement("input");
		        	checkbox1.type = "checkbox";
		        	checkbox1.id = "Item1";
		        	var checkbox2 = document.createElement("input");
		        	checkbox2.type = "checkbox";
		        	checkbox2.id = "Item2";
		        	var checkbox3 = document.createElement("input");
		        	checkbox3.type = "checkbox";
		        	checkbox3.id = "Item3";
		        	var checkbox4 = document.createElement("input");
		        	checkbox4.type = "checkbox";
		        	checkbox4.id = "Item4";
		        	
		        	marqueConX.appendChild(cont1);
		        	marqueConX.appendChild(checkbox1);
		        	marqueConX.appendChild(cont2);
		        	marqueConX.appendChild(espacio1);
		        	marqueConX.appendChild(checkbox2);
		        	marqueConX.appendChild(cont3);
		        	marqueConX.appendChild(espacio2);
		        	marqueConX.appendChild(checkbox3);
		        	marqueConX.appendChild(cont4);
		        	marqueConX.appendChild(espacio3);
		        	marqueConX.appendChild(checkbox4);
		        	marqueConX.appendChild(cont5);
		        	marqueConX.appendChild(espacio4);
		        }
		        
		        else if (elemento.tipo == "complete"){
		        	var label = document.createElement('h4');
		        	var textA = document.createElement('textarea');
		        	var espacio1 = document.createElement('h5');
		        	
		        	label.textContent = i+1 + "." + elemento.descripcionPregunta;
		        	espacio1.textContent = "    ";
		        	
		        	textA.class="form-control";
		        	textA.rows="1";
		        	
		        	complete.appendChild(label);
		        	complete.appendChild(textA);
		        	complete.appendChild(espacio1);
		        }
		        
		        else{
		        	var label = document.createElement('h4');
		        	var textA = document.createElement('textarea');
		        	var espacio1 = document.createElement('h5');
		        	
		        	label.textContent = i+1 + "." + elemento.descripcionPregunta;
		        	
		        	textA.class="form-control";
		        	textA.rows="4";
		        	textA.style=style="margin: 0px; width: 905px; height: 156px;";
		        	espacio1.textContent = "    ";
		        	
		        	desarrollo.appendChild(label);
		        	desarrollo.appendChild(textA);
		        	desarrollo.appendChild(espacio1);
		        } 
		    }
			interval();
		}
	});
};