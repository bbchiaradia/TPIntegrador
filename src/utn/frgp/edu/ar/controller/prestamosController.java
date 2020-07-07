package utn.frgp.edu.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import utn.frgp.edu.ar.dao.clientesService;
import utn.frgp.edu.ar.dao.cuentasService;

@Controller
public class prestamosController {
	
	@RequestMapping("redireccionar_prestamos.html")
	public ModelAndView eventoRedireccionar_prestamos() {
		
		
		ModelAndView MV= new ModelAndView();
		System.out.println( "linea 18" + clientesService.getClienteLogueado());
		MV.addObject("cuentas", cuentasService.cuentasByClientId( clientesService.getClienteLogueado().getIdCliente() ));
		MV.setViewName("prestamos");
		return MV;
		
	}

}
