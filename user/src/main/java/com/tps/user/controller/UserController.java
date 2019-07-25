package com.tps.user.controller;

import com.tps.user.models.BookItem;
import com.tps.user.models.User;
import com.tps.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping
public class UserController{
    @Autowired
	private UserRepository userRepository;
	


    @PostMapping(path = "/users") // Ingresar Nuevo Usuario
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email, @RequestParam String password) {
		User n = new User();
		n.setUsername(name);
		n.setEmail(email);
		n.setPassword(password);
		userRepository.save(n);
		return "User saved";
	}

	@GetMapping(path="/users") // Obtener todos los Usuarios
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}



	@DeleteMapping(path = "/users/{id_user}")
	public @ResponseBody String deleteUserById(@RequestParam("id_user") Long id_user){
		if (userRepository.existsById(id_user)){
			userRepository.deleteById(id_user);
			return "User deleted";
		} else{
			return "User could not be deleted";
		}
	}

	@PostMapping(path = "/users_books")
	public  @ResponseBody String addBooktoUser(@RequestParam("id_user") Long id_user, @RequestParam("book_isbn") String book_isbn){
		BookItem bookItem = new BookItem();
		bookItem.setISBN(book_isbn);
		User user = userRepository.getOne(id_user);
		user.getBooks().add(bookItem);
		bookItem.getUsers().add(user);
		userRepository.save(user);
		//bookItemRepository.save(bookItem);
		return "Save";
	}
}