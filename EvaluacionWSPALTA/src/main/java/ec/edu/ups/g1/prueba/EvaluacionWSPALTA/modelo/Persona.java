package ec.edu.ups.g1.prueba.EvaluacionWSPALTA.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="persona")
public class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length=10, nullable=false)
	private String cedula;
	
	private String nombres;
	private String apellidos;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL })
	@JoinColumn(name="cuenta_fk")	
	private List<Titulos> titulos;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<Titulos> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<Titulos> titulos) {
		this.titulos = titulos;
	}

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", titulos="
				+ titulos + "]";
	}
	
	
	
}
