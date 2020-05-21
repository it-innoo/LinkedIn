
package projekti.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class UserController {
    
    @GetMapping("/registration")
    public String registration(Model model) {

        return "registration";
    }

    
}
