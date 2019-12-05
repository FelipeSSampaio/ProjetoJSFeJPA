package br.com.Investimentos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Ativo") // define o nome da tabela no banco, se nao informado tera o mesmo nome da classe
public class Ativo {

	@Id @GeneratedValue
	private Long id;
	
	@Column(name = "Nome_Ativo") // comportamento identico a @Table, mas para colunas da tabela
	private String nome;
	private String tipo;
	private String perfilInvestidor;
	private Double capitalMinimoInicial;
	private Double saqueMinimo;
	
	@Transient //atributo que nunca sera persistido
	private String qtdCotasEstoque;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getPerfilInvestidor() {
		return perfilInvestidor;
	}
	public void setPerfilInvestidor(String perfilInvestidor) {
		this.perfilInvestidor = perfilInvestidor;
	}
	
	public Double getCapitalMinimoInicial() {
		return capitalMinimoInicial;
	}
	public void setCapitalMinimoInicial(Double capitalMinimoInicial) {
		this.capitalMinimoInicial = capitalMinimoInicial;
	}
	
	public Double getSaqueMinimo() {
		return saqueMinimo;
	}
	public void setSaqueMinimo(Double saqueMinimo) {
		this.saqueMinimo = saqueMinimo;
	}
	
	public String getQtdCotasEstoque() {
		return qtdCotasEstoque;
	}
	public void setQtdCotasEstoque(String qtdCotasEstoque) {
		this.qtdCotasEstoque = qtdCotasEstoque;
	}
}
