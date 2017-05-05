package logicaIntegracion;


import java.sql.SQLException;
import java.util.ArrayList;

import logicaAccesoADatos.conexion;
import logicaDeNegocios.Curso;
import logicaDeNegocios.Estudiante;
import logicaDeNegocios.Profesor;
import logicaDeNegocios.Usuario;

public class GestionDatosBD {
	private conexion conexion= new conexion();
	
	@SuppressWarnings("static-access")
	public ArrayList<Curso> listaCursos(){
			ArrayList<Curso> cursos = new ArrayList<Curso>();
			try {
				ArrayList<String> ids = conexion.obtenerIdCursos(conexion.conexionDB());
				for(int i=0;i<ids.size();i++){
					Curso curso = (Curso) conexion.deSerializeJavaObjectFromDBCurso(conexion.conexionDB(),ids.get(i));
					System.out.println(curso.getId());
					cursos.add(curso);
				}
				return cursos;
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return cursos;
			
		}
	public void eliminarCurso(String curso){
		try {
			conexion.eliminarCurso(conexion.conexionDB(), curso);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int verificacionUsuario(String email, String password) throws ClassNotFoundException, SQLException {
		Usuario user = (Usuario) conexion.deSerializeJavaObjectFromDB(conexion.conexionDB(),email);
		if(user!=null){
			if(user.getCorreo().equals(password)){
				return 0;
			}
			if(user.getId().equals(password)){
				return 1;
				
			}
			else {
				return 9;
			}
		}
	return 404;
	}
	
	
	public int verificacionCurso(String id) throws ClassNotFoundException, SQLException {
		Curso curso = (Curso) conexion.deSerializeJavaObjectFromDBCurso(conexion.conexionDB(),id);
		if(curso!=null){
			return 1;
		}
	return 404;
	}

	@SuppressWarnings("static-access")
	public String registrarProfesor(Profesor profesor) throws ClassNotFoundException, SQLException {
		if (verificacionUsuario(profesor.getCorreo(), profesor.getId())==1) {
			return profesor.getId();
		}
		if (verificacionUsuario(profesor.getCorreo(), profesor.getPassword())==0) {
			return profesor.getId();
		}
		if (verificacionUsuario(profesor.getCorreo(), profesor.getPassword())==404 && verificacionUsuario(profesor.getCorreo(), profesor.getId())==404) {
			conexion.serializeJavaObjectToDB(conexion.conexionDB(), profesor.getId(), profesor);
			return profesor.getId();
		}
		return null;
	}

	@SuppressWarnings("static-access")
	public String registrarEstudiante(Estudiante estudiante) throws ClassNotFoundException, SQLException {
		if (verificacionUsuario(estudiante.getCorreo(), estudiante.getPassword())==0) {
			return "Usuario registrado con ese correo";
		}
		if (verificacionUsuario(estudiante.getCorreo(), estudiante.getPassword())==1) {
			return "Usuario registrado con ese correo";
		}
		if (verificacionUsuario(estudiante.getCorreo(), estudiante.getPassword())==9) {
			return "Usuario registrado con ese correo";
		}
		conexion.serializeJavaObjectToDB(conexion.conexionDB(), estudiante.getId(), estudiante);
		return "Registro Correcto!";
	}
	
	
	@SuppressWarnings("static-access")
	public String registrarCurso(Curso curso) throws ClassNotFoundException, SQLException {
		if (verificacionCurso(curso.getId())==1) {
			return "Curso registrado con ese id";
		}
		conexion.serializeJavaObjectToDBCurso(conexion.conexionDB(), curso.getId(), curso);
		return "Registro Correcto!";
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		conexion conexion= new conexion();
		
		GestionDatosBD log = new GestionDatosBD();
		Curso curso = new Curso("123", "JODIENDO ESTUDIANTES");
		System.out.println(log.registrarCurso(curso));
		
		
		System.out.println(conexion.obtenerIdCursos(conexion.conexionDB()));
	}

}
