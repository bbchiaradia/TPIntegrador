package utn.frgp.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="TipoCuenta")
public class TipoCuenta implements Serializable {
	
	public TipoCuenta() {
		
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_TipoCuenta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_TipoCuenta;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="estado")
	private int estado;

	public int getId_TipoCuenta() {
		return id_TipoCuenta;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	//////

	
	
	

}
