package utn.frgp.edu.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaginaController {
	
	
	@RequestMapping("redireccionar_Index.html")
	public ModelAndView eventoRedireccionar_Index() {
		ModelAndView MV= new ModelAndView();
		MV.setViewName("Index");
		return MV;
		
	}
	
	
	@RequestMapping("redireccionar_login.html")
	public ModelAndView eventoRedireccionar_login() {
		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("login");
		return MV;
		
	}
	
	
	
	@RequestMapping("redireccionar_detalle_cuenta.html")
	public ModelAndView eventoRedireccionar_detalle_cuenta() {
		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("detalle_cuenta");
		return MV;
		
	}
	
	
	@RequestMapping("redireccionar_clientes.html")
	public ModelAndView eventoRedireccionar_clientes() {
		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("clientes");
		return MV;
		
	}
	
	
	@RequestMapping("redireccionar_AltaCuenta.html")
	public ModelAndView eventoRedireccionar_AltaCuenta() {
		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("AltaCuenta");
		return MV;
		
	}
	
	@RequestMapping("redireccionar_prestamos.html")
	public ModelAndView eventoRedireccionar_prestamos() {
		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("prestamos");
		return MV;
		
	}
	
	
	@RequestMapping("redireccionar_informe.html")
	public ModelAndView eventoRedireccionar_informe() {
		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("informe");
		return MV;
		
	}
	
	
	@RequestMapping("redireccionar_cuentascl.html")
	public ModelAndView eventoRedireccionar_cuentascl() {
		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("cuentascl");
		return MV;
		
	}
	
	
	@RequestMapping("redireccionar_transferencias.html")
	public ModelAndView eventoRedireccionar__trasnferencias() {
		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("transferencias");
		return MV;
		
	}
	
	
}
