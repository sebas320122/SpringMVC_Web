
package Repositories;

import Models.Registro;
import java.util.List;

public interface RegistroRepository {
    void save(Registro registro);
    List<Registro> findAllDb(); //Metodo para desplegar elementos de db
    List<Registro> findByUsername(String username);//buscar por usuario
}
