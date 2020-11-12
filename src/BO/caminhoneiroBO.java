package BO;

import DAO.caminhoneiroDAO;
import DTO.caminhoneiroDTO;
import java.util.List;

public class caminhoneiroBO {
    public boolean inserir (caminhoneiroDTO caminhoneirodto) {
        caminhoneiroDAO caminhoneirodao = new caminhoneiroDAO();
        caminhoneirodao.inserir(caminhoneirodto);
        return true;
    }
    public boolean alterar (caminhoneiroDTO caminhoneirodto) {
        caminhoneiroDAO caminhoneirodao = new caminhoneiroDAO();
        caminhoneirodao.alterar(caminhoneirodto);
        return true;
    }
    public boolean excluir (caminhoneiroDTO caminhoneirodto) {
        caminhoneiroDAO caminhoneirodao = new caminhoneiroDAO();
        caminhoneirodao.excluir(caminhoneirodto);
        return true;
    }
    public List<caminhoneiroDTO> pesquisar(){
        List<caminhoneiroDTO> lista;
        caminhoneiroDAO caminhoneirodao = new caminhoneiroDAO();
        lista = caminhoneirodao.pesquisar();
        return lista;
    }
    public caminhoneiroDTO procurar(caminhoneiroDTO caminhoneirodto){
        caminhoneiroDAO caminhoneirodao = new caminhoneiroDAO();
        caminhoneirodto = caminhoneirodao.procurar(caminhoneirodto);
        return caminhoneirodto;
    }
    public boolean existe (caminhoneiroDTO caminhoneirodto) {
        caminhoneiroDAO caminhoneirodao = new caminhoneiroDAO();
        return caminhoneirodao.existe(caminhoneirodto);
    }
}
