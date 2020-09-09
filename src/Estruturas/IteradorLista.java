package Estruturas;

import java.util.Iterator;

public class IteradorLista<T> implements Iterator<T> {

    private Celula<T> proximacelula;

    public IteradorLista(Celula primeira) {
        this.proximacelula = primeira;

    }

    @Override
    public boolean hasNext() {
        return proximacelula != null;
    }

    public boolean hasPrevious() {
        return proximacelula != null;
    }

    @Override
    public T next() {

        T celula = proximacelula.getElemento();
        proximacelula = proximacelula.getProximo();
        return celula;
    }

    public T previous() {
        T Celula = proximacelula.getElemento();
        proximacelula = proximacelula.getAnterior();
        return Celula;
    }

}
