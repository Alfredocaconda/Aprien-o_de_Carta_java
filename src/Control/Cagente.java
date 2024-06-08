/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.Magente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author ALFREDO CACONDA
 */
public class Cagente {
    private PreparedStatement ps;
    private ResultSet rs;
    conexao c= new conexao();
    public void salvar(Magente a){
        String sql=" insert into agente_regulador values(default,?,?,?)";
        try {
            ps=c.Conectar().prepareStatement(sql);
            ps.setInt(1, a.getId_policia());
            ps.setString(2, a.getNome());
            ps.setInt(3, a.getNip());
            if (ps.executeUpdate()==1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
                c.mensagem(e.getMessage());
        }
        
    }
    public void atualizar(Magente a){
        String sql=" update into agente_regulador set id_policia=?, nome=? nip=? where id_agente=?";
        try {
            ps=c.Conectar().prepareStatement(sql);
            ps.setInt(1, a.getId_policia());
            ps.setString(2, a.getNome());
            ps.setInt(3, a.getNip());
            ps.setInt(4, a.getId_agente());
            if (ps.executeUpdate()==1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
                c.mensagem(e.getMessage());
        }
    }
     public void apagar(Magente a){
        String sql=" delete from agente_regulador where id_agente=?";
        try {
            ps=c.Conectar().prepareStatement(sql);
           
            ps.setInt(1, a.getId_agente());
            if (ps.executeUpdate()==1) {
                c.mensagem("APAGADOR COM SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
                c.mensagem(e.getMessage());
        }
    }
        public ArrayList<Magente > listar(String pesquisar){
            ArrayList<Magente> dados= new ArrayList<>();
            String sql="select * from agente_regulador where nome like '%"+pesquisar+"%' order by id_agente";
            try {
                ps=c.Conectar().prepareStatement(sql);
                rs=ps.executeQuery();
                while (rs.next()) {
                    Magente a= new Magente();
                    a.setId_agente(rs.getInt(1));
                    a.setId_policia(rs.getInt(2));
                    a.setNome(rs.getString(3));
                    a.setNip(rs.getInt(4));
                    dados.add(a);
                }
            } catch (Exception e) {
                c.mensagem(e.getMessage());
            }
        return dados;
        }
    }
           
    

