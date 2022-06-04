package com.example.FORM.Controller;

import com.example.FORM.Validadores.UsuarioValidador;
import com.example.FORM.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("usuario") //Para mantener los datos, como atributos que no estan mapeados en la base de datos (Ejemplo el Identificador que armamos aca)
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @ModelAttribute("paises")
    public List<String> paises(){
        return Arrays.asList("Argentina", "Peru", "Bolivia", "Uruguay", "Chile");
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap(){

        Map<String, String> paises = new HashMap<>();
        paises.put("ES", "España");
        paises.put("MX", "Mexico");
        paises.put("CL", "Chile");
        paises.put("AR", "Argentina");
        paises.put("PE", "Peru");

        return paises;
    }

    @GetMapping("/form")
    public String form(Model model){

        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Treviranus");
        usuario.setEmail("juantrevo@gggff.com");
        usuario.setUsername("ddd");
        usuario.setPassword("123456");


        usuario.setIdentificador("321.125.445-K");
        model.addAttribute("titulo", "Formulario usuarios");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String recibirDatos (@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status){
                                //Si quisieramos pasar solo un atributo podemos usar @RequestParam String username
                                //@Valid son validaciones tipicas que ya vienen con Spring, pero indicar en la clase usuario que reglas usaremos
                                //El BindingResult es para continuar validando, contiene los mensajes de error de la validacion cuando el objeto
                                //esta anotado con @Valid, pero SIEMPRE el objeto tiene que estar despues del objeto que se valida

        validador.validate(usuario, result);
        model.addAttribute("titulo", "Resultado del form");

        if (result.hasErrors()){
            return "form";
        }


        model.addAttribute("usuario", usuario);
        status.setComplete();
        return "resultado";

    }
}
