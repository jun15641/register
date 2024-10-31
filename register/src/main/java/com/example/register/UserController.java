package com.example.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String showRegistrationForm() {
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(@RequestParam("name") String name,
			@RequestParam("gender") String gender,
			@RequestParam("age") int age,
			Model model) {
		User user = new User();
		user.setName(name);
		user.setGender(gender);
		user.setAge(age);
		userRepository.save(user);

		model.addAttribute("message", "登録が完了しました。");
		return "register";
	}

}
