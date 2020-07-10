package utn.frgp.edu.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import utn.frgp.edu.ar.dao.clientesService;
import utn.frgp.edu.ar.dao.conceptoService;
import utn.frgp.edu.ar.dao.conceptosService;
import utn.frgp.edu.ar.dao.cuentasService;
import utn.frgp.edu.ar.dao.movimientosService;
import utn.frgp.edu.ar.dao.nacionalidadService;
import utn.frgp.edu.ar.dao.sexoService;
import utn.frgp.edu.ar.dao.ubicacionService;
import utn.frgp.edu.ar.dao.usuariosService;
import utn.frgp.edu.ar.entidad.Clientes;
import utn.frgp.edu.ar.entidad.Conceptos;
import utn.frgp.edu.ar.entidad.Movimientos;
import utn.frgp.edu.ar.entidad.TipoCuenta;
import utn.frgp.edu.ar.entidad.Usuarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import utn.frgp.edu.ar.dao.sexoService;

@Controller
public class informeController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping("redireccionar_detalle_informe.html")
	public String eventoRedireccionar_detalle_cuenta(ModelMap modelMap, Integer id , String fhasta , String fdesde) {

	  Double suma = 0.0 ;
	  System.out.println("GOOLLLLLLLLLLLLLLLL " + conceptosService.getConceptosById(id).getDescripcion() + " FECHA " + fhasta);
      modelMap.addAttribute("detalleConcepto", conceptosService.getConceptosById(id));	
      modelMap.addAttribute("fechaDesde",  fdesde);	
      modelMap.addAttribute("fechaHasta", fhasta);	
     
     
     modelMap.addAttribute("movimientos", movimientosService.MovimientoByIdCuenta(id));	
     modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
	  modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
	  
	  List <Movimientos> movimientos = movimientosService.MovimientoByIdConcepto(id, fdesde.replace("/", "-"), fhasta.replace("/", "-")) ;
	  for (Movimientos movimientos2 : movimientos) {
		  suma  = suma + movimientos2.getImporte();
	  }
	  System.out.println("SALDO " + suma);
	  modelMap.addAttribute("saldo", suma);	
	  modelMap.addAttribute("movimientos",movimientos);
	  
	  
		return "/detalle_informe";
		
	}
	
	@RequestMapping(value = "informePOST" , method = RequestMethod.POST)
	public String lista59(ModelMap modelMap, HttpServletRequest request) {
	//@RequestMapping(value = "informePOST" , method = RequestMethod.GET)
	//public String lista59(ModelMap modelMap) {
		modelMap.addAttribute("listaconcepto", conceptoService.getConceptos());
		modelMap.addAttribute("listatcuenta", cuentasService.listarTipoCuentas());
		modelMap.addAttribute("txtbusqueda", "565");
		System.out.println("Tipo de cuenta: " + request.getParameter("tcuenta"));
		System.out.println("Fecha Desde: " + request.getParameter("fdesde"));	
		System.out.println("Fecha Hasta: " + request.getParameter("fhasta"));	
		System.out.println("Concepto: " + request.getParameter("concepto"));	

		modelMap.addAttribute("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		modelMap.addAttribute("rol", usuariosService.RolUsuarioLogueado());
		
		return "/informe";		
	}
	
	@RequestMapping("redireccionar_informe.html")
	public ModelAndView eventoRedireccionar_informe() {		
		ModelAndView MV= new ModelAndView();
		MV.setViewName("informe");
		MV.addObject("listaconcepto", conceptoService.getConceptos());
		MV.addObject("listatcuenta", cuentasService.listarTipoCuentas());
		
		MV.addObject("nombreLogin",usuariosService.UsuarioLogueado().getNombreUsuario());
		MV.addObject("rol", usuariosService.RolUsuarioLogueado());
		
		return MV;
		
	}

}
