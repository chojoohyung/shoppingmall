package shop.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shop.model.Product;
@Controller
public class mainController {
	@GetMapping("/main")

	public String main(Model model) {

		return "main";
	}
	

}
