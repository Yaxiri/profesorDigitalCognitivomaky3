package logicaDeNegocios;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Estudiante extends Usuario implements Serializable{
	private int carnet;
	
	public Estudiante(String pId, int pCarnet, String pFechaNacimiento, String pApellido1, String pApellido2, String pNombre, String pCorreo,String password){
		setId(pId);
		setCarnet(pCarnet);
		setFechaNacimiento(pFechaNacimiento);
		setPrimerApellido(pApellido1);
		setSegundoApellido(pApellido2);
		setNombre(pNombre);
		setCorreo(pCorreo);
		setPassword(password);
		
	}
	
	@SuppressWarnings("unused")
	private int getCarnet(){
		return carnet;
	}
	private void setCarnet(int carnet) {
		this.carnet = carnet;
	}
	
}
