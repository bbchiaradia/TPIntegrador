package utn.frgp.edu.ar.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;

import utn.frgp.edu.ar.dao.ConfigHibernet;
import utn.frgp.edu.ar.dao.Idao;


@Entity
@Table(name="Clientes")
public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idCliente")
    private int idCliente;
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idUsuario")
	private Usuarios idUsuario;
	
	
	@Column(name="dni")
    private int dni;
	
	@Column(name="nombre")
    private String nombre;
	
	@Column(name="apellido")
    private String apellido;
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idSexo")
	private Sexo idSexo;
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idNacionalidad")
	private Nacionalidad idNacionalidad;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idLocalidad")
	private Localidades idLocalidad;
	
	
	public Localidades getIdLocalidad() {
		return idLocalidad;
	}


	public void setIdLocalidad(Localidades idLocalidad) {
		this.idLocalidad = idLocalidad;
	}


	@Column(name="fecha_nacimiento")
    private Date fecha_nacimiento;
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idProvincia")
	private Provincias idProvincia;
	
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idAdmBanco")
	private AdministradorBanco idAdmBanco;
	

	
	@Column(name="fecha_alta")
    private Date fecha_alta;
    
    @Column(name="fecha_baja")
    private Date fecha_baja;
    
    
    public Clientes() {
        
    }
    
  
    

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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



	public Sexo getIdSexo() {
		return idSexo;
	}


	public void setIdSexo(Sexo idSexo) {
		this.idSexo = idSexo;
	}


	public Nacionalidad getIdNacionalidad() {
		return idNacionalidad;
	}


	public void setIdNacionalidad(Nacionalidad idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}



	public Provincias getIdProvincia() {
		return idProvincia;
	}


	public void setIdProvincia(Provincias idProvincia) {
		this.idProvincia = idProvincia;
	}


	public AdministradorBanco getIdAdmBanco() {
		return idAdmBanco;
	}


	public void setIdAdmBanco(AdministradorBanco idAdmBanco) {
		this.idAdmBanco = idAdmBanco;
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

	public static Clientes getClienteById(Integer id) {
		ConfigHibernet config= new ConfigHibernet();
		 Session session = config.abrirConexion();
		Clientes cli = (Clientes) session.byId(Clientes.class).getReference(id);
		session.close();
		return cli;
	}

	@Override
	public String toString() {
		return "Clientes [idCliente=" + idCliente + ", idUsuario=" + idUsuario + ", dni=" + dni + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", idSexo=" + idSexo + ", idNacionalidad=" + idNacionalidad
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", idProvincia=" + idProvincia + ", idAdmBanco="
				+ idAdmBanco + ", fecha_alta=" + fecha_alta + ", fecha_baja=" + fecha_baja + "]";
	}


	
	
	
}
