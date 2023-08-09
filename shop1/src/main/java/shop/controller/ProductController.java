package shop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
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
	@GetMapping("/top")
	public String topPage(Model model) {
		return "top"; 
	}
	
	@GetMapping("/Jproduct")
	public String JproductPage(Model model) {

	    List<List<Jproduct>> plist = new ArrayList<>();

	    for (int i = 0; i < 2; i++) {
	        List<Jproduct> plistItem = new ArrayList<>();
	        for (int j = 0; j < 5; j++) {
	            Jproduct jproduct = new Jproduct();
	            if (j % 2 == 0) {
	                jproduct.setImg("img/hi.png");
	            } else {
	                jproduct.setImg("img/h2.png");
	            }
	            jproduct.setImg("img/hi.png");
	            jproduct.setName("이름" + j);  // 각 제품마다 다른 이름
	            jproduct.setPrice((j + 1) * 10000);
	            jproduct.setUrl("/products");
	            plistItem.add(jproduct);
	        }
	       
	        plist.add(plistItem);
	    }
	    model.addAttribute("plist", plist);

	    return "jproduct";
	}
}
	