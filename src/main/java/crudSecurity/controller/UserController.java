package crudSecurity.controller;

import crudSecurity.model.User;
import crudSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin")
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "admin";
    }

    @GetMapping(value = "/admin/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        User user = userService.getUserById(id);
        if (user != null) {
            userService.delete(user);
        }
        return modelAndView;
    }

    @GetMapping(value = "/admin/add")
    public ModelAndView addPage(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @PostMapping(value = "/admin/add")
    public ModelAndView addUser(@ModelAttribute("user") User user, String role) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userService.add(user, role);
        return modelAndView;
    }

    @GetMapping(value = "/admin/edit/{id}")
    public ModelAndView editUserPage(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        User tempUser = userService.getUserById(id);
        modelAndView.addObject("user", tempUser);
        modelAndView.setViewName("/edit");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping(value = "/admin/edit")
    public ModelAndView editUser(@RequestParam(value = "id") Long id, @ModelAttribute("user") User user, String role) {
        ModelAndView modelAndView = new ModelAndView();
        user.setId(id);
        modelAndView.setViewName("redirect:/admin");
        userService.update(user, role);
        return modelAndView;
    }
}
