
package Controllers;

import Models.Registro;
import Repositories.RegistroRepository;
import Services.RegistroService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class registroController {
    
    //Declarar servicio   
    @Autowired
    RegistroService registroService;   
   
    //Declarar repositorio
    @Autowired
    RegistroRepository registroRepository;
    

    //Redirigir al view resultado
    @RequestMapping(value = "/resultado", method = RequestMethod.GET)
    public ModelAndView goResultado() {
    ModelAndView mav = new ModelAndView("resultado");//View a la que se redirigira
    return mav;
    }
    //Redirigir al view registros
    @RequestMapping(value = "/registros", method = RequestMethod.GET)
    public ModelAndView goRegistros() {
    ModelAndView mav = new ModelAndView("registros");//View a la que se redirigira
    return mav;
    }
        
    //Registrar calculo de IMC
    @RequestMapping(value = "/resultado", method = {RequestMethod.POST })
    public ModelAndView registrarImc(HttpServletRequest request, HttpServletResponse response){
         ModelAndView mav = new ModelAndView();

        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            float peso = Float.parseFloat(request.getParameter("peso"));
            float estatura = Float.parseFloat(request.getParameter("estatura"));

            //Llamar servicio
            Registro registro = registroService.crear(username,peso,estatura);

            //Llamar repositorio
            registroRepository.save(registro);

            mav.setViewName("resultado");//redirigir a url
            mav.addObject("imc", registro.getImc());
        } catch (NullPointerException e) {
            // handle error when username attribute is not set in the session
            mav.setViewName("index");
            mav.addObject("error", "Favor de iniciar sesión");
        } catch (Exception e) {
            // handle other exceptions
            mav.setViewName("index");
            mav.addObject("error", "Favor de iniciar sesión");
        }

        return mav;
        }
    
    //Ver registros 
    @RequestMapping(value = "/registros", method = {RequestMethod.POST })
    public ModelAndView verRegistros(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        
        //Llamar repositorio
         List<Registro> registros = registroRepository.findByUsername(username);
        ArrayList<Registro> registros_busqueda = new ArrayList<Registro>(registros);
         
       
        ModelAndView mav = new ModelAndView("registros");//redirigir a url
        mav.addObject("registros_busqueda", registros_busqueda);
        
        return mav; 
        }
    
    
    
    }
    
 
