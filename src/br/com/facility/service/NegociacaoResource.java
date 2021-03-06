package br.com.facility.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Mensagem;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

import com.google.gson.Gson;

@Path("/negociacao")
public class NegociacaoResource {
	
	private UsuarioBO uBO;
	private NegociacaoBO nBO;
	//private MensagemBO mBO;
	
	public NegociacaoResource(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		uBO = new UsuarioBO(em);
		nBO = new NegociacaoBO(em);
		//mBO = new MensagemBO(em);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/listar/{id}")
	public String listar(@PathParam("id") int id){
		Usuario u = uBO.buscar(id);
		List<Negociacao> lista = nBO.listarPorUsuario(u);
		return new Gson().toJson(lista);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/listarporprofissional/{id}")
	public String listarPorProfissional(@PathParam("id") int id){
		Profissional p = uBO.buscarProfissional(id);
		List<Negociacao> lista = nBO.listarPorProfissional(p);
		return new Gson().toJson(lista);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/msgs/{protocolo}")
	public String listarMensagens(@PathParam("protocolo") long protocolo){
		Negociacao n = nBO.buscar(protocolo);
		List<Mensagem> lista = nBO.listarPorNegociacao(n);
		return new Gson().toJson(lista);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/msg")
	public Response cadastrar(String usuarioJSON){
		
		//recupera json
		try {
			usuarioJSON = java.net.URLDecoder.decode(usuarioJSON, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int pos = usuarioJSON.indexOf("{");
		String json = usuarioJSON.substring(pos,usuarioJSON.length());
		Mensagem m = new Gson().fromJson(json, Mensagem.class);
		
		//cadastra Usuario e retorna status
		nBO.enviaMensagem(m);
		return Response.status(201).entity("Mensagem cadastrada").build();
	}
}
