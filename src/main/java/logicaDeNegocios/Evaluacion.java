package logicaDeNegocios;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;
public class Evaluacion {
	private double nota;
	private double puntajeTotal;
	private double porcentaje;
	private String tipoEvaluacion;
	private Date fecha;
	private ArrayList<Pregunta>preguntas;
	private int minutosMaximos;
	
	public Evaluacion(double pPuntajeTotal,double pPorcentaje, String pTipoEvaluacion, Date pFecha, int pMinutosMaximos, ArrayList<Pregunta> pPreguntas){
		puntajeTotal=pPuntajeTotal;
		porcentaje=pPorcentaje;
		tipoEvaluacion=pTipoEvaluacion;
		fecha=pFecha;
		minutosMaximos = pMinutosMaximos;
		preguntas = pPreguntas;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public double getPuntajeTotal() {
		return puntajeTotal;
	}
	public void setPuntajeTotal(double puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}
	public double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public String getTipoEvaluacion() {
		return tipoEvaluacion;
	}
	public void setTipoEvaluacion(String tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getMinutosMaximos() {
		return minutosMaximos;
	}
	public void setMinutosMaximos(int minutosMaximos) {
		this.minutosMaximos = minutosMaximos;
	}
	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(ArrayList<Pregunta> pPreguntas) {
		this.preguntas = pPreguntas;
	}
	
	public static void main( String[] args ) throws IOException
    {
		ArrayList<String> a = new ArrayList();
		a.add("Incorrecta");
		a.add("a");
		Pregunta p1 = new MarqueConX("Pregunta 1", "1", a);
		Pregunta p2 = new MarqueConX("Pregunta 2", "2", a);
		Pregunta p3 = new Complete("Pregunta 3 C", "Potasio");
		Pregunta p4 = new Complete("Pregunta 4 C", "Hierro");
		Pregunta p5 = new Desarrollo("Pregunta 5 D", "Stuffing stuff");
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
		preguntas.add(p1);
		preguntas.add(p2);
		preguntas.add(p3);
		preguntas.add(p4);
		preguntas.add(p5);
		Gson gson = new Gson();
		Date fecha1 = new Date(82,4,1,10,30,15);
		String json = gson.toJson(new Evaluacion(100, 30, "stuff", fecha1, 15, preguntas));
		System.out.println(json);
		FileWriter file = new FileWriter("prueba.json");
		file.write(json);
		file.flush();
		file.close();
    }
}

