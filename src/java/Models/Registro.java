
package Models;


public class Registro {
    //Atributos
    private int id;
    private String username;
    private float peso;
    private float estatura;
    private float imc;
    private String fecha;

    //Constructores
    public Registro(String username, float peso, float estatura, float imc, String fecha) {
        this.username = username;
        this.peso = peso;
        this.estatura = estatura;
        this.imc = imc;
        this.fecha = fecha;
    }
    public Registro() {
    }
    
    //Getters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public float getPeso() {
        return peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public float getImc() {
        return imc;
    }
    
    public String getFecha(){
        return fecha;
    }
    
}
