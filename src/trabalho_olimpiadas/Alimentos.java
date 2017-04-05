/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_olimpiadas;

/**
 *
 * @author Chrysthian
 */
public class Alimentos {
    
    private int boi;
    private int frango;
    private int legumes;
    private int peixe;
    private int sup1;
    private int sup2;
    private int massa;

    public int getBoi() {
        return boi;
    }

    public int getFrango() {
        return frango;
    }

    public int getLegumes() {
        return legumes;
    }

    public int getPeixe() {
        return peixe;
    }

    public int getSup1() {
        return sup1;
    }

    public int getSup2() {
        return sup2;
    }

    public int getMassa() {
        return massa;
    }

    public void setBoi(int boi) {
        this.boi = boi;
    }

    public void setFrango(int frango) {
        this.frango = frango;
    }

    public void setLegumes(int legumes) {
        this.legumes = legumes;
    }

    public void setPeixe(int peixe) {
        this.peixe = peixe;
    }

    public void setSup1(int sup1) {
        this.sup1 = sup1;
    }

    public void setSup2(int sup2) {
        this.sup2 = sup2;
    }

    public void setMassa(int massa) {
        this.massa = massa;
    }
    
    public void decrementarBoi(int boi) {
        this.boi = this.boi - boi; 
       } 
 
    public void decrementarFrango(int frango) {
        
        this.frango = this.frango - frango;
    }

    public void decrementarLegumes(int legumes) {
        this.legumes = this.legumes - legumes;
    }

    public void decrementarPeixe(int peixe) {
        this.peixe = this.peixe - peixe;
    }

    public void decrementarSup1(int sup1) {
        this.sup1 = this.sup1 - sup1;
    }

    public void decrementarSup2(int sup2) {
        this.sup2 = this.sup2 - sup2;
    }

    public void decrementarMassa(int massa) {
        this.massa = this.massa - massa;
    }  
}
