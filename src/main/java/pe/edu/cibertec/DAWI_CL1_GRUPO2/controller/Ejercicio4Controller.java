package pe.edu.cibertec.DAWI_CL1_GRUPO2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_GRUPO2.model.Ejercicio4;

@Controller
public class Ejercicio4Controller {
    @GetMapping("/ejercicio4")
    public String form(Model model) {
        model.addAttribute("verresultado", false);
        model.addAttribute("limite", new Ejercicio4());
        return "ejercicio4";
    }

    @PostMapping("/calcularlim")
    public String calcularlim(@ModelAttribute("limite") Ejercicio4 ejer, Model model) {

        int limite = ejer.getLimite();
        String cubo = "";
        String cuarta = "";

        for (int numero = 1; numero <= limite; numero++) {
            if(limite==1){
                cubo = cubo +(numero * numero * numero);
                cuarta = cuarta +(numero * numero * numero * numero);
            } else {
                cubo = cubo + (numero * numero * numero) + "    ";
                cuarta = cuarta + (numero * numero * numero * numero) + "   ";
            }
        }

        model.addAttribute("verresultado", true);
        model.addAttribute("resultado", "Número: " + limite + ", Cubo: " + cubo + "         Cuarta: " + cuarta);
        return "ejercicio4";
    }
}
