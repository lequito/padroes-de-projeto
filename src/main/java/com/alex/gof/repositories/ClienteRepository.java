package com.alex.gof.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alex.gof.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
