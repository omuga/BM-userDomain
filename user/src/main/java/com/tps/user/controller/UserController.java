package com.tps.user.controller;

import com.tps.user.models.User;
import com.tps.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(path = "/user")
public class UserController{
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email, @RequestParam String password) {

		User n = new User();
		n.setUsername(name);
		n.setEmail(email);
		n.setPassword(password);
		userRepository.save(n);
		return "User ";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}