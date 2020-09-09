package Estruturas;

import Estruturas.Exceptions.PosicaoInvalidaException;

public class ListaDuplamenteEncadeada<T> {

    private Celula primeira;
    private Celula ultima;
    private int qtd;

    public ListaDuplamenteEncadeada() {
        this.primeira = null;
        this.ultima = null;
        this.qtd = 0;

    }

    public void adcionaInicio(T elemento) {
        Celula nova = new Celula(null, null, elemento);

        if (qtd == 0) {
            this.primeira = nova;
            this.ultima = this.primeira;
        } else {
            Celula aux = this.primeira;
            aux.setAnterior(nova);
            primeira = nova;
            nova.setProximo(aux);
        }

        this.qtd++;

    }

    public void adcionaFim(T elemento) {

        if (qtd == 0) {
            adcionaInicio(elemento);
        } else {
            Celula nova = new Celula(null, ultima, elemento);
            this.ultima.setProximo(nova);
            this.ultima = nova;
            qtd++;

        }

    }

    public void adciona(T elemento, int posicao) throws PosicaoInvalidaException {
        Celula nova = new Celula(elemento);
        if (posicao > qtd) {
            throw new PosicaoInvalidaException();
        } else if (posicao == 0) {
            adcionaInicio(elemento);
        } else if (posicao == qtd) {
            adcionaFim(elemento);
        } else {
            Celula aux = primeira;
            Celula anterior = aux;
            Celula posterior = null;
            IteradorLista it = new IteradorLista(aux);
            int cont = 0;

            while (it.hasNext() && cont < posicao) {
                anterior = aux;
                aux = aux.getProximo();
                it.next();

                cont++;
            }
            nova.setProximo(aux);
            anterior.setProximo(nova);
            aux.setAnterior(nova);
            nova.setAnterior(anterior);
            
            this.qtd++;
        }

    }

    public boolean existeDado(T elemento) {
        Celula aux = primeira;
        IteradorLista it = new IteradorLista(aux);
        while (it.hasNext()) {
            if (it.equals(elemento)) {
                return true;
            }

            it.next();
        }
        return false;
    }

    public T recupera(int pos) throws PosicaoInvalidaException {

        if (qtd == 0) {
            throw new PosicaoInvalidaException();
        } else if (pos > qtd) {
            throw new PosicaoInvalidaException();

        } else {
            Celula aux = primeira;
            IteradorLista it = new IteradorLista(aux);
            int count = 0;

            while (it.hasNext() && count <= pos) {
                it.next();
                count++;
                aux = aux.getProximo();

            }
            return (T) aux;
        }

    }

    public Object RecuperaR(int pos) throws PosicaoInvalidaException {
        Celula aux = this.primeira;
        if (qtd == 0) {
            throw new PosicaoInvalidaException();
        } else if (pos >= 0) {
            aux = aux.getProximo();
            RecuperaR(pos - 1);
        }
        return aux;
    }

    public void remove(int pos) throws PosicaoInvalidaException {
        Celula aux = this.primeira;
        Celula anterior = null;
        Celula proxima = null;
        int cont = 0;
        IteradorLista it = new IteradorLista(aux);
        if (qtd == 0) {
            throw new PosicaoInvalidaException();

        } else if (pos == 0) {
            removeInicio();
        } else if (pos > qtd) {
            throw new PosicaoInvalidaException();

        } else {
            while (it.hasNext() && cont < pos) {
                anterior = aux;
                aux = aux.getProximo();
                proxima = aux.getProximo();
                cont++;
                it.next();
            }
            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);

            qtd--;

        }
    }

    public void removeInicio() throws PosicaoInvalidaException {
        if (qtd == 0) {
            throw new PosicaoInvalidaException();
        } else {

            this.primeira = this.primeira.getProximo();
            this.qtd--;

        }

    }

    public void removeFim() throws PosicaoInvalidaException {
        if (qtd == 0) {
            throw new PosicaoInvalidaException();
        } else {

            this.ultima = this.ultima.getAnterior();
            this.ultima.setProximo(null);
            this.qtd--;

        }
    }

    public int tamanho() {
        return this.qtd;
    }

    public void limpa() {
        Celula aux = primeira;
        Celula anterior;
        IteradorLista it = new IteradorLista(aux);
        while (it.hasNext()) {
            anterior = aux;
            anterior = null;
            it.next();
            aux = aux.getProximo();
        }
        this.primeira = null;
        this.ultima = null;
        this.qtd = 0;
    }

    public void imprime(char tipo) {
        System.out.println("/////////////");

        if (Character.toUpperCase(tipo) == 'C') {
            Celula aux = primeira;
            IteradorLista it = new IteradorLista(aux);

            while (it.hasNext()) {
                System.out.println(it.next() + "\n");
                //aux = aux.getProximo();

            }

        } else if (Character.toUpperCase(tipo) == 'D') {
            Celula aux = ultima;
            IteradorLista it = new IteradorLista(aux);

            while (it.hasPrevious()) {
                System.out.println(it.previous() + "\n");

            }
        } else {
            throw new IllegalArgumentException("erro,apenas letras C e D");
        }

    }

}
