package utn.frgp.edu.ar.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import utn.frgp.edu.ar.dao.clientesService;
import utn.frgp.edu.ar.dao.cuentasService;
import utn.frgp.edu.ar.dao.transferenciasService;
import utn.frgp.edu.ar.dao.usuariosService;


@Controller
public class transferenciasController {

	@RequestMapping("redireccionar_transferencias.html")
	public ModelAndView eventoRedireccionar_trasnferencias() {
		
		ModelAndView MV= new ModelAndView();
		MV.addObject("cuentascliente", cuentasService.cuentasByClientId( clientesService.getClienteLogueado().getIdCliente() )  );
		System.out.println( cuentasService.cuentasByClientId( clientesService.getClienteLogueado().getIdCliente() ) );
		
		 MV.addObject("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		 MV.addObject("rol", usuariosService.RolUsuarioLogueado());
		MV.setViewName("transferencias");
		return MV;
		
	}
	
	@RequestMapping("transferCuentasPropias.html")
	@ResponseBody
	public String transferCuentasPropias( HttpServletRequest request ) {
		boolean status;
		boolean montok = cuentasService.verificaMontoCuenta( Integer.parseInt(request.getParameter("ctaorigen")) , Double.parseDouble(request.getParameter("monto")));
		if(montok) {
			 status = transferenciasService.saveTransferencia(request.getParameter("ctaorigen"), request.getParameter("ctadestino"), request.getParameter("monto"));
		}
		else {
			return  "Fondos insuficientes";
		}

		return String.valueOf(status) ;
		
	}
	
	@RequestMapping("transferOtrasCuentas.html")
	@ResponseBody
	public String transferOtrasCuentas( HttpServletRequest request ) {
		boolean status;
		String idcta = cuentasService.idCtaByCbu(request.getParameter("cbudestino"));
		
		boolean montok = cuentasService.verificaMontoCuenta( Integer.parseInt(request.getParameter("ctaorigen")) , Double.parseDouble(request.getParameter("monto")));
		if(montok) {
			status = transferenciasService.saveTransferencia(request.getParameter("ctaorigen"), idcta, request.getParameter("monto"));
		}else {
			return  "Fondos insuficientes";
		}
		 

		return String.valueOf(status) ;
		
	}
	
	@RequestMapping("detallesByCbu.html")
	@ResponseBody
	public String detallesByCbu( HttpServletRequest request ) {
		
		Map<String, String> datos = cuentasService.datosByCbu( request.getParameter("cbu") );
		
		return new Gson().toJson(datos) ;
		
	}
	
	
	
	
}
