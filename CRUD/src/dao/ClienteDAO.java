/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import factory.ConnectionFactory;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Cliente;
/**
 *
 * @author Rafaela Penafiel
 */
public class ClienteDAO {
    private Connection connection;
    
    public ClienteDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Cliente cliente){
        String sql = "INSERT INTO cliente(cli_nome, cli_cpf, cli_email, cli_telefone, cli_endereco, cli_data_nascimento) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement (sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            stmt.setDate(6, cliente.getDataNascimento());
            
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
    }

    public boolean existeCPF(String cpf) {
        String sql = "SELECT COUNT(*) FROM cliente WHERE cli_cpf = ?";
        
        try(Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1,cpf);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1)>0;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Errro ao verificar CPF: " +e.getMessage());
        }
        return false;
    }
    
    public List<Cliente> listarTodos(){
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("cli_id"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setEmail(rs.getString("cli_email"));
                cliente.setTelefone(rs.getString("cli_telefone"));
                cliente.setEndereco(rs.getString("cli_endereco"));
                cliente.setDataNascimento(rs.getDate("cli_data_nascimento"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes: " + e.getMessage());
        }
        
        return clientes;
    }
    
    public void atualizar (Cliente cliente){
        String sql = "UPDATE cliente SET cli_nome=?, cli_cpf=?, cli_email=?, cli_telefone=?, cli_endereco=?, cli_data_nascimento=? WHERE cli_id=?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            stmt.setDate(6, cliente.getDataNascimento());
            stmt.setInt(7, cliente.getId());
            
            stmt.executeUpdate();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public List<Cliente> getLista() {
        return listarTodos();
    }
    
    public boolean existeCPFParaOutroCliente(String cpf, int idClienteAtual){
        String sql = "SELECT COUNT(*) FROM cliente WHERE cli_cpf = ? AND cli_id <> ?";
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cpf);
            stmt.setInt(2, idClienteAtual);
            
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao verificar CPF duplicado: "+ e.getMessage());
        }
        return false;
    }
    
    public void excluirPorCpf(String cpf) throws SQLException{
        String sql = "DELETE FROM cliente WHERE cli_cpf = ?";
        
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, cpf);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected == 0){
                JOptionPane.showMessageDialog(null, "Cliente com CPF " + cpf + "não encontrado.");
            }else {
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.");
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente: " + e.getMessage());
        }
    }
    
    public Cliente buscarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE cli_cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("cli_id"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setEmail(rs.getString("cli_email"));
                cliente.setTelefone(rs.getString("cli_telefone"));
                cliente.setEndereco(rs.getString("cli_endereco"));
                cliente.setDataNascimento(rs.getDate("cli_data_nascimento"));
                return cliente;
            }
        }
        return null;
    }
    
    public List<Cliente> buscarPorNome(String nome) throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE cli_nome LIKE ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("cli_id"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setEmail(rs.getString("cli_email"));
                cliente.setTelefone(rs.getString("cli_telefone"));
                cliente.setEndereco(rs.getString("cli_endereco"));
                cliente.setDataNascimento(rs.getDate("cli_data_nascimento"));
                lista.add(cliente);
            }
        }
        return lista;
    }
}
