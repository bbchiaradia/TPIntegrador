package utn.frgp.edu.ar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import utn.frgp.edu.ar.dao.daoBanco;
import utn.frgp.edu.ar.entidad.Clientes;

import java.util.List;


@RequestMapping("/clientes")
@Controller()
public class ClientesController{
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		System.out.println("estoe es un control");
	    modelMap.addAttribute("clientes", daoBanco.getClientes());
	    
	    return "/clientes";
	}
	
//Funcion de belu
	
	
	@RequestMapping(method = RequestMethod.GET,  value = "/{id}")
	public ModelAndView list2(ModelMap modelMap, @PathVariable(value="id") Integer id) {
		System.out.println( "AcaaaaaaaaaDESPUES" +id);
	   // modelMap.addAttribute("detalleCliente", daoBanco.LeerCliente(1));		
	    
// Funcion en desa
	/*@RequestMapping(value = "clientes/{id}", method = RequestMethod.GET)
	public String detalleCliente(@PathVariable("id") int userId,ModelMap modelMap) {
		System.out.println("estoe es un control id de usuario: " + userId);
	    modelMap.addAttribute("clientes", daoBanco.getClientes());*/
	    ModelAndView MV = new ModelAndView();
	    MV.clear();
	    MV.addObject("detalleCliente", daoBanco.LeerCliente(id));
	    
		MV.setViewName("detalleCliente");
	    return MV;
	    //return "detalleCliente";
	}

}