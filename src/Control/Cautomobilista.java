/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.Mautomobilista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ALFREDO CACONDA
 */
public class Cautomobilista {

    private PreparedStatement ps;
    private ResultSet rs;
    conexao c = new conexao();

    public void salvar(Mautomobilista p) {
        String sql = "insert into automobilista values(default,?,?,?,?,?,?,?)";
        try {
            ps = c.Conectar().prepareStatement(sql);
            ps.setInt(1, p.getIdp());
            ps.setString(2, p.getNome());
            ps.setString(3, p.getEndereco());
            ps.setString(4, p.getTelefone());
            ps.setString(5, p.getCarta());
            ps.setString(6, p.getDatae());
            ps.setString(7, p.getCaducidade());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }
    }

    public void atualizar(Mautomobilista p) {
        String sql = "update automobilista set nome=?,endereco=?,telefone_gmail=?,"
                + "n_carta=?,data_emissao=?,data_caducidade=? where id_automobilista=?";
        try {
            ps = c.Conectar().prepareStatement(sql);
            ps.setInt(1, p.getIdp());
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEndereco());
            ps.setString(3, p.getTelefone());
            ps.setString(4, p.getCarta());
            ps.setString(5, p.getDatae());
            ps.setString(6, p.getCaducidade());
            ps.setInt(7, p.getId_automobilista());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }
    }

     public void apagar(Mautomobilista p) {
        String sql = "delete from automobilista where id_automobilista=?";
        try {
            ps = c.Conectar().prepareStatement(sql);
           
            ps.setInt(1, p.getId_automobilista());
            if (ps.executeUpdate() == 1) {
                c.mensagem("APAGADO COM SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }
    }

    public ArrayList<Mautomobilista> listar(String pesquisar) {
        ArrayList<Mautomobilista> dados = new ArrayList<>();
        String sql = "select * from automobilista where nome like"
                + " '%" + pesquisar + "%'";
        try {
            ps = c.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mautomobilista p = new Mautomobilista();
                p.setCarta(rs.getString("n_carta"));
                p.setDatae(rs.getString("data_emissao"));
                p.setCaducidade(rs.getString("data_caducidade"));
                p.setEndereco(rs.getString("endereco"));
                p.setId_automobilista(rs.getInt("id_automobilista"));
                p.setIdp(rs.getInt("idpolicia"));
                p.setNome(rs.getString("nome"));
                p.setTelefone(rs.getString("telefone_gmail"));
                dados.add(p);
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
        }
        return dados;
    }

    public int data_de_caducidade() {
        int valor = 0;
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
        String sql = "select *from automobilista where data_caducidade<='" + s.format(d) + "'";
        try {
            ps = c.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                valor++;
            }
        } catch (SQLException ex) {
            c.mensagem(ex.getMessage());
        }
        return valor;
    }

}
