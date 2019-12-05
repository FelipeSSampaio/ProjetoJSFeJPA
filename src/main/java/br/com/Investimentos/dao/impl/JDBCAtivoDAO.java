package br.com.Investimentos.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Investimentos.dao.AtivoDAO;
import br.com.Investimentos.model.Ativo;

/**
 * 
 *  * @author Felipe Sampaio
 *  
 *  * Classe que demonstra uma construcao tipica JDBC com o intuito de comparar com a classe JPA
 *
 */
public class JDBCAtivoDAO implements AtivoDAO{

	private Connection abreConexao() {
		
		try {
            return DriverManager.getConnection("jdbc:postgresql://localhost/Investimentos", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
	}
	
	public void salva(Ativo ativo) {
		StringBuffer querie = new StringBuffer();
		querie.append("Insert into Ativo (nome, tipo, perfilInvestidor, capitalMinimoInicial, saqueMinimo) ");
		querie.append("values (?, ?, ?, ?, ?)");
		
		Connection conn = abreConexao();
		
		try{
			PreparedStatement ps = null;
			ps = conn.prepareStatement(querie.toString());
			
			ps.setString(1, ativo.getNome());
			ps.setString(2, ativo.getTipo());
			ps.setString(3, ativo.getPerfilInvestidor());
			ps.setDouble(4, ativo.getCapitalMinimoInicial());
			ps.setDouble(5, ativo.getSaqueMinimo());
			
			ps.execute();
		}
		catch(SQLException sqlException){
			throw new RuntimeException(sqlException);
		}
		finally {
			try{
				conn.close();
			}
			catch(Exception e){
				throw new RuntimeException(e);
			}
		}
		
	}

	public List<Ativo> lista() {
		List<Ativo> ativos = new ArrayList<Ativo>();
		StringBuffer querie = new StringBuffer();
		querie.append("Select * from Ativo");
		Connection conn = abreConexao();
		
		try{
			PreparedStatement ps = conn.prepareStatement(querie.toString());
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ){
				Ativo ativo = new Ativo();
				
				ativo.setId(rs.getLong("id"));
				ativo.setNome(rs.getString("nome"));
				ativo.setTipo(rs.getString("tipo")); 
				ativo.setPerfilInvestidor(rs.getString("perfilInvestidor")); 
				ativo.setCapitalMinimoInicial(rs.getDouble("capitalMinimoInicial")); 
				ativo.setSaqueMinimo(rs.getDouble("saqueMinimo"));
				
				ativos.add(ativo);
			}
		}
		catch(SQLException sqlException){
			throw new RuntimeException(sqlException);
		}
		finally {
			try{
				conn.close();
			}
			catch(Exception e){
				throw new RuntimeException(e);
			}
		}
		
		return ativos;
	}

	public void remove(Ativo ativo) {
		StringBuffer querie = new StringBuffer();
		querie.append("Delete from Ativo ");
		querie.append("where id = ?");
		
		Connection conn = abreConexao();
		
		try{
			PreparedStatement ps = null;
			ps = conn.prepareStatement(querie.toString());
			
			ps.setLong(1, ativo.getId());
			
			ps.execute();
		}
		catch(SQLException sqlException){
			throw new RuntimeException(sqlException);
		}
		finally {
			try{
				conn.close();
			}
			catch(Exception e){
				throw new RuntimeException(e);
			}
		}
	}
}
