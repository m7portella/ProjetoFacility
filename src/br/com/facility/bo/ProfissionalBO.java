package br.com.facility.bo;

import java.util.Calendar;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;

import br.com.facility.dao.LocalAtendimentoDAO;
import br.com.facility.dao.ProfissionalDAO;
import br.com.facility.dao.impl.ProfissionalDAOImpl;
import br.com.facility.enums.StatusProfissional;
import br.com.facility.enums.StatusValidacao;
import br.com.facility.enums.TipoPessoa;
import br.com.facility.enums.TipoUsuario;
import br.com.facility.to.ClienteFisico;
import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.LocalAtendimento;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

public class ProfissionalBO {

	private EntityManager em;
	private ProfissionalDAO pDAO;
	private UsuarioBO uBO;

	public ProfissionalBO(EntityManager e) {
		em = e;
		pDAO = new ProfissionalDAOImpl(em);
		uBO = new UsuarioBO(em);
	}

	public void cadastrar(Usuario u, Profissional p) {

		// Busca Cliente conforme tipo de pessoa e atribui ao Profissional
		TipoPessoa t = u.getTipoPessoa();
		
		if (t == TipoPessoa.FISICA) {
			
			ClienteFisico cf = uBO.consultarClienteFisico(u.getId());
			p.setClienteFisico(cf);
			p.setTipo(TipoPessoa.FISICA);
			
		} else if (t == TipoPessoa.JURIDICA) {
			
			ClienteJuridico cj = uBO.consultarClienteJuridico(u.getId());
			p.setClienteJuridico(cj);
			p.setTipo(TipoPessoa.JURIDICA);
			
		} else {
			// trava o cadastro se não tiver cadastro como Cliente
			Error e = new Error("Nenhum cliente cadastrado para este usuário");
			throw new RuntimeErrorException(e);
		}
		
		// RN - usa a chave do Usuário/Cliente no Profissional
		p.setId(u.getId());
		// altera tipo de Usuario para PROFISSIONAL
		u.setTipo(TipoUsuario.PROFISSIONAL);
		// Status inicial AGUARDADNO VALIDACAO
		p.setStatusValidacao(StatusValidacao.AGUARDANDO_VALIDACAO);
		p.setDataCadastro(Calendar.getInstance());
		p.setStatus(StatusProfissional.VALIDAR);
		p.setDataStatus(Calendar.getInstance());

		// TODO definir regras para uso do rank
		p.setRank(0);

		pDAO.insert(p);
		uBO.alterar(u);
		
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
	
	
	public void inserirLocaisAtendimento(Profissional profissional, List<LocalAtendimento> lstLocal){
		profissional.setLocaisAtendimento(lstLocal);
		pDAO.update(profissional);
	}
	
	public void removerLocalAtendimento(Profissional profissional, int indice){
		List<LocalAtendimento> lstLocal = profissional.getLocaisAtendimento();
		lstLocal.remove(indice);
		profissional.setLocaisAtendimento(lstLocal);
		
		pDAO.update(profissional);
		
	}

}
