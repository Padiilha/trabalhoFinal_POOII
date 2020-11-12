package DAO;

import Conexao.conexao;
import DTO.transportadoraDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class transportadoraDAO {
    final String NOMEBANCO = "trabalhofinal_poo_bd";
    final String NOMETABELA = "transportadora";
    
    public boolean existe (transportadoraDTO transportadora) {
        try{
            Connection conn = conexao.conectar(NOMEBANCO);
            String sql = "SELECT * FROM " + NOMETABELA + " WHERE codEmpresa = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, transportadora.getCodEmpresa());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
        return false;
    }
    public boolean inserir(transportadoraDTO transportadora) {
        if (existe(transportadora) != true) {
            try {
                Connection conn = conexao.conectar(NOMEBANCO); 
                String sql = "INSERT INTO " + NOMETABELA + " (codEmpresa, nome, servico, valorMercado, numFunc) VALUES (?,?,?,?,?);"; 
                PreparedStatement ps = conn.prepareStatement(sql); 
                ps.setInt(1, transportadora.getCodEmpresa());
                ps.setString(2, transportadora.getNome());
                ps.setString(3, transportadora.getServico());
                ps.setFloat(4, transportadora.getValorMercado());
                ps.setInt(5, transportadora.getNumFunc());
                ps.execute(); 
                ps.close(); 
                conn.close(); 
                return true; 
            } catch(Exception e) {
                System.err.println("Erro: " + e.toString());
                e.printStackTrace();
                return false; 
            }
        }
        return false; 
    }
    public boolean alterar (transportadoraDTO transportadora){
        try{
            Connection conn = conexao.conectar(NOMEBANCO);
            String sql = "UPDATE " + NOMETABELA + " SET codEmpresa = ?, nome = ?, servico = ?, valorMercado = ?, numFunc = ? WHERE codEmpresa = ?;"; 
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, transportadora.getCodEmpresa());
            ps.setString(2, transportadora.getNome());
            ps.setString(3, transportadora.getServico());
            ps.setFloat(4, transportadora.getValorMercado());
            ps.setInt(5, transportadora.getNumFunc());
            ps.setInt(6, transportadora.getCodEmpresa());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch(Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false; 
        }
    }
    public boolean excluir (transportadoraDTO transportadora){
        try{
            Connection conn = conexao.conectar(NOMEBANCO);
            String sql = "DELETE FROM " + NOMETABELA + " WHERE codEmpresa = ?;"; 
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, transportadora.getCodEmpresa());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch(Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false; 
        }
    }
    public List<transportadoraDTO> montarLista (ResultSet rs) {
        List<transportadoraDTO> listModel = new ArrayList<transportadoraDTO> ();
        try {
            while (rs.next()) {
                transportadoraDTO registro = new transportadoraDTO();
                registro.setCodEmpresa(rs.getInt(1));
                registro.setNome(rs.getString(2));
                registro.setServico(rs.getString(3));
                registro.setValorMercado(rs.getFloat(4));
                registro.setNumFunc(rs.getInt(5));
                listModel.add(registro);
            }
            return listModel;
        } catch(Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null; 
        }
    }
    public List<transportadoraDTO> pesquisar() {
        try{
            Connection conn = conexao.conectar(NOMEBANCO);
            String sql = "SELECT * FROM " + NOMETABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<transportadoraDTO> listRegistro = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listRegistro;
        } catch(Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null; 
        }
    }
    public transportadoraDTO procurar(transportadoraDTO transportadora) {
        try {
            Connection conn = conexao.conectar(NOMEBANCO);
            String sql = "SELECT * FROM " + NOMETABELA + " WHERE codEmpresa = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, transportadora.getCodEmpresa());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                transportadoraDTO registro = new transportadoraDTO();
                registro.setCodEmpresa(rs.getInt(1));
                registro.setNome(rs.getString(2));
                registro.setServico(rs.getString(3));
                registro.setValorMercado(rs.getFloat(4));
                registro.setNumFunc(rs.getInt(5));
                ps.close();
                rs.close();
                conn.close();
                return registro;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch(Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
