package com.dicaspet.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

public class FacesMessageUtil {
	
	public static FacesMessage criarMensagem(Severity severity, 
			String resumo, String detalhe) {
		return new FacesMessage(severity, resumo, detalhe);
	}
	
	public static FacesMessage criarMensagemInfo(String resumo, 
			String detalhe) {
		return criarMensagem(FacesMessage.SEVERITY_INFO, resumo, detalhe);
	}
	
	public static FacesMessage criarMensagemErro(String resumo, 
			String detalhe) {
		return criarMensagem(FacesMessage.SEVERITY_ERROR, resumo, detalhe);
	}
	
	public static FacesMessage criarMensagemFatal(String resumo, 
			String detalhe) {
		return criarMensagem(FacesMessage.SEVERITY_FATAL, resumo, detalhe);
	}
	
}