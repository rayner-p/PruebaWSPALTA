package ec.edu.ups.g1.prueba.EvaluacionWSPALTA.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Produces;

import ec.edu.ups.g1.prueba.EvaluacionWSPALTA.modelo.Persona;
import ec.edu.ups.g1.prueba.EvaluacionWSPALTA.modelo.Titulos;
import ec.edu.ups.g1.prueba.EvaluacionWSPALTA.negocio.GestionTituloLOCAL;

@WebService
public class ClienteServicioSOAP {
	@Inject
	private GestionTituloLOCAL on;
	private Titulos titu;
	private List<Titulos> c;
	private List<Persona> p;
	private Date fechaA;

	@WebMethod
	public void registrarTitulo(String cedula, String nombreTitulo, String universidad) throws Exception {
		p = new ArrayList<Persona>();
		fechaA = new Date();
		titu = new Titulos();
		Persona cl = on.buscarPersona(cedula); 
		if (cl == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Message",
					"No existe cliente con este número de cédula" + cedula);

			System.out.println("No existe cliente con ese numero");
		} else if (on.validadorDeCedula(cedula) == false) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message",
					"Ingrese un número de cédula correcto" + cedula);
		} else {
			p.add(cl);
			try {
				titu.setCodigoAlfa(on.generarCodigoLibro());
				titu.setFecha(fechaA);
				titu.setNombre(nombreTitulo);
				titu.setUniversidad(universidad);
				titu.setNumero_cuenta_fk(cl.getCedula());
				titu.setCuenta_fk(p);
				System.out.println("guardado"+titu.getCuenta_fk());
				on.registrarTitulo(titu);
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message",
						"Titulo Creado...Código único" + " " + titu.getCodigoAlfa());

			} catch (Exception e) {
				throw new Exception("Se ah producido un error" + e.getMessage());
			}
		}
	}

	@WebMethod
	public List<Titulos> obtenerTituLOS(String cedula) throws Exception {
		c = new ArrayList<Titulos>();
		try {
			if (on.validadorDeCedula(cedula) == false) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message",
						"Ingrese un número de cédula correcto" + cedula);
			} else {
				c = on.obtenerTitulos(cedula);
				for (Titulos titulos : c) {
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Message",
							"El código único del título es: " + " " + titulos.getCodigoAlfa());
				}
			}
		} catch (Exception e) {
			throw new Exception("Se ah producido un error" + e.getMessage());
		}
		return c;
	}
	
	
}
