package com.franciscomanuelmatos.udemysb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.franciscomanuelmatos.udemysb.domain.Category;
import com.franciscomanuelmatos.udemysb.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getCategory(@PathVariable Integer id) {
		Category obj = service.find(id);
		
		return ResponseEntity.ok(obj);
	}
	
}
