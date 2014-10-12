package br.com.facility.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Especialidade;

@FacesConverter("especialidadeConverter")
public class EspecialidadeConverter implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				AtividadeBO aBO = new AtividadeBO(EntityManagerFactorySingleton
						.getInstance().createEntityManager());
				int val = Integer.parseInt(value);
				Especialidade e = aBO.buscarEspecialidade(val);
				return e;

			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erro de conversão",
						"Especialidade inválida"));
			}
		} else {
			return null;
		}
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((Especialidade) object).getId());
		} else {
			return null;
		}
	}
}