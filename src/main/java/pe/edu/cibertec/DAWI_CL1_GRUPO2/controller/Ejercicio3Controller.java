package pe.edu.cibertec.DAWI_CL1_GRUPO2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_GRUPO2.model.Ejercicio3;

@Controller
public class Ejercicio3Controller {
    @GetMapping("/ejercicio3")
    public String form(Model model){
        model.addAttribute("verresultado",false);
        model.addAttribute("entero", new Ejercicio3());
        return "ejercicio3";
    }

    @PostMapping("/calcularent")
    public String calcularent(@ModelAttribute("entero") Ejercicio3 ejer, Model model){
        int entero = ejer.getEntero();
        char vocal;
        if (entero == 1) {
            vocal = 'A';
        } else if (entero == 2) {
            vocal = 'E';
        } else if (entero == 3) {
            vocal = 'I';
        } else if (entero == 4) {
            vocal = 'O';
        } else if (entero == 5) {
            vocal = 'U';
        } else {
            vocal = '?';
        }
        model.addAttribute("verresultado",true);
        model.addAttribute("resultado", "La vocal correspondiente al número ingresado es: " + vocal);
        return "ejercicio3";
    }
}