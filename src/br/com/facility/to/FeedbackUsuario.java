package br.com.facility.to;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="F_FEEDBACK")
@SequenceGenerator(sequenceName="SQ_F_FEEDBACK", allocationSize=1, name="sq_feedback_usuario")
public class FeedbackUsuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="sq_feedback_usuario", strategy=GenerationType.SEQUENCE)
	private int id;
	
	//Deve ser alterada para o Enum TipoResolucao
	@Column(name="ds_resolucao", length=80, nullable=false)
	private String resolucao;
	
	@Column(name="nr_recomendacao", length=2, nullable=false)
	private int recomendacao;
	
	@Column(name="ds_depoimento", length=500, nullable=false)
	private String depoimento;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_usuario")
	private Usuario usuario;
	
	public FeedbackUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedbackUsuario(int id, String resolucao, int recomendacao,
			String depoimento, Usuario usuario) {
		super();
		this.id = id;
		this.resolucao = resolucao;
		this.recomendacao = recomendacao;
		this.depoimento = depoimento;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResolucao() {
		return resolucao;
	}

	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}

	public int getRecomendacao() {
		return recomendacao;
	}

	public void setRecomendacao(int recomendacao) {
		this.recomendacao = recomendacao;
	}

	public String getDepoimento() {
		return depoimento;
	}

	public void setDepoimento(String depoimento) {
		this.depoimento = depoimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
