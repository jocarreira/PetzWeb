package br.com.jocarreira.petz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.jocarreira.petz.dto.ClienteDto;
import br.com.jocarreira.petz.service.ClienteServiceImpl;

@Controller
@RequestMapping("/clientes")
public class ClienteControler {

	@Autowired
	ClienteServiceImpl service;
	
	@RequestMapping("/form")
	public String index() {
		System.out.println("/");
		
		return "cliente/form";
	}
	
	@RequestMapping(value="/listar" , method=RequestMethod.GET)
	public ModelAndView listar() {
		
		System.out.println("listar");
		
		List<ClienteDto> lista = (List<ClienteDto>) service.getAll();
		
		ModelAndView modelAndView = new ModelAndView("cliente/lista");
		modelAndView.addObject("clientes", lista);
		return modelAndView;
	}
	
	@RequestMapping(value="/gravar" ,method=RequestMethod.POST)
	public ModelAndView gravar(ClienteDto cliente){

		ClienteDto salvo = service.save(cliente);
		
		return new ModelAndView("redirect:listar");
	}
	
	@RequestMapping(value="/atualizar" ,method=RequestMethod.POST)
	public ModelAndView atualizar(ClienteDto cliente){

		ClienteDto salvo = service.update(cliente);
		
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
