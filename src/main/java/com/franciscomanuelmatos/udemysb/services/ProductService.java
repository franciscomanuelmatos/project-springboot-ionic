package com.franciscomanuelmatos.udemysb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franciscomanuelmatos.udemysb.domain.Product;
import com.franciscomanuelmatos.udemysb.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public Product find(Integer id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
