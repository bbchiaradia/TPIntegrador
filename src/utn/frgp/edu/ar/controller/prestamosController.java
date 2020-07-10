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
import utn.frgp.edu.ar.entidad.Prestamos;
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
		
		
		if( prestamosService.PrestamosByIdCliente(clientesService.getClienteLogueado().getIdCliente() ).size()== 0) {
			MV.addObject("sin_prestamos", "Aún NO posee PRESTAMOS");
		}else {
			MV.addObject("prestamos_cliente", prestamosService.PrestamosByIdCliente(clientesService.getClienteLogueado().getIdCliente() ));
		}
		
		
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
		
		MV.addObject("cuentas", cuentasService.getCuentas());
		MV.addObject("cliente",clientesService.getClientes());
		MV.addObject( "tiposcuentas", cuentasService.listarTipoCuentas() );
		
		if(prestamosService.PrestamosAll().size()== 0) {
			MV.addObject("sin_prestamos", "NO TIENE PRESTAMOS PENDIENTES DE APROBACIÓN");
		}else {
			MV.addObject("prestamos_cliente", prestamosService.PrestamosAll());
		}
		
		
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
	
	
	@RequestMapping( value= "aprobarPrestamo", method = RequestMethod.POST )
	public String aprobarPrestamo(HttpServletRequest request,ModelMap modelMap, Integer idPrestamo, Integer cuentaDestino ) {

		modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
		
		
		Prestamos pres = prestamosService.prestamoById(idPrestamo);	
		boolean result = prestamosService.aprobarPrestamoPorId(pres, cuentaDestino);
		
		if(result) {
			modelMap.addAttribute("msj", "El préstamo ha sido aprobado exitosamente");
			System.out.println("PRESTAMO APROBADO");
		}else {
			modelMap.addAttribute("msj", "Ocurrió un error al aprobar el préstamo");
			System.out.println("PRESTAMO DENEGADO");
		}
		return "prestamosAdmin";
		
	}
	
	
	@RequestMapping( value= "rechazarPrestamo", method = RequestMethod.POST )
	public String rechazarPrestamo(HttpServletRequest request,ModelMap modelMap, Integer idPrestamo ) {
		modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
		
		Prestamos pres = prestamosService.prestamoById(idPrestamo);	
		boolean result = prestamosService.rechazarPrestamoPorId(pres);
		if(result) {
			modelMap.addAttribute("msj", "El préstamo ha sido rechazado exitosamente");
			System.out.println("PRESTAMO APROBADO");
		}else {
			modelMap.addAttribute("msj", "Ocurrió un error al rechazar el préstamo");
			System.out.println("PRESTAMO DENEGADO");
		}
		
		return "prestamosAdmin";
		
	}
	
	

}
