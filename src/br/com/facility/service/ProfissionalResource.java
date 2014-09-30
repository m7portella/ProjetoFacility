package br.com.facility.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.facility.bo.AtividadeProfissionalBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Profissional;

import com.google.gson.Gson;

@Path("/profissional")
public class ProfissionalResource {

	private EntityManager em;
	private AtividadeProfissionalBO apBO;
	private UsuarioBO uBO;
	
	public ProfissionalResource(){
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		apBO = new AtividadeProfissionalBO(em);
		uBO = new UsuarioBO(em);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/buscar/{id}")
	public String BuscaProfissional(@PathParam("id")int id){
		Profissional p = uBO.buscarProfissional(id);
		return new Gson().toJson(p);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/poratividade/{atividade}")
	public String listarProfissionaisPorAtividade(@PathParam("atividade")int atividade){
		List<Profissional> lista = apBO.listarProfissionalPorAtividade(atividade);
		return new Gson().toJson(lista);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/porespecialidade/{especialidade}")
	public String listarProfissionaisPorEspecialidade(@PathParam("especialidade")int especialidade){
		List<Profissional> lista = apBO.listarProfissionalPorEspecialidade(especialidade);
		return new Gson().toJson(lista);
	}
	
}
