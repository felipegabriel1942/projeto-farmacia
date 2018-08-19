package br.com.farmacia.test;

import java.sql.SQLException;

import org.junit.Test;


import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;


public class ProdutoDAOTeste {
	
	@Test
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
}
