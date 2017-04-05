/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalidades;

import trabalho_olimpiadas.AlimentoException;
import trabalho_olimpiadas.Alimentos;

/**
 *
 * @author Chrysthian
 */
public abstract class Modalidade {
    
    protected int codigo;
    protected String nome;
    protected String sub_modalidade;
    protected String especificacao;

    public Modalidade(int codigo, String nome, String sub_modalidade, String especificacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.sub_modalidade = sub_modalidade;
        this.especificacao = especificacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getSub_modalidade() {
        return sub_modalidade;
    }

    public String getEspecificacao() {
        return especificacao;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSub_modalidade(String sub_modalidade) {
        this.sub_modalidade = sub_modalidade;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }
    
    public abstract void verificarBoi(Alimentos estoque, String nome)throws AlimentoException;
    public abstract void verificarFrango(Alimentos estoque, String nome)throws AlimentoException;
    public abstract void verificarLegumes(Alimentos estoque, String nome)throws AlimentoException;
    public abstract void verificarPeixe(Alimentos estoque, String nome)throws AlimentoException;   
    public abstract void verificarSup1(Alimentos estoque, String nome)throws AlimentoException;
    public abstract void verificarSup2(Alimentos estoque, String nome)throws AlimentoException;
    public abstract void verificarMassa(Alimentos estoque, String nome)throws AlimentoException;
}
