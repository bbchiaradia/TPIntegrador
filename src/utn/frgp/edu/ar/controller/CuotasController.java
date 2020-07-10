package utn.frgp.edu.ar.controller;


import javax.servlet.http.HttpServletRequest;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import utn.frgp.edu.ar.dao.clientesService;
import utn.frgp.edu.ar.dao.cuentasService;
import utn.frgp.edu.ar.dao.cuotasService;
import utn.frgp.edu.ar.dao.prestamosService;
import utn.frgp.edu.ar.dao.usuariosService;
import utn.frgp.edu.ar.entidad.Cuentas;
import utn.frgp.edu.ar.entidad.Cuotas;

@Controller
public class CuotasController {

	
	@SuppressWarnings("unchecked")
	@RequestMapping("redireccionar_cuotas_detalle.html")
	public String eventoRedireccionar_cuotas_detalle(ModelMap modelMap, Integer idPrestamo) {
		
		System.out.println("LINEA 18 ACAAA  PRESTAMOS id "+ idPrestamo);
		modelMap.addAttribute("cuentas", cuentasService.cuentasByClientId( clientesService.getClienteLogueado().getIdCliente() ));
		
	/*	 List <TipoCuenta> tp = cuentasService.listarTipoCuentas();
	
		  System.out.println("LINEA 81 ACAAA  CUENTAS "+ cuentas);
		 
		    modelMap.addAttribute("tiposcuentacl",tp);
		    modelMap.addAttribute("cuentas_clientecl",cuentas);
		
		modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
	    modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
	    */
		modelMap.addAttribute("idPrestamo",idPrestamo);
		modelMap.addAttribute("cuotas", cuotasService.CuotasByIdPrestamo(idPrestamo));
		
		modelMap.addAttribute("monto_cuota", cuotasService.MontoCuotasByIdPrestamo(idPrestamo));
		
		modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
		
		return "/cuotas_detalle";
		
	}
	
	

	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("redireccionar_pagoCuota.html")
	public String redireccionar_pagoCuota(ModelMap modelMap, Integer idCuota, Integer PagarDesde, Double montoCuota, Integer idPrestamo ) {
		
		modelMap.addAttribute("cuentas", cuentasService.cuentasByClientId( clientesService.getClienteLogueado().getIdCliente() ));
		modelMap.addAttribute("idPrestamo",idPrestamo);
		modelMap.addAttribute("cuotas", cuotasService.CuotasByIdPrestamo(idPrestamo));
		
		modelMap.addAttribute("monto_cuota", cuotasService.MontoCuotasByIdPrestamo(idPrestamo));
		
		
		Cuentas cuenta= cuentasService.cuentaById(PagarDesde);
		System.out.println("ANTES IF ----------- "+ montoCuota);
		
		if(cuentasService.verificaMontoCuenta(PagarDesde, montoCuota)) {
			System.out.println("ENTRO AL 1 IF 66 ----------- ");
			
			if (cuotasService.PagarCuota(cuenta, montoCuota, idCuota)){
				System.out.println("ENTRO AL IF 68 ----------- ");
			 modelMap.addAttribute("msjCuota", "Su pago se registró satisfactoriamente.");
		    }else {
		    	System.out.println("NO ENTRO AL IF 72 ----------- ");
			 modelMap.addAttribute("msjCuota", "Su pago no ha podido ser registrado");
		    }
			
			
		}
		
				
		modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
		System.out.println("CUOTA A PAGAR ----------- "+ idCuota);
		
        

		return "/cuotas_detalle";
		
	}
	
	
	
	
}
