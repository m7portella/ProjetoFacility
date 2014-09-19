package br.com.facility.service;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.config.Security_Util;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Usuario;

import com.google.gson.Gson;

@Path("/usuario")
public class UsuarioResource {
	
	private EntityManager em;
	private UsuarioBO uBO;
	
	public UsuarioResource(){
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		uBO = new UsuarioBO(em);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/buscar/{id}")
	public String buscar(@PathParam("id") int id){
		
		//busca e retorna Usuario
		Usuario u = uBO.buscar(id);		
		return new Gson().toJson(u);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/cadastrar")
	public Response cadastrar(String usuarioJSON){
		
		//recupera json
		try {
			usuarioJSON = java.net.URLDecoder.decode(usuarioJSON, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int pos = usuarioJSON.indexOf("{");
		String json = usuarioJSON.substring(pos,usuarioJSON.length());
		Usuario u = new Gson().fromJson(json, Usuario.class);
		
		//cadastra Usuario e retorna status
		uBO.cadastrar(u);
		return Response.status(201).entity("Usuário cadastrado").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/login")
	public String logar(String usuarioJSON){
		
		//recupera json
		try {
			usuarioJSON = java.net.URLDecoder.decode(usuarioJSON, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int pos = usuarioJSON.indexOf("{");
		String json = usuarioJSON.substring(pos,usuarioJSON.length());
		Usuario u = new Gson().fromJson(json, Usuario.class);
		
		//descriptografa login e senha
		String login = u.getUsername();
		String senha = u.getSenha();
		try {
			login = Security_Util.decrypt(login);
			senha = Security_Util.decrypt(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//busca e retorna Usuario
		u = uBO.logar(login, senha);
		return new Gson().toJson(u);
	}
	
}
