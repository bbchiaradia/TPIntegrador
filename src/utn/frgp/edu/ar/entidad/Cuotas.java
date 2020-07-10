package utn.frgp.edu.ar.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Cuotas")
public class Cuotas implements Serializable{
    
	
	
	
	public Cuotas() {
	
	}




	public Cuotas( Date fecha_pago) {
		super();
		this.fecha_pago = fecha_pago;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idCuota")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCuota;
	


	@Column(name="fecha_pago")
	@Temporal(TemporalType.DATE)
	private Date fecha_pago;

	public int getIdCuota() {
		return idCuota;
	}


	

	public void setIdPrestamo(int idPrestamo) {
		idPrestamo = idPrestamo;
	}

	public Date getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(Date fecha_pago) {
		fecha_pago = fecha_pago;
	}

		
	
	
}
