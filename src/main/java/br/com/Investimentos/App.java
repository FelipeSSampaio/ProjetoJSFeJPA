package br.com.Investimentos;

import br.com.Investimentos.dao.impl.HibernateAtivoDAO;
import br.com.Investimentos.dao.impl.JDBCAtivoDAO;
import br.com.Investimentos.model.Ativo;

/**
 * Classe Principal para verificacao da aplicacao funcionando
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Criando o primeiro ativo
    	Ativo ativo1 = new Ativo();
    	ativo1.setNome("CDB");
    	ativo1.setPerfilInvestidor("Conservador");
    	ativo1.setSaqueMinimo(500.00);
    	ativo1.setCapitalMinimoInicial(1000.00);
    	ativo1.setTipo("Renda Fixa");
    	
    	//Criando o segundo ativo
    	Ativo ativo2 = new Ativo();
    	ativo2.setNome("Acoes");
    	ativo2.setPerfilInvestidor("Agressivo");
    	ativo2.setSaqueMinimo(100.00);
    	ativo2.setCapitalMinimoInicial(100.00);
    	ativo2.setTipo("Renda Variavel");
    	
    	//Salvando os ativos no banco
    	//Rode primeiro com o hibernate para que a sequence seja criada e nao de erro no JDBC
        HibernateAtivoDAO had = new HibernateAtivoDAO();
        //JDBCAtivoDAO had = new JDBCAtivoDAO();
        had.salva(ativo1);
        had.salva(ativo2);
        
        //Apresentando a lista de ativos salvos
        System.out.println("Lista de Ativos antes do remover");
        for (Ativo ativo : had.lista()) {
			System.out.println(ativo.getNome());
			if(ativo.getNome().equalsIgnoreCase(ativo1.getNome()))
				ativo1.setId(ativo.getId());
		}
                
        //Apresentando o ID do ativo a ser removido
        System.out.println("ID ativo1: " + ativo1.getId());
        
        //Removendo um ativo com o ID
        had.remove(ativo1);
        
        //Apresentando a lista de ativos depois da remocao
        System.out.println("Lista de Ativos depois do remover");
        for (Ativo ativo : had.lista()) {
			System.out.println(ativo.getNome());
		}
    }
}
