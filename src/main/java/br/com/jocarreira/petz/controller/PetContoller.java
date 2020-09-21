package br.com.jocarreira.petz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.jocarreira.petz.dto.PetDto;
import br.com.jocarreira.petz.service.PetServiceImpl;

@Controller
@RequestMapping("/pets")
public class PetContoller {

	@Autowired
	PetServiceImpl service;
	
	@RequestMapping("/form")
	public String index() {
		System.out.println("/");
		
		return "pet/form";
	}
	
	@RequestMapping(value="/listar" , method=RequestMethod.GET)
	public ModelAndView listar() {
		
		System.out.println("listar");
		
		List<PetDto> lista = (List<PetDto>) service.getAll();
		
		ModelAndView modelAndView = new ModelAndView("pet/lista");
		modelAndView.addObject("pets", lista);
		return modelAndView;
	}
	
	@RequestMapping(value="/gravar" ,method=RequestMethod.POST)
	public ModelAndView gravar(PetDto pet){

		PetDto salvo = service.save(pet);
		
		return new ModelAndView("redirect:listar");
	}
	
	@RequestMapping(value="/atualizar" ,method=RequestMethod.POST)
	public ModelAndView atualizar(PetDto pet){

		PetDto salvo = service.update(pet);
		
		return new ModelAndView("redirect:listar");
	}
	
	
	@RequestMapping(value="/excluir" ,method=RequestMethod.GET)
	public ModelAndView excluir(Long id){

		if (!service.delete(id)) {
			return new ModelAndView("redirect:erro");
		}
		return new ModelAndView("redirect:listar");
	}
	
}
