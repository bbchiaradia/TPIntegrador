package utn.frgp.edu.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


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
