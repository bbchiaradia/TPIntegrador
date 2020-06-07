package utn.frgp.edu.ar.entidad;

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
@Table(name="Movimientos_Transferencias")
public class Movimientos_Transferencias {



public Movimientos_Transferencias(Movimientos id_movimiento, Transferencias idTransferencia) {
		super();
		this.id_movimiento = id_movimiento;
		this.idTransferencia = idTransferencia;
	}


private static final long serialVersionUID = 1L;
@Id
@Column(name="idMovTransferencia")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idMovTransferencia;

   
@OneToOne(cascade = {CascadeType.ALL})
@JoinColumn(name="id_movimiento")
private Movimientos id_movimiento;


@ManyToOne(cascade= {CascadeType.ALL})
@JoinColumn(name = "id_transferencia")
private Transferencias idTransferencia;


public int getIdMovTransferencia() {
return idMovTransferencia;
}



public Transferencias getIdTransferencia() {
	return idTransferencia;
}




public void setIdTransferencia(Transferencias idTransferencia) {
	this.idTransferencia = idTransferencia;
}




public Movimientos getId_movimiento() {
return id_movimiento;
}


public void setId_movimiento(Movimientos id_movimiento) {
this.id_movimiento = id_movimiento;
}

}
