package logicaDeVista;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import logicaDeNegocios.Complete;
import logicaDeNegocios.Curso;
import logicaDeNegocios.Desarrollo;
import logicaDeNegocios.Estudiante;
import logicaDeNegocios.Evaluacion;
import logicaDeNegocios.MarqueConX;
import logicaDeNegocios.Pregunta;
import logicaDeNegocios.Profesor;
import logicaIntegracion.GestionDatosBD;


/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/controlVista")
public class controlVista extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Pregunta> Preguntas =new ArrayList<Pregunta>();
	private GestionDatosBD validacion = new GestionDatosBD();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		String tipoFuncion = request.getParameter("tipoFuncion");

		if (tipoFuncion.equals("logIn")) {
			procedimientoIniciarSesion(request, response);
		} else if (tipoFuncion.equals("RegistrarEstudiantes")) {
			registrarEstudiantes(request, response);
		} else if (tipoFuncion.equals("RegistrarProfesor")) {
			registrarProfesor(request, response);
		} else if (tipoFuncion.equals("IniciarEvaluacion")) {
			iniciarEvaluacion(request, response);
		} else if (tipoFuncion.equals("RegistrarCurso")) {
			RegistrarCurso(request, response);
		} else if (tipoFuncion.equals("cargarCursos")) {
			cargarCursos(request, response);
		}
		else if (tipoFuncion.equals("eliminarCurso")) {
			eliminarCurso(request, response);
		}
		else if (tipoFuncion.equals("RegistrarEvaluacion")) {
			RegistrarEvaluacion(request, response);
		}
		else if (tipoFuncion.equals("agregarPregunta")) {
			agregarPregunta(request, response);
		}
	}

	private void agregarPregunta(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void RegistrarEvaluacion(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String tipo = request.getParameter("tipo");
		String descripcion = request.getParameter("descripcion");
		double puntaje = Double.valueOf(request.getParameter("puntaje"));
		double porcentaje = Double.valueOf(request.getParameter("porcentaje"));
		//Date fechaEvaluacion = request.getParameter("fechaEvaluacion");
		int TiempoEvaluacion = Integer.valueOf(request.getParameter("TiempoEvaluacion"));
		
		//Evaluacion evaluacion = new Evaluacion(puntaje,porcentaje,tipo,fechaEvaluacion,TiempoEvaluacion);
	}

	private void eliminarCurso(HttpServletRequest request, HttpServletResponse response) {
		String codigo = request.getParameter("codigo");
		validacion.eliminarCurso(codigo);
		
	}

	private void cargarCursos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		PrintWriter out;
		
		Gson gson3 = new Gson();
		String jsonString;
		jsonString = gson3.toJson(validacion.listaCursos());
		out = response.getWriter();
		out.println(jsonString);
		
		
		

	}

	private void RegistrarCurso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String codigo = request.getParameter("codigo");
		String descripcion = request.getParameter("descripcion");

		Curso curso = new Curso(codigo, descripcion);
		PrintWriter out;

		try {
			out = response.getWriter();
			out.println(validacion.registrarCurso(curso));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void registrarProfesor(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String fNacimiento = request.getParameter("fNacimiento");
		String pApellido = request.getParameter("pApellido");
		String sApellido = request.getParameter("sApellido");

		Profesor profesor = new Profesor(id, fNacimiento, pApellido, sApellido, nombre, email);

		PrintWriter out;
		try {
			out = response.getWriter();
			try {
				out.println(validacion.registrarProfesor(profesor));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void registrarEstudiantes(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String numeroIdentificacion = request.getParameter("numeroIdentificacion");
		int numeroCarnet = Integer.valueOf(request.getParameter("numeroCarnet"));
		String fNacimiento = request.getParameter("fNacimiento");
		String pApellido = request.getParameter("pApellido");
		String sApellido = request.getParameter("sApellido");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Estudiante newUser = new Estudiante(numeroIdentificacion, numeroCarnet, fNacimiento, pApellido, sApellido,
				nombre, email, password);

		PrintWriter out;
		try {
			out = response.getWriter();
			try {
				out.println(validacion.registrarEstudiante(newUser));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void procedimientoIniciarSesion(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("user");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();
		// envia el resultado a la variable result del la funcion del javascrip

		try {
			out.println(validacion.verificacionUsuario(email, password));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void iniciarEvaluacion(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
			// TODO Auto-generated method stub
			ArrayList<String> b = new ArrayList();
			b.add("Bajo los precios de sus exportaciones.");
			b.add("Dejó de pagar su deuda externa.");
			b.add("Era el gran acreedor mundial.");
			ArrayList<String> a = new ArrayList();
			a.add("Dirigirse a un mercado reducido y local.");
			a.add("La existencia de grandes bancos de peces.");
			a.add("Satisfacer la demanda de productos en el nivel internacional.");
			Pregunta p1 = new MarqueConX("La práctica de la pesca artesanal se caracteriza por:", "El empleo de barcos de gran tonelaje.", a);
			Pregunta p2 = new MarqueConX("La Crisis económica de 1929, se inició en Estados Unidos, pero pronto alcanzó repercusiones mundiales por que este país:", "Redujo los intereses a los préstamos internacionales.", b);
			Pregunta p3 = new Complete("Mencione un problema socioeconómico de la Región Pacífico Central", "Potasio");
			Pregunta p4 = new Complete("Para enfrentar la crisis de la economía agroexportadora en Costa Rica, la administración González Flores (1914-1917) decidió.", "Hierro");
			Pregunta p5 = new Desarrollo("Defina el	concepto de biodiversidad.", "Stuffing stuff");
			ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
			preguntas.add(p1);
			preguntas.add(p2);
			preguntas.add(p3);
			preguntas.add(p4);
			preguntas.add(p5);
			Date fecha1 = new Date(82,4,1,10,30,15);
			Gson gson = new Gson();
			String json = gson.toJson(new Evaluacion(100, 30, "stuff", fecha1, 15, preguntas));
			PrintWriter out = response.getWriter();
			out.println(json);
	}
}

