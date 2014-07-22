package br.com.facility.to;

import java.io.Serializable;

public class EspecialidadeProfissionalPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7706758521426563886L;
	private Integer profissional;
	private Integer especialidade;

	public int hashCode() {
		// junta o hashCode dos atributos chave
		return profissional.hashCode() + especialidade.hashCode();
	}

	public boolean equals(Object o) {
		EspecialidadeProfissionalPK myId = (EspecialidadeProfissionalPK) o;

		if ((o instanceof EspecialidadeProfissionalPK) 
				// iguala todos os atributos que compõe a chave
				&& (profissional == myId.getProfissional())
				&& (especialidade == myId.getEspecialidade())){
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

	public Integer getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Integer especialidade) {
		this.especialidade = especialidade;
	}
	
}
