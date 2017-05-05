var tablaElementos = document.getElementById('tabla-elementos');

var txtPregunta = document.getElementById('Pregunta');
var txtRespuesta1 = document.getElementById('Respuesta1');
var txtRespuesta2 = document.getElementById('Respuesta2');
var txtRespuesta3 = document.getElementById('Respuesta3');

var btnAgregar = document.getElementById('agregar');

var Pregunta1 = new Object();
Pregunta1.Pregunta = 'Pregunta 1';
Pregunta1.opcion1 = '1';
Pregunta1.opcion2 = '2';
Pregunta1.opcioncorrecta = '3';

var Pregunta2 = new Object();
Pregunta2.Pregunta = 'Pregunta 2';
Pregunta2.opcion1 = '4';
Pregunta2.opcion2 = '5';
Pregunta2.opcioncorrecta = '6';

var Pregunta3 = new Object();
Pregunta3.Pregunta = 'Pregunta 3';
Pregunta3.opcion1 = '7';
Pregunta3.opcion2 = '8';
Pregunta3.opcioncorrecta = '9';

var Pregunta4 = new Object();
Pregunta4.Pregunta = 'Pregunta 4';
Pregunta4.opcion1 = '10';
Pregunta4.opcion2 = '11';
Pregunta4.opcioncorrecta = "12";

var Preguntas = [Pregunta1, Pregunta2, Pregunta3, Pregunta4];

function btnAgregar_Click(event) {

    for (var i = 0; i < Preguntas.length; i++) {

        var elemento = Preguntas[i];

        var tr = document.createElement('tr');
        var td1 = document.createElement('td');
        var td2 = document.createElement('td');
        var td3 = document.createElement('td');
        var td4 = document.createElement('td');

        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);

        td1.textContent = elemento.Pregunta;
        td2.textContent = elemento.opcion1;
        td3.textContent = elemento.opcion2;
        td4.textContent = elemento.opcioncorrecta;

        tablaElementos.appendChild(tr);
    }
};

btnAgregar.addEventListener('click', btnAgregar_Click);
