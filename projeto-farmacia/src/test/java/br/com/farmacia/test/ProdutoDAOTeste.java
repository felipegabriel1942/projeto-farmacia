package br.com.farmacia.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;


import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;



public class ProdutoDAOTeste {
	
	@Test
	@Ignore
	public void salvar() throws SQLException {
		Produtos p1 = new Produtos();
		p1.setDescricao("DIPIRONA");
		p1.setPreco(2.99);
		p1.setQuantidade(100);
		
		Fornecedores f = new Fornecedores();
		f.setCodigo(1);
		p1.setFornecedor(f);
		
		ProdutoDAO pdao = new ProdutoDAO();
		pdao.salvar(p1);
		
	}
	
	@Test
	public void listar() throws SQLException {
		ProdutoDAO fdao = new ProdutoDAO();
		ArrayList<Produtos> lista = fdao.listar();
		
		for(Produtos p : lista) {
			System.out.println("Código do Produto: " + p.getCodigo());
			System.out.println("Descrição do Produto: " + p.getDescricao());
			System.out.println("Valor do Produto: " + p.getPreco());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.println("Código do Fornecedor: " + p.getFornecedor().getCodigo());
			System.out.println("Descrição do Fornecedor: " + p.getFornecedor().getDescricao());
			System.out.println("----------------------------------------------------------------------------");
		}
	}
}
