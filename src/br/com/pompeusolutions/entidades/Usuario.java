package br.com.pompeusolutions.entidades;

public class Usuario {
	private int id;
	private String nome;
	private String senha;
	private String login;

	public Usuario() {

	}

	public Usuario(int id) {
		super();
		this.id = id;
	}

	public Usuario(String nome) {
		super();
		this.nome = nome;
	}

	public Usuario(String login, String senha) {
		super();
		this.senha = senha;
		this.login = login;
	}

	public Usuario(String nome, String senha, String login) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.login = login;
	}

	public Usuario(int id, String nome, String senha, String login) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
/*
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha
				+ ", login=" + login + ", getId()=" + getId() + ", getNome()="
				+ getNome() + ", getSenha()=" + getSenha() + ", getLogin()="
				+ getLogin() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}*/

}
