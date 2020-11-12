package projetofinal;

import Conexao.conexao;
import GUI.principalGUI;
import java.sql.Connection;

public class ProjetoFinal {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connection conn = conexao.conectar("trabalhofinal_poo_bd");
        
        principalGUI telaprincipal = new principalGUI();
        telaprincipal.show();
    }
    
}