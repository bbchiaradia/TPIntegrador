package utn.frgp.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Nacionalidad")
public class Nacionalidad implements Serializable{

	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idNacionalidad")
    private int idNacionalidad;
	

    @Column(name="descripcion")
    private String descripcion;
    
    public Nacionalidad() {
    	
    }

	public int getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(int idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
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
		return "Nacionalidad [idNacionalidad=" + idNacionalidad + ", descripcion=" + descripcion + "]";
	}
    
    

	
}
