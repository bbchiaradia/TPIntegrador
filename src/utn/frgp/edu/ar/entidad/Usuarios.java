package utn.frgp.edu.ar.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name="Usuarios")
public class Usuarios implements Serializable{
   
	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idUsuario")
    private int idUsuario;
    
	
    @Column(name="nombreUsuario")
    private String nombreUsuario;


    @Column(name="contrasenia")
    private String contrasenia;
    
    
    @Column(name="fecha_alta")
    private Date fecha_alta;
    
    @Column(name="fecha_baja")
    private Date fecha_baja;
    
    
    
    public Usuarios() {
        
    }
    
 
 

    public Usuarios(String nombreUsuario, String contrasenia) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}




	public int getIdUsuario() {
		return idUsuario;
	}




	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}




	public String getNombreUsuario() {
		return nombreUsuario;
	}




	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}




	public String getContrasenia() {
		return contrasenia;
	}




	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}







	public Date getFecha_alta() {
		return fecha_alta;
	}




	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}




	public Date getFecha_baja() {
		return fecha_baja;
	}




	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}




	public static long getSerialversionuid() {
        return serialVersionUID;
    }




	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia
				+ ", fecha_alta=" + fecha_alta + ", fecha_baja=" + fecha_baja + "]";
	}
    
	
	public void initUsuario() {
		System.out.println("Se inicializa el usuario");
	}

	public void destroyUsuario() {
		System.out.println("Se destruye el usuario");
	}
 

}