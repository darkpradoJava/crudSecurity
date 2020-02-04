package crudSecurity.controller;

import crudSecurity.model.User;
import crudSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin")
    public String printUsers(ModelMap model) {
        User user1 = new User();
        User user2 = new User();
        userService.add(user1);
        userService.add(user2);
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        User user = userService.getUserById(id);
        if (user != null) {
            userService.delete(user);
        }
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView addPage(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        userService.add(user);
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editUserPage(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        User tempUser = userService.getUserById(id);
        modelAndView.addObject("user", tempUser);
        modelAndView.setViewName("edit");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editUser(@RequestParam(value = "id") Long id, @ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        user.setId(id);
        modelAndView.setViewName("redirect:/users");
        userService.update(user);
        return modelAndView;
    }
}
