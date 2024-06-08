/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.Mproprietario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ALFREDO CACONDA
 */
public class Cproprietario {
 private PreparedStatement ps;
 private ResultSet rs;
 conexao c= new conexao();
 
 public void salvar(Mproprietario p){
     String sql="insert into proprietario values(default,?,?,?,?,?,?)";
     try {
         ps=c.Conectar().prepareStatement(sql);
         ps.setInt(1, p.getIdp());
         ps.setString(2, p.getNome());
         ps.setString(3, p.getEndereco());
         ps.setString(4, p.getTelefone());
         ps.setInt(5, p.getCarta());
         ps.setString(6, p.getDatae());
         if (ps.executeUpdate()==1) {
             c.mensagem("SUCESSO");
         } else {
             c.mensagem("ERRO");
         }
     } catch (Exception e) {
             c.mensagem(e.getMessage());
     }
 }
public void atualizar(Mproprietario p){
     String sql="update into proprietario set idpolicia=?,nome=?,endereco=?,telefone=?,"
             + "n_carta=?,data_emissao=? where id_proprietario=?";
     try {
         ps=c.Conectar().prepareStatement(sql);
         ps.setInt(1, p.getIdp());
         ps.setString(2, p.getNome());
         ps.setString(3, p.getEndereco());
         ps.setString(4, p.getTelefone());
         ps.setInt(5, p.getCarta());
         ps.setString(6, p.getDatae());
         if (ps.executeUpdate()==1) {
             c.mensagem("SUCESSO");
         } else {
             c.mensagem("ERRO");
         }
     } catch (Exception e) {
             c.mensagem(e.getMessage());
     }
 }
public ArrayList<Mproprietario> listar(String pesquisar){
    ArrayList<Mproprietario> dados= new ArrayList<>();
    String sql="select * from proprietario where nome like"
            + " '%"+pesquisar+"%'";
    try {
        ps=c.Conectar().prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            Mproprietario p= new Mproprietario();
            p.setCarta(rs.getInt("n_carta"));
            p.setDatae(rs.getString("data_emissao"));
            p.setEndereco(rs.getString("endereco"));
            p.setIdpropretario(rs.getInt("id_proprietario"));
            p.setIdp(rs.getInt("idpolicia"));
            p.setNome(rs.getString("nome"));
            p.setTelefone(rs.getString("telefone"));
            dados.add(p);
        }
    } catch (Exception e) {
        c.mensagem(e.getMessage());
    }
    return dados;
}
}
