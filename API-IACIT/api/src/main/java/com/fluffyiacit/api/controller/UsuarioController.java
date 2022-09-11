package com.fluffyiacit.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fluffyiacit.api.modal.EstacaoModal;
import com.fluffyiacit.api.modal.UsuarioModal;
import com.fluffyiacit.api.repositorios.EstacaoRepository;
import com.fluffyiacit.api.repositorios.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController{
	
	//Trocar para SERVICE posteriormente
	@Autowired
	private UsuarioRepository usuariorepository;
	
	@Autowired(required=true)
	private EstacaoRepository aaaaaaaaaaa;
	
	//PAGINA CADASTRAR
	@RequestMapping(value = {"/novo"}, method = RequestMethod.GET)
	public ModelAndView formulario() {
		ModelAndView modelAndView = new ModelAndView();
		
		//PASSANDO VALORES PARA DENTRO DO HTML ATRAVES DO THYMELEAF
		UsuarioModal usuariomodal = new UsuarioModal();
		usuariomodal.setNome("");
		usuariomodal.setSenha("");
		modelAndView.addObject("registroAtual", usuariomodal);
		
		//BORA BILL
		List<EstacaoModal> usu = (List<EstacaoModal>) aaaaaaaaaaa.listar("A702");
		modelAndView.addObject("AA", usu);
		
		//INFORMANDO A PAGINA QUE SERA MOSTRADA
		modelAndView.setViewName("usuario-formulario");
		return modelAndView;
	}
	
	
//	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
//	public RedirectView redirecionamento() {
//		RedirectView redirectView = new RedirectView();
//	    redirectView.setUrl("http://localhost:8080/usuario/");
//	    return redirectView;
//	}
	
	
	//EVENTO CADASTRAR
		@RequestMapping(value = {"/salvar"}, method = RequestMethod.POST)
		public ModelAndView salvar(UsuarioModal usuariomodal) {
			
			//System.out.println("Conta:" + usuariomodal.getNome());
			//System.out.println("Conta:" + usuariomodal.getSenha());
			
			ModelAndView modelAndView = new ModelAndView();
			try {
				usuariorepository.save(usuariomodal);
				return listagem();
			} catch (Exception ex) {
				// TODO: handle exception
				modelAndView.setViewName("usuario-formulario");
			}
			return modelAndView;
		}
	
	//LISTAR TABELA
	@RequestMapping(value = {"/", "/lista"}, method = RequestMethod.GET)
	public ModelAndView listagem() {
		ModelAndView modelAndView = new ModelAndView();
		List<UsuarioModal> listaUsuario = (List<UsuarioModal>) usuariorepository.findAll();
		modelAndView.setViewName("usuario-lista");
		modelAndView.addObject("registros", listaUsuario);
		return modelAndView;
	}
	

	//EVENTO EDITAR
	@RequestMapping(value = {"/editar/{id}"}, method = RequestMethod.GET)
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		UsuarioModal usuariomodal = usuariorepository.findById(id).get();
		modelAndView.setViewName("usuario-formulario");
		modelAndView.addObject("registroAtual", usuariomodal);
		return modelAndView;
	}
	
	//EVENTO EXCLUIR
	@RequestMapping(value = {"/excluir/{id}"}, method = RequestMethod.GET)
	public ModelAndView excluir(@PathVariable("id") Integer id) {
		UsuarioModal usuariomodal = usuariorepository.findById(id).get();
		usuariorepository.delete(usuariomodal);
		
		return listagem();
	}
	
	


}
