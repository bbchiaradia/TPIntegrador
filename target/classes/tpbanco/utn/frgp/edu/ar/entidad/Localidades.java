package utn.frgp.edu.ar.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Localidades")
public class Localidades implements Serializable{
	
	
	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idLocalidad")
    private int idLocalidad;
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idProvincia")
    private Provincias idProvincia;

    @Column(name="descripcion")
    private String descripcion;
    
    
    @Column(name="codPostal")
    private String codPostal;
   
    

	public Localidades() {
	
    }



	public Localidades( String descripcion, String codPostal) {
		this.descripcion = descripcion;
		this.codPostal = codPostal;
	}

	
	
	public Localidades( Provincias idProvincia, String descripcion, String codPostal) {
		this.idProvincia = idProvincia;
		this.descripcion = descripcion;
		this.codPostal = codPostal;
	}


	public int getIdLocalidad() {
		return idLocalidad;
	}


	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	
    


	public String getCodPostal() {
		return codPostal;
	}


	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
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


	


	public Provincias getIdProvincia() {
		return idProvincia;
	}


	public void setIdProvincia(Provincias idProvincia) {
		this.idProvincia = idProvincia;
	}



	@Override
	public String toString() {
		return "Localidades [idLocalidad=" + idLocalidad + ", idProvincia=" + idProvincia + ", descripcion="
				+ descripcion + ", codPostal=" + codPostal + "]";
	}


	
	
	



   


}
