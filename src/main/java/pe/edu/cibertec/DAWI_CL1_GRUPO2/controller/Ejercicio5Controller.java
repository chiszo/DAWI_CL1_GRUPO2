package pe.edu.cibertec.DAWI_CL1_GRUPO2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pe.edu.cibertec.DAWI_CL1_GRUPO2.model.Ejercicio5;


@Controller
public class Ejercicio5Controller {

    @GetMapping("/ejercicio5")
    public String form(Model model){
        model.addAttribute("verresultado", false);
        model.addAttribute("rebaja", new Ejercicio5());
        return "ejercicio5";
    }

    public String calcularPrecio(@ModelAttribute("rebaja") Ejercicio5 ejercicio, Model model){
        Double precioTotal;
        if (ejercicio.getCantidadAdquirida() > 20) {
            precioTotal = ejercicio.getPrecioUnitario() * ejercicio.getCantidadAdquirida() * 0.9;
        } else if(ejercicio.getCantidadAdquirida() > 10) {
            precioTotal = ejercicio.getPrecioUnitario() * ejercicio.getCantidadAdquirida() * 0.95;
        } else {
            precioTotal = ejercicio.getPrecioUnitario() * ejercicio.getCantidadAdquirida();
        }

        model.addAttribute("verresultado",true);
        model.addAttribute("resultado", "Precio total a pagar: "+ String.format("%.2f",precioTotal));
        return "ejercicio1";
    }

}
