package pe.edu.cibertec.DAWI_CL1_GRUPO2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ejercicio5Controller {

    @GetMapping("/ejercicio5")
    public String form(Model model){
        model.addAttribute("verresultado", false);
        return "ejercicio5";

    }

}
