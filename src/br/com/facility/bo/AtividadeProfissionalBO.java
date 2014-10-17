package br.com.facility.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.AtividadeDAO;
import br.com.facility.dao.AtividadeProfissionalDAO;
import br.com.facility.dao.EspecialidadeDAO;
import br.com.facility.dao.EspecialidadeProfissionalDAO;
import br.com.facility.dao.impl.AtividadeDAOImpl;
import br.com.facility.dao.impl.AtividadeProfissionalDAOImpl;
import br.com.facility.dao.impl.EspecialidadeDAOImpl;
import br.com.facility.dao.impl.EspecialidadeProfissionalDAOImpl;
import br.com.facility.enums.TipoPreco;
import br.com.facility.to.Atividade;
import br.com.facility.to.AtividadeProfissional;
import br.com.facility.to.AtividadeProfissionalPK;
import br.com.facility.to.Especialidade;
import br.com.facility.to.EspecialidadeProfissional;
import br.com.facility.to.EspecialidadeProfissionalPK;
import br.com.facility.to.Profissional;

public class AtividadeProfissionalBO {
	
	private EntityManager em;
	private AtividadeDAO aDAO;
	private EspecialidadeDAO eDAO;
	private AtividadeProfissionalDAO apDAO;
	private EspecialidadeProfissionalDAO epDAO;
	
	public AtividadeProfissionalBO(EntityManager e){
		em = e;
		aDAO = new AtividadeDAOImpl(em);
		eDAO = new EspecialidadeDAOImpl(em);
		apDAO = new AtividadeProfissionalDAOImpl(em);
		epDAO = new EspecialidadeProfissionalDAOImpl(em);
	}
	
	public void cadastrar(AtividadeProfissional ap, Atividade a, Profissional p){
		
		//vincula Atividade e Profissional
		ap.setAtividade(a);
		ap.setProfissional(p);
		//rank e estrelas iniciais ZERO
		ap.setRank(0);
		ap.setEstrelas(0);
		
		ap.setTipoPreco(TipoPreco.SERVICO);
		ap.setPreco(0);
		
		apDAO.insert(ap);
		
	}
	
	public void cadastrar(EspecialidadeProfissional ep, Especialidade e, Profissional p){
		
		//vincula Atividade e Profissional
		ep.setEspecialidade(e);
		ep.setProfissional(p);
		//rank e estrelas iniciais ZERO
		ep.setRank(0);
		ep.setEstrelas(0);
		
		ep.setTipoPreco(TipoPreco.SERVICO);
		ep.setPreco(0);
				
		epDAO.insert(ep);
		
	}
	
	public AtividadeProfissional buscar(Atividade a, Profissional p){
		
		AtividadeProfissionalPK aPK = new AtividadeProfissionalPK();
		aPK.setAtividade(a.getId());
		aPK.setProfissional(p.getId());
		AtividadeProfissional ap = apDAO.searchByID(aPK);
		
		return ap;
		
	}
	
	public EspecialidadeProfissional buscar(Especialidade e, Profissional p){
		
		EspecialidadeProfissionalPK ePK = new EspecialidadeProfissionalPK();
		ePK.setEspecialidade(e.getId());
		ePK.setProfissional(p.getId());
		EspecialidadeProfissional ep = epDAO.searchByID(ePK);
		
		return ep;
		
	}
	
	public List<Profissional> listarProfissionalPorAtividade(int a){
		
		Atividade atividade = aDAO.searchByID(a);
		List<AtividadeProfissional> lista = apDAO.listarPorAtividade(atividade);
		List<Profissional> profissionais = new ArrayList<Profissional>();
		for (AtividadeProfissional atividadeProfissional : lista) {
			Profissional p = atividadeProfissional.getProfissional();
			profissionais.add(p);
		}
		return profissionais;
		
	}
	
	public List<AtividadeProfissional> listarAtividadePorProfissional(Profissional p){
		
		List<AtividadeProfissional> lista = apDAO.listarPorProfissional(p);
		return lista;
		
	}
	
	public List<EspecialidadeProfissional> listarEspecialidadePorProfissional(Profissional p){
		
		List<EspecialidadeProfissional> lista = epDAO.listarPorProfissional(p);
		return lista;
		
	}
	
	public List<Profissional> listarProfissionalPorEspecialidade(int e){
		
		Especialidade especialidade = eDAO.searchByID(e);
		List<EspecialidadeProfissional> lista = epDAO.listarPorEspecialidade(especialidade);
		List<Profissional> profissionais = new ArrayList<Profissional>();
		for (EspecialidadeProfissional especialidadeProfissional : lista) {
			Profissional p = especialidadeProfissional.getProfissional();
			profissionais.add(p);
		}
		return profissionais;
		
	}
	
	public void alterar(AtividadeProfissional ap){
		apDAO.update(ap);
	}
	
	public void alterar(EspecialidadeProfissional ep){
		epDAO.update(ep);
	}
	
	public void remover(AtividadeProfissional ap){
		apDAO.remove(ap);
	}
	
	public void remover(EspecialidadeProfissional ep){
		epDAO.remove(ep);
	}
	
}
