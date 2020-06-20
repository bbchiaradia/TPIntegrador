package utn.frgp.edu.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaginaController {
	
	
	@RequestMapping("redireccionar_Index.html")
	public ModelAndView eventoRedireccionar_Index() {
		
		ModelAndView MV= new ModelAndView();
		return MV;
		
	}
}
