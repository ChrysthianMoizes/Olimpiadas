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
public class NatacaoPeito extends Modalidade{
    
    public NatacaoPeito(int codigo, String nome, String sub_modalidade, String especificacao) {
        super(codigo, nome, sub_modalidade, especificacao);
        //7, "Natação", "Peito", "200 metros"
    }
    
    @Override
    public void verificarBoi(Alimentos estoque, String nome) throws AlimentoException{
        
        if(estoque.getBoi() >= 0){
                
            estoque.decrementarBoi(0);
                
        }else{
             throw new AlimentoException("Boi", nome);
        }   
    }
    
    @Override
    public void verificarFrango(Alimentos estoque, String nome) throws AlimentoException{
        
        if(estoque.getFrango() >= 10){
                
            estoque.decrementarFrango(10);
                
        }else{
             throw new AlimentoException("Frango", nome);
        }   
    }
    
    @Override
    public void verificarLegumes(Alimentos estoque, String nome) throws AlimentoException{
        
        if(estoque.getLegumes() >= 4){
                
            estoque.decrementarLegumes(4);
            
        }else{
             throw new AlimentoException("Legumes", nome);
        }   
    }
    
    @Override
    public void verificarPeixe(Alimentos estoque, String nome) throws AlimentoException{
        
        if(estoque.getPeixe() >= 20){
                
            estoque.decrementarPeixe(20);
            
        }else{
             throw new AlimentoException("Peixe", nome);
        }   
    }
    
    @Override
    public void verificarSup1(Alimentos estoque, String nome) throws AlimentoException{
        
        if(estoque.getSup1() >= 0){
                
            estoque.decrementarSup1(0);
           
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
        
        if(estoque.getMassa() >= 0){
                
            estoque.decrementarMassa(0);
           
        }else{
            throw new AlimentoException("Massa", nome);
        }   
    } 
}
