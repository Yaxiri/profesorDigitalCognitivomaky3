package logicaDeNegocios;

import java.io.Serializable;

public class Profesor extends Usuario implements Serializable{
	private String gradoAcademico;
	public Profesor(String pId, String pFechaNacimiento, String pApellido1, String pApellido2, String pNombre, String pCorreo){
		setId(pId);
		setFechaNacimiento(pFechaNacimiento);
		setPrimerApellido(pApellido1);
		setSegundoApellido(pApellido2);
		setNombre(pNombre);
		setCorreo(pCorreo);

	
		
	}
	@SuppressWarnings("unused")
	private String getGradoAcademico() {
		return gradoAcademico;
	}
	@SuppressWarnings("unused")
	private void setGradoAcademico(String gradoAcademico) {
		this.gradoAcademico = gradoAcademico;
	}
}
