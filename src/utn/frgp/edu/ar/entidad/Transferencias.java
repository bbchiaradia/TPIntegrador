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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Transferencias")
public class Transferencias implements Serializable {
	
	public Transferencias () {
		
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="IdTransferencia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTransferencia;
	
    
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idCliente")
    private Clientes idCliente;
	
	@Column(name="cbu_origen")
	private long cbu_origen;
	
	@Column(name="cbu_destino")
	private long cbu_destino;
	
	@Column(name="monto")
	private double monto;
	
    @Column(name="fecha_alta")
   	private Date fecha_alta;
    
    @Column(name="fecha_baja")
   	private Date fecha_baja;

	public int getIdTransferencia() {
		return idTransferencia;
	}

	public void setIdTransferencia(int idTransferencia) {
		this.idTransferencia = idTransferencia;
	}


	
	public Clientes getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Clientes idCliente) {
		this.idCliente = idCliente;
	}

	public long getCbu_origen() {
		return cbu_origen;
	}

	public void setCbu_origen(long cbu_origen) {
		this.cbu_origen = cbu_origen;
	}

	public long getCbu_destino() {
		return cbu_destino;
	}

	public void setCbu_destino(long cbu_destino) {
		this.cbu_destino = cbu_destino;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
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
		return "Transferencias [idTransferencia=" + idTransferencia + ", idCliente=" + idCliente + ", cbu_origen="
				+ cbu_origen + ", cbu_destino=" + cbu_destino  + ", monto=" + monto
				+ ", fecha_alta=" + fecha_alta + ", fecha_baja=" + fecha_baja + "]";
	}
	
    

}
