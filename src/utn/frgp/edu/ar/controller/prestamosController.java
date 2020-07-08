package utn.frgp.edu.ar.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import utn.frgp.edu.ar.dao.clientesService;
import utn.frgp.edu.ar.dao.cuentasService;
import utn.frgp.edu.ar.dao.prestamosService;
import utn.frgp.edu.ar.dao.usuariosService;

@Controller
public class prestamosController {
	
	@RequestMapping("redireccionar_prestamos.html")
	public ModelAndView eventoRedireccionar_prestamos() {
		
		
		ModelAndView MV= new ModelAndView();
		System.out.println( "linea 18" + clientesService.getClienteLogueado());
		MV.addObject( "tiposcuentas", cuentasService.listarTipoCuentas() );
		MV.addObject("idlogin", clientesService.getClienteLogueado().getIdCliente());
		MV.addObject("cuentas", cuentasService.cuentasByClientId( clientesService.getClienteLogueado().getIdCliente() ));
		MV.setViewName("prestamos");
		
		  MV.addObject("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		  MV.addObject("rol", usuariosService.RolUsuarioLogueado());
		
		return MV;
		
	}
	
	@RequestMapping( value= "pedirprestamo", method = RequestMethod.POST )
	@ResponseBody
	public String pedirPrestamo(HttpServletRequest request) {
		 boolean flag = prestamosService.setPrestamo(
				 Integer.parseInt(request.getParameter("id")), 
				Integer.parseInt(request.getParameter("plazo")),
				Integer.parseInt(request.getParameter("monto")), 
				request.getParameter("cuentadestino")
				);  
			
		
		
		return String.valueOf(flag);
		
	}

}
