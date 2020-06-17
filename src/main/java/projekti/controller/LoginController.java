package projekti.controller;

import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import projekti.model.Account;

@Controller
public class LoginController {

    @ModelAttribute
    private Account getAccount() {
        return new Account();
    }

    @GetMapping("/login")
    public String login(@ModelAttribute Account account) {
        /*
        if (bindingResult.hasErrors()) {
            return "login";
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
*/
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Authentication authentication) {
        SecurityContextLogoutHandler securityContextLogoutHandler
                = new SecurityContextLogoutHandler();

        securityContextLogoutHandler.setInvalidateHttpSession(true);
        securityContextLogoutHandler.setClearAuthentication(true);
        return "redirect:/index";
    }

    @GetMapping("/accounts")
    public String registration(Model model) {

        return "accounts";
    }
}
