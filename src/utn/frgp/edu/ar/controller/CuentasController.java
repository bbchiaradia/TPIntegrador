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
import com.google.gson.GsonBuilder;

import utn.frgp.edu.ar.dao.ConfigHibernet;
import utn.frgp.edu.ar.dao.clientesService;
import utn.frgp.edu.ar.dao.conceptosService;
import utn.frgp.edu.ar.dao.cuentasService;
import utn.frgp.edu.ar.dao.movimientosService;
import utn.frgp.edu.ar.dao.usuariosService;
import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Conceptos;
import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.TipoCuenta;
import utn.frgp.edu.ar.entidad.Usuarios;

@Controller
public class CuentasController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping("redireccionar_AltaCuenta.html")
	public ModelAndView eventoRedireccionar_AltaCuenta( ModelAndView MV ) {
		List<TipoCuenta> tiposcuenta = cuentasService.listarTipoCuentas();
		 List<Clientes> clientes = clientesService.getClientes();
		
		MV.addObject("tiposcuenta", tiposcuenta);
		MV.addObject("clientes", clientes);
		MV.addObject("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		MV.addObject("rol", usuariosService.RolUsuarioLogueado());
		MV.setViewName("AltaCuenta");
		return MV;
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("redireccionar_detalle_cuenta.html")
	public String eventoRedireccionar_detalle_cuenta(ModelMap modelMap, Integer id) {
      
		modelMap.addAttribute("detalleCuenta", cuentasService.cuentaById(id));		   
       
      List <TipoCuenta> tp = cuentasService.listarTipoCuentas();
      modelMap.addAttribute("tiposcuenta",tp);
      
      if(movimientosService.MovimientoByIdCuenta(id).size() == 0) {
    	  modelMap.addAttribute("sin_mov", "La cuenta aun NO posee MOVIMIENTOS");
      }else {
      modelMap.addAttribute("movimientos", movimientosService.MovimientoByIdCuenta(id));	
      }
      
      modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
	  modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
      
	  List <Conceptos> cp = conceptosService.getConceptos();
	    modelMap.addAttribute("conceptos",cp);
	  
		return "/detalle_cuenta";
		
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("redireccionar_cuentascl.html")
	public String eventoRedireccionar_cuentascl(ModelMap modelMap) {
		
		System.out.println("LINEA 77 ACAAA  CLIENTE  "+ clientesService.getClienteLogueado().getIdCliente());
		
		 List <Cuentas> cuentas= cuentasService.cuentasByClientId(clientesService.getClienteLogueado().getIdCliente());
		 List <TipoCuenta> tp = cuentasService.listarTipoCuentas();

		  
		  if (cuentas.size()==0) {
		    	 modelMap.addAttribute("NOCUENTAS","Bienvenido! A�n no posee cuentas");
		    }else {
		    	modelMap.addAttribute("tiposcuentacl",tp);
			    modelMap.addAttribute("cuentas_clientecl",cuentas);
		    }
		    
		    
		    
		    
		
		modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
	    modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		return "/cuentascl";
		
	}
	
	
	
	@SuppressWarnings("finally")
	@RequestMapping( value= "nuevacuenta", method = RequestMethod.POST )
	public ModelAndView nuevaCuenta( ModelAndView MV , HttpServletRequest request) {
		
		List<Cuentas> aux2 = cuentasService.cuentasByClientId(Integer.parseInt(request.getParameter("clientePropietario")));
		if( aux2.size() >= 4 ) {
			MV.addObject("status", "El cliente no puede poseer mas de 4 cuentas activas");
			MV.setViewName("AltaCuenta");
			return MV;
		}
		TipoCuenta tipocuenta = cuentasService.tipoCuentaById( Integer.parseInt(request.getParameter("tipoCuenta")) );
		Clientes cli = clientesService.getClienteId(Integer.parseInt(request.getParameter("clientePropietario")));
		Session session = ConfigHibernet.abrirConexion();
		try {
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
		ConfigHibernet.commitSession(session);
		MV.addObject("status", "La cuenta ha sido creada correctamente");
		}catch(Exception e) {
			MV.addObject("status", "Ocurri� un error al crear la cuenta");
			ConfigHibernet.rollbackSession(session);
		}finally {
		List<TipoCuenta> tiposcuenta = cuentasService.listarTipoCuentas();
		List<Clientes> clientes = clientesService.getClientes();
		MV.addObject("tiposcuenta", tiposcuenta);
		MV.addObject("clientes", clientes);
		MV.addObject("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		MV.addObject("rol", usuariosService.RolUsuarioLogueado());
		MV.setViewName("AltaCuenta");
		return MV;}
		
	}
	
	@RequestMapping( value= "cuentascliente", method = RequestMethod.POST )
	@ResponseBody
	public String cuentasClienteById( Integer id){
		System.out.println( id );
		List<Cuentas> ctas = cuentasService.cuentasByClientId(id);
		System.out.println( ctas );
		if( ctas != null ) {
			return  new Gson().toJson(ctas);			
		}else{
			return null;
		}
		
	}
	
	@RequestMapping( value= "darDeBajaCuenta", method = RequestMethod.POST )
	@ResponseBody
	public String darDeBajaCuentaPorId( Integer id){
		System.out.println( id );
		Cuentas ctas = cuentasService.cuentaById(id);	
		boolean result = cuentasService.darDeBajaCuentaPorId(ctas);
		if(result) { return "true"; }
		else{ return "false"; }
	}
	
	@RequestMapping( value= "modificarCuenta", method = RequestMethod.POST )
	@ResponseBody
	public String modificarCuenta( Integer id, Integer tipo){
	
		Cuentas ctas = cuentasService.cuentaById(id);
		TipoCuenta tipocta = cuentasService.tipoCuentaById(tipo);
		ctas.setTipocuenta(tipocta);
		boolean result = cuentasService.modificarTipoCuenta(ctas);
		if(result) { return "true"; }
		else{ return "false"; }
	}
	
}