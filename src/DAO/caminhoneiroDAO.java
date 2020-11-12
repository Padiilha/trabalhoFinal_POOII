package DAO;

import Conexao.conexao;
import DTO.caminhoneiroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class caminhoneiroDAO {
    final String NOMEBANCO = "trabalhofinal_poo_bd";
    final String NOMETABELA = "caminhoneiro";
    
    public boolean existe (caminhoneiroDTO caminhoneiro) {
        try{
            Connection conn = conexao.conectar(NOMEBANCO);
            String sql = "SELECT * FROM " + NOMETABELA + " WHERE codPessoa = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, caminhoneiro.getCodPessoa());
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
    public boolean inserir(caminhoneiroDTO caminhoneiro) {
        if (existe(caminhoneiro) != true) {
            try {
                Connection conn = conexao.conectar(NOMEBANCO); 
                String sql = "INSERT INTO " + NOMETABELA + " (codPessoa, nome, idade, numCNH, tipoCNH, codEmpresa) VALUES (?,?,?,?,?,?);"; 
                PreparedStatement ps = conn.prepareStatement(sql); 
                ps.setInt(1, caminhoneiro.getCodPessoa());
                ps.setString(2, caminhoneiro.getNome());
                ps.setInt(3, caminhoneiro.getIdade());
                ps.setInt(4, caminhoneiro.getNumCNH());
                ps.setString(5, caminhoneiro.getTipoCNH());
                ps.setInt(6, caminhoneiro.getCodEmpresa());
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
    public boolean alterar (caminhoneiroDTO caminhoneiro){
        try{
            Connection conn = conexao.conectar(NOMEBANCO);
            String sql = "UPDATE " + NOMETABELA + " SET codPessoa = ?, nome = ?, idade = ?, numCNH = ?, tipoCNH = ?, codEmpresa = ? WHERE codPessoa = ?;"; 
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, caminhoneiro.getCodPessoa());
            ps.setString(2, caminhoneiro.getNome());
            ps.setInt(3, caminhoneiro.getIdade());
            ps.setInt(4, caminhoneiro.getNumCNH());
            ps.setString(5, caminhoneiro.getTipoCNH());
            ps.setInt(6, caminhoneiro.getCodEmpresa());
            ps.setInt(7, caminhoneiro.getCodPessoa());
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
    public boolean excluir (caminhoneiroDTO caminhoneiro){
        try{
            Connection conn = conexao.conectar(NOMEBANCO);
            String sql = "DELETE FROM " + NOMETABELA + " WHERE codPessoa = ?;"; 
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, caminhoneiro.getCodPessoa());
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
    public List<caminhoneiroDTO> montarLista (ResultSet rs) {
        List<caminhoneiroDTO> listModel = new ArrayList<caminhoneiroDTO> ();
        try {
            while (rs.next()) {
                caminhoneiroDTO registro = new caminhoneiroDTO();
                registro.setCodPessoa(rs.getInt(1));
                registro.setNome(rs.getString(2));
                registro.setIdade(rs.getInt(3));
                registro.setNumCNH(rs.getInt(4));
                registro.setTipoCNH(rs.getString(5));
                registro.setCodEmpresa(rs.getInt(6));
                listModel.add(registro);
            }
            return listModel;
        } catch(Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null; 
        }
    }
    public List<caminhoneiroDTO> pesquisar() {
        try{
            Connection conn = conexao.conectar(NOMEBANCO);
            String sql = "SELECT * FROM " + NOMETABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<caminhoneiroDTO> listRegistro = montarLista(rs);
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
    public caminhoneiroDTO procurar(caminhoneiroDTO caminhoneiro) {
        try {
            Connection conn = conexao.conectar(NOMEBANCO);
            String sql = "SELECT * FROM " + NOMETABELA + " WHERE codPessoa = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, caminhoneiro.getCodPessoa());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                caminhoneiroDTO registro = new caminhoneiroDTO();
                registro.setCodPessoa(rs.getInt(1));
                registro.setNome(rs.getString(2));
                registro.setIdade(rs.getInt(3));
                registro.setNumCNH(rs.getInt(4));
                registro.setTipoCNH(rs.getString(5));
                registro.setCodEmpresa(rs.getInt(6));
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
