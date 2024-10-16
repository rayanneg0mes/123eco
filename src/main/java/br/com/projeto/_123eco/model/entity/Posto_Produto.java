package br.com.projeto._123eco.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Posto_Produto")
public class Posto_Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "postodecoleta_id")
	private PostoDeColeta postodecoleta;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	private String statusPosto_Produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PostoDeColeta getPostodecoleta() {
		return postodecoleta;
	}

	public void setPostodecoleta(PostoDeColeta postodecoleta) {
		this.postodecoleta = postodecoleta;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getStatusPosto_Produto() {
		return statusPosto_Produto;
	}

	public void setStatusPosto_Produto(String statusPosto_Produto) {
		this.statusPosto_Produto = statusPosto_Produto;
	}

	
}
