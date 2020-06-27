package utn.frgp.edu.ar.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Provincias")
public class Provincias implements Serializable{

	@Override
	public String toString() {
		return "Provincias [idProvincia=" + idProvincia + ", descripcion=" + descripcion + "]";
	}

	private static final long serialVersionUID = 1L; 
	@Id
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProvincia")
	private int idProvincia;

	
	@Column(name="descripcion")
	private String descripcion;
    
	public Provincias() {
        
    }

	/*@Column
	@ElementCollection(targetClass=Localidades.class)
	private List<Localidades>listaLocalidades;
	
	
	public List<Localidades> getListaLocalidades() {
		return listaLocalidades;
	}



	public void setListaLocalidades(List<Localidades> listaLocalidades) {
		this.listaLocalidades = listaLocalidades;
	}*/



	public Provincias(int idProvincia, String descripcion) {
		this.idProvincia = idProvincia;
		this.descripcion = descripcion;
	}



	public Provincias(String descripcion) {
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


	

    
	
}

