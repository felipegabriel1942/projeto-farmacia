package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.com.farmacia.domain.Produtos;
import br.com.farmacia.factory.ConexaoFactory;

public class ProdutoDAO {
	
	
	public void salvar(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produtos ");
		sql.append("(descricao, preco, quantidade, fornecedores_codigo) ");
		sql.append("VALUES (?,?,?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getDescricao());
		comando.setDouble(2, p.getPreco());
		comando.setLong(3, p.getQuantidade());
		comando.setLong(4, p.getFornecedor().getCodigo());
		comando.executeUpdate();
	}
}