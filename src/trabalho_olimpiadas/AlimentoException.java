/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_olimpiadas;

/**
 *
 * @author Multimidia
 */
public class AlimentoException extends Exception{

    private final String alimento;
    private final String nome;

    public AlimentoException(String alimento, String nome) {
        this.alimento = alimento;
        this.nome = nome;
    }  

    public String getAlimento() {
        return alimento;
    }

    public String getNome() {
        return nome;
    }
    
}
