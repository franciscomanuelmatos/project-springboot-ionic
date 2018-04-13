package com.franciscomanuelmatos.udemysb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franciscomanuelmatos.udemysb.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
