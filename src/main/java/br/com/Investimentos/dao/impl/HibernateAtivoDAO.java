package br.com.Investimentos.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.Investimentos.dao.AtivoDAO;
import br.com.Investimentos.model.Ativo;

public class HibernateAtivoDAO extends DBConnection implements AtivoDAO {

	public void salva(Ativo ativo) {
		EntityManager em = abreConexao();
		em.getTransaction().begin();
		
		em.persist(ativo);
		em.getTransaction().commit();
		em.close();
	}

	public List<Ativo> lista() {
		EntityManager em = abreConexao();
		
		@SuppressWarnings("unchecked")
		List<Ativo> ativos = em.createQuery("Select a from Ativo a").getResultList();
		
		em.close();
		
		return ativos;
	}

	public Ativo buscaAtivo(Long id) {
		EntityManager em = abreConexao();
		return em.find(Ativo.class, id);		
	}
	
	public void edita(Ativo ativo) {
		EntityManager em = abreConexao();
		em.getTransaction().begin();
		
		Ativo ativoPersistido = em.find(Ativo.class, ativo.getId());
		
		ativoPersistido.setNome(ativo.getNome());
		ativoPersistido.setTipo(ativo.getTipo());
		ativoPersistido.setPerfilInvestidor(ativo.getPerfilInvestidor());
		ativoPersistido.setCapitalMinimoInicial(ativo.getCapitalMinimoInicial());
		ativoPersistido.setSaqueMinimo(ativo.getSaqueMinimo());
		
		em.merge(ativoPersistido);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Ativo ativo) {
		EntityManager em = abreConexao();
		em.getTransaction().begin();
		
		ativo = em.merge(ativo);
		
		em.remove(ativo);
		
		em.getTransaction().commit();
		em.close();
	}
}
