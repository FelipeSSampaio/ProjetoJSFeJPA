package br.com.Investimentos.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.Investimentos.dao.impl.HibernateAtivoDAO;
import br.com.Investimentos.model.Ativo;

@ManagedBean
public class AtivoBean {

	private Ativo ativo = new Ativo();
	private List<Ativo> listaAtivos;
	
	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public void salva(Ativo ativo){
		HibernateAtivoDAO ativoDAO = new HibernateAtivoDAO();
		ativoDAO.salva(ativo);
	}
	
	public List<Ativo> getAtivos(){
		HibernateAtivoDAO ativoDAO = new HibernateAtivoDAO();
		
		if(listaAtivos == null)
			listaAtivos = ativoDAO.lista();
		
		return listaAtivos;
	}
	
	public void exclui(Ativo ativo){
		HibernateAtivoDAO ativoDAO = new HibernateAtivoDAO();
		ativoDAO.remove(ativo);
	}
}
