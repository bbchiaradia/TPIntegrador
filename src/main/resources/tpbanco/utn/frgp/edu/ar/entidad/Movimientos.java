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
import javax.persistence.Table;

@Entity
@Table(name="Movimientos")
public class Movimientos {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idMovimiento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMovimiento;
	
	@Column(name="fecha")
	private Date fecha;
	
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idConcepto")
    private Conceptos idConcepto;
	
	
	/*@Column(name="idCuenta")
	private int idCuenta;*/
	
	@Column(name="importe")
	private double importe;
	

	
	public Movimientos(Date fecha, Conceptos idConcepto, double importe) {
		super();
		this.fecha = fecha;
		this.idConcepto = idConcepto;
		this.importe = importe;
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

	@Override
	public String toString() {
		return "Movimientos [idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", idConcepto=" + idConcepto
				+ ", importe=" + importe + "]";
	}


	
	

}
