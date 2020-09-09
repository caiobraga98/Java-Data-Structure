
package Estruturas;


public class Celula<T> {
    private Celula<T> proximo;
    private Celula <T> anterior;    
    private T elemento;
    
    

    public Celula(Celula proximo, T elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }
    public Celula(Celula proximo,Celula anterior,T elemento){
        this.proximo = proximo;
        this.elemento = elemento;
        this.anterior = anterior;
        
    }


    public Celula(T elemento) {
        this.elemento = elemento;
    }
    

    public Celula<T> getProximo() {
        return proximo;
    }

    public void setProximo(Celula<T> proximo) {
        this.proximo = proximo;
    }

    public Celula<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula<T> anterior) {
        this.anterior = anterior;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    
    
     
   

    
    
    
}
