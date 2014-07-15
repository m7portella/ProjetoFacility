package br.com.facility.bo;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.facility.dao.ClienteFisicoDAO;
import br.com.facility.dao.ClienteJuridicoDAO;
import br.com.facility.dao.UsuarioDAO;
import br.com.facility.dao.impl.ClienteFisicoDAOImpl;
import br.com.facility.dao.impl.ClienteJuridicoDAOImpl;
import br.com.facility.dao.impl.UsuarioDAOImpl;
import br.com.facility.enums.StatusUsuario;
import br.com.facility.enums.TipoPessoa;
import br.com.facility.enums.TipoUsuario;
import br.com.facility.to.ClienteFisico;
import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.Usuario;

public class UsuarioBO {

	private EntityManager em;
	private UsuarioDAO uDAO;
	private ClienteFisicoDAO cfDAO;
	private ClienteJuridicoDAO cjDAO;

	public UsuarioBO(EntityManager e) {
		// em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		em = e;
		uDAO = new UsuarioDAOImpl(em);
		cfDAO = new ClienteFisicoDAOImpl(em);
		cjDAO = new ClienteJuridicoDAOImpl(em);
	}

	public void cadastrar(Usuario u) {

		// RN - Usuários são cadastrados inicialmente com tipo USUARIO
		u.setTipo(TipoUsuario.USUARIO);
		// data de cadastro atual
		u.setDataCadastro(Calendar.getInstance());
		// status inicial AGUARDANDO CONFIRMAÇÃO
		u.setStatus(StatusUsuario.AGUARDANDO_CONFIRMACAO);
		u.setDataStatus(Calendar.getInstance());

		uDAO.insert(u);
	}

	public void cadastrarClienteFisico(Usuario u, ClienteFisico cf) {
		
		// RN - pega o id do Usuário e coloca no CLiente
		cf.setId(u.getId());
		
		u.setTipo(TipoUsuario.CLIENTE);
		u.setTipoPessoa(TipoPessoa.FISICA);
		cf.setUsuario(u);
		cfDAO.insert(cf);
	}
	
	public ClienteFisico consultarClienteFisico(int id){
		ClienteFisico cf = cfDAO.searchByID(id);
		return cf;
	}
	
	public void cadastrarClienteJuridico(Usuario u, ClienteJuridico cj) {
		// RN - pega o id do Usuário e coloca no CLiente
		cj.setId(u.getId());
		
		u.setTipo(TipoUsuario.CLIENTE);
		u.setTipoPessoa(TipoPessoa.JURIDICA);
		cj.setUsuario(u);
		cjDAO.insert(cj);
	}
	
	public ClienteJuridico consultarClienteJuridico(int id){
		ClienteJuridico cj = cjDAO.searchByID(id);
		return cj;
	}
	
	public void alterarClienteFisico(ClienteFisico cf){
		cfDAO.update(cf);
	}
	
	public void alterarClienteJuridico(ClienteJuridico cj){
		cjDAO.update(cj);
	}

	// RN - Nâo será possível remover Usuário do banco de dados
	//public void remover(Usuario u){ uDAO.remove(u); }

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

	public void alterar(Usuario u) {
		uDAO.update(u);
	}
	
	public void alterar(ClienteFisico cf){
		cfDAO.update(cf);
	}
	
	public void alterar(ClienteJuridico cj){
		cjDAO.update(cj);
	}

	public Usuario consultar(int id) {
		Usuario u = uDAO.searchByID(id);
		return u;
	}

	public void ativar(Usuario u) {

		u.setStatus(StatusUsuario.ATIVO);
		u.setDataStatus(Calendar.getInstance());

		uDAO.update(u);
	}

}
