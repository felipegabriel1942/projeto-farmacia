package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "fornecedorBean")
@ViewScoped
public class FornecedoresBean {

	private ArrayList<Fornecedores> itens;
	private ArrayList<Fornecedores> itensFiltrados;
	private Fornecedores fornecedores;

	// @PostConstruct executa metodo ao executa página
	@PostConstruct
	public void prepararPesquisa() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();

			// Atualiza a lista
			itens = fdao.listar();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void prepararNovoFornencedor() {
		fornecedores = new Fornecedores();
	}

	public void novoCadastro() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.salvar(fornecedores);

			// Atualiza a lista
			itens = fdao.listar();

			JSFUtil.adicionarMensagemSucesso("Fornecedor salvo com sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	

	public void excluir() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.excluir(fornecedores);

			// Atualiza a lista
			itens = fdao.listar();

			JSFUtil.adicionarMensagemSucesso("Fornecedor excluído com sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("Não é possivel excluir um fornecedor que tem produto associado!");
			e.printStackTrace();
		}
	}

	
	public void editar() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.editar(fornecedores);

			// Atualiza a lista
			itens = fdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor editado com sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	public ArrayList<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fornecedores> itens) {
		this.itens = itens;
	}

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	public ArrayList<Fornecedores> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fornecedores> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

}
