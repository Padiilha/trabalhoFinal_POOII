package BO;

import DAO.transportadoraDAO;
import DTO.transportadoraDTO;
import java.util.List;

public class transportadoraBO {
    public boolean inserir (transportadoraDTO transportadoradto) {
        transportadoraDAO transportadoradao = new transportadoraDAO();
        transportadoradao.inserir(transportadoradto);
        return true;
    }
    public boolean alterar (transportadoraDTO transportadoradto) {
        transportadoraDAO transportadoradao = new transportadoraDAO();
        transportadoradao.alterar(transportadoradto);
        return true;
    }
    public boolean excluir (transportadoraDTO transportadoradto) {
        transportadoraDAO transportadoradao = new transportadoraDAO();
        transportadoradao.excluir(transportadoradto);
        return true;
    }
    public List<transportadoraDTO> pesquisar(){
        List<transportadoraDTO> lista;
        transportadoraDAO transportadoradao = new transportadoraDAO();
        lista = transportadoradao.pesquisar();
        return lista;
    }
    public transportadoraDTO procurar(transportadoraDTO transportadoradto){
        transportadoraDAO transportadoradao = new transportadoraDAO();
        transportadoradto = transportadoradao.procurar(transportadoradto);
        return transportadoradto;
    }
    public boolean existe (transportadoraDTO transportadoradto) {
        transportadoraDAO transportadoradao = new transportadoraDAO();
        return transportadoradao.existe(transportadoradto);
    }
}
