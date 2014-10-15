package br.com.facility.enums;

public enum TipoTelefone {
	RESIDENCIAL("Residencial"), COMERCIAL("Comercial"), CELULAR("Celular"), FAX("Fax");
	
	private final String label;

	private TipoTelefone(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return this.label;
	}
}
