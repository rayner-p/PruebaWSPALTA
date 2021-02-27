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
	public boolean validadorDeCedula(String cedula) throws Exception {

		boolean cedulaCorrecta = false;
		System.out.println("INGRESA VALIDACION CEDULA");
		// System.out.println("ESTO CEDULA INGRESADA " + cedula);
		try {
			if (cedula.length() == 10) // ConstantesApp.LongitudCedula
				System.out.println("ESTAS EN EL VALIDADAOR?");
			{
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}
					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			cedulaCorrecta = false;
			throw new Exception("Error cedula  " + err.getMessage());
		}
		if (!cedulaCorrecta) {
			return cedulaCorrecta;
		}
		return cedulaCorrecta;
	}
}
