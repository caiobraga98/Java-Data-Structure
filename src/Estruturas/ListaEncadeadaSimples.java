package Estruturas;

import Estruturas.Exceptions.PosicaoInvalidaException;

public class ListaEncadeadaSimples<T> {

    private Celula primeira;
    private Celula ultima;
    private int qtd;

    public ListaEncadeadaSimples() {
        this.primeira = null;
        this.ultima = null;
        this.qtd = 0;

    }

    public void adciona(T elemento, int posicao) throws PosicaoInvalidaException {
        //faltou por o contador.
        Celula nova = new Celula(primeira, elemento);
        if (this.qtd < posicao) {
            throw new PosicaoInvalidaException();
        } else if (posicao == 0) {
            adcionaInicio(elemento);
        } else {

            Celula aux = this.primeira;
            Celula anterior = aux;
            IteradorLista it = new IteradorLista(aux);

            while (it.hasNext()) {
                anterior = aux;
                aux = aux.getProximo();
                it.next();
            }

            nova.setProximo(aux);
            anterior.setProximo(nova);

            this.qtd++;
        }
    }

    public void adcionaInicio(T elemento) {
        Celula nova = new Celula(this.primeira, elemento);
        this.primeira = nova;
        if (qtd == 0) {
            this.ultima = this.primeira;
        }
        this.qtd++;
    }

    public void adcionarFim(T elemento) {

        if (qtd == 0) {
            this.adcionaInicio(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProximo(nova);
            this.ultima = nova;
            this.qtd++;
        }
    }

    public boolean existeDado(T elemento) {
        Celula atual = primeira;

        IteradorLista ite = new IteradorLista(atual);
        while (ite.hasNext()) {
            if (atual.getElemento().equals(elemento)) {
                return true;

            }
            atual.getElemento();
            ite.next();

        }

        return false;
    }

    public boolean posicaoOcupada(int pos) {
        Celula aux = this.primeira;
        IteradorLista ite = new IteradorLista(aux);
        int cont = 0;
        while (ite.hasNext()) {
            cont++;
            if (cont == pos) {
                if (aux != null) {
                    return true;
                }
            }
            aux = aux.getProximo();
            ite.next();
        }
        return false;

    }

    public int tamanho() {

        return qtd;

    }
//RECUPERA ESTA IMCOMPLETO
    public void limpa() {
        this.primeira = null;
        this.ultima = null;
        this.qtd = 0;
    }

    public Object recupera(int posicao) throws PosicaoInvalidaException {
        Celula aux = this.primeira;
        int cont = 0;
        IteradorLista it = new IteradorLista(aux);
        if (qtd == 0) {
            throw new PosicaoInvalidaException();
        } else {
            while (it.hasNext()) {
                if (cont == posicao) {
                    return aux;
                }
                it.next();
                aux = aux.getProximo();
                cont++;

            }

        }
        return false;

    }

    public void removeInicio() throws PosicaoInvalidaException {
        if (qtd == 0) {
            throw new PosicaoInvalidaException();
        }
        this.primeira = this.primeira.getProximo();
        this.qtd--;

    }

    public void removeFim() throws PosicaoInvalidaException {
        Celula aux = this.primeira;
        Celula anterior = aux;
        IteradorLista it = new IteradorLista(aux);
        if (qtd == 0) {
            throw new PosicaoInvalidaException();
        }
        while (it.hasNext()) {
            anterior = aux;
            aux = aux.getProximo();
            it.next();

        }
        this.ultima = anterior;

        qtd--;
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

        }else {
            while(it.hasNext() && cont < pos){
                anterior = aux;
                aux = aux.getProximo();
                proxima = aux.getProximo();
                cont++;
                it.next();
            }
            anterior.setProximo(proxima);
            
            

        qtd--;

    }

}
    

}
