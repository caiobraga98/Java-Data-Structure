package Estruturas;

public class Fila<T> {

    private Celula primeiro;
    private Celula ultimo;
    private int qtd;

    public Fila() {

    }

    public void Inserir(T elemento) {
        Celula nova = new Celula(elemento);
        if (this.qtd == 0) {
            this.primeiro = nova;
            this.ultimo = nova;
            this.qtd++;
        } else {
            this.ultimo.setProximo(nova);
            this.ultimo = nova;
            this.qtd++;
        }

    }

    public boolean existeDado(T elemento) {
        Celula aux = new Celula(elemento);
        Celula compara = primeiro;
        IteradorLista it = new IteradorLista(compara);

        while (it.hasNext()) {
            if (compara == aux) {
                return true;
            }
            it.next();
        }

        return false;
    }

    public boolean isEmpty() {
        return qtd == 0;
    }

    public T Recuperar() {
        return (T) this.primeiro;
    }

    public void Alterar(T elemento) {
        this.primeiro.setElemento(elemento);
    }

    public void remove() {
        
    }
    public int tamanho(){
        return this.qtd;
    }
    public void limpa(){
        this.qtd = 0;
        this.primeiro = null;
        this.ultimo = null;
    }

}
