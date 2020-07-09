package utn.frgp.edu.ar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import utn.frgp.edu.ar.dao.clientesService;
import utn.frgp.edu.ar.dao.cuentasService;
import utn.frgp.edu.ar.dao.estadosService;
import utn.frgp.edu.ar.dao.movimientosService;
import utn.frgp.edu.ar.dao.prestamosService;
import utn.frgp.edu.ar.dao.usuariosService;
import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.TipoCuenta;

@Controller
public class prestamosController {
	
	@RequestMapping("redireccionar_prestamos.html")
	public ModelAndView eventoRedireccionar_prestamos() {
		
		
		ModelAndView MV= new ModelAndView();
		System.out.println( "linea 18" + clientesService.getClienteLogueado());
		MV.addObject( "tiposcuentas", cuentasService.listarTipoCuentas() );
		MV.addObject("idlogin", clientesService.getClienteLogueado().getIdCliente());
		MV.addObject("cuentas", cuentasService.cuentasByClientId( clientesService.getClienteLogueado().getIdCliente() ));
		MV.addObject("prestamos_cliente", prestamosService.PrestamosByIdCliente(clientesService.getClienteLogueado().getIdCliente() ));
		MV.addObject("movimientos_prestamos_cliente", movimientosService.MovimientosPrestamosByIdCliente(clientesService.getClienteLogueado().getIdCliente() ));
		MV.addObject("cuenta_movimientos_prestamos_cliente", cuentasService.CuentasMovimientosPrestamosByIdCliente(clientesService.getClienteLogueado().getIdCliente() ));
		
		MV.addObject("estado_prestamo", estadosService.getEstados());
		MV.setViewName("prestamos");
		
		
		
		  MV.addObject("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		  MV.addObject("rol", usuariosService.RolUsuarioLogueado());
		
		return MV;
		
	}
	
	
	
	@RequestMapping("redireccionar_prestamos_admin.html")
	public ModelAndView eventoRedireccionar_prestamos_admin() {
		
		
		ModelAndView MV= new ModelAndView();
		
		/*
		System.out.println( "linea 18" + clientesService.getClienteLogueado());
		
		MV.addObject("idlogin", clientesService.getClienteLogueado().getIdCliente());
		
	
		MV.addObject("movimientos_prestamos_cliente", movimientosService.MovimientosPrestamosByIdCliente(clientesService.getClienteLogueado().getIdCliente() ));
		MV.addObject("cuenta_movimientos_prestamos_cliente", cuentasService.CuentasMovimientosPrestamosByIdCliente(clientesService.getClienteLogueado().getIdCliente() ));
		
		
		*/
		
		MV.addObject("cliente",clientesService.getClientes());
		MV.addObject( "tiposcuentas", cuentasService.listarTipoCuentas() );
		MV.addObject("prestamos_cliente", prestamosService.PrestamosAll());
		MV.addObject("estado_prestamo", estadosService.getEstados());
		
		  MV.addObject("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		  MV.addObject("rol", usuariosService.RolUsuarioLogueado());
		
		  MV.setViewName("prestamosAdmin");
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
