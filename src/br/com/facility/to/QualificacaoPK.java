package br.com.facility.to;

public class QualificacaoPK {

	private Long id;
	private Long servicoConcluidos;

	public int hashCode() {
		// junta o hashCode dos atributos chave
		return id.hashCode() + getServicoConcluidos().hashCode();
	}

	public boolean equals(Object o) {
		QualificacaoPK myId = (QualificacaoPK) o;

		if ((o instanceof QualificacaoPK) 
				// iguala todos os atributos que compõe a chave
				&& (id == myId.getId())
				&& (getServicoConcluidos() == myId.getServicoConcluidos())){
			return true;
		}
		return false;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getServicoConcluidos() {
		return servicoConcluidos;
	}

	public void setServicoConcluidos(Long servicoConcluidos) {
		this.servicoConcluidos = servicoConcluidos;
	}

}
