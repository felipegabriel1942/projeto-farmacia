package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "fornecedorBean")
@ViewScoped
public class FornecedoresBean {

	private ListDataModel<Fornecedores> itens;
	private Fornecedores fornecedores;

	// @PostConstruct executa metodo ao executa p�gina
	@PostConstruct
	public void prepararPesquisa() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			
			//Atualiza a lista
			ArrayList<Fornecedores> lista = fdao.listar();
			itens = new ListDataModel<Fornecedores>(lista);
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
			
			//Atualiza a lista
			ArrayList<Fornecedores> lista = fdao.listar();
			itens = new ListDataModel<Fornecedores>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor salvo com sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	public void prepararExcluir() {
		fornecedores = itens.getRowData();
	}

	public void excluir() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.excluir(fornecedores);
			
			//Atualiza a lista
			ArrayList<Fornecedores> lista = fdao.listar();
			itens = new ListDataModel<Fornecedores>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor exclu�do com sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("N�o � possivel excluir um fornecedor que tem produto associado!");
			e.printStackTrace();
		}
	}
	
	public void prepararEditar() {
		fornecedores = itens.getRowData();
	}

	public void editar() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.editar(fornecedores);
			
			//Atualiza a lista
			ArrayList<Fornecedores> lista = fdao.listar();
			itens = new ListDataModel<Fornecedores>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor editado com sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	public ListDataModel<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fornecedores> itens) {
		this.itens = itens;
	}

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

}
