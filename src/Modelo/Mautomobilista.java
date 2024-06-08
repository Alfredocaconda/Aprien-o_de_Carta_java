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
public class Mautomobilista {

    private int id_automobilista;
    private int idp;
    private String nome;
    private String carta;
    private String datae;
    private String caducidade;
    private String endereco;
    private String telefone;

    public int getId_automobilista() {
        return id_automobilista;
    }

    public void setId_automobilista(int id_automobilista) {
        this.id_automobilista = id_automobilista;
    }

    public String getCaducidade() {
        return caducidade;
    }

    public void setCaducidade(String caducidade) {
        this.caducidade = caducidade;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCarta() {
        return carta;
    }

    public void setCarta(String carta) {
        this.carta = carta;
    }

    public String getDatae() {
        return datae;
    }

    public void setDatae(String datae) {
        this.datae = datae;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void mensagem(String sms) {
        JOptionPane.showMessageDialog(null, sms);
    }
}
