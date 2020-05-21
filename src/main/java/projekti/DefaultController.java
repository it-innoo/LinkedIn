package projekti;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import projekti.model.Account;
import projekti.repository.AccountRepository;

@Controller
public class DefaultController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (accountRepository.count() == 0) {
            accountRepository.save(new Account("admin",
                    "admin",
                    passwordEncoder.encode("sekret"),
                    passwordEncoder.encode("sekret"),
                    "admin"));
            accountRepository.save(new Account("ukko",
                    "Ukko",
                    passwordEncoder.encode("salainen"),
                    passwordEncoder.encode("salainen"),
                    "ihme ukko"));
            /*
            accountRepository.save(new Account("ukko", passwordEncoder.encode("salainen")));
            accountRepository.save(new Account("jpa", passwordEncoder.encode("salainen")));
*/
        }
    }

    @GetMapping("*")
    public String helloWorld(Model model) {
        model.addAttribute("message", "World!");
        return "index";
    }
}
