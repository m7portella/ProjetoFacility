package br.com.facility.bo;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.facility.dao.ProfissionalDAO;
import br.com.facility.dao.impl.ProfissionalDAOImpl;
import br.com.facility.enums.StatusProfissional;
import br.com.facility.enums.StatusValidacao;
import br.com.facility.enums.TipoPessoa;
import br.com.facility.to.Profissional;

public class ProfissionalBO {

	private EntityManager em;
	private ProfissionalDAO pDAO;

	public ProfissionalBO(EntityManager e) {
		em = e;
		pDAO = new ProfissionalDAOImpl(em);
	}

	// TODO métodos a implementar
	// buscar por usuario

	public void inserir(Profissional p) {

		TipoPessoa t = p.getTipo();

		if ((t == TipoPessoa.FISICA && p.getClienteFisico() != null)
				|| (t == TipoPessoa.JURIDICA) && p.getClienteJuridico() != null) {

			p.setStatusValidacao(StatusValidacao.AGUARDANDO_VALIDACAO);
			p.setDataCadastro(Calendar.getInstance());
			p.setStatus(StatusProfissional.VALIDAR);
			p.setDataStatus(Calendar.getInstance());

			// TODO definir regras para uso do rank
			p.setRank(0);

			pDAO.insert(p);

		}

	}

	public void deletar(Profissional p) {

		p.setStatus(StatusProfissional.DELETADO);
		p.setDataStatus(Calendar.getInstance());

		pDAO.update(p);

	}

	public void alterar(Profissional p) {
		pDAO.update(p);
	}

	public Profissional consultar(int id) {
		Profissional p = pDAO.searchByID(id);
		return p;
	}

	public void validar(Profissional p) {
		p.setStatusValidacao(StatusValidacao.VALIDADO);
		p.setStatus(StatusProfissional.ATIVO);
		p.setDataStatus(Calendar.getInstance());

		pDAO.update(p);
	}

}
