package utn.frgp.edu.ar.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.annotations.Generated;
import org.hibernate.criterion.Restrictions;

import utn.frgp.edu.ar.dao.ConfigHibernet;

@Entity
@Table(name="TipoCuenta")
public class TipoCuenta implements Serializable {
	
	public TipoCuenta() {
		
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_TipoCuenta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_TipoCuenta;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="estado")
	private int estado;

	public int getId_TipoCuenta() {
		return id_TipoCuenta;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	//////

	@SuppressWarnings("unchecked")
	public static List<TipoCuenta> listarTipoCuentas(){
		ConfigHibernet config= new ConfigHibernet();
		 Session session = config.abrirConexion();
		 List<TipoCuenta> tiposcuenta = session.createCriteria(TipoCuenta.class).list();
		return  tiposcuenta;
	}
	
	public static TipoCuenta tipoCuentaById( Integer id  ) {
		ConfigHibernet config= new ConfigHibernet();
		 Session session = config.abrirConexion();
		TipoCuenta tipocuenta = (TipoCuenta) session.createCriteria(TipoCuenta.class)
				 .add(Restrictions.eq("id_TipoCuenta", id)).uniqueResult();
		return tipocuenta;
	}
	
	
	

}
