package ec.edu.ups.g1.prueba.EvaluacionWSPALTA.datos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.g1.prueba.EvaluacionWSPALTA.modelo.Persona;


@Stateless
public class PersonaDAO {
	@Inject
	private Connection con;

	@Inject
	private EntityManager em;

	public boolean insert(Persona persona) throws SQLException {
		em.persist(persona);
		return true;
	}
	

	public Persona getPersona(String cedula) {
		System.out.println("trae cedula al dao" +""+cedula);
		String jpl = "select c from Persona c Where c.cedula =:corr";
		Query q = em.createQuery(jpl, Persona.class);
		q.setParameter("corr", cedula);
		return (Persona)q.getSingleResult();
		
	}
	
	
	
	
}
