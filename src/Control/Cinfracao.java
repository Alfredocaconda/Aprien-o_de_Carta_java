/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.Minfracao;
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
public class Cinfracao {

    private PreparedStatement ps;
    private ResultSet rs;
    conexao c = new conexao();

    public void salvar(Minfracao i) {
        String sql = "insert into infracao values(default,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = c.Conectar().prepareStatement(sql);
            ps.setInt(1, i.getPolicia());
            ps.setInt(3, i.getAgente());
            ps.setInt(2, i.getIdautomobilista());
            ps.setString(4, i.getInfracao());
            ps.setString(5, i.getData_emissao());
            ps.setString(6, i.getDisciplina());
            ps.setString(7, i.getLocal_de_atuacao());
            ps.setString(8, i.getEsta_de_pagamento());
            ps.setString(9, i.getMulta());
            ps.setString(10, i.getData_do_pagamento());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (SQLException e) {
            c.mensagem(e.getMessage());
        }
    }

    public void atualizar(Minfracao i) {
        String sql = "update infracao set idpolicia=?,"
                + "infracao=?,data_da_atuacao=?,disciplina_rodoviaria=?,local_de_atuacao=?,"
                + "multa=?"
                + " where idin=?";
        try {
            ps = c.Conectar().prepareStatement(sql);
            ps.setInt(1, i.getPolicia());
           
            ps.setString(2, i.getInfracao());
            ps.setString(3, i.getData_emissao());
            ps.setString(4, i.getDisciplina());
            ps.setString(5, i.getLocal_de_atuacao());
            
            ps.setString(6, i.getMulta());
            ps.setInt(7, i.getId_infracao());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (SQLException e) {
            c.mensagem(e.getMessage());
        }
    }

    public void atualizarM(Minfracao i) {
        String sql = "update infracao set estado_de_pagamento=?,data_do_pagamento=?"
                + " where idin=?";
        try {
            ps = c.Conectar().prepareStatement(sql);
            ps.setString(1, i.getEsta_de_pagamento());
            ps.setString(2, i.getData_do_pagamento());
            ps.setInt(3, i.getId_infracao());
            if (ps.executeUpdate() == 1) {
                c.mensagem("SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (SQLException e) {
            c.mensagem(e.getMessage());
        }
    }
public void apagar(Minfracao i) {
        String sql = "delete from infracao where idin=?";
        try {
            ps = c.Conectar().prepareStatement(sql);
           
            ps.setInt(1, i.getId_infracao());
            if (ps.executeUpdate() == 1) {
                c.mensagem("APAGADO COM SUCESSO");
            } else {
                c.mensagem("ERRO");
            }
        } catch (SQLException e) {
            c.mensagem(e.getMessage());
        }
    }
    public ArrayList<Minfracao> pesquisar(String pesquisar) {
        ArrayList<Minfracao> dados = new ArrayList<>();
        String sql = "select * from infracao where infracao like '%" + pesquisar + "%' order by idin DESC";
        try {
            ps = c.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Minfracao f = new Minfracao();
                f.setId_infracao(rs.getInt("idin"));
                f.setInfracao(rs.getString("infracao"));
                f.setPolicia(rs.getInt("idpolicia"));
                f.setIdautomobilista(rs.getInt("id_automobilista"));
                f.setAgente(rs.getInt("idagente"));
                f.setData_emissao(rs.getString("data_da_atuacao"));
                f.setLocal_de_atuacao(rs.getString("local_de_atuacao"));
                f.setDisciplina(rs.getString("disciplina_rodoviaria"));
                f.setEsta_de_pagamento(rs.getString("estado_de_pagamento"));
                f.setMulta(rs.getString("multa"));
                f.setData_do_pagamento(rs.getString("data_do_pagamento"));
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
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\Aprienção_de_Carta\\Relatorio\\infracao2.jasper", d, conexao);
            JasperViewer.viewReport(imprimir, false);
        } catch (JRException ex) {
            c.mensagem(ex.getMessage());
        }
    }

    public void imprimirtudo() {
        conexao = c.Conectar();
        try {
            JasperPrint print = JasperFillManager.fillReport("C:\\Aprienção_de_Carta\\Relatorio\\infracao.jasper", null, conexao);
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            c.mensagem(ex.getMessage());
        }
    }

    public int qtd_carta() {
        int valor = 0;
        String sql = "select * from infracao where estado_de_pagamento='não pago'";
        try {
            ps = c.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                valor++;
            }
        } catch (SQLException e) {
            c.mensagem(e.getMessage());
        }
        return valor;
    }
}
