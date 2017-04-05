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
public class SaltoVara extends Modalidade{
    
    public SaltoVara(int codigo, String nome, String sub_modalidade, String especificacao) {
        super(codigo, nome, sub_modalidade, especificacao);
        //5, "Salto com Vara", "NULO", "NULO"
    }  
    
    @Override
    public void verificarBoi(Alimentos estoque, String nome) throws AlimentoException{
        
        if(estoque.getBoi() >= 1){
                
            estoque.decrementarBoi(1);
                
        }else{
             throw new AlimentoException("Boi", nome);
        }   
    }
    
    @Override
    public void verificarFrango(Alimentos estoque, String nome) throws AlimentoException{
        
        if(estoque.getFrango() >= 1){
                
            estoque.decrementarFrango(1);
                
        }else{
             throw new AlimentoException("Frango", nome);
        }   
    }
    
    @Override
    public void verificarLegumes(Alimentos estoque, String nome) throws AlimentoException{
        
        if(estoque.getLegumes() >= 5){
                
            estoque.decrementarLegumes(5);
            
        }else{
             throw new AlimentoException("Legumes", nome);
        }   
    }
    
    @Override
    public void verificarPeixe(Alimentos estoque, String nome) throws AlimentoException{
        
        if(estoque.getPeixe() >= 0){
                
            estoque.decrementarPeixe(0);
            
        }else{
             throw new AlimentoException("Peixe", nome);
        }   
    }
    
    @Override
    public void verificarSup1(Alimentos estoque, String nome) throws AlimentoException{
        
        if(estoque.getSup1() >= 3){
                
            estoque.decrementarSup1(3);
           
        }else{
            throw new AlimentoException("Suplemento 1", nome);
        }   
    }
    
    @Override
    public void verificarSup2(Alimentos estoque, String nome) throws AlimentoException{
        
        if(estoque.getSup2() >= 0){
                
            estoque.decrementarSup2(0);
          
        }else{
            throw new AlimentoException("Suplemento 2", nome);
        }   
    }
    
    @Override
    public void verificarMassa(Alimentos estoque, String nome) throws AlimentoException{
        
        if(estoque.getMassa() >= 6){
                
            estoque.decrementarMassa(6);
           
        }else{
            throw new AlimentoException("Massa", nome);
        }   
    } 
    
    
}
