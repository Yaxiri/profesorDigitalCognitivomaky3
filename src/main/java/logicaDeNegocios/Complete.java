package logicaDeNegocios;

public class Complete extends Pregunta{
	private String descripcionPregunta;
	private String descripcionRespuesta;
	
	public Complete(String pPregunta, String pRespuesta){
		setDescripcionPregunta(pPregunta);
		setDescripcionRespuesta(pRespuesta);
		tipo = "complete";
	}
	public Complete(){
		
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
