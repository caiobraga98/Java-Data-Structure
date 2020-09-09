package Estruturas;

import java.util.Iterator;

public class Iterador<T> implements Iterator {

    T[] itens;
    int posicao = 0;

    public Iterador(T[] itens) {
        this.itens = itens;
    }

    @Override
    public boolean hasNext() {
        if (posicao < 0 || posicao >= itens.length) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Object item = itens[posicao];
        posicao++;
        return item;
    }
    

}
