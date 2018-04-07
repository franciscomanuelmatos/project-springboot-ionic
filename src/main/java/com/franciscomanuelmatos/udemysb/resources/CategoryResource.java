package com.franciscomanuelmatos.udemysb.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.franciscomanuelmatos.udemysb.domain.Category;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Category> listAll() {
		List<Category> categories = new ArrayList<>();
		categories.add(new Category(1, "IT"));
		categories.add(new Category(2, "Office"));
		
		return categories;
	}
	
}
