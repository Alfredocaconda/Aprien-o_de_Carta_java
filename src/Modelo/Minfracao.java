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
public class Minfracao {

    private int idautomobilista;
    private int policia;
    private int id_infracao;
    private String infracao;
    private String data_emissao;
    private String local_de_atuacao;
    private String disciplina;
    private String esta_de_pagamento;
    private String multa;
    private int agente;
    private String data_do_pagamento;

    public int getIdautomobilista() {
        return idautomobilista;
    }

    public void setIdautomobilista(int idautomobilista) {
        this.idautomobilista = idautomobilista;
    }
    

    public int getAgente() {
        return agente;
    }

    public void setAgente(int agente) {
        this.agente = agente;
    }

    public int getPolicia() {
        return policia;
    }

    public void setPolicia(int policia) {
        this.policia = policia;
    }

    public int getId_infracao() {
        return id_infracao;
    }

    public void setId_infracao(int id_infracao) {
        this.id_infracao = id_infracao;
    }

    public String getInfracao() {
        return infracao;
    }

    public void setInfracao(String infracao) {
        this.infracao = infracao;
    }

    public String getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(String data_emissao) {
        this.data_emissao = data_emissao;
    }

    public String getLocal_de_atuacao() {
        return local_de_atuacao;
    }

    public void setLocal_de_atuacao(String local_de_atuacao) {
        this.local_de_atuacao = local_de_atuacao;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getEsta_de_pagamento() {
        return esta_de_pagamento;
    }

    public void setEsta_de_pagamento(String esta_de_pagamento) {
        this.esta_de_pagamento = esta_de_pagamento;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }

    public String getData_do_pagamento() {
        return data_do_pagamento;
    }

    public void setData_do_pagamento(String data_do_pagamento) {
        this.data_do_pagamento = data_do_pagamento;
    }

    public void mensagem(String sms) {
        JOptionPane.showMessageDialog(null, sms);
    }
}
