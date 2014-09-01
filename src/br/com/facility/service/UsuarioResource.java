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
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Usuario;

import com.google.gson.Gson;

@Path("/usuario")
public class UsuarioResource {
	
	EntityManager em;
	UsuarioBO uBO;
	
	public UsuarioResource(){
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		uBO = new UsuarioBO(em);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/buscar/{id}")
	public String buscar(@PathParam("id") int id){
		Usuario u = uBO.buscar(id);		
		return new Gson().toJson(u);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cadastrar")
	public Response cadastrar(String usuarioJSON){
		Usuario u = new Gson().fromJson(usuarioJSON, Usuario.class);
		uBO.cadastrar(u);
		return Response.status(201).entity("Usuário cadastrado").build();
	}
	
}
