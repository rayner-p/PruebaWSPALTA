package ec.edu.ups.g1.prueba.EvaluacionWSPALTA.modelo;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String cuenta_fk;
	
	
	public String getCuenta_fk() {
		return cuenta_fk;
	}
	public void setCuenta_fk(String cuenta_fk) {
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
				+ universidad + ", nombre=" + nombre + ", persona="+"]";
	}
	
	
}
