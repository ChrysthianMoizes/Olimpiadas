/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_olimpiadas;

import modalidades.VoleyPraia;
import modalidades.NatacaoCostas;
import modalidades.NatacaoPeito;
import modalidades.LancamentoMartelo;
import modalidades.Futebol;
import modalidades.SaltoVara;
import modalidades.Atletismo;
import modalidades.Modalidade;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Olimpiadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Modalidade> modalidade = new ArrayList<>();

        Alimentos estoque = new Alimentos();

        Scanner arquivoAlimentos = abrirArquivoAlimentos();
        Scanner arquivoAtletas = abrirArquivoAtletas();

        preencherEstoque(estoque, arquivoAlimentos);
        List<Atleta> atletas = preencherListaAtletas(arquivoAtletas);

        contarDias(atletas, estoque); // decrementarEstoque é chamada dentro desse método
        atletasFemininas(atletas);
        semSubModalidade(atletas);
        maiorMediaIdade(atletas);
        

    }

    public static Scanner abrirArquivoAlimentos() {

        try {

            // abrindo arquivo de alimentos
            FileInputStream alimentos = new FileInputStream("alimentos.txt");
            Scanner arquivoAlimentos = new Scanner(alimentos);
            System.out.println("Arquivo Alimentos aberto com Sucesso!");

            return arquivoAlimentos;
            //arquivoAlimentos.close();

        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo Alimentos não encontrado");
        }
        return null;
    }

    public static Scanner abrirArquivoAtletas() {

        try {

            FileInputStream atletas = new FileInputStream("atletas.txt");
            Scanner arquivoAtletas = new Scanner(atletas);
            System.out.println("Arquivo Atletas aberto com Sucesso!");

            return arquivoAtletas;

        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo Atletas não encontrado");
        }

        return null;
    }

    public static void preencherEstoque(Alimentos estoque, Scanner arquivoAlimentos) {

        //preenchendo objeto de estoque
        estoque.setBoi(arquivoAlimentos.nextInt());
        estoque.setFrango(arquivoAlimentos.nextInt());
        estoque.setLegumes(arquivoAlimentos.nextInt());
        estoque.setPeixe(arquivoAlimentos.nextInt());
        estoque.setSup1(arquivoAlimentos.nextInt());
        estoque.setSup2(arquivoAlimentos.nextInt());
        estoque.setMassa(arquivoAlimentos.nextInt());

        arquivoAlimentos.close();

    }

    public static List<Atleta> preencherListaAtletas(Scanner arquivoAtletas) {

        List<Atleta> atletas = new ArrayList<>();
        Atleta atleta = null;

        while (arquivoAtletas.hasNext()) {

            String nome = arquivoAtletas.next();
            int idade = arquivoAtletas.nextInt();
            double peso = arquivoAtletas.nextDouble();
            String sexo = arquivoAtletas.next();
            String pais_origem = arquivoAtletas.next();
            String pais_repre = arquivoAtletas.next();
            int cod_modalidade = arquivoAtletas.nextInt();
            Modalidade mod = null;
            
            // preenchendo o objeto modalidade de acordo com o esporte do atleta
            switch (cod_modalidade) {

                case 1: mod = new NatacaoCostas(1, "Natação", "Costas", "100 metros"); break;
                    
                case 2: mod = new Futebol(2, "Futebol", "NULO", "NULO"); break;
                    
                case 3: mod = new Atletismo(3, "Atletismo", "Corrida", "200 metros"); break;
                    
                case 4: mod = new LancamentoMartelo(4, "Lançamento de Martelo", "Grande", "NULO"); break;
                    
                case 5: mod = new SaltoVara(5, "Salto com Vara", "NULO", "NULO"); break;
                    
                case 6: mod = new VoleyPraia(6, "Voley de Praia", "Areia Branca", "NULO"); break;
                    
                case 7: mod = new NatacaoPeito(7, "Natação", "Peito", "200 metros"); break;
                    
                default: System.out.println("Modalidade Inválida!");

            }

            atleta = new Atleta(nome, idade, peso, sexo, pais_origem, pais_repre, cod_modalidade, mod);
            atletas.add(atleta);

        }
        arquivoAtletas.close();
        return atletas;

    }

    public static void contarDias(List<Atleta> atletas, Alimentos estoque) {

        int dias = 0;
        int retorno = 0;

        while (retorno == 0) {
            
            //usando iterator para navegar pela lista de objetos
            Iterator it = atletas.iterator();
            
            while(it.hasNext()){
                
                try{
                    Atleta atleta = (Atleta)it.next();
                    decrementarEstoque(atleta, estoque);
                    
                }catch(AlimentoException erro){
                    
                    System.out.println("O estoque consegue alimentar os atletas por " + dias + " dias.");
                    System.out.println("A simulação acabou com o " + erro.getNome() + " faltando o alimento " + erro.getAlimento() + ".");
                    retorno = 1;
                    break;     
                }
            }
            dias++;
        }
    }

    public static void decrementarEstoque(Atleta atleta, Alimentos estoque)  throws AlimentoException{
        
        atleta.getMod().verificarBoi(estoque, atleta.getNome());
        atleta.getMod().verificarFrango(estoque, atleta.getNome());
        atleta.getMod().verificarLegumes(estoque, atleta.getNome());
        atleta.getMod().verificarPeixe(estoque, atleta.getNome());
        atleta.getMod().verificarSup1(estoque, atleta.getNome());
        atleta.getMod().verificarSup2(estoque, atleta.getNome());
        atleta.getMod().verificarMassa(estoque, atleta.getNome()); 
        
    }
    
    public static void atletasFemininas(List<Atleta> atletas){
            
        String af = "A(s) atleta(s) ";
        int cont = 0;
        
        Iterator it = atletas.iterator();
        while (it.hasNext()) {

            Atleta atleta = (Atleta)it.next();
            if((atleta.getCod_modalidade() == 1)||(atleta.getCod_modalidade() == 7)){
                
                if(!atleta.getPais_origem().equals(atleta.getPais_repre())){
                    if("F".equals(atleta.getSexo())){
                        af = af + atleta.getNome() + ", ";
                        cont++;
                    }
                }   
            }
        }
        if(cont > 1){
            af = af + "são nadadoras e possuem país de origem diferente do país de representação.";
        }else if(cont == 1){
            af = af + "é nadadora e possui país de origem diferente do país de representação.";
        }else{
            af = "Não existem nadadoras com país de origem diferente do país de representação";
        }
        
        System.out.println(af);
    }    
    
    public static void semSubModalidade(List<Atleta> atletas){
        
        List<String> pais = new ArrayList<>();
        int[] qt = new int[10];
        
        Iterator it = atletas.iterator();
        
        int j = 0;
            
        while(it.hasNext()){

            Atleta atleta = (Atleta)it.next();
            
            if((atleta.getCod_modalidade() == 2)||(atleta.getCod_modalidade() == 5)){
                
                if(pais.size()==0){
                    pais.add(j, atleta.getPais_repre());
                    qt[j] = qt[j]+1;
                    j++;
                    
                }else{
                    int retorno = 0;
                    
                    for(int i = 0; i < pais.size(); i++){
                        
                        if(pais.get(i).equals(atleta.getPais_repre())){
                            qt[i] = qt[i]+1;
                            retorno = 1;
                            break;
                        }
                    }
                    
                    if(retorno == 0){
                        pais.add(j, atleta.getPais_repre());
                        qt[j] = qt[j]+1;
                        j++;
                    }    
                }
            }
        }
        
        int maior = qt[0];
        int cont = 0;
        String saida = "";
        
        for(int i = 0; i < pais.size(); i++){
            
            if(maior <= qt[i]){
                maior = qt[i];         
            }
        }
        
        for(int k = 0; k < pais.size(); k++){
            
            if(qt[k] == maior){
                saida = saida + pais.get(k) + ", ";
                cont++;
            }
        }
        
        if(cont > 1){
            saida = saida + "são os países com mais atletas em modalidades sem submodalidades";
        }else if(cont == 1){
            saida = saida + "é o país com mais atletas em modalidades sem submodalidades";
        }
        
        System.out.println(saida);
    }
    
    public static void maiorMediaIdade(List<Atleta> atletas){
        
        List<String> modalidades = new ArrayList<>(); 
        int[] idade = new int[8];
        int[] contador = new int[8];
        float[] media = new float[8];
        int indice = 0;
        
        modalidades.add(0, "NULO");
        modalidades.add(1, "Natação/Costas");
        modalidades.add(2, "Futebol");
        modalidades.add(3, "Atletismo");
        modalidades.add(4, "Lançamento de Martelo");
        modalidades.add(5, "Salto com Vara");
        modalidades.add(6, "Voley de Praia");
        modalidades.add(7, "Natação/Peito");

        Iterator corrente = atletas.iterator();
            
        for(int i = 0; i < atletas.size(); i++){
                
            Atleta atual = (Atleta)corrente.next();
                
            indice = atual.getCod_modalidade();
            idade[indice] = idade[indice] + atual.getIdade();
            contador[indice] = contador[indice] + 1;    
        }
        
        for(int k = 1; k < idade.length; k++){
            media[k] = (float)idade[k] / contador[k];
        }
        
        float maior = media[0];
        
        for(int j = 1; j < media.length; j++){
            
            if(maior <= media[j]){
                maior = media[j];         
            }
        }
        
        String saida = "";
        int cont = 0;
        
        for(int k = 1; k < media.length; k++){
            
            if(media[k] == maior){
                saida = saida + modalidades.get(k) + ", ";
                cont++;
            }
        }
        
        if(cont > 1){
            saida = saida + "são as modalidades cujos atletas tem média de idade mais alta";
        }else if(cont == 1){
            saida = saida + "é a modalidade cujos atletas tem media de idade mais alta.";
        }
        
        System.out.println(saida);
    }
}
