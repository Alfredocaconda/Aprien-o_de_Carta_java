/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author ALFREDO CACONDA
 */
public class Magente {
    private int id_agente;
    private int id_policia;
    private int nip;
    private String nome;

    public int getId_agente() {
        return id_agente;
    }

    public void setId_agente(int id_agente) {
        this.id_agente = id_agente;
    }

    public int getId_policia() {
        return id_policia;
    }

    public void setId_policia(int id_policia) {
        this.id_policia = id_policia;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void mensagem(String sms){
        JOptionPane.showMessageDialog(null, sms);
    }
}
