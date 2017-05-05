package logicaDeNegocios;
import java.util.*;
public class MarqueConX extends Pregunta{
	private String descripcion;
	private ArrayList<String>posiblesRespuestas;
	private String respuestaCorrecta;
	
	public MarqueConX(){
		
	}
	public MarqueConX(String pDescripcion, String pRespuesta, ArrayList<String>pPosiblesRespuestas){
		setRespuestaCorrecta(pRespuesta);
		setDescripcion(pDescripcion);
		posiblesRespuestas = pPosiblesRespuestas;
		tipo = "marqueconx";
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}
	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}
}
