package bo.wilar.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class PathVariableExampleController {

    @GetMapping("/string/{text}/{text2}")
    private String variables(@PathVariable String text, Model model, @PathVariable String text2) {
        model.addAttribute("tittle", "Recibir parámetros de la ruta(PathVariable)");
        model.addAttribute("result", "El texto enviado en la ruta es: " + text);
        model.addAttribute("result2", "El texto enviado en la ruta es: " + text2);

        return "variables/ver";
    }

}
