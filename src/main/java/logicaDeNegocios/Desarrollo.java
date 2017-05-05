package logicaDeNegocios;

public class Desarrollo extends Pregunta{
	private String descripcionPregunta;
	private String descripcionRespuesta;
	
	public Desarrollo(String pPregunta, String pRespuesta){
		setDescripcionPregunta(pPregunta);
		setDescripcionRespuesta(pRespuesta);
		tipo = "desarrollo";
	}
	public Desarrollo(){
		
	}
	public String getDescripcionPregunta() {
		return descripcionPregunta;
	}
	public void setDescripcionPregunta(String descripcionPregunta) {
		this.descripcionPregunta = descripcionPregunta;
	}
	public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}
	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}
}
