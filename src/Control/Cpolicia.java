/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.Mpolicia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ALFREDO CACONDA
 */
public class Cpolicia {

    private PreparedStatement ps;
    private ResultSet rs;
    conexao c = new conexao();

     public void apagar(Mpolicia f) {
        String sql = "delete from policia where idpolicia=?";
        try {
            ps = c.Conectar().prepareStatement(sql);
            ps.setInt(1, f.getIdpolicia());
            
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());

        }

    }
    public void guardar(Mpolicia f) {
        String sql = "insert into policia values(default,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = c.Conectar().prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getGenero());
            ps.setInt(3, f.getNip());
            ps.setString(4, f.getNome_do_pai());
            ps.setString(5, f.getNome_da_mae());
            ps.setString(6, f.getBi());
            ps.setString(7, f.getMunicipio());
            ps.setString(8, f.getProvincia());
            ps.setString(9, f.getCategoria());
            ps.setString(10, f.getTelefone());
            ps.setString(11, f.getUsuario());
            ps.setString(12, f.getSenha());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());

        }

    }

    public void atualizar(Mpolicia f) {
        String sql = "update policia set nome=?,genero=?, nip=?,"
                + "nome_do_pai=?,nome_da_mae=?,bi=?,municipio=?,provincia=?,"
                + "categoria=?,telefone_email=?,"
                + "usuario=?,senha=? where idpolicia=?";

        try {
            ps = c.Conectar().prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getGenero());
            ps.setInt(3, f.getNip());
            ps.setString(4, f.getNome_do_pai());
            ps.setString(5, f.getNome_da_mae());
            ps.setString(6, f.getBi());
            ps.setString(7, f.getMunicipio());
            ps.setString(8, f.getProvincia());
            ps.setString(9, f.getCategoria());
            ps.setString(10, f.getTelefone());
            ps.setString(11, f.getUsuario());
            ps.setString(12, f.getSenha());
            ps.setInt(13, f.getIdpolicia());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());

        }
    }

    public ArrayList<Mpolicia> pesquisar(String pesquisar) {
        ArrayList<Mpolicia> dados = new ArrayList<>();
        String sql = "select * from policia where nome like '%" + pesquisar + "%'order by idpolicia";
        try {
            ps = c.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mpolicia f = new Mpolicia();
                f.setIdpolicia(rs.getInt("idpolicia"));
                f.setNome(rs.getString("nome"));
                f.setGenero(rs.getString("genero"));
                f.setNip(rs.getInt("nip"));
                f.setNome_do_pai(rs.getString("Nome_do_pai"));
                f.setNome_da_mae(rs.getString("Nome_da_Mae"));
                f.setBi(rs.getString("bi"));
                f.setMunicipio(rs.getString("municipio"));
                f.setProvincia(rs.getString("provincia"));
                f.setCategoria(rs.getString("categoria"));
                f.setTelefone(rs.getString("telefone_email"));
                f.setUsuario(rs.getString("usuario"));
                f.setSenha(rs.getString("senha"));
                dados.add(f);
            }
        } catch (SQLException ex) {
            c.mensagem(ex.getMessage());
        }
        return dados;
    }
     Connection conexao = null;

    public void imprimir(String n) {
        conexao = c.Conectar();
        HashMap d = new HashMap();
        d.put("codigo", n);

        try {
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\Aprienção_de_Carta\\Relatorio\\policia2.jasper", d, conexao);
            JasperViewer.viewReport(imprimir, false);
        } catch (JRException ex) {
            c.mensagem(ex.getMessage());
        }
    }

    public void imprimirtudo() {
        conexao = c.Conectar();
        try {
            JasperPrint print = JasperFillManager.fillReport("C:\\Aprienção_de_Carta\\Relatorio\\policia.jasper", null, conexao);
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            c.mensagem(ex.getMessage());
        }
    }
}
