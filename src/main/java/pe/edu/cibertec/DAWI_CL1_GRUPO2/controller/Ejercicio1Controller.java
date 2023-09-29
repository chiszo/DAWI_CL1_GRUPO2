package pe.edu.cibertec.DAWI_CL1_GRUPO2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_GRUPO2.model.Ejercicio1;

@Controller
public class Ejercicio1Controller {

    @GetMapping("/ejercicio1")
    public String form(Model model){
        model.addAttribute("verresultado",false);
        model.addAttribute("descuento", new Ejercicio1());
        return "ejercicio1";
    }

    @PostMapping("/calculardes")
    public String calculardes(@ModelAttribute("descuento") Ejercicio1 ejer, Model model){
        Double total=ejer.getPrecio()* ejer.getCantidad();
        if(total>=200){
            total=total*0.8;
        } else {
            total=total;
        }

        model.addAttribute("verresultado",true);
        model.addAttribute("resultado", "Precio total a pagar: "+ String.format("%.2f",total));
        return "ejercicio1";
    }
}
