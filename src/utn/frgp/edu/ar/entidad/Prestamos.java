package utn.frgp.edu.ar.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Prestamos")
public class Prestamos implements Serializable {  // Recordar agregar en el Hibernate.cfg.xml --> <mapping  class="frgp.utn.edu.ar.entidad.Prestamos"/>
	
    public Prestamos() {
    }

	private static final long serialVersionUID = 1L; 
    @Id
    @Column(name="idPrestamo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrestamo;
    
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idCliente")
    private Clientes idCliente;
	
    
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idMovimiento")
    private Movimientos idMovimiento;
	
 
    
    @Column(name="fecha")
   	private Date fecha;
    
    @Column(name="importe")
   	private double importe;
    
    @Column(name="cuotas")
   	private int cuotas;
    
    @Column(name="Plazo_meses")
   	private int Plazo_meses;
    
    @Column(name="fecha_alta")
   	private Date fecha_alta;
    
    @Column(name="fecha_baja")
   	private Date fecha_baja;
    
    
    
    ////////
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idEstado")
	private Estados idEstado;


	
	public void setIdEstado(Estados idEstado) {
		this.idEstado = idEstado;
	}

	////
	 @OneToMany(cascade= {CascadeType.ALL})
	 @JoinColumn(name = "id_prestamo")
	 private List<Cuotas> listaCuotas = new ArrayList<Cuotas>();
	 
	 
	
	public List<Cuotas> getListaCuotas() {
		return listaCuotas;
	}

	public void setListaCuotas(List<Cuotas> listaCuotas) {
		this.listaCuotas = listaCuotas;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}



	public Clientes getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Clientes idCliente) {
		this.idCliente = idCliente;
	}



	public Movimientos getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Movimientos idMovimiento) {
		this.idMovimiento = idMovimiento;
	}


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	public int getPlazo_meses() {
		return Plazo_meses;
	}

	public void setPlazo_meses(int plazo_meses) {
		this.Plazo_meses = plazo_meses;
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

	@Override
	public String toString() {
		return "Prestamos [idPrestamo=" + idPrestamo + ", idCliente=" + idCliente + ", idMovimiento=" + idMovimiento
				+ ", idEstado=" + idEstado + ", fecha=" + fecha + ", importe=" + importe + ", cuotas=" + cuotas
				+ ", Plazo_meses=" + Plazo_meses + ", fecha_alta=" + fecha_alta + ", fecha_baja=" + fecha_baja + "]";
	}
	

}
