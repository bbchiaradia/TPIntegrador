package utn.frgp.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Estados")
public class Estados  implements Serializable{
	
	public Estados () {		
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idEstado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstado;
	
	@Column(name="Descripcion")
	private String Descripcion;

	public int getIdEstado() {
		return idEstado;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Estados [idEstado=" + idEstado + ", Descripcion=" + Descripcion + "]";
	}	
	
	

}
