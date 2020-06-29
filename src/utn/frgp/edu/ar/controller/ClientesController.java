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
	    
	    System.out.println("ACA CONTROLLER LINEA 81- idCliente " + request.getParameter("idCliente"));
	    System.out.println("ACA CONTROLLER LINEA 81- sexo " + request.getParameter("sexo"));
	    System.out.println("ACA CONTROLLER LINEA 82- nacionalidad " + request.getParameter("nacionalidad"));
	    System.out.println("ACA CONTROLLER LINEA 83- localidad " + request.getParameter("localidad"));
	    System.out.println("ACA CONTROLLER LINEA 84- provincia " + request.getParameter("provincia"));
	    System.out.println("ACA CONTROLLER LINEA 85- fnac " + request.getParameter("fnac"));
	    System.out.println("ACA CONTROLLER LINEA 87- idUsuario " + request.getParameter("idUsuario"));
	    
	    
	  //  cli.setIdCliente(daoBanco.getClienteId(Integer.parseInt(request.getParameter("idCliente"))));
	    
	    cli.setIdSexo(daoBanco.getSexoId(Integer.parseInt(request.getParameter("sexo"))));
	    
	    
	    
	    String sDate1=request.getParameter("fnac");  
	    SimpleDateFormat date1=new SimpleDateFormat("dd/MM/yyyy");
	    Date date;
		try {
			date = (Date) date1.parse(sDate1);
			cli.setFecha_nacimiento(date);
		} catch (ParseException e) {
			System.out.println("rompe aca");
			e.printStackTrace();
		}
		
	  
		
	    
	    cli.setIdNacionalidad(daoBanco.getNacionalidadId(Integer.parseInt(request.getParameter("nacionalidad"))));
	    cli.setIdLocalidad(daoBanco.getLocalidadesId(Integer.parseInt(request.getParameter("localidad"))));
	    cli.setIdProvincia(daoBanco.getProvinciasId(Integer.parseInt(request.getParameter("provincia"))));
	    
	  //  System.out.println("ACA CONTROLLER LINEA 100" + request.getParameter("nombreUser"));
	   // cli.setIdUsuario(daoBanco.getNombreUsuarioId(Integer.parseInt(request.getParameter("nombreUser"))));
	   
	 //   modelMap.addAttribute("formclientes", daoBanco.LeerCliente(Integer.parseInt(request.getParameter("id"))));		
	    
	    
	    System.out.println("ACA CLI" + cli.toString());
	    
	    
	    modelMap.addAttribute("formclientes", cli);
	    
	    
	    
	    return "/formclientes";
	}
	
	
}