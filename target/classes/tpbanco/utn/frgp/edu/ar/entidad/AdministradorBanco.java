package utn.frgp.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AdministradorBanco")
public class AdministradorBanco implements Serializable{

	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idAdmBanco")
    private int idAdmBanco;
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idUsuario")
	private Usuarios idUsuario;

	
	@Column(name="dni")
    private int dni;
	
	@Column(name="nombre")
    private String nombre;
	
	@Column(name="apellido")
    private String apellido;
	
	 public AdministradorBanco() {
	        
	    }

	public int getIdAdmBanco() {
		return idAdmBanco;
	}

	public void setIdAdmBanco(int idAdmBanco) {
		this.idAdmBanco = idAdmBanco;
	}

	

	public Usuarios getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuarios idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AdministradorBanco [idAdmBanco=" + idAdmBanco + ", idUsuario=" + idUsuario + ", dni=" + dni
				+ ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	 
	 
	    
}
