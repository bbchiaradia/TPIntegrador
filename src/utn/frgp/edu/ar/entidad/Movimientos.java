package utn.frgp.edu.ar.entidad;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Movimientos")
public class Movimientos {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idMovimiento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMovimiento;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)   
	private Date fecha;
	
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idConcepto")
    private Conceptos idConcepto;
	
	
	@Column(name="importe")
	private double importe;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idCuenta")
	private Cuentas idCuenta;

	
	public Movimientos(Date fecha, Conceptos idConcepto, double importe) {
		super();
		this.fecha = fecha;
		this.idConcepto = idConcepto;
		this.importe = importe;
	}



	public Movimientos() {
		
	}



	public int getIdMovimiento() {
		return idMovimiento;
	}


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public Conceptos getIdConcepto() {
		return idConcepto;
	}



	public void setIdConcepto(Conceptos idConcepto) {
		this.idConcepto = idConcepto;
	}



	public double getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}
	


	public Cuentas getIdCuenta() {
		return idCuenta;
	}



	public void setIdCuenta(Cuentas idCuenta) {
		this.idCuenta = idCuenta;
	}



	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}



	public void setImporte(double importe) {
		this.importe = importe;
	}



	@Override
	public String toString() {
		return "Movimientos [idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", idConcepto=" + idConcepto
				+ ", importe=" + importe + "]";
	}


	
	

}
