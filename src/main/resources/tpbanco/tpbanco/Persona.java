package tpbanco;

import java.io.Serializable;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
@Table(name="personas")
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String dni;
	
	public Persona() {
		
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}
	
	public void initapp() {
		Persona perso = new Persona();
		perso.setApellido("Wilson");
	}
}

