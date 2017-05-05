package logicaDeNegocios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@SuppressWarnings("serial")
public class Curso implements Serializable{
	private String id;
	private HashMap<String, ArrayList<String>> temaSubtema = new HashMap<String, ArrayList<String>>();
	private String nombre;
	private String descripcion;
    //private ArrayList<Evaluacion> evaluaciones = new ArrayList<Evaluacion>(); 
	
	public Curso(String pId, String pDescripcion){
		setId(pId);
		setDescripcion(pDescripcion);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<String> getTemas() {
		ArrayList<String> temas = new ArrayList<String>();
		Set<String> keys = temaSubtema.keySet();
		for(String key: keys){
			temas.add(key);
		}
		return temas;
	}
	public void setTema(String tema) {
		ArrayList<String> subtemas = new ArrayList<String>();
		temaSubtema.put(tema, subtemas);
	}
	
	public ArrayList<String> getSubtemas(String tema) {
		return temaSubtema.get(tema);
	}
	
	public void setSubtema(String tema, String subtema) {
		ArrayList<String> subtemas = temaSubtema.get(tema);
		subtemas.add(subtema);
		temaSubtema.put(tema, subtemas);
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
