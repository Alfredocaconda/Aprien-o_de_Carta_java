/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.MFuncionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ALFREDO CACONDA
 */
public class CFuncionario {

    private PreparedStatement ps;
    private ResultSet rs;
    conexao c = new conexao();

    public void guardar(MFuncionario f) {
        String sql = "insert into funcionario values(default,?,?,?,?,?,?,?,?)";
        try {
            ps = c.Conectar().prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getTelefone());
            ps.setString(3, f.getEndereco());
            ps.setString(4, f.getUsuario());
            ps.setString(5, f.getSenha());
            ps.setString(6, f.getCategoria());
            ps.setString(7, f.getGenero());
            ps.setString(8, f.getBi());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());

        }

    }
    public void atualizar(MFuncionario f){
        String sql="update funcionario set nome=?,telefone_email=?,endereco=?,"
                + "usuario=?,senha=?,categoria=?,genero=?,bi=? where idfuncionario=?";
    
     try {
            ps = c.Conectar().prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getTelefone());
            ps.setString(3, f.getEndereco());
            ps.setString(4, f.getUsuario());
            ps.setString(5, f.getSenha());
            ps.setString(6, f.getCategoria());
            ps.setString(7, f.getGenero());
            ps.setString(8, f.getBi());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());

        }
    }
     public ArrayList<MFuncionario> pesquisar(String pesquisar) {
        ArrayList<MFuncionario> dados = new ArrayList<>();
        String sql = "select * from funcionario where nome like '%" + pesquisar + "%'order by idf";
        try {
            ps = c.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MFuncionario f = new MFuncionario();
                f.setIdfuncionario(rs.getInt("idf"));
                f.setNome(rs.getString("nome"));
                f.setGenero(rs.getString("genero"));
                f.setBi(rs.getString("bi"));
                f.setUsuario(rs.getString("usuario"));
                f.setSenha(rs.getString("senha"));
                f.setCategoria(rs.getString("cargo"));
                f.setTelefone(rs.getString("telefone_email"));
                f.setEndereco(rs.getString("endereco"));
                dados.add(f);
            }
        } catch (SQLException ex) {
            c.mensagem(ex.getMessage());
        }
        return dados;
    }
}
