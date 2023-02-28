package com.autobots.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.sistema.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
