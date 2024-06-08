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
public class Mproprietario {

    private int idpropretario;
    private int idp;
    private String nome;
    private int carta;
    private String datae;
    private String endereco;
    private String telefone;

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public int getIdpropretario() {
        return idpropretario;
    }

    public void setIdpropretario(int idpropretario) {
        this.idpropretario = idpropretario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCarta() {
        return carta;
    }

    public void setCarta(int carta) {
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
