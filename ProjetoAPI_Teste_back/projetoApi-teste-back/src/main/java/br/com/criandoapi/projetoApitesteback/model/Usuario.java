package br.com.criandoapi.projetoApitesteback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	private Integer id;
	

	@Size(min = 3, message = "O nome precisa ter no mínimo 3 caracteres")
	@NotBlank(message = "O nome é obrigatório!")
	@Column(name = "nome_completo", length = 200, nullable = false)
	private String nome;
	
	@Email(message = "Insira um Email válido!")
	@NotBlank(message = "O Email é obrigatório!")
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@NotBlank(message = "A senha é obrigatória!")
	@Column(name = "senha", columnDefinition = "TEXT" , nullable = false)
	private String senha;
	
	@NotBlank(message = "O telefone é obrigatório!")
	@Column(name = "telefone", length = 15, nullable = false)
	private String telefone;
	
	
	

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	

}
