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
@Table(name="Cuentas")
public class Cuentas implements Serializable{ 
	
	
    public Cuentas(Clientes idCliente, long cbu, String nroCta, double saldo, Date fecha_baja, Date fecha_alta,
			TipoCuenta id_TipoCuenta) {
		super();
		this.idCliente = idCliente;
		this.cbu = cbu;
		this.nroCta = nroCta;
		this.saldo = saldo;
		this.fecha_baja = fecha_baja;
		this.fecha_alta = fecha_alta;
		this.id_TipoCuenta = id_TipoCuenta;
	}
    
   
    
	public Cuentas() {
		
	}
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idCuenta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCuenta;
	
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="idCliente")
    private Clientes idCliente;
	
	
	@Column(name="cbu")
	private long cbu;
	
	@Column(name="nroCta")
	private String nroCta;
	
	@Column(name="saldo")
	private double saldo;
	
	@Column(name="fecha_baja")
	private Date fecha_baja;
	
	@Column(name="fecha_alta")
    private Date fecha_alta;
	
	///
    
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_TipoCuenta")
	private TipoCuenta id_TipoCuenta;

	public TipoCuenta getTipocuenta() {
			return id_TipoCuenta;
	}
	public void setTipocuenta(TipoCuenta tipocuenta) {
		this.id_TipoCuenta = tipocuenta;
	}	
    
	
	 @OneToMany(cascade= {CascadeType.ALL})
	 @JoinColumn(name = "id_cuenta")
	 private List<Movimientos> listaMovimientos = new ArrayList<Movimientos>();
	 	 
	
	public List<Movimientos> getListaMovimientos() {
		return listaMovimientos;
	}
	public void setListaMovimientos(List<Movimientos> listaMovimientos) {
		this.listaMovimientos = listaMovimientos;
	}
	public int getIdCuenta() {
		return idCuenta;
	}



	public long getCbu() {
		return cbu;
	}

	public void setCbu(long cbu) {
		this.cbu = cbu;
	}

	public String getNroCta() {
		return nroCta;
	}

	public void setNroCta(String nroCta) {
		this.nroCta = nroCta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Date getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	
	

	
	
	


	

	
}
