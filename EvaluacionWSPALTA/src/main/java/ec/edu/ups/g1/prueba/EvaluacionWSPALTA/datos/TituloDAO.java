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
		System.out.println("TRAE AL DAO "+" "+persona);
		em.persist(persona);
		return true;
	}

	public List<Titulos> getPersona() {

		String jpql = "SELECT c FROM Titulos c";
		Query q = em.createQuery(jpql, Titulos.class);
		List<Titulos> listado = q.getResultList();
		System.out.println("ESTO ES DEL DAO CLIENTE LISTAR" + listado);
		return listado;
	}
	
	public List<Titulos> obtenerTitulos(String cedu) {
		System.out.println("entra a cedua" + cedu);
		@SuppressWarnings("unchecked")
		List<Titulos> resultadoCuentas = em.createNativeQuery(
				"SELECT * FROM Titulos c join Persona p on c.numero_cuenta_fk = p.cedula and c.numero_cuenta_fk =:cedulaCliente",
				Titulos.class).setParameter("cedulaCliente", cedu).getResultList();
		System.out.println("RESULTADO DEL QUERY "+ resultadoCuentas);
		return resultadoCuentas;		
	}

}
