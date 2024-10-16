package br.com.projeto._123eco.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Coleta")
public class Coleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime dataColeta;
	private String descricao;
	
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "postodecoleta_id")
	private PostoDeColeta postodecoleta;
	
	private String statusColeta;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(LocalDateTime dataColeta) {
		this.dataColeta = dataColeta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PostoDeColeta getPostodecoleta() {
		return postodecoleta;
	}

	public void setPostodecoleta(PostoDeColeta postodecoleta) {
		this.postodecoleta = postodecoleta;
	}

	public String getStatusColeta() {
		return statusColeta;
	}

	public void setStatusColeta(String statusColeta) {
		this.statusColeta = statusColeta;
	}

}
