package shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shop.model.*;

@Controller
public class ProductController {
	@GetMapping("/products")

	public String product(Model model, Product products) {

		return "product-list";
	}

	@GetMapping("/qa")
	public String qaPage(Model model) {
		return "qa";

	}

	@GetMapping("/change")
	public String changePage(Model model) {
		return "change";

	}

	@GetMapping("/Jproduct")
	public String JproductPage(Model model) {

		List<List<Jproduct>> jplist = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			List<Jproduct> jplistItem = new ArrayList<>();
			for (int j = 0; j < 4; j++) {
				Jproduct jproduct = new Jproduct();
				jproduct.setImg("../img/hi.png");
				jproduct.setName("이름");
				jproduct.setPrice((j + 1) * 10000);
				jproduct.setUrl("/products");
				jplistItem.add(jproduct);

			}
			jplist.add(jplistItem);
		}
		model.addAttribute("jplist", jplist);

		return "jproduct";

	}

}
