package br.estacio.carros.dao;

import br.estacio.carros.entidade.Cliente;
import br.estacio.carros.util.FabricaConexao;
import br.estacio.carros.util.exception.ErroSistema;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge Pereira
 */
public class ClienteDAO implements CrudDAO<Cliente>{
    
   @Override
    public void salvar(Cliente cliente) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(cliente.getId() == null){
                ps = conexao.prepareStatement("INSERT INTO carros.cliente (nome,endereco,telefone,celular, dtnascimento, cnh) VALUES (?,?,?,?,?,?)");
            } else {      
                ps = conexao.prepareStatement("UPDATE cliente SET nome=?, endereco=?, telefone=?, celular=?, dtnascimento=?, cnh=? where id=?");
                ps.setInt(7, cliente.getId());
            }
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getCelular());
            ps.setDate(5, new Date(cliente.getDtnascimento().getTime()));
            ps.setString (6, cliente.getCnh());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }
    @Override
    public void deletar(Cliente cliente) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("DELETE FROM cliente WHERE id = ?");
            ps.setInt(1, cliente.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar cliente!", ex);
        }
    }
    
    @Override
    public List<Cliente> buscar() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from cliente");
            ResultSet resultSet = ps.executeQuery();
            List<Cliente> clientes = new ArrayList<>();
            while(resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setCelular(resultSet.getString("celular"));
                cliente.setDtnascimento(resultSet.getDate("dtnascimento"));
                cliente.setCnh(resultSet.getString("cnh"));
               
                clientes.add(cliente);
            }
            FabricaConexao.fecharConexao();
            return clientes;
            
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar os clientes!",ex);
        }
    }
   
   
}
