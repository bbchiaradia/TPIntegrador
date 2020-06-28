package utn.frgp.edu.ar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import utn.frgp.edu.ar.dao.daoBanco;
import utn.frgp.edu.ar.entidad.Clientes;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;



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
	    modelMap.addAttribute("listaProvincias", daoBanco.getProvincias());		
	    modelMap.addAttribute("listaLocalidades", daoBanco.getLocalidades());		
	    modelMap.addAttribute("listaSexo", daoBanco.getSexo());	
	    modelMap.addAttribute("listaNacionalidades", daoBanco.getNacionalidad());	
	    return "/formclientes";
	}
	
	
	@RequestMapping(value = "formclientesPost" , method = RequestMethod.POST)
	public String list4(ModelMap modelMap, Integer id , HttpServletRequest request) {
	    modelMap.addAttribute("formclientes", daoBanco.LeerCliente(id));		
	    modelMap.addAttribute("listaProvincias", daoBanco.getProvincias());		
	    modelMap.addAttribute("listaLocalidades", daoBanco.getLocalidades());		
	    modelMap.addAttribute("listaSexo", daoBanco.getSexo());	
	    modelMap.addAttribute("listaNacionalidades", daoBanco.getNacionalidad());
	    Clientes cli= new Clientes ();
	    cli.setNombre(request.getParameter("nombre"));
	    cli.setApellido(request.getParameter("apellido"));
	    cli.setDni(Integer.parseInt(request.getParameter("dni")));
	    cli.setIdSexo(daoBanco.getSexoId(request.getParameter("sexo")));
	    
	    String sDate1=request.getParameter("fnac");  
	    SimpleDateFormat date1=new SimpleDateFormat("dd/MM/yyyy");
	    Date date = (Date) date1.parse(sDate1);
	    cli.setFecha_nacimiento(date);
	    
	    cli.setIdNacionalidad(daoBanco.getNacionalidadId(request.getParameter("nacionalidad")));
	    cli.setIdLocalidad(daoBanco.getLocalidadesId(request.getParameter("localidad")));

	    
	    cli.setIdProvincia(daoBanco.getProvinciasId(request.getParameter("provincia")));
	    cli.setIdUsuario(daoBanco.getNombreUsuarioId(request.getParameter("nombreUser")));
	    

	    
	    modelMap.addAttribute("cliente", cli);
	    
	    return "/formclientes";
	}
	
	
}