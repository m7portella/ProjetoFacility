package br.com.facility.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.facility.enums.TipoAtividadeEspecialidade;

@Entity
@Table(name="F_PROJETO_ATIVIDADE")
public class ProjetoAtividade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2033727583047232868L;

	@Id
	@ManyToOne
	@JoinColumn(name="cd_projeto", nullable=false)
	private Projeto projeto;
	
	@Id
	@SequenceGenerator(allocationSize=1,name="sq_projeto_atividade",sequenceName="SQ_F_PROJETO_ATIVIDADE")
	@GeneratedValue(generator="sq_projeto_atividade", strategy=GenerationType.SEQUENCE)
	@Column(name="nr_item")
	private int item;
	
	@ManyToOne
	@JoinColumn(name="cd_atividade", nullable=false)
	private Atividade atividade;
	
	@ManyToOne
	@JoinColumn(name="cd_especialidade", nullable=false)
	private Especialidade especialidade;
	
	@Column(name="cd_tipo", nullable=false)
	private TipoAtividadeEspecialidade tipo;
	
	@Column(name="ds_projeto_atividade", length=200)
	private String descricao;

	public ProjetoAtividade() {
		super();
	}

	public ProjetoAtividade(Projeto projeto, int item, Atividade atividade,
			Especialidade especialidade, TipoAtividadeEspecialidade tipo,
			String descricao) {
		super();
		this.projeto = projeto;
		this.item = item;
		this.atividade = atividade;
		this.especialidade = especialidade;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public TipoAtividadeEspecialidade getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtividadeEspecialidade tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
