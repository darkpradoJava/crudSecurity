package crudSecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    private ModelAndView modelAndView = new ModelAndView();

    @GetMapping("/")
    public ModelAndView getLoginPage(Authentication authentication) {
        if (authentication != null) {
            modelAndView.setViewName("redirect: /user");
            return modelAndView;
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(Authentication authentication, ModelMap model, HttpServletRequest request) {
        if (authentication != null) {
            modelAndView.setViewName("redirect: /user");
            return modelAndView;
        }
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/user")
    public ModelAndView getUserPage(Authentication authentication) {
        modelAndView.addObject("user", authentication.getName());
        modelAndView.setViewName("user");
        return modelAndView;
    }
}
