package br.com.Investimentos.dao;

import java.util.List;

import br.com.Investimentos.model.Ativo;

public interface AtivoDAO {

	void salva(Ativo ativo);
	void remove(Ativo ativo);
	List<Ativo> lista();
}
