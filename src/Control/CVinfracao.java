/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.Mvenfracao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class CVinfracao {
    
    private PreparedStatement ps;
    private ResultSet rs;
    Conexao.conexao c = new conexao();
    
    public ArrayList<Mvenfracao> listar(String pesquisar) {
        ArrayList<Mvenfracao> dados = new ArrayList<>();
        String sql = "select * from Vinfracao where automobilista like '%" + pesquisar + "%' order by idin";
        try {
            ps = c.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mvenfracao v = new Mvenfracao();
                v.setIdin(rs.getInt("idin"));
                v.setAutomobilista(rs.getString("automobilista"));
                v.setEndereco(rs.getString("endereco"));
                v.setN_carta(rs.getString("n_carta"));
                v.setTelefone_gmail(rs.getString("telefone_gmail"));
                v.setData_caducidade(rs.getString("data_caducidade"));
                v.setAgente(rs.getString("agente"));
                v.setNip(rs.getInt("nip"));
                v.setInfracao(rs.getString("infracao"));
                v.setData_da_atuacao(rs.getString("data_da_atuacao"));
                v.setDisciplina_rodoviaria(rs.getString("disciplina_rodoviaria"));
                v.setLocal_de_atuacao(rs.getString("local_de_atuacao"));
                v.setEstado_de_pagamento(rs.getString("estado_de_pagamento"));
                v.setMulta(rs.getInt("multa"));
                v.setData_do_pagamento(rs.getString("data_do_pagamento"));
                v.setPolicia(rs.getString("policia"));
                dados.add(v);
            }
        } catch (Exception e) {
            c.mensagem(e.getMessage());
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
    public void imprimir1(String n) {
        conexao = c.Conectar();
        HashMap d = new HashMap();
        d.put("codigo", n);

        try {
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\Aprienção_de_Carta\\Relatorio\\infracao3.jasper", d, conexao);
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
}
