package utn.frgp.edu.ar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import utn.frgp.edu.ar.dao.daoBanco;
import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Sexo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	
	
	@RequestMapping(value = "formclientesPost" , method = RequestMethod.POST)
	public String list4(ModelMap modelMap, Integer id , HttpServletRequest request) {
	    modelMap.addAttribute("listaProvincias", daoBanco.getProvincias());		
	    modelMap.addAttribute("listaLocalidades", daoBanco.getLocalidades());		
	    modelMap.addAttribute("listaSexo", daoBanco.getSexo());	
	    modelMap.addAttribute("listaNacionalidades", daoBanco.getNacionalidad());
	    Clientes cli= daoBanco.getClienteId(Integer.parseInt(request.getParameter("idCliente")));
	    
	    cli.setNombre(request.getParameter("nombre"));
	    cli.setApellido(request.getParameter("apellido"));
	    cli.setDni(Integer.parseInt(request.getParameter("dni")));
	    
	    cli.setIdSexo(daoBanco.getSexoId(Integer.parseInt(request.getParameter("sexo"))));
	   
	    System.out.println( "ACA UPDATEEEEEEE 85"+ cli.toString());
	    String sDate1=request.getParameter("fnac");  
	    SimpleDateFormat date1=new SimpleDateFormat("dd/MM/yyyy");
	    Date date;
		try {
			date = (Date) date1.parse(sDate1);
			cli.setFecha_nacimiento(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	    cli.setIdNacionalidad(daoBanco.getNacionalidadId(Integer.parseInt(request.getParameter("nacionalidad"))));
	    cli.setIdLocalidad(daoBanco.getLocalidadesId(Integer.parseInt(request.getParameter("localidad"))));
	    cli.setIdProvincia(daoBanco.getProvinciasId(Integer.parseInt(request.getParameter("provincia"))));
	  
	    
	    daoBanco dao = new daoBanco();
	    dao.ModificarCliente(cli);		
	  
	    List<Clientes> list = new ArrayList();
	    list.add(cli); 
	    
	  
	    
	    modelMap.addAttribute("formclientes", list);
	    
	    
	    
	    return "/formclientes";
	}
	
	
}