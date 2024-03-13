
package Controllers;

import Models.Registro;
import Repositories.RegistroRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controlador para Restful web services
@RestController
public class restController {
    @Autowired
    private RegistroRepository registroRepository;
    
    //Metodo GET, desplegar todos
    @RequestMapping(value = "/api/registros", method=RequestMethod.GET)
    public ArrayList<Registro> getRegistroList(){
      
        List<Registro> registros = registroRepository.findAllDb();
        ArrayList<Registro> registros_all = new ArrayList<Registro>(registros);
         return registros_all;   
    }
    
    //desplegar registros pOr username
    @GetMapping(value = "/api/registros/{username}")
    public ArrayList<Registro> getRegistroListByU(@PathVariable("username") String username){
      String metodo="byNombre";
        List<Registro> registros = registroRepository.findByUsername(username);
        ArrayList<Registro> registros_busqueda = new ArrayList<Registro>(registros);
         return registros_busqueda;  
    }   
}
