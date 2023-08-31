package bo.wilar.springcourse.controllers;

import bo.wilar.springcourse.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("titulo", "hola Spring framework");
        return "index";
    }

    @GetMapping(value = "/profile")
    private String profile(Model model) {
        User user = new User();
        user.setName("Wilar");
        user.setSurname("Arancibia");
        user.setEmail("wilarads@gmail.com");
        model.addAttribute("tittle", "Perfil del usuario: ".concat(user.getName()));
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping(value = "/list")
    private String list(Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Jose","Mayser","jmayser@gmail.com"));
        model.addAttribute("tittle", "Listado de usuarios");
        model.addAttribute("users", userList);
        return "list";
    }


}
