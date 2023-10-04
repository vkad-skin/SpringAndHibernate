package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/show-all-users")
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "all-users";
    }

    @GetMapping("/add-new-user")
    public String addNewUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "info-user";
    }

    @PostMapping("/add-new-user")
    public String saveUser(@ModelAttribute User user) {
        System.out.println(user.getId());
        userService.saveUser(user);
        return "redirect:/show-all-users";
    }

    @GetMapping("/update-user")
    public String updateUser(@RequestParam("userId") int id, ModelMap model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "info-user";
    }

    @GetMapping("/delete-user")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUserById(id);
        return "redirect:/show-all-users";
    }
}
