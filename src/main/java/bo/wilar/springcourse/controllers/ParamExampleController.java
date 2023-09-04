package bo.wilar.springcourse.controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamExampleController {

    @GetMapping("/")
    private String index() {
        return "params/index";
    }

    @GetMapping("/string")
    private String param(@RequestParam(name = "text", required = false) String text, Model model) {
        model.addAttribute("result", "El parámetro enviado es: " + text);
        return "params/ver";
    }

    @GetMapping("/mix-params")
    private String param(@RequestParam String saludo, @RequestParam Integer number, Model model) {
        model.addAttribute("result", "El saludo enviado es: " + saludo +
                " y el número es " + number);
        return "params/ver";
    }

    @GetMapping("/mix-params-request")
    private String param(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        Integer number = null;
        try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e) {
            number = 0;
        }
        model.addAttribute("result", "El saludo enviado es: " + saludo +
                " y el número es " + number);
        return "params/ver";
    }
}
