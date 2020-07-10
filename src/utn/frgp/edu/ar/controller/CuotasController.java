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
import utn.frgp.edu.ar.entidad.Cuotas;

@Controller
public class CuotasController {

	
	@SuppressWarnings("unchecked")
	@RequestMapping("redireccionar_cuotas_detalle.html")
	public String eventoRedireccionar_cuentascl(ModelMap modelMap, Integer idPrestamo) {
		
		System.out.println("LINEA 18 ACAAA  PRESTAMOS id "+ idPrestamo);
		modelMap.addAttribute("cuentas", cuentasService.cuentasByClientId( clientesService.getClienteLogueado().getIdCliente() ));
		
	/*	 List <TipoCuenta> tp = cuentasService.listarTipoCuentas();
	
		  System.out.println("LINEA 81 ACAAA  CUENTAS "+ cuentas);
		 
		    modelMap.addAttribute("tiposcuentacl",tp);
		    modelMap.addAttribute("cuentas_clientecl",cuentas);
		
		modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
	    modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
	    */
		modelMap.addAttribute("cuotas", cuotasService.CuotasByIdPrestamo(idPrestamo));
		
		modelMap.addAttribute("monto_cuota", cuotasService.MontoCuotasByIdPrestamo(idPrestamo));
		
		modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
		
		return "/cuotas_detalle";
		
	}
	
	

	
	
	
	@RequestMapping( value= "redireccionar_pagoCuota", method = RequestMethod.POST )
	@ResponseBody
	public String pedirPrestamo(HttpServletRequest request,ModelMap modelMap, Integer idCuota) {

	
		modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
		System.out.println("CUOTA A PAGAR ----------- "+ idCuota);
		
		if (idCuota != 0) {
			// ACA GUARDAR PAGO DE CUOTA
			return "true";
		}
		else {
			return "false";
			}


		
	}
	
	
	
	
}