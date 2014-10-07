package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.facility.dao.ProfissionalDAO;
import br.com.facility.to.Atividade;
import br.com.facility.to.Categoria;
import br.com.facility.to.Especialidade;
import br.com.facility.to.Profissional;

public class ProfissionalDAOImpl extends DAOImpl<Profissional, Integer> implements ProfissionalDAO{

	public ProfissionalDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<Profissional> listar() {
		Query q = em.createQuery("from Profissional");
		List<Profissional> lista = q.getResultList();
		return lista;
	}

	@Override
	public List<Profissional> buscarProfissionalPorNome(String nome) {
		TypedQuery<Profissional> query = em.createQuery("from Profissional p where p.nome like :nome",Profissional.class);
		query.setParameter("nome","%"+ nome + "%");
		return query.getResultList();
	}

	@Override
	public List<Profissional> buscarProfissionalPorCidade(String cidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profissional> buscarProfissionalPorCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profissional> buscarProfissionalPorAtividade(Atividade atividade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profissional> buscarProfissionalPorEspecialidade(
			Especialidade especialidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
