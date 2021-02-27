package ec.edu.ups.g1.prueba.EvaluacionWSPALTA.negocio;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.g1.prueba.EvaluacionWSPALTA.modelo.Persona;
import ec.edu.ups.g1.prueba.EvaluacionWSPALTA.modelo.Titulos;

@Local
public interface GestionTituloLOCAL {
	public void registrarTitulo(Titulos titulo);
	public String generarCodigoLibro();
	public Persona buscarPersona(String cedulaCliente);
	public List<Titulos> obtenerTitulos(String cedula) ;
	public boolean validadorDeCedula(String cedula) throws Exception ;

}
