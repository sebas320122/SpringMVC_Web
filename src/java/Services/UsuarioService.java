
package Services;

import Models.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    public Usuario crear(String username, String nombre, int edad,
            String sexo, String password) {
        return new Usuario(username, nombre, edad, sexo, password);
    }
}
