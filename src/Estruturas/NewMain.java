package Estruturas;

import Estruturas.Exceptions.PosicaoInvalidaException;
import TesteClasses.Carro;
import java.util.ArrayList;

public class NewMain {

    public static void main(String[] args) throws PosicaoInvalidaException {
        //cidades da Estrada 2(BR-235)
        Cidade cidade4 = new Cidade("Carira",36.6);
        Cidade cidade3 = new Cidade("Frei", 57.7);
        Cidade cidade2 = new Cidade("itabaiana",20);
        Cidade cidade1 = new Cidade("Aracaju",0);
        
        //cidade da Estrada 1 (Br-101)
        
        Cidade cidade5 = new Cidade("japaratuba",13.3);
        Cidade cidade6 = new Cidade("carmopolis",17.3);
        Cidade cidade7 = new Cidade("maruim",31.9);
        
        Pilha p = new Pilha();
        p.push(cidade1);
        p.push(cidade2);
        p.push(cidade3);
        Pilha geral = new Pilha();
        
        Estrada estrada1 = new Estrada("br-101",p);
        geral.push(estrada1);
    }

}
