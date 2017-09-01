package com.shopmall.controler;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopmall.bean.Category;
import com.shopmall.bean.User;
import com.shopmall.dao.impl.UserDAOImpl;
import com.shopmall.service.CategoryService;
import com.shopmall.service.ProductService;
import com.shopmall.service.UserService;

@Controller
public class ForeControler {

	@RequestMapping("/index")
	public String index(Model model) {
		List<Category> cs = new CategoryService().list();
		new ProductService().fill(cs);
		new ProductService().fillByRow(cs);
		model.addAttribute("cs", cs);
		return "index";
	}

	@RequestMapping("/register")
	public String register(Model model, @RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "password", defaultValue = "") String password) {
		boolean result = new UserService().isExist(name);
		if(result){
			 
		}
		
		return "register";
	}

	@RequestMapping("/login")
	public String login(Model model, @RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "password", defaultValue = "") String password) {

		User user = new UserDAOImpl().get(name, password);
		if(user!=null){			
            return "index";
		}
		else{
			return "login";
		}
	}

	@RequestMapping("/update")
	public String update(Model model, @RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "password", defaultValue = "") String password) {
		
		User user = new User(name,password);
		new UserService().update(user);
		return "update";
	}
}
