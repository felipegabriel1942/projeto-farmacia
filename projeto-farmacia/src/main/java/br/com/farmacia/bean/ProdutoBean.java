package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "produtoBean")
@ViewScoped
public class ProdutoBean {
	
	private Produtos produtos;
	private ArrayList<Produtos> itens;
	private ArrayList<Produtos> itensFiltrados;
	private ArrayList<Fornecedores> cmbFornecedores;
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			ProdutoDAO pDao = new ProdutoDAO();
			itens = pDao.listar();
		} catch (Exception e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void prepararNovo() {
		produtos = new Produtos();
		
		
		try {
			FornecedoresDAO dao = new FornecedoresDAO();
			cmbFornecedores = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void novoCadastro() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.salvar(produtos);

			// Atualiza a lista
			itens = pdao.listar();

			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.excluir(produtos);

			// Atualiza a lista
			itens = pdao.listar();

			JSFUtil.adicionarMensagemSucesso("Produto excluído com sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	

	public void editar() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.editar(produtos);

			// Atualiza a lista
			itens = pdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void prepararEditar() {
		produtos = new Produtos();
		
		
		try {
			FornecedoresDAO dao = new FornecedoresDAO();
			cmbFornecedores = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Produtos getProdutos() {
		return produtos;
	}
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	public ArrayList<Produtos> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Produtos> itens) {
		this.itens = itens;
	}
	public ArrayList<Produtos> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Produtos> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public ArrayList<Fornecedores> getCmbFornecedores() {
		return cmbFornecedores;
	}

	public void setCmbFornecedores(ArrayList<Fornecedores> cmbFornecedores) {
		this.cmbFornecedores = cmbFornecedores;
	}
	
	
	
}
