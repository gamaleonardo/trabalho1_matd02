package br.ufba.dcc.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {
	private Integer id;
	private String nome;
	private String login;
	private String Senha;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	
}
