package org.jbuilder.glider.controller;

import javax.servlet.http.HttpServletRequest;

import org.jbuilder.glider.entity.User;
import org.jbuilder.glider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "{userId}")
    public String articles(@PathVariable Integer userId, HttpServletRequest request, Model modelMap) {
        User user = userService.getUserById(userId);
        modelMap.addAttribute("user", user);
        return "default/user";
    }
}
