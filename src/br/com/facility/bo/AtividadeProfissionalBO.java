package br.com.facility.bo;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.facility.dao.AtividadeProfissionalDAO;
import br.com.facility.dao.EspecialidadeProfissionalDAO;
import br.com.facility.dao.impl.AtividadeProfissionalDAOImpl;
import br.com.facility.dao.impl.EspecialidadeProfissionalDAOImpl;
import br.com.facility.to.Atividade;
import br.com.facility.to.AtividadeProfissional;
import br.com.facility.to.AtividadeProfissionalPK;
import br.com.facility.to.Especialidade;
import br.com.facility.to.EspecialidadeProfissional;
import br.com.facility.to.EspecialidadeProfissionalPK;
import br.com.facility.to.Profissional;

public class AtividadeProfissionalBO {
	
	private EntityManager em;
	private AtividadeProfissionalDAO apDAO;
	private EspecialidadeProfissionalDAO epDAO;
	
	public AtividadeProfissionalBO(EntityManager e){
		em = e;
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
		
		apDAO.insert(ap);
		
	}
	
	public void cadastrar(EspecialidadeProfissional ep, Especialidade e, Profissional p){
		
		//vincula Atividade e Profissional
		ep.setEspecialidade(e);
		ep.setProfissional(p);
		//rank e estrelas iniciais ZERO
		ep.setRank(0);
		ep.setEstrelas(0);
				
		epDAO.insert(ep);
		
	}
	
	public AtividadeProfissional consultar(Atividade a, Profissional p){
		
		AtividadeProfissionalPK aPK = new AtividadeProfissionalPK();
		aPK.setAtividade(a.getId());
		aPK.setProfissional(p.getId());
		AtividadeProfissional ap = apDAO.searchByID(aPK);
		
		return ap;
		
	}
	
	public EspecialidadeProfissional consultar(Especialidade e, Profissional p){
		
		EspecialidadeProfissionalPK ePK = new EspecialidadeProfissionalPK();
		ePK.setEspecialidade(e.getId());
		ePK.setProfissional(p.getId());
		EspecialidadeProfissional ep = epDAO.searchByID(ePK);
		
		return ep;
		
	}
	
	public List<AtividadeProfissional> listarProfissionalPorAtividade(Atividade a){
		
		List<AtividadeProfissional> lista = apDAO.listarPorAtividade(a);
		return lista;
		
	}
	
	public List<AtividadeProfissional> listarAtividadePorProfissional(Profissional p){
		
		List<AtividadeProfissional> lista = apDAO.listarPorProfissional(p);
		return lista;
		
	}
	
	public List<EspecialidadeProfissional> listarEspecialidadePorProfissional(Profissional p){
		
		List<EspecialidadeProfissional> lista = epDAO.listarPorProfissional(p);
		return lista;
		
	}
	
	public List<EspecialidadeProfissional> listarProfissionalPorEspecialidade(Especialidade e){
		
		List<EspecialidadeProfissional> lista = epDAO.listarPorEspecialidade(e);
		return lista;
		
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
