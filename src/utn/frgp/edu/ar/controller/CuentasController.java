package utn.frgp.edu.ar.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import utn.frgp.edu.ar.dao.ConfigHibernet;
import utn.frgp.edu.ar.dao.daoBanco;
import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.TipoCuenta;

@Controller
public class CuentasController {
	
	@RequestMapping("redireccionar_AltaCuenta.html")
	public ModelAndView eventoRedireccionar_AltaCuenta( ModelAndView MV ) {
		List<TipoCuenta> tiposcuenta = TipoCuenta.listarTipoCuentas();
		List<Clientes> clientes = daoBanco.getClientes();
		MV.addObject("tiposcuenta", tiposcuenta);
		MV.addObject("clientes", clientes);
		MV.setViewName("AltaCuenta");
		return MV;
		
	}
	
	@RequestMapping( value= "nuevacuenta", method = RequestMethod.POST )
	public ModelAndView nuevaCuenta( ModelAndView MV , HttpServletRequest request) {
		
		TipoCuenta tipocuenta = TipoCuenta.tipoCuentaById( Integer.parseInt(request.getParameter("tipoCuenta")) );
		Clientes cli = Clientes.getClienteById(Integer.parseInt(request.getParameter("clientePropietario")));
		ConfigHibernet config= new ConfigHibernet();
		try {
		 Session session = config.abrirConexion();
		 session.beginTransaction();
		//max cbu
		Criteria criteria = session.createCriteria(Cuentas.class).setProjection(Projections.max("cbu"));
		long maxCbu = (long)criteria.uniqueResult();
		maxCbu = maxCbu+1;
		//max numero cuenta
		Criteria criteria2 = session.createCriteria(Cuentas.class).setProjection(Projections.max("nroCta"));
		String maxNroCta = (String)criteria2.uniqueResult();
		Integer aux = Integer.parseInt( maxNroCta );
		aux = aux+1;
		maxNroCta = String.valueOf(aux);
		
		Cuentas account = new Cuentas(cli, maxCbu,  maxNroCta, 10000, Calendar.getInstance().getTime(), null, tipocuenta );
		session.save(account);
		session.getTransaction().commit();
		session.close();
		MV.addObject("status", "La cuenta ha sido creada correctamente");
		}catch(Exception e) {
			MV.addObject("status", "Ocurrió un error al crear la cuenta");
		}finally {
		List<TipoCuenta> tiposcuenta = TipoCuenta.listarTipoCuentas();
		List<Clientes> clientes = daoBanco.getClientes();
		MV.addObject("tiposcuenta", tiposcuenta);
		MV.addObject("clientes", clientes);
		MV.setViewName("AltaCuenta");
		return MV;}
		
	}
	
	
}