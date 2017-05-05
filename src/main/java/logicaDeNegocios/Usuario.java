package logicaDeNegocios;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Usuario implements Serializable{
	protected String id;
	protected String fechaNacimiento;
	protected String primerApellido;
	protected String segundoApellido;
	protected String nombre;
	protected String correo;
	protected String password;
	protected ArrayList<Curso> cursos=new ArrayList<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public ArrayList<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Curso curso) {
		cursos.add(curso);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
