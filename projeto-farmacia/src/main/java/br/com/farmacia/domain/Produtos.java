package br.com.farmacia.domain;

public class Produtos {
	
	private Long codigo;
	private String descricao;
	private long quantidade;
	private Double preco;
	private Fornecedores fornecedor = new Fornecedores();
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Fornecedores getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedores fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
}
