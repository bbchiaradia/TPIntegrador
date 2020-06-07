package utn.frgp.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Provincias")
public class Provincias implements Serializable{

	private static final long serialVersionUID = 1L; 
	@Id
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProvincia")
	private int idProvincia;

	
	@Column(name="descripcion")
	private String descripcion;
    
	public Provincias() {
        
    }
	
	

	public Provincias(int idProvincia, String descripcion) {
		super();
		this.idProvincia = idProvincia;
		this.descripcion = descripcion;
	}



	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Provincias [idProvincia=" + idProvincia + ", descripcion="
				+ descripcion + "]";
	}
	

    
	
}

