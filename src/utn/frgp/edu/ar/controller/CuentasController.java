package utn.frgp.edu.ar.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import utn.frgp.edu.ar.dao.ConfigHibernet;
import utn.frgp.edu.ar.dao.clientesService;
import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.TipoCuenta;

@Controller
public class CuentasController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping("redireccionar_AltaCuenta.html")
	public ModelAndView eventoRedireccionar_AltaCuenta( ModelAndView MV ) {
		List<TipoCuenta> tiposcuenta = TipoCuenta.listarTipoCuentas();
		//List<Clientes> clientes = daoBanco.getClientes();
		
		 ConfigHibernet config= new ConfigHibernet();
		 Session session = config.abrirConexion();
		 Query q = session.createQuery("from Clientes where fecha_baja is null	");
		 List<Clientes> clientes = q.list();
		
		MV.addObject("tiposcuenta", tiposcuenta);
		MV.addObject("clientes", clientes);
		MV.setViewName("AltaCuenta");
		return MV;
		
	}
	
	
	@SuppressWarnings("finally")
	@RequestMapping( value= "nuevacuenta", method = RequestMethod.POST )
	public ModelAndView nuevaCuenta( ModelAndView MV , HttpServletRequest request) {
		
		List<Cuentas> aux2 = Cuentas.cuentasByClientId(Integer.parseInt(request.getParameter("clientePropietario")));
		if( aux2.size() >= 4 ) {
			MV.addObject("status", "El cliente no puede poseer mas de 4 cuentas activas");
			MV.setViewName("AltaCuenta");
			return MV;
		}
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
		
		Cuentas account = new Cuentas(cli, maxCbu,  maxNroCta, 10000, null, Calendar.getInstance().getTime(), tipocuenta );
		session.save(account);
		session.getTransaction().commit();
		session.close();
		MV.addObject("status", "La cuenta ha sido creada correctamente");
		}catch(Exception e) {
			MV.addObject("status", "Ocurrió un error al crear la cuenta");
		}finally {
		List<TipoCuenta> tiposcuenta = TipoCuenta.listarTipoCuentas();
		ClientesController cc = new ClientesController();
		List<Clientes> clientes = clientesService.getClientes();
		MV.addObject("tiposcuenta", tiposcuenta);
		MV.addObject("clientes", clientes);
		MV.setViewName("AltaCuenta");
		return MV;}
		
	}
	
	@RequestMapping( value= "cuentascliente", method = RequestMethod.POST )
	@ResponseBody
	public String cuentasClienteById( Integer id){
		System.out.println( id );
		List<Cuentas> ctas = Cuentas.cuentasByClientId(id);
		System.out.println( ctas );
		if( ctas != null ) {
			return new Gson().toJson(ctas);			
		}else{
			return null;
		}
		
	}
	
	@RequestMapping( value= "darDeBajaCuenta", method = RequestMethod.POST )
	@ResponseBody
	public String darDeBajaCuentaPorId( Integer id){
		System.out.println( id );
		Cuentas ctas = this.cuentaById(id);
		ctas.setFecha_baja( Calendar.getInstance().getTime() );
		ConfigHibernet config= new ConfigHibernet();
		try {
			Session session = config.abrirConexion();
	        Transaction transaction = session.beginTransaction();
	        session.update(ctas);
	        transaction.commit();
	        session.close();
	       	return "true";
		}catch(Exception E) {
			System.out.println( E.getMessage() );
			return "false";
		}
		
		
	}
	
	@RequestMapping( value= "modificarCuenta", method = RequestMethod.POST )
	@ResponseBody
	public String modificarCuenta( Integer id, Integer tipo){
		System.out.println( id );
		System.out.println( tipo );
		Cuentas ctas = this.cuentaById(id);
		TipoCuenta tipocta = TipoCuenta.tipoCuentaById(tipo);
		ctas.setTipocuenta(tipocta);
		ConfigHibernet config= new ConfigHibernet();
		try {
			Session session = config.abrirConexion();
	        Transaction transaction = session.beginTransaction();
	        session.update(ctas);
	        transaction.commit();
	        session.close();
	       	return "true";
		}catch(Exception E) {
			System.out.println( E.getMessage() );
			return "false";
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public static Cuentas cuentaById(Integer id){
		ConfigHibernet config= new ConfigHibernet();
		 Session session = config.abrirConexion();
		//List<Cuentas> cuentas = session.createCriteria(Cuentas.class).add(Restrictions.eq("idCliente", id)).list();
		 Query q = session.createQuery("from Cuentas where idCuenta = " + id);
		 Cuentas cuentas = (Cuentas) q.uniqueResult();
		 session.close();
		 return cuentas;
	}
	
}