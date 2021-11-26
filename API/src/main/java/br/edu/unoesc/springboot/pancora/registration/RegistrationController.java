package br.edu.unoesc.springboot.pancora.registration;

import br.edu.unoesc.springboot.pancora.appuser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

//    @GetMapping("/register")
//    public ModelAndView register(Model model) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("register");
//
//        return modelAndView;
//    }

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
