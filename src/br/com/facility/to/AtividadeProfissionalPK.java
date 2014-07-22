package br.com.facility.to;

import java.io.Serializable;

public class AtividadeProfissionalPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4426683094388805273L;
	private Integer profissional;
	private Integer atividade;

	public int hashCode() {
		// junta o hashCode dos atributos chave
		return profissional.hashCode() + atividade.hashCode();
	}

	public boolean equals(Object o) {
		AtividadeProfissionalPK myId = (AtividadeProfissionalPK) o;

		if ((o instanceof AtividadeProfissionalPK) 
				// iguala todos os atributos que compõe a chave
				&& (profissional == myId.getProfissional())
				&& (atividade == myId.getAtividade())){
			return true;
		}
		return false;
	}

	public Integer getProfissional() {
		return profissional;
	}

	public void setProfissional(Integer profissional) {
		this.profissional = profissional;
	}

	public Integer getAtividade() {
		return atividade;
	}

	public void setAtividade(Integer atividade) {
		this.atividade = atividade;
	}
	
}
