
package Models;

//Modelo Usuario
public class Usuario {
    //Atributos
    private int id;
    private String username;
    private String nombre;
    private int edad;
    private String sexo;
    private String password;

    //Constructores
    public Usuario(String username, String nombre, int edad, String sexo, String password) {
        this.username = username;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.password = password;
    }

    public Usuario() {
    }
    
    //Getters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getPassword() {
        return password;
    }
    
    
}
