package utn.frgp.edu.ar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import utn.frgp.edu.ar.dao.clientesService;
import utn.frgp.edu.ar.dao.cuentasService;
import utn.frgp.edu.ar.dao.usuariosService;
import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.TipoCuenta;
import utn.frgp.edu.ar.entidad.Usuarios;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UsuariosController {
	
	
	@RequestMapping(value = "redireccionar_Index.html" , method = RequestMethod.POST)
	public String lista1(ModelMap modelMap, HttpServletRequest request) {
		
		  
		Usuarios usu= new Usuarios();
	    
	    usu.setNombreUsuario(request.getParameter("nombreUser"));
	    usu.setContrasenia(request.getParameter("contrasenia"));
	    
	    usuariosService.esAdminBanco(usu.getNombreUsuario());
	    
	    
	    if (usuariosService.esAdminBanco(usu.getNombreUsuario()) == false) {
	    List <Cuentas> cuentas= cuentasService.cuentasByClientId(clientesService.getClienteLogueado().getIdCliente());
	    List <TipoCuenta> tp = cuentasService.listarTipoCuentas();
	    
	    if (cuentas.size()==0) {
	    	 modelMap.addAttribute("NOCUENTAS","Bienvenido! Aún no posee cuentas");
	    }else {
	    	 modelMap.addAttribute("tiposcuenta",tp);
	         modelMap.addAttribute("cuentas_cliente",cuentas);
	    }
	    
	    
	   
	    
	    }
	    
	  
	    
	        modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
	    modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
	    
	    
	    return "/Index";
		
		
	}
	
	

	@RequestMapping( value= "validarNombreUsuarioAcceso", method = RequestMethod.POST )
	@ResponseBody
	public String nombreUsuarioByNombrePass( String nombre){
		System.out.println(nombre);
		List<Usuarios> usuario = usuariosService.UsuarioByNombrePass(nombre);
		System.out.println( usuario );
		if( usuario.size() == 0 ) {
			return "false";			
		}else{
			return "true";
		}
		
	}
	

	 
	 
		@RequestMapping( value= "validarContraseniaAcceso", method = RequestMethod.POST )
		@ResponseBody 
		public String contraseniaUsuarioByPass(String nombre, String contrasenia){
			System.out.println(nombre);
			System.out.println(contrasenia);
			List<Usuarios> usuario = usuariosService.UsuarioByPass(nombre, contrasenia);
			System.out.println( usuario );
			if( usuario.size() == 0 ) {
				return "false";			
			}else{
				return "true";
			}
			
		}
	 

	}