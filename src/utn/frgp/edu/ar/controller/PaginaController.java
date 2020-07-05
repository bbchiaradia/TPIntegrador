package utn.frgp.edu.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import utn.frgp.edu.ar.dao.daoBanco;

@Controller
public class PaginaController {
	
	
	@RequestMapping("redireccionar_Index.html")
	public ModelAndView eventoRedireccionar_Index(String txtNombre) {
		ModelAndView MV= new ModelAndView();
		MV.addObject("nombre", txtNombre);
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
	
	
	@RequestMapping("redireccionar_prestamos.html")
	public ModelAndView eventoRedireccionar_prestamos() {
		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("prestamos");
		return MV;
		
	}
	
	@RequestMapping("redireccionar_prestamosAdmin.html")
	public ModelAndView eventoRedireccionar_prestamosAdmin() {
		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("prestamosAdmin");
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
	public ModelAndView eventoRedireccionar_trasnferencias() {
		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("transferencias");
		return MV;
		
	}
	
	
	@RequestMapping("redireccionar_formclientes.html")
	public ModelAndView eventoRedireccionar_formclientes() {
		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("formclientes");
		return MV;
		
	}
	@RequestMapping("alta_cliente.html")
	public ModelAndView eventoRedireccionar_alta_cliente() {
		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("altaCliente");
		return MV;
		
	}
	
	/*
	@RequestMapping("redireccionar_clientes_D.html")
    public String customerList(ModelMap modelMap) {
		
		 System.out.println( "DEBUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG =D" );
        modelMap.addAttribute("clientes", daoBanco.getClientes());

		return "clientes";
		
    }
	*/
	
}
