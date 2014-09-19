package br.com.facility.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Atividade;
import br.com.facility.to.Categoria;
import br.com.facility.to.Especialidade;

import com.google.gson.Gson;

@Path("/atividade")
public class AtividadeResource {

	private EntityManager em;
	private AtividadeBO aBO;
	
	public AtividadeResource(){
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		aBO = new AtividadeBO(em);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/categorias")
	public String listarCategorias(){
		List<Categoria> lista = aBO.listarCategorias();
		return new Gson().toJson(lista);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/listar")
	public String listarAtividades(){
		List<Atividade> lista = aBO.listarAtividades();
		return new Gson().toJson(lista);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/listar/{categoria}")
	public String listarAtividadesPorCategoria(@PathParam("categoria")int categoria){
		Categoria c = aBO.buscarCategoria(categoria);
		List<Atividade> lista = aBO.listarAtividades(c);
		return new Gson().toJson(lista);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/especialidades/{atividade}")
	public String listarEspecialidades(@PathParam("atividade")int atividade){
		Atividade a = aBO.buscarAtividade(atividade);
		List<Especialidade> lista = aBO.listarEspecialidades(a);
		return new Gson().toJson(lista);
	}
}
