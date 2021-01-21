package ec.edu.ups.g1.prueba.EvaluacionWSPALTA.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private Date fechaA;
	
	@WebMethod
	public void registrarTitulo(String cedula,String nombreTitulo, String universidad) throws Exception {
		fechaA = new Date();
		titu = new Titulos();
		Persona cl = on.buscarPersona(cedula);
		if (cl == null) {
			System.out.println("No existe cliente con ese numero");
		}else {
			try {
				titu.setCodigoAlfa(on.generarCodigoLibro());
				titu.setFecha(fechaA);
				titu.setNombre(nombreTitulo);
				titu.setUniversidad(universidad);
				titu.setCuenta_fk(cedula);
				on.registrarTitulo(titu);
			}catch (Exception e) {
				throw new Exception("Se ah producido un error"+e.getMessage());
			}
		}
	}

	@WebMethod
	public List<Titulos> obtenerTituLOS(String cedula) throws Exception {
		c = new ArrayList<Titulos>();
		try {
			c = on.obtenerTitulos(cedula);
		}catch (Exception e) {
			throw new Exception("Se ah producido un error"+e.getMessage());
		}
		return c;
	}

}
