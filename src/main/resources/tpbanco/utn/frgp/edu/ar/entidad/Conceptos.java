package utn.frgp.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Conceptos")
public class Conceptos implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idConcepto")
    private int idConcepto;
	

    @Column(name="descripcion")
    private String descripcion;

    
    public Conceptos() {
        
    }
    

	public Conceptos(String descripcion) {
		super();
		this.descripcion = descripcion;
	}


	public int getIdConcepto() {
		return idConcepto;
	}


	public void setIdConcepto(int idConcepto) {
		this.idConcepto = idConcepto;
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
		return "Conceptos [idConcepto=" + idConcepto + ", descripcion=" + descripcion + "]";
	}
    
    
    
    

}
