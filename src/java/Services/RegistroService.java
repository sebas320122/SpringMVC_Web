
package Services;

import Models.Registro;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

@Service
public class RegistroService {
    public Registro crear(String username, float peso, float estatura) {
        float imc = peso/(estatura*estatura);
        String fecha = (java.time.LocalDate.now()).toString();
        
        return new Registro(username, peso, estatura, imc, fecha);
    }
}
