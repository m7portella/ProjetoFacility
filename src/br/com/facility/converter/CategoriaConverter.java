package br.com.facility.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Categoria;

@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter{
	 
	    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
	        if(value != null && value.trim().length() > 0) {
	            try {
	            	AtividadeBO aBO = new AtividadeBO(EntityManagerFactorySingleton.getInstance().createEntityManager());
	            	int val = Integer.parseInt(value);
	            	Categoria c = aBO.buscarCategoria(val);
	            	return c;
	            	
	            } catch(NumberFormatException e) {
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão", "Categoria inválida"));
	            }
	        }
	        else {
	            return null;
	        }
	    }
	 
	    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
	        if(object != null) {
	            return String.valueOf(((Categoria) object).getId());
	        }
	        else {
	            return null;
	        }
	    }   
	}