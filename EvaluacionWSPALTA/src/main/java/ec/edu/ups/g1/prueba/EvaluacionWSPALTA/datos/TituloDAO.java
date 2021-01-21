package ec.edu.ups.g1.prueba.EvaluacionWSPALTA.datos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.g1.prueba.EvaluacionWSPALTA.modelo.Persona;
import ec.edu.ups.g1.prueba.EvaluacionWSPALTA.modelo.Titulos;
@Stateless
public class TituloDAO {
	@Inject
	private Connection con;

	@Inject
	private EntityManager em;

	public boolean insert(Titulos persona) throws SQLException {
		em.persist(persona);
		return true;
	}

	public List<Titulos> getPersona() {

		String jpql = "SELECT c FROM Persona c";
		Query q = em.createQuery(jpql, Titulos.class);
		List<Titulos> listado = q.getResultList();
		System.out.println("ESTO ES DEL DAO CLIENTE LISTAR" + listado);
		return listado;
	}
	
	public List<Titulos> obtenerTitulos(String cedu) {
		System.out.println("entra a cedua" + cedu);
		String jpql = "SELECT p, c FROM Titulos c, Persona p WHERE c.cuenta_fk = :cedulaCliente";
		Query q = em.createQuery(jpql, Persona.class);
		q.setParameter("cedulaCliente", cedu);
		@SuppressWarnings("unchecked")
		List<Titulos> pers = (List<Titulos>) q.getSingleResult();
		return pers;
	}

}
