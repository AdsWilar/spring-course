package bo.wilar.springcourse.controllers;

import bo.wilar.springcourse.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${text.indexcontroller.index.tittle}")
    private String textIndex;
    @Value("${text.indexcontroller.profile.tittle}")
    private String textProfile;
    @Value("${text.indexcontroller.list.tittle}")
    private String textList;

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("titulo", textIndex);
        return "index";
    }

    @GetMapping(value = "/profile")
    private String profile(Model model) {
        User user = new User();
        user.setName("Wilar");
        user.setSurname("Arancibia");
        user.setEmail("wilarads@gmail.com");
        model.addAttribute("tittle", textProfile.concat(user.getName()));
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping(value = "/list")
    private String list(Model model) {
        model.addAttribute("tittle", textList);
        return "list";
    }

    @ModelAttribute("users")
    public List<User> populateUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Jose", "Mayser", "jmayser@gmail.com"));
        userList.add(new User("Wilar", "ADS", "wilar@gmail.com"));
        userList.add(new User("Andres", "Mayser", "jmayser@gmail.com"));
        return userList;

    }


}
