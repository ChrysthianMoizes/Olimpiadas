/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_olimpiadas;

import modalidades.Modalidade;

/**
 *
 * @author Chrysthian
 */
public class Atleta {
    
    private String nome;
    private int idade;
    private double peso;
    private String sexo;
    private String pais_origem;
    private String pais_repre;
    private int cod_modalidade;
    private final Modalidade mod;

    public Atleta(String nome, int idade, double peso, String sexo, String pais_origem, String pais_repre, int cod_modalidade, Modalidade mod) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.sexo = sexo;
        this.pais_origem = pais_origem;
        this.pais_repre = pais_repre;
        this.cod_modalidade = cod_modalidade;
        this.mod = mod;
        
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public String getSexo() {
        return sexo;
    }

    public String getPais_origem() {
        return pais_origem;
    }

    public String getPais_repre() {
        return pais_repre;
    }

    public int getCod_modalidade() {
        return cod_modalidade;
    }

    public Modalidade getMod() {
        return mod;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setPais_origem(String pais_origem) {
        this.pais_origem = pais_origem;
    }

    public void setPais_repre(String pais_repre) {
        this.pais_repre = pais_repre;
    }

    public void setCod_modalidade(int cod_modalidade) {
        this.cod_modalidade = cod_modalidade;
    }
    

}