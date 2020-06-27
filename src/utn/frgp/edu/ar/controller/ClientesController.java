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
	
	
	/*@RequestMapping(value = "redireccionar_clientes_D", method = RequestMethod.GET)
	public ModelAndView list() {
		
		ModelAndView MV= new ModelAndView();
		
		//List<Clientes> list = (List<Clientes>) dao.getClientes();
		//MV.addObject("listaClientes",list);
		MV.setViewName("clientes");
		return MV;
	}*/
	
	@RequestMapping(value = "redireccionar_clientes_D", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		System.out.println("estoe es un control");
	    modelMap.addAttribute("clientes", daoBanco.getClientes());

	    return "/clientes";
	}

}