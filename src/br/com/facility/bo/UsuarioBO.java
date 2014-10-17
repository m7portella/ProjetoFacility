package br.com.facility.bo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;

import br.com.facility.dao.ClienteFisicoDAO;
import br.com.facility.dao.ClienteJuridicoDAO;
import br.com.facility.dao.ProfissionalDAO;
import br.com.facility.dao.UsuarioDAO;
import br.com.facility.dao.UsuarioGcmDAO;
import br.com.facility.dao.impl.ClienteFisicoDAOImpl;
import br.com.facility.dao.impl.ClienteJuridicoDAOImpl;
import br.com.facility.dao.impl.ProfissionalDAOImpl;
import br.com.facility.dao.impl.UsuarioDAOImpl;
import br.com.facility.dao.impl.UsuarioGcmDAOImpl;
import br.com.facility.enums.StatusProfissional;
import br.com.facility.enums.StatusUsuario;
import br.com.facility.enums.StatusValidacao;
import br.com.facility.enums.TipoPessoa;
import br.com.facility.enums.TipoUsuario;
import br.com.facility.to.ClienteFisico;
import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.LocalAtendimento;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;
import br.com.facility.to.UsuarioGCM;

public class UsuarioBO {

	private EntityManager em;
	private UsuarioDAO uDAO;
	private UsuarioGcmDAO gcmDAO;
	private ClienteFisicoDAO cfDAO;
	private ClienteJuridicoDAO cjDAO;
	private ProfissionalDAO pDAO;

	public UsuarioBO(EntityManager e) {
		// em =
		// EntityManagerFactorySingleton.getInstance().createEntityManager();
		em = e;
		uDAO = new UsuarioDAOImpl(em);
		cfDAO = new ClienteFisicoDAOImpl(em);
		cjDAO = new ClienteJuridicoDAOImpl(em);
		pDAO = new ProfissionalDAOImpl(em);
		gcmDAO = new UsuarioGcmDAOImpl(em);
	}
	
	public void cadastrarGCM(int usuarioId, String registrationId){
		Usuario u = uDAO.searchByID(usuarioId);
		UsuarioGCM gcm = new UsuarioGCM();
		gcm.setUsuario(u);
		gcm.setRegistrationId(registrationId);
		gcmDAO.insert(gcm);
	}
	
	public List<String> listarGCM(int usuarioId){
		Usuario u = uDAO.searchByID(usuarioId);
		List<UsuarioGCM> lista = gcmDAO.listarPorUsuario(u);
		List<String> gcm = new ArrayList<String>();
		for (UsuarioGCM usuarioGCM : lista) {
			gcm.add(usuarioGCM.getRegistrationId());
		}
		return gcm;
	}

	public void cadastrar(Usuario u) {

		// RN - Usuários são cadastrados inicialmente com tipo USUARIO
		u.setTipo(TipoUsuario.USUARIO);
		// data de cadastro atual
		u.setDataCadastro(Calendar.getInstance());
		// status inicial AGUARDANDO CONFIRMAÇÃO
		u.setStatus(StatusUsuario.AGUARDANDO_CONFIRMACAO);
		u.setDataStatus(Calendar.getInstance());
		u.setNome(u.getUsername());

		uDAO.insert(u);

	}

	public Usuario logar(String login, String senha) {

		Usuario u;

		u = uDAO.buscarPorUsername(login);
		if (u == null) {
			u = uDAO.buscarPorEmail(login);
		}

		if (u != null) {
			if (u.getSenha().equals(senha)) {
				return u;
			}
		}
		return null;
	}

	public Usuario buscarPorUsername(String username) {
		return uDAO.buscarPorUsername(username);
	}

	public Usuario buscarPorEmail(String email) {
		return uDAO.buscarPorEmail(email);
	}

	public void alterar(Usuario u) {
		uDAO.update(u);
	}

	public Usuario buscar(int id) {
		Usuario u = uDAO.searchByID(id);
		return u;
	}

	public void ativar(Usuario u) {

		u.setStatus(StatusUsuario.ATIVO);
		u.setDataStatus(Calendar.getInstance());

		uDAO.update(u);
	}

	// CLIENTE //

	public void cadastrarClienteFisico(Usuario u, ClienteFisico cf) {

		// RN - pega o id do Usuário e coloca no CLiente
		cf.setId(u.getId());

		u.setTipo(TipoUsuario.CLIENTE);
		u.setTipoPessoa(TipoPessoa.FISICA);
		u.setNome(cf.getNome() + " " + cf.getSobrenome());
		cf.setUsuario(u);
		cfDAO.insert(cf);
	}

	public ClienteFisico buscarClienteFisico(int id) {
		ClienteFisico cf = cfDAO.searchByID(id);
		return cf;
	}

	public void cadastrarClienteJuridico(Usuario u, ClienteJuridico cj) {
		// RN - pega o id do Usuário e coloca no CLiente
		cj.setId(u.getId());

		u.setTipo(TipoUsuario.CLIENTE);
		u.setTipoPessoa(TipoPessoa.JURIDICA);
		u.setNome(cj.getNomeFantasia());
		cj.setUsuario(u);
		cjDAO.insert(cj);
	}

	public ClienteJuridico buscarClienteJuridico(int id) {
		ClienteJuridico cj = cjDAO.searchByID(id);
		return cj;
	}

	public void alterarClienteFisico(ClienteFisico cf) {
		cfDAO.update(cf);
	}

	public void alterarClienteJuridico(ClienteJuridico cj) {
		cjDAO.update(cj);
	}

	public void deletar(Usuario u) {

		// RN - usuários deletados são mantidos no BD com status DELETADO
		u.setStatus(StatusUsuario.DELETADO);
		u.setDataStatus(Calendar.getInstance());

		uDAO.update(u);
	}

	public void deletar(ClienteFisico cf) {

		// RN - clientes deletados são mantidos no BD com status DELETADO
		Usuario u = cf.getUsuario();
		u.setStatus(StatusUsuario.DELETADO);
		u.setDataStatus(Calendar.getInstance());
		cf.setUsuario(u);

		cfDAO.update(cf);
	}

	public void deletar(ClienteJuridico cj) {

		// RN - clientes deletados são mantidos no BD com status DELETADO
		Usuario u = cj.getUsuario();
		u.setStatus(StatusUsuario.DELETADO);
		u.setDataStatus(Calendar.getInstance());
		cj.setUsuario(u);

		cjDAO.update(cj);
	}

	public void alterar(ClienteFisico cf) {
		Usuario u = cf.getUsuario();
		u.setNome(cf.getNome() + " " + cf.getSobrenome());
		cf.setUsuario(u);
		cfDAO.update(cf);
	}

	public void alterar(ClienteJuridico cj) {
		Usuario u = cj.getUsuario();
		u.setNome(cj.getNomeFantasia());
		cj.setUsuario(u);
		cjDAO.update(cj);
	}

	// PROFISSIONAL //

	public void cadastrarProfissional(Usuario u, Profissional p) {

		// Busca Cliente conforme tipo de pessoa e atribui ao Profissional
		TipoPessoa t = u.getTipoPessoa();

		if (t == TipoPessoa.FISICA) {

			ClienteFisico cf = cfDAO.searchByID(u.getId());
			p.setClienteFisico(cf);
			p.setTipo(TipoPessoa.FISICA);
			p.setNome(cf.getNome() + " " + cf.getSobrenome());

		} else if (t == TipoPessoa.JURIDICA) {

			ClienteJuridico cj = cjDAO.searchByID(u.getId());
			p.setClienteJuridico(cj);
			p.setTipo(TipoPessoa.JURIDICA);
			p.setNome(cj.getNomeFantasia());

		} else {
			// trava o cadastro se não tiver cadastro como Cliente
			Error e = new Error("Nenhum cliente cadastrado para este Usuario");
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
		uDAO.update(u);

	}

	public void deletar(Profissional p) {

		p.setStatus(StatusProfissional.DELETADO);
		p.setDataStatus(Calendar.getInstance());

		pDAO.update(p);

	}
	
	public void removerDoBanco(Profissional p){
		pDAO.remove(p);
	}

	public void alterar(Profissional p) {
		pDAO.update(p);
	}

	public Profissional buscarProfissional(int id) {
		Profissional p = pDAO.searchByID(id);
		return p;
	}

	public void validar(Profissional p) {
		p.setStatusValidacao(StatusValidacao.VALIDADO);
		p.setStatus(StatusProfissional.ATIVO);
		p.setDataStatus(Calendar.getInstance());

		pDAO.update(p);
	}

	public List<Profissional> listarProfissional() {
		List<Profissional> lista = pDAO.listar();
		return lista;
	}

	// LOCAL ATENDIMENTO - PROFISSIONAL //

	public void inserirLocaisAtendimento(Profissional profissional,
			List<LocalAtendimento> lstLocal) {
		profissional.setLocaisAtendimento(lstLocal);
		pDAO.update(profissional);
	}

	public void removerLocalAtendimento(Profissional profissional, int indice) {
		List<LocalAtendimento> lstLocal = profissional.getLocaisAtendimento();
		lstLocal.remove(indice);
		profissional.setLocaisAtendimento(lstLocal);

		pDAO.update(profissional);

	}

}
