/**
 * 
 */
package br.com.facility.to;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Andersson
 * 
 * Data:15/07/2014
 *
 */

@Entity
@Table(name="F_CURRICULO")
//@SequenceGenerator(allocationSize=1,name="sq_curriculo",sequenceName="SQ_F_CURRICULO")
public class Curriculo implements Serializable {

	private static final long serialVersionUID = -6599200750388769544L;

	@Id
	//@GeneratedValue(generator="sq_curriculo", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_curriculo")
	private int id;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="cd_profissional")
	private Profissional profissional;
	
	@Column(name="ds_resumo", length=250)
	private String resumo;
	
	private List<CurriculoURL> urls;
	
	private List<CurriculoIdioma> idiomas;
	
	private List<CurriculoImagem> imagens;
	
	private List<CurriculoFormacao> formacoes;

	public Curriculo() {
		super();
		
	}

	public Curriculo(int id, Profissional profissional, String resumo,
			List<CurriculoURL> urls, List<CurriculoIdioma> idiomas,
			List<CurriculoImagem> imagens, List<CurriculoFormacao> formacoes) {
		super();
		this.id = id;
		this.profissional = profissional;
		this.resumo = resumo;
//		this.urls = urls;
//		this.idiomas = idiomas;
//		this.imagens = imagens;
//		this.formacoes = formacoes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

//	public List<CurriculoURL> getUrls() {
//		return urls;
//	}

//	public void setUrls(List<CurriculoURL> urls) {
//		this.urls = urls;
//	}
//
//	public List<CurriculoIdioma> getIdiomas() {
//		return idiomas;
//	}
//
//	public void setIdiomas(List<CurriculoIdioma> idiomas) {
//		this.idiomas = idiomas;
//	}
//
//	public List<CurriculoImagem> getImagens() {
//		return imagens;
//	}
//
//	public void setImagens(List<CurriculoImagem> imagens) {
//		this.imagens = imagens;
//	}
//
//	public List<CurriculoFormacao> getFormacoes() {
//		return formacoes;
//	}
//
//	public void setFormacoes(List<CurriculoFormacao> formacoes) {
//		this.formacoes = formacoes;
//	}
	
}
