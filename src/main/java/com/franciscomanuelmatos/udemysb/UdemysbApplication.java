package com.franciscomanuelmatos.udemysb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.franciscomanuelmatos.udemysb.domain.Address;
import com.franciscomanuelmatos.udemysb.domain.Category;
import com.franciscomanuelmatos.udemysb.domain.City;
import com.franciscomanuelmatos.udemysb.domain.Client;
import com.franciscomanuelmatos.udemysb.domain.Product;
import com.franciscomanuelmatos.udemysb.domain.State;
import com.franciscomanuelmatos.udemysb.domain.enums.ClientType;
import com.franciscomanuelmatos.udemysb.repositories.AddressRepository;
import com.franciscomanuelmatos.udemysb.repositories.CategoryRepository;
import com.franciscomanuelmatos.udemysb.repositories.CityRepository;
import com.franciscomanuelmatos.udemysb.repositories.ClientRepository;
import com.franciscomanuelmatos.udemysb.repositories.ProductRepository;
import com.franciscomanuelmatos.udemysb.repositories.StateRepository;

@SpringBootApplication
public class UdemysbApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(UdemysbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "IT");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "PC", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		State s1 = new State(null, "Minas Gerais");
		State s2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Uberlândia", s1);
		City c2 = new City(null, "São Paulo", s2);
		City c3 = new City(null, "Campinas", s2);
		
		s1.getCities().addAll(Arrays.asList(c1));
		s2.getCities().addAll(Arrays.asList(c2, c3));
		
		Client cl1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PHYSICALPERSON);
		cl1.getTelephones().addAll(Arrays.asList("27363323", "93838393"));
		
		Address a1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cl1, c1);
		Address a2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cl1, c2);
		
		cl1.getAddresses().addAll(Arrays.asList(a1, a2));
		
		categoryRepo.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		stateRepo.saveAll(Arrays.asList(s1, s2));
		cityRepo.saveAll(Arrays.asList(c1, c2, c3));
		clientRepo.saveAll(Arrays.asList(cl1));
		addressRepo.saveAll(Arrays.asList(a1, a2));
	}
}
