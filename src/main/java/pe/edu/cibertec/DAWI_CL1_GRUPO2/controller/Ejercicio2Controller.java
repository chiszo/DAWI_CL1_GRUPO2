package pe.edu.cibertec.DAWI_CL1_GRUPO2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_GRUPO2.model.Ejercicio2;

@Controller
public class Ejercicio2Controller {

    @GetMapping("/calcularCobro")
    public String index(Model model) {
        model.addAttribute("cobrarmodel",
                new Ejercicio2());
        model.addAttribute("resultadoCobro",
                false);
        return "formCobrar";
    }
    @PostMapping("/calcularCobro")
    public String calcularCobro(@ModelAttribute("cobrarmodel")
                                Ejercicio2 cobrarmodel,
                                Model model){
        Double monto = cobrarmodel.getMonto();
        Integer numcuotas = 0;
        Double montoxcuotas = 0.0;

        Double montoInteres;
        if(monto < 4000){
            montoInteres = monto * 0.12;
        } else {
            montoInteres = monto * 0.10;
        }

        double montoTotalDeuda = monto + montoInteres;

        String resultadoCobro;
        if (monto > 5000) {
            numcuotas = 3;
            montoxcuotas = (monto / numcuotas) + montoInteres;
            resultadoCobro = "Debe pagar en " + numcuotas + " cuotas de $" + montoxcuotas;
        } else if (monto < 1000) {
            numcuotas = 1;
            montoxcuotas = monto/numcuotas;
            resultadoCobro = "Debe pagar en "+ numcuotas + " cuotas de $" + montoxcuotas;
        } else if (monto >= 2000 && monto <= 3000) {
            numcuotas = 2;
            montoxcuotas = monto/numcuotas;
            resultadoCobro = "Debe pagar en " + numcuotas + " cuotas de $" + montoxcuotas;
        } else {
            numcuotas = 5;
            montoxcuotas = monto/numcuotas;
            resultadoCobro = "Debe pagar en " + numcuotas + " cuotas de $" + montoxcuotas;
        }


        model.addAttribute("resultadoCobro", true);
        model.addAttribute("resultadofinal", resultadoCobro);
        return "formCobrar";

    }
}
