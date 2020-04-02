package br.com.Investimentos.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.Investimentos.dao.impl.HibernateAtivoDAO;
import br.com.Investimentos.model.Ativo;

@ManagedBean
@RequestScoped
public class AtivoBean {

	private Ativo ativo = new Ativo();
	private List<Ativo> listaAtivos;
	
	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public String salva(Ativo ativo){
		HibernateAtivoDAO ativoDAO = new HibernateAtivoDAO();
		ativoDAO.salva(ativo);
		
		return "listaAtivo.xhtml?faces-redirect=true";
	}
	
	public List<Ativo> getAtivos(){
		HibernateAtivoDAO ativoDAO = new HibernateAtivoDAO();
		
		if(listaAtivos == null)
			listaAtivos = ativoDAO.lista();
		
		return listaAtivos;
	}
	
	public String edita(Ativo ativo){
		HibernateAtivoDAO ativoDAO = new HibernateAtivoDAO();
		ativoDAO.edita(ativo);
		
		return "listaAtivo.xhtml?faces-redirect=true";
	}
	
	public String exclui(Ativo ativo){
		HibernateAtivoDAO ativoDAO = new HibernateAtivoDAO();
		ativoDAO.remove(ativo);
		
		return "listaAtivo.xhtml?faces-redirect=true";
	}
	
	public String redirecionaEdita(){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		Long ativoId = Long.parseLong( params.get("ativoId") );
		
		HibernateAtivoDAO ativoDAO = new HibernateAtivoDAO();
		Ativo ativoEscolhido = ativoDAO.buscaAtivo(ativoId);
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("ativo", ativoEscolhido);
		
		return "editaAtivo.xhtml?faces-redirect=true";
	}
}
