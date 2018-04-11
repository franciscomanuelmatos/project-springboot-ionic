package com.franciscomanuelmatos.udemysb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franciscomanuelmatos.udemysb.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
