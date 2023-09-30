package pe.edu.cibertec.DAWI_CL1_GRUPO2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_GRUPO2.model.Ejercicio5;


@Controller
public class Ejercicio5Controller {

    @GetMapping("/ejercicio5")
    public String form(Model model){
        model.addAttribute("verresultado", false);
        model.addAttribute("rebaja", new Ejercicio5());
        return "ejercicio5";
    }

    @PostMapping("/calcularprecio")
    public String calcularPrecio(@ModelAttribute("rebaja") Ejercicio5 ejercicio, Model model){
        Double precioTotal= ejercicio.getPrecioUnitario() * ejercicio.getCantidadAdquirida();
        Integer cantidad = ejercicio.getCantidadAdquirida();
        if (cantidad > 20) {
            precioTotal = precioTotal * 0.9;
        } else if(cantidad > 10) {
            precioTotal = precioTotal * 0.95;
        } else {
            precioTotal = precioTotal;
        }

        model.addAttribute("verresultado",true);
        model.addAttribute("resultado", "Precio total a pagar: " +precioTotal);
        return "ejercicio5";
    }

}
