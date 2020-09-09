
package Estruturas;


public class Cidade {
    private String nomecidade;
    private double dist;

    public Cidade(String nomecidade, double dist) {
        this.nomecidade = nomecidade;
        this.dist = dist;
    }

    public String getNomecidade() {
        return nomecidade;
    }

    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }
       
    
}
