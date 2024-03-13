
package Repositories;

import Models.Usuario;
import java.util.List;


public interface UsuarioRepository {
    void save(Usuario usuario);
    List<Usuario> findAllDb(); //Metodo para desplegar elementos de db
    
    int findByUP(String username, String password);
    boolean usernameExists(String username);
}
