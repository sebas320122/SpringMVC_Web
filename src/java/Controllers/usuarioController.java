
package Controllers;

import Models.Usuario;
import Repositories.UsuarioRepository;
import Services.UsuarioService;
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
public class usuarioController {
    //Declarar servicio   
    @Autowired
    UsuarioService usuarioService;   
   
    //Declarar repositorio
    @Autowired
    UsuarioRepository usuarioRepository;
    
    //Redirigir al inicio
    @RequestMapping(value = "/inicio", method = RequestMethod.GET)
    public ModelAndView goInicio() {
    ModelAndView mav = new ModelAndView("index");//View a la que se redirigira
    return mav;
    }
    //Redirigir al view registro
    @RequestMapping(value = "/registrate", method = RequestMethod.GET)
    public ModelAndView goRegistro() {
    ModelAndView mav = new ModelAndView("registrate");//View a la que se redirigira
    return mav;
    }    
    //Redirigir al view registro
    @RequestMapping(value = "/ingresar", method = RequestMethod.GET)
    public ModelAndView goIngresar() {
    ModelAndView mav = new ModelAndView("ingresar");//View a la que se redirigira
    return mav;
    }
    
    @RequestMapping(value = "/registrate", method = {RequestMethod.POST })
    public ModelAndView registrar(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String nombre = request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        String password = request.getParameter("password");

        // Revisar si usuario existe
        if (usuarioRepository.usernameExists(username)) {
        ModelAndView mav = new ModelAndView("registrate");
        mav.addObject("error", "El nombre de usuario ya existe");
        return mav;
        }
        
        //Llamar servicio
        Usuario usuario = usuarioService.crear(username,nombre,edad,sexo,password);
      
        //Llamar repositorio
        usuarioRepository.save(usuario);
       
        ModelAndView mav = new ModelAndView("registrate");//redirigir a url
        return mav; 
        }
    
    //Iniciar sesion
    @RequestMapping(value = "/inicio", method = {RequestMethod.POST })
    public ModelAndView iniciarSesion(HttpServletRequest request, HttpServletResponse response){
      String username = request.getParameter("username");
      String password = request.getParameter("password");
        
      int uEncontrado = usuarioRepository.findByUP(username, password);
    
        if (uEncontrado == 1) {
            // If there is a record that matches, create a session and redirect to the index page
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            return new ModelAndView("index");
        } else {
            // If there is no record that matches, show an error message and return to the login page
            ModelAndView mav = new ModelAndView("ingresar");
            mav.addObject("error", "El nombre de usuario o contraseña es incorrecto");
            return mav;
        }
       }
}
