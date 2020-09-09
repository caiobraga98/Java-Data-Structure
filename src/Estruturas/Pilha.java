package Estruturas;

public class Pilha<T> {

    private int qtd;
    private Celula primeira;
    private Celula ultima;

    public Pilha() {
     
    }

    public void push(T elemento) {
        Celula nova = new Celula(elemento);
        if (qtd == 0) {
            this.primeira = nova;
            this.ultima = nova;
            this.qtd++;
        } else {
            Celula aux = this.ultima;
            aux.setProximo(nova);
            this.ultima = nova;
            this.qtd++;

        }
    }

    public boolean existeDado(T elemento) {
        Celula aux = new Celula(elemento);
        Celula compara = primeira;
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

    public T Top() {
        return (T) this.ultima.getElemento();
    }

    public void Pull(T elemento) {
        this.ultima.setElemento(elemento);
    }

    public void Pop() {
        Celula aux = this.primeira;
        Celula aux2 = aux;
        IteradorLista it = new IteradorLista(aux);
        while (it.hasNext()) {
            aux2 = aux;
            it.next();
            aux = aux.getProximo();
        }
        aux2.setProximo(null);
        this.ultima = aux2;

    }

    public int Tamanho() {
        return this.qtd;
    }
    public void limpa(){
        this.qtd =0;
        this.primeira = null;
        this.ultima = null;
    }
    public double calculaDistancia(Estrada estrada,Cidade a,Cidade b){
        Pilha aux;
        
        double dista;
        double distb;
        
        aux = estrada.getPilha();
        if(aux.Top() == a){
           dista = a.getDist();
           distb = a.getDist();
           double distac = dista+distb;
           return distac;
        }else {
            return 0;
        }
        
       
        
    }
}
