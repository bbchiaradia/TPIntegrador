package utn.frgp.edu.ar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import utn.frgp.edu.ar.dao.daoBanco;
import utn.frgp.edu.ar.entidad.Clientes;

import java.util.List;



@Controller
public class ClientesController{
	
	
	@RequestMapping(value = "redireccionar_clientes_D", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
	    modelMap.addAttribute("clientes", daoBanco.getClientes());

	    return "/clientes";
	}
	
	
	@RequestMapping(value = "redireccionar_detalleCliente" , method = RequestMethod.GET)
	public String list2(ModelMap modelMap, Integer id) {
	    modelMap.addAttribute("detalleCliente", daoBanco.LeerCliente(id));		
	    
	    return "/detalleCliente";
	}
	
	
	
	
	@RequestMapping(value = "formclientes" , method = RequestMethod.GET)
	public String list3(ModelMap modelMap, Integer id) {
	    modelMap.addAttribute("formclientes", daoBanco.LeerCliente(id));		
	    
	    return "/formclientes";
	}
	
	@RequestMapping( value= "eliminarCliente", method = RequestMethod.POST )
	@ResponseBody
	public String eliminarCliente( Integer id, daoBanco dao ){
		System.out.println(id);
		boolean cl = dao.EliminarCliente(id);
		if( cl ) {
			return "true";
		}
		return "false";
	}
	
	
	
}