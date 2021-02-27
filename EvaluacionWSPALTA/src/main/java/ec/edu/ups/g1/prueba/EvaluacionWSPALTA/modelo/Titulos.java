package ec.edu.ups.g1.prueba.EvaluacionWSPALTA.modelo;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="titulos")
public class Titulos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name ="codigoPK")
	private int codigo;	
	
	@Column(name="codigo_alfa")
	private String codigoAlfa;
	private Date fecha;
	private String universidad;
	private String nombre;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE })
	@JoinColumn(name="cuenta_fk")	
	private List<Persona> cuenta_fk;
	private String numero_cuenta_fk;
	
	
	
	public String getNumero_cuenta_fk() {
		return numero_cuenta_fk;
	}
	public void setNumero_cuenta_fk(String numero_cuenta_fk) {
		this.numero_cuenta_fk = numero_cuenta_fk;
	}
	public List<Persona> getCuenta_fk() {
		return cuenta_fk;
	}
	public void setCuenta_fk(List<Persona> cuenta_fk) {
		this.cuenta_fk = cuenta_fk;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCodigoAlfa() {
		return codigoAlfa;
	}
	public void setCodigoAlfa(String codigoAlfa) {
		this.codigoAlfa = codigoAlfa;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Titulos [codigo=" + codigo + ", codigoAlfa=" + codigoAlfa + ", fecha=" + fecha + ", universidad="
				+ universidad + ", nombre=" + nombre + ", cuenta_fk=" + cuenta_fk + ", numero_cuenta_fk="
				+ numero_cuenta_fk + "]";
	}
	
	
	
	
	
}
