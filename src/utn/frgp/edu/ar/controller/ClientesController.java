package utn.frgp.edu.ar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import utn.frgp.edu.ar.dao.daoBanco;
import utn.frgp.edu.ar.entidad.Clientes;

import java.util.List;



@Controller
public class ClientesController{
	
	
	@RequestMapping(value = "redireccionar_clientes_D", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		System.out.println("estoe es un control");
	    modelMap.addAttribute("clientes", daoBanco.getClientes());

	    return "/clientes";
	}
	
	
	@RequestMapping(value = "redireccionar_detalleCliente", method = RequestMethod.GET)
	public String list2(ModelMap modelMap, Integer id) {
		System.out.println( "AcaaaaaaaaaDESPUES" +id);
	    modelMap.addAttribute("detalleCliente", daoBanco.LeerCliente(1));		
	    
	    return "/detalleCliente";
	}

}