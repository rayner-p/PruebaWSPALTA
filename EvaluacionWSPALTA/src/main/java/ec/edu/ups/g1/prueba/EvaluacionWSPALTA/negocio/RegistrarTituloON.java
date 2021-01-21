package ec.edu.ups.g1.prueba.EvaluacionWSPALTA.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.g1.prueba.EvaluacionWSPALTA.datos.PersonaDAO;
import ec.edu.ups.g1.prueba.EvaluacionWSPALTA.datos.TituloDAO;
import ec.edu.ups.g1.prueba.EvaluacionWSPALTA.modelo.Persona;
import ec.edu.ups.g1.prueba.EvaluacionWSPALTA.modelo.Titulos;


@Stateless
public class RegistrarTituloON implements GestionTituloLOCAL{
	private List<Titulos> t;
	private Persona newPersona;
	private Titulos newTitulos;
	@Inject
	private TituloDAO daoTitulo;
	@Inject
	private PersonaDAO daoPersona;

	public RegistrarTituloON() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		newPersona = new Persona();
		newTitulos = new Titulos();
		t = new ArrayList<Titulos>();

	}

	public Persona buscarPersona(String cedulaCliente) {
		System.out.println("entra al buscar cuenta");
		newPersona = daoPersona.getPersona(cedulaCliente);
		System.out.println(newPersona);
		return newPersona;

	}

	public String generarCodigoLibro() {
		String simbolos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefjhijklmnopqrstuvwxyz0123456789!#$%&()*+,-./:;<=>?@_";

		int tam = simbolos.length() - 1;
		System.out.println(tam);
		String clave = "";
		for (int i = 0; i < 10; i++) {
			int v = (int) Math.floor(Math.random() * tam + 1);
			clave += simbolos.charAt(v);
		}

		return clave;
	}

	public void registrarTitulo(Titulos titulo) {
		try {
			System.out.println("QUE TRAE AL ON EL TITULO " + " "+ titulo);
			
			daoTitulo.insert(titulo);
		} catch (SQLException e) {
			System.out.println("Error en registro");
		}		
	}
	public List<Titulos> obtenerTitulos(String cedula){
		
		try {
			t = daoTitulo.obtenerTitulos(cedula);
			System.out.println("listado de titulos de la persona"+t);
		}catch (Exception e) {
			System.err.println("error en el listado de titulos");
		}
		
	
		return t;
	}
}
