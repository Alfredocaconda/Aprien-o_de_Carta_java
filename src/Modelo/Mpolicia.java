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
public class Mpolicia {
    private int idpolicia;
    private String nome;
    private String genero;
    private int nip;
    private String nome_do_pai;
    private String nome_da_mae;
    private String bi;
    private String municipio;
    private String provincia;
    private String categoria;
    private String telefone;
    private String usuario;
    private String senha;

    
    
    public int getIdpolicia() {
        return idpolicia;
    }

    public void setIdpolicia(int idpolicia) {
        this.idpolicia = idpolicia;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public String getNome_do_pai() {
        return nome_do_pai;
    }

    public void setNome_do_pai(String nome_do_pai) {
        this.nome_do_pai = nome_do_pai;
    }

    public String getNome_da_mae() {
        return nome_da_mae;
    }

    public void setNome_da_mae(String nome_da_mae) {
        this.nome_da_mae = nome_da_mae;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void mensagem(String sms){
        JOptionPane.showMessageDialog(null, sms);
    }
    
}
