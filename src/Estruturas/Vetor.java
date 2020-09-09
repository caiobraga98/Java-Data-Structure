package Estruturas;

import Estruturas.Exceptions.PosicaoInvalidaException;

public class Vetor<T> {

    private T[] vetor;
    private int qtd;

    public Vetor() {

    }

    public Vetor(int tamanho) {
        vetor = (T[]) new Object[tamanho];

    }

    public void Adciona(T elemento) {
        if (Tamanho() == vetor.length) {
            redimensionaIt();
        }
        Iterador it = new Iterador(vetor);
        int i = 0;
        while (it.hasNext()) {
            if (it.next() == null) {
                vetor[i] = elemento;
                qtd++;
                break;
            }
        }
    }

    public void adcionaInicio(T elemento) {
        if (this.qtd == 0) {
            vetor[0] = elemento;
        }

    }

    public void adcionaFim(T elemento) {
  
    }

    public void Remove(int pos) throws PosicaoInvalidaException {
        if (vetor[pos] != null) {
            vetor[pos] = null;
            qtd--;
        } else {
            throw new PosicaoInvalidaException();
        }

    }

    public void removeInicio() {
        if (vetor[0] != null) {
            vetor[0] = null;
            qtd--;
        }

    }

    public void removeFim() throws PosicaoInvalidaException {
        if (vetor[vetor.length] != null) {
            vetor[vetor.length] = null;
            qtd--;
        } else {
            throw new PosicaoInvalidaException();
        }

    }

    public int Tamanho() {
        //quantidade de elementos inseridos
        return qtd;
    }

    public void Redimensiona() {
        T[] vetor2;
        vetor2 = (T[]) new Object[vetor.length * 2];
        for (int i = 0; i < vetor.length; i++) {
            vetor2[i] = vetor[i];
        }
        vetor = vetor2;

    }

    public void redimensionaIt() {
        T[] vetor2;
        vetor2 = (T[]) new Object[vetor.length * 2];

        Iterador it = new Iterador(vetor);
        int i = 0;
        while (it.hasNext()) {
            vetor2[i] = vetor[i];
            it.next();
        }
        vetor = vetor2;
    }

    public boolean existeDado(int pos) {
        if (vetor[pos] != null) {
            return true;
        } else {
            return false;
        }
    }

    public T Recupera(int pos) {
        if (vetor[pos] != null) {
            return vetor[pos];
        }
        return null;

    }

    public boolean Vazio() {
        if (qtd == 0) {
            return true;
        } else {
            return false;
        }

    }

    public void limpa() {

        Iterador it = new Iterador(vetor);
        int i = 0;
        while (it.hasNext()) {
            vetor[i] = null;
        }

        qtd = 0;
    }
}
