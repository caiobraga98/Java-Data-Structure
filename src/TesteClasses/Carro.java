
package TesteClasses;


public class Carro {
    public String nome;
    public int portas;

    public Carro(String nome, int portas) {
        this.nome = nome;
        this.portas = portas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }
    
    
}
