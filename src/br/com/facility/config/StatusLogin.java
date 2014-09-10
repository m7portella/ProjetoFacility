////package com.status.controle;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Locale;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.status.modelo.cobradores.CobradoresDao;
//import com.status.modelo.usuario.Usuario;
//import com.status.modelo.usuario.UsuarioDao;
//
///**
// * Servlet cuida da autenticação ao servidor web,
// * dados recebidos e enviados, criptografados com AES 128
// * @author Status Informática
// * Alterado em: 24/05/2013
// */
//@WebServlet("/Login")
//public class StatusLogin extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		this.processaRequisicao(request, response);
//	}
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		this.processaRequisicao(request, response);
//	}
//	/**
//	 * processa o pedido de autenticação ao servidor web
//	 * @param request
//	 * @param response
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	protected void processaRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//cria uma nova sessão, cada login terá um ID
//		HttpSession session=request.getSession();
//		StringBuffer log=new StringBuffer();
//		
//		//escreve o ip
//		log.append("IP:"+request.getRemoteAddr()+" - ");
//		
//		try{
//			Usuario usuBean=new Usuario();
//			UsuarioDao usuDao=new  UsuarioDao();
//			int reset=0;
//
//			//0-Normal, 1-Invalida a Sessão
//			if(request.getParameter("reset") != null)
//				reset=1;	
//
//			//setando usuario e login e descriptografando
//			session.setAttribute("usuario", Security_Util.decrypt(request.getParameter("usuario")));
//			session.setAttribute("senha", Security_Util.decrypt(request.getParameter("senha")));
//			session.setAttribute("optCon", request.getParameter("optCon"));	
//
//			String usuario=(String)session.getAttribute("usuario");
//			String senha=(String)session.getAttribute("senha");
//			int optCon=Integer.valueOf((String)session.getAttribute("optCon"));
//
//			log.append(" Mensageiro no acesso: "+usuario);
//
//			//TESTE
//			/*
//		session.setAttribute("usuario","MSG100");
//		session.setAttribute("senha", "MSG100");
//			 */
//
//			if((usuario == null)||(senha == null)){
//				throw new IllegalArgumentException(" Digite Usuario e Senha!");
//			}
//
//			//verificar
//			if(session.isNew()){
//				log.append(" Logando...");
//
//				try{
//					usuBean=usuDao.validaAcesso(usuario,senha,optCon);
//				}catch(Exception erro){
//					if(erro.getMessage().contains("ACCESS_NOT_PERMITTED"))
//						response.getWriter().println("ACCESS_NOT_PERMITTED");
//
//					throw erro;
//				}
//				
//				//se passou no login
//				if(usuBean != null){
//					response.setContentType("text/html");
//					response.setLocale(Locale.getDefault());
//					response.setCharacterEncoding(Security_Util.ISO_8859_1);
//					
//					PrintWriter out = response.getWriter();
//					out.println(Security_Util.encrypt(usuBean.getNome()));
//					
//					int modo=0;
//					try {
//						modo=new CobradoresDao(this.getServletContext()).verificaModo(Integer.valueOf(usuario.substring(3)), optCon);
//					} catch (Exception e) {
//						//caso dispare Exceção pega o parametro padrão
//						modo=Integer.parseInt(this.getServletContext().getInitParameter("modo"));
//					}
//					
//					log.append(", mensageiro logado: "+usuBean.getId()+"-"+usuBean.getNome()+
//							" - modo: "+(modo == 1 ?
//											"Produção":
//												"Homologação"));	
//
//					//apos logar invalida a sessao para poder usar serviços
//					if(reset == 1){
//						session.invalidate();
//						log.append(", autenticação OK. ");
//					}
//
//				}else{
//					//senão
//					log.append(" Mensageiro não encontrado ou sem conexão com servidor.");
//					session.invalidate();
//				}
//				
//			}else{
//				log.append(" Usuário já esta logado!");
//
//				try{
//					if(session != null)
//						session.invalidate();
//				}catch (Exception e) {
//					log.append(" Erro ao invalidar sessao.");
//				}
//			}
//			
//		}catch (Exception e) {
//			
//			if(e.getMessage().contains("ACCESS_NOT_PERMITTED"))
//				log.append("Erro no Login: ACCESS_NOT_PERMITTED - Acesso não é permitido, expirou acesso ao sistema!");
//			else
//				log.append("Erro no Login: "+StatusUtil.getStackTrace(e));
//			
//			try{
//				if(session != null)
//					session.invalidate();
//			}catch (Exception ex) {
//				log.append(" Erro ao invalidar sessao.");
//			}
//		}
//		
//		//escrevendo em localhost[data].log
//		this.getServletContext().log(log.toString());
//	}
//}
